package com.example.firstminiproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;
//public class  MyGalleryAdapter extends RecyclerView.Adapter<MyGalleryAdapter.ViewHolder>{
//private String text;
//private int image;

//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyGalleryAdapter.ViewHolder viewHolder, int i) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
//    }
//}
public class MyGalleryAdapter extends RecyclerView.Adapter<MyGalleryAdapter.ViewHolder> {
    private Context context;
    private List<Gallery> list;

    public MyGalleryAdapter(Context context, List<Gallery> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyGalleryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.container_gallary, null);
        return new MyGalleryAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyGalleryAdapter.ViewHolder viewHolder, int i) {
        if (list != null && !list.isEmpty()) {
            Gallery gallery = list.get(i);

            viewHolder.image.setImageResource(gallery.getImage());
            viewHolder.title.setText(gallery.getTitle());
        }
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.myImageView);
            title = itemView.findViewById(R.id.myImageViewText);
        }
    }
}

