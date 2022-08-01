package com.example.eskillsandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        holder.commentTime.setText(CurrentComment.getDatetime());
        holder.senderName.setText(CurrentComment.getSender());
        holder.commentHeader.setText(CurrentComment.getTopic());
        holder.commentText.setText(CurrentComment.getTxt());
        holder.commentReputation.setText(CurrentComment.getReputation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView senderName, commentTime, commentHeader, commentText, commentReputation;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            senderName = itemView.findViewById(R.id.commentator);
            commentTime = itemView.findViewById(R.id.commenttime);
            commentHeader = itemView.findViewById(R.id.commentHeader);
            commentText = itemView.findViewById(R.id.commentTXT);
            commentReputation = itemView.findViewById(R.id.CommentReputation);
        }
    }
}
