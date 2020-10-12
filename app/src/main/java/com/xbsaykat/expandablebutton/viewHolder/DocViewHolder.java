package com.xbsaykat.expandablebutton.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.xbsaykat.expandablebutton.R;

public class DocViewHolder extends RecyclerView.ViewHolder {

    public TextView TextViewtitle, TextViewauthor;
    public ConstraintLayout ConstrainDocument;

    public DocViewHolder(@NonNull View itemView) {
        super(itemView);
        TextViewtitle = itemView.findViewById(R.id.tvtitle);
        TextViewauthor = itemView.findViewById(R.id.tvauthor);
        ConstrainDocument = itemView.findViewById(R.id.constraindocument);
    }
}
