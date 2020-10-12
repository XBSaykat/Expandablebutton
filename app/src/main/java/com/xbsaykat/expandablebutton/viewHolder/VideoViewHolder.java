package com.xbsaykat.expandablebutton.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.xbsaykat.expandablebutton.R;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    public TextView TextViewtitle;
    public ConstraintLayout ConstraintLayoutvideo;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        TextViewtitle = itemView.findViewById(R.id.tvtitle);
        ConstraintLayoutvideo = itemView.findViewById(R.id.ConstraintLayoutvideo);
    }
}