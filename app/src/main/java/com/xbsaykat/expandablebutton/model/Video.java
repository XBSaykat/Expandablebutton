package com.xbsaykat.expandablebutton.model;

public class Video extends ViewItem {

    private String videoFileName;

    public Video(int viewType, String videoFileName) {
        super(viewType);
        this.videoFileName = videoFileName;
    }

    public String getVideoFileName() {
        return videoFileName;
    }

}
