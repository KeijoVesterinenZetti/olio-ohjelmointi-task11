package com.example.task11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView tv_food;
    TextView tv_mem;

    ImageView removeImage, editImage;


    EditText editName;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_food=itemView.findViewById(R.id.tv_foodName);
        tv_mem=itemView.findViewById(R.id.tv_memo);
        removeImage=itemView.findViewById(R.id.img_remove);
        editImage=itemView.findViewById(R.id.img_edit);
        editName=itemView.findViewById(R.id.tv_editName);
    }
}