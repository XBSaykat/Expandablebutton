package com.xbsaykat.expandablebutton.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xbsaykat.expandablebutton.R;
import com.xbsaykat.expandablebutton.viewHolder.AudioViewHolder;
import com.xbsaykat.expandablebutton.viewHolder.DocViewHolder;
import com.xbsaykat.expandablebutton.viewHolder.VideoViewHolder;
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


public class ParentAdapter extends RecyclerView.Adapter {

    private List<ViewItem> parentList;
    private Context context;
    public static final String TAG = "ParentAdapter ";

    public ParentAdapter(List<ViewItem> parentList, Context context) {
        this.parentList = parentList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        switch (parentList.get(position).getViewType()) {
            case 0:
                return CHAPTER;
            case 1:
                return VIDEO;
            case 2:
                return DOC;
            case 3:
                return AUDIO;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_layout, parent, false);
                return new ChapterViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_layout, parent, false);
                return new VideoViewHolder(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_layout, parent, false);
                return new DocViewHolder(view);
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_layout, parent, false);
                return new AudioViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        ViewItem item = parentList.get(position);

        if (holder instanceof ChapterViewHolder) {
            Chapter chapter = (Chapter) item;
            ((ChapterViewHolder) holder).TextViewchapter.setText(chapter.getChapterName());
            List<ViewItem> childList = new ArrayList<>();
            if(((ChapterViewHolder) holder).TextViewchapter.getText().toString().equalsIgnoreCase("Chapter 1")){
                childList.clear();

                if (chapter.getVideos() != null)
                    childList.addAll(chapter.getVideos());

                if (chapter.getDocumentList() != null)
                    childList.addAll(chapter.getDocumentList());

                if (chapter.getVideos() != null)
                    childList.addAll(chapter.getVideos());
            }else if(((ChapterViewHolder) holder).TextViewchapter.getText().toString().equalsIgnoreCase("Chapter 2")){
                childList.clear();
                if (chapter.getDocumentList() != null)
                    childList.addAll(chapter.getDocumentList());

                if (chapter.getVideos() != null)
                    childList.addAll(chapter.getVideos());

                if (chapter.getVideoItems2() != null)
                    childList.addAll(chapter.getVideoItems2());

                if (chapter.getAudio() != null)
                    childList.addAll(chapter.getAudio());
            }

            ChildAdapter adapter = new ChildAdapter(childList, context);
            ((ChapterViewHolder) holder).recyclerView.setAdapter(adapter);

            boolean isExpanded = chapter.isExpanded();
            if (isExpanded) {
                ((ChapterViewHolder) holder).expandableLayout.setVisibility(View.VISIBLE);
                ((ChapterViewHolder) holder).indicator.setImageResource(R.drawable.ic_baseline_arrow_drop_up_24);
            } else {
                ((ChapterViewHolder) holder).expandableLayout.setVisibility(View.GONE);
                ((ChapterViewHolder) holder).indicator.setImageResource(R.drawable.ic_baseline_arrow_drop_down_circle_24);
            }

        } else if (holder instanceof VideoViewHolder) {
            Video video = (Video) item;
            ((VideoViewHolder) holder).TextViewtitle.setText(video.getVideoFileName());
            ((VideoViewHolder) holder).ConstraintLayoutvideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, ((VideoViewHolder) holder).TextViewtitle.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof DocViewHolder) {
            Document doc = (Document) item;
            ((DocViewHolder) holder).TextViewauthor.setText(doc.getDocAuthor());
            ((DocViewHolder) holder).TextViewtitle.setText(doc.getDocName());
            ((DocViewHolder) holder).ConstrainDocument.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, ((DocViewHolder) holder).TextViewtitle.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof AudioViewHolder) {
            Audio audio = (Audio) item;
            ((AudioViewHolder) holder).TextViewtitle.setText(audio.getFileName());
            ((AudioViewHolder) holder).ConstraintLayoutAudio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, ((AudioViewHolder) holder).TextViewtitle.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + parentList.size());
        return parentList.size();
    }


    public class ChapterViewHolder extends RecyclerView.ViewHolder {

        private TextView TextViewchapter;
        private ImageView indicator;
        private ConstraintLayout expandableLayout;
        private RecyclerView recyclerView;

        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            TextViewchapter = itemView.findViewById(R.id.tvchapter_name);
            indicator = itemView.findViewById(R.id.imageindicator);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            recyclerView = itemView.findViewById(R.id.recyclerviewchild);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));


            indicator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Chapter chapter = (Chapter) parentList.get(getAdapterPosition());
                    chapter.setExpanded(!chapter.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }

}
