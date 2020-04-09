package com.example.firstminiproject;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DynamicListCustomAdapter extends ArrayAdapter<String> {

        private final LayoutInflater mInflater;
        private final Context mContext;
        private List<String> listitems = null;
        private final int mResource;

        public DynamicListCustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<String> listitem) {
            super(context, resource, 0, listitem);
            mContext = context;
            mInflater = LayoutInflater.from(context);
            mResource = resource;
            listitems=listitem;
        }
        @Override
        public View getDropDownView(int position, @Nullable View convertView,
                                    @NonNull ViewGroup parent) {
            return createItemView(position, convertView, parent);
        }

        @Override
        public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return createItemView(position, convertView, parent);
        }

        private View createItemView(int position, View convertView, ViewGroup parent){
            final View view = mInflater.inflate(mResource, parent, false);
            Log.d("inside adapter", String.valueOf(listitems.size()));
            String data = listitems.get(position);

            TextView title = view.findViewById(R.id.tvTitle);
            title.setText(data);

            return view;
        }

}
