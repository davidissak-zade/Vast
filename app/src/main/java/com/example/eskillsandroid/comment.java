package com.example.eskillsandroid;



public class comment {
    private String id, sender, topic,toId, txt, datetime;
    private int reputation;

    public comment(String ID, String TOID, String sender, String topic,String TXT, String datetime, int reputation){
        this.id = ID;
        this.toId = TOID;
        this.sender = sender;
        this.topic = topic;
        this.txt = TXT;
        this.reputation = reputation;
        this.datetime = datetime;
    }

    public comment(){}

    public int getReputation() {
        return reputation;
    }

    public String getId() {
        return id;
    }

    public String getToId() {
        return toId;
    }

    public String getTxt() {
        return txt;
    }
    public void upvote(){
        this.reputation++;
    }
    public void downvote(){
        this.reputation -= 1;
    }

    public String getTopic() {
        return topic;
    }

    public String getSender() {
        return sender;
    }
}
