package com.example.eskillsandroid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<comment> list;

    public Adapter(Context context, ArrayList<comment> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.comment_row_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        comment CurrentComment = list.get(position);
        String CurrentCommentID = CurrentComment.getId();
        holder.commentTime.setText(CurrentComment.getDatetime());
        holder.senderName.setText(CurrentComment.getSender());
        holder.commentHeader.setText(CurrentComment.getTopic());
        holder.commentText.setText(CurrentComment.getTxt());
        holder.commentReputation.setText(String.valueOf(CurrentComment.getReputation()));
        holder.CurrentComment = CurrentComment;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateReputation(DatabaseReference ref, comment CurrentComment){
        ref.orderByChild("id").equalTo(CurrentComment.getId()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    for (DataSnapshot data : snapshot.getChildren()){
                        String key = data.getKey();

                        ref.child(key).child("reputation").setValue(CurrentComment.getReputation());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView senderName, commentTime, commentHeader, commentText, commentReputation;
        ImageButton upvote, downvote, reply;
        comment CurrentComment;
        FirebaseDatabase DB;
        DatabaseReference ref;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            DB = FirebaseDatabase.getInstance("https://vast-a293d-default-rtdb.firebaseio.com/");
            ref = DB.getReference("comments");

            senderName = itemView.findViewById(R.id.commentator);
            commentTime = itemView.findViewById(R.id.commenttime);
            commentHeader = itemView.findViewById(R.id.commentHeader);
            commentText = itemView.findViewById(R.id.commentTXT);
            commentReputation = itemView.findViewById(R.id.CommentReputation);

            upvote = itemView.findViewById(R.id.upvote);
            downvote = itemView.findViewById(R.id.downvote);

            upvote.setTag(R.drawable.up);  // set the tag for initial drawable
            downvote.setTag(R.drawable.down);  // set the tag for initial drawable


            //buttons onclick fucntions
            upvote.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(((Integer) upvote.getTag()) == R.drawable.up  && (((Integer) downvote.getTag()) == R.drawable.down)){  // if the user didn't upvote or downvote yet
                        Log.d("demo", "onClick: Upvote for comment " + CurrentComment.getTxt());
                        CurrentComment.upvote();
                        Log.d("demo", "Comment Reputation: " + CurrentComment.getReputation());
                        upvote.setImageResource(R.drawable.upcolor);
                        updateReputation(ref, CurrentComment);
                        commentReputation.setText("" + CurrentComment.getReputation());
                        upvote.setTag(R.drawable.upcolor);
                    }
                    else if(((Integer) upvote.getTag()) == R.drawable.upcolor){   // if the upvote button was already pressed and is pressed again, return the upvote
                        CurrentComment.downvote();
                        commentReputation.setText("" + CurrentComment.getReputation());
                        upvote.setImageResource(R.drawable.up);
                        upvote.setTag(R.drawable.up);
                    }
                }
            });

            downvote.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(((Integer) downvote.getTag()) == R.drawable.down  && (((Integer) upvote.getTag()) == R.drawable.up)) {
                        Log.d("demo", "onClick: downvote for comment " + CurrentComment.getTxt());
                        CurrentComment.downvote();
                        updateReputation(ref, CurrentComment);
                        commentReputation.setText("" + CurrentComment.getReputation());
                        Log.d("demo", "Comment Reputation: " + CurrentComment.getReputation());
                        downvote.setImageResource(R.drawable.downcolor);
                        downvote.setTag(R.drawable.downcolor);
                    }
                    else if (((Integer) downvote.getTag()) == R.drawable.downcolor ){  // if the downvote was already pressed and is pressed again, return the downvote
                        CurrentComment.upvote();
                        commentReputation.setText("" + CurrentComment.getReputation());
                        downvote.setImageResource(R.drawable.down);
                        downvote.setTag(R.drawable.down);
                    }
                }
            });


        }
    }
}
