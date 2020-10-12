package com.xbsaykat.expandablebutton.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xbsaykat.expandablebutton.R;
import com.xbsaykat.expandablebutton.viewHolder.AudioViewHolder;
import com.xbsaykat.expandablebutton.viewHolder.DocViewHolder;
import com.xbsaykat.expandablebutton.viewHolder.VideoViewHolder;
import com.xbsaykat.expandablebutton.model.Audio;
import com.xbsaykat.expandablebutton.model.Document;
import com.xbsaykat.expandablebutton.model.ViewItem;
import com.xbsaykat.expandablebutton.model.Video;

import java.util.List;

import static com.xbsaykat.expandablebutton.StaticFiles.AUDIO;
import static com.xbsaykat.expandablebutton.StaticFiles.DOC;
import static com.xbsaykat.expandablebutton.StaticFiles.VIDEO;


public class ChildAdapter extends RecyclerView.Adapter {

    private List<ViewItem> childList;
    private Context context;
    public static final String TAG = "ParentAdapter ";

    public ChildAdapter(List<ViewItem> childList, Context context) {
        this.childList = childList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        switch (childList.get(position).getViewType()) {
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
        ViewItem item = childList.get(position);

        if (holder instanceof VideoViewHolder) {
            Video video = (Video) item;

            ((VideoViewHolder) holder).TextViewtitle.setText(video.getVideoFileName());

            ((VideoViewHolder) holder).ConstraintLayoutvideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, ((VideoViewHolder) holder).TextViewtitle.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof DocViewHolder) {
            Document document = (Document) item;
            ((DocViewHolder) holder).TextViewauthor.setText(document.getDocAuthor());
            ((DocViewHolder) holder).TextViewtitle.setText(document.getDocName());
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
        return childList.size();
    }
}
