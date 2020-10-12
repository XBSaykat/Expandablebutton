package com.xbsaykat.expandablebutton.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.xbsaykat.expandablebutton.R;

public class AudioViewHolder extends RecyclerView.ViewHolder {

    public TextView TextViewtitle;
    public ConstraintLayout ConstraintLayoutAudio;

    public AudioViewHolder(@NonNull View itemView) {
        super(itemView);
        TextViewtitle = itemView.findViewById(R.id.tvtitle);
        ConstraintLayoutAudio = itemView.findViewById(R.id.constraintlayoutaudio);
    }
}