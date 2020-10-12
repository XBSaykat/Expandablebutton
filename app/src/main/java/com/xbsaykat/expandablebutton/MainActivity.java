package com.xbsaykat.expandablebutton;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xbsaykat.expandablebutton.adapter.ParentAdapter;
import com.xbsaykat.expandablebutton.model.Audio;
import com.xbsaykat.expandablebutton.model.Chapter;
import com.xbsaykat.expandablebutton.model.Document;
import com.xbsaykat.expandablebutton.model.ViewItem;
import com.xbsaykat.expandablebutton.model.Video;

import java.util.ArrayList;
import java.util.List;

import static com.xbsaykat.expandablebutton.StaticFiles.AUDIO;
import static com.xbsaykat.expandablebutton.StaticFiles.CHAPTER;
import static com.xbsaykat.expandablebutton.StaticFiles.DOC;
import static com.xbsaykat.expandablebutton.StaticFiles.VIDEO;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ViewItem> ListItem;
    private ParentAdapter parentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        LoadData();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        parentAdapter = new ParentAdapter(ListItem, this);
        recyclerView.setAdapter(parentAdapter);
    }

    private void LoadData() {
        List<Video> videoItems1 = new ArrayList<>();
        videoItems1.add(new Video(VIDEO, "Video 1_1"));
        List<Document> docItems1 = new ArrayList<>();
        docItems1.add(new Document(DOC, "Document 1_1", "I am Author"));
        List<Video> videoItems1_2 = new ArrayList<>();
        videoItems1_2.add(new Video(VIDEO, "Video 1_2"));

        List<Document> docItems2 = new ArrayList<>();
        docItems2.add(new Document(DOC, "Document 2_1", "I am Author"));
        List<Video> videoItems2 = new ArrayList<>();
        videoItems2.add(new Video(VIDEO, "Video 2_1"));
        List<Video> videoItems2_2 = new ArrayList<>();
        videoItems2_2.add(new Video(VIDEO, "Video 2_2"));
        List<Audio> audioItems2 = new ArrayList<>();
        audioItems2.add(new Audio(AUDIO, "Audio 2_1"));

        ListItem = new ArrayList<>();
        ListItem.add(new Chapter(CHAPTER, "chapter 1",videoItems1,docItems1,videoItems1_2));
        ListItem.add(new Chapter(CHAPTER, "chapter 2", docItems2, videoItems2,videoItems2_2, audioItems2));
        ListItem.add(new Video(VIDEO, "Video 3_0"));
        ListItem.add(new Document(DOC, "Document 4_0", "I am Author"));
    }
}