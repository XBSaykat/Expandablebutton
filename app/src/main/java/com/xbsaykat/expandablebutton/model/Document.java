package com.xbsaykat.expandablebutton.model;

public class Document extends ViewItem {

    private String docName;
    private String docAuthor;

    public Document(int viewType, String docName, String docAuthor) {
        super(viewType);
        this.docName = docName;
        this.docAuthor = docAuthor;
    }

    public String getDocName() {
        return docName;
    }

    public String getDocAuthor() {
        return docAuthor;
    }

}
