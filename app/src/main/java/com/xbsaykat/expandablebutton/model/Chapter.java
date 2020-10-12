package com.xbsaykat.expandablebutton.model;

import java.util.List;

public class Chapter extends ViewItem {

    private String chapterName;
    private List<Document> documentList;
    private List<Video> videos;
    private List<Video> video2;
    private List<Audio> audio;
    private boolean expanded;

    public Chapter(int viewType, String chapterName, List<Video> videos, List<Document> documentList, List<Video> video2) {
        super(viewType);
        this.chapterName = chapterName;
        this.videos = videos;
        this.documentList = documentList;
        this.video2 = video2;
        this.expanded=false;
    }
    public Chapter(int viewType, String chapterName, List<Document> documentList, List<Video> videos, List<Video> video2, List<Audio> audio) {
        super(viewType);
        this.chapterName = chapterName;
        this.documentList = documentList;
        this.videos = videos;
        this.video2 = video2;
        this.audio = audio;
        this.expanded=false;
    }

    public Chapter(int viewType) {
        super(viewType);
    }

    public String getChapterName() {
        return chapterName;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public List<Video> getVideos() {
        return videos;
    }
    public List<Video> getVideoItems2() {
        return video2;
    }

    public List<Audio> getAudio() {
        return audio;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
