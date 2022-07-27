package com.example.eskillsandroid;

public class page {
    private String Name;
    private String StepName;
    private String Steps;
    private String id;
    private String intro;
    private String videoLink;

    public page(String name, String StepName, String steps, String id, String intro, String videoLink){
        this.Name = name;
        this.StepName = StepName;
        this.Steps = steps;
        this.id = id;
        this.intro = intro;
        this.videoLink = videoLink;
    }
    public page (){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStepName() {
        return StepName;
    }

    public void setStepName(String stepName) {
        StepName = stepName;
    }

    public String getSteps() {
        return Steps;
    }

    public void setSteps(String steps) {
        Steps = steps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }
}
