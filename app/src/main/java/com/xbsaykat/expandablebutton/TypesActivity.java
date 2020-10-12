package com.xbsaykat.expandablebutton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TypesActivity extends AppCompatActivity {
    TextView textView_title,textView_titledoc;
    LinearLayout Videolayout,Documentlayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.typeactivity);

        Videolayout=findViewById(R.id.videolayout);
        Documentlayout=findViewById(R.id.documentlayout);

        Intent intent= getIntent();
        String types= intent.getStringExtra("types");
        String title= intent.getStringExtra("name");

        if(types.equals("Video")){
            Documentlayout.setVisibility(View.GONE);
            Videolayout.setVisibility(View.VISIBLE);
            textView_title=findViewById(R.id.title);
            textView_title.setText(title);
        }
        if(types.equals("Document")){
            Documentlayout.setVisibility(View.VISIBLE);
            Videolayout.setVisibility(View.GONE);
            textView_titledoc=findViewById(R.id.titledoc);
            textView_titledoc.setText(title);
        }



    }
}
