package com.xbsaykat.expandablebutton.model;

public class Audio extends ViewItem {
    private String fileName;

    public Audio(int viewType, String fileName) {
        super(viewType);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
