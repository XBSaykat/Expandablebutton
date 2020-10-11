package com.xbsaykat.expandablebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataParent;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        expListView = findViewById(R.id.explistview);
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataParent, listDataChild);
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                 //Toast.makeText(getApplicationContext(),"Group Clicked " + listDataParent.get(groupPosition), Toast.LENGTH_SHORT).show();
                String typeOfContent= listDataParent.get(groupPosition);
                boolean isAudio= typeOfContent.indexOf("Audio")!=1?true:false;
                if(isAudio){
                    Toast.makeText(getApplicationContext(),listDataParent.get(groupPosition), Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), listDataParent.get(groupPosition) + " : " + listDataChild.get(listDataParent.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                String typeOfContent= listDataParent.get(groupPosition);
                boolean isVideo= typeOfContent.indexOf("Video")!=1?true:false;
                boolean isDocument= typeOfContent.indexOf("Document")!=1?true:false;
                boolean isAudio= typeOfContent.indexOf("Audio")!=1?true:false;

                if(isVideo){
                    Intent intent= new Intent(MainActivity.this, TypesActivity.class);
                    intent.putExtra("types","Video");
                    startActivity(intent);
                }
                if(isDocument){
                    Intent intent= new Intent(MainActivity.this, TypesActivity.class);
                    intent.putExtra("types","Document");
                    startActivity(intent);
                }
                if(isAudio){
                    Toast.makeText(getApplicationContext(),listDataParent.get(groupPosition), Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
    private void prepareListData() {
        listDataParent = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataParent.add("Chapter 1");
        listDataParent.add("Chapter 2");
        listDataParent.add("Video 3_0");
        listDataParent.add("Document 4_0 ");

        List<String> Chapter1 = new ArrayList<String>();
        Chapter1.add("Video 1_1");
        Chapter1.add("Document 1_1");
        Chapter1.add("Video 1_2");

        List<String> Chapter2= new ArrayList<String>();
        Chapter2.add("Document 2_1");
        Chapter2.add("Video 2_1");
        Chapter2.add("Video 2_2");
        Chapter2.add("Audio 2_1");

        listDataChild.put(listDataParent.get(0), Chapter1);
        listDataChild.put(listDataParent.get(1), Chapter2);


    }
}