package com.example.eskillsandroid;



public class comment {
    private String id, sender, topic, toName, txt, datetime;
    private Long reputation;

    public comment(String ID, String ToSender, String sender, String topic,String TXT, String datetime, Long reputation){
        this.id = ID;
        this.toName = ToSender;
        this.sender = sender;
        this.topic = topic;
        this.txt = TXT;
        this.reputation = reputation;
        this.datetime = datetime;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public comment(){}

    @Override
    public String toString() {
        return "comment{" +
                "id='" + id + '\'' +
                ", sender='" + sender + '\'' +
                ", topic='" + topic + '\'' +
                ", toName='" + toName + '\'' +
                ", txt='" + txt + '\'' +
                ", datetime='" + datetime + '\'' +
                ", reputation=" + reputation +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setReputation(Long reputation) {
        this.reputation = reputation;
    }

    public Long getReputation() {
        return reputation;
    }

    public String getId() {
        return id;
    }

    public String getToName() {
        return toName;
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

    public String getDatetime(){ return datetime;}


}
