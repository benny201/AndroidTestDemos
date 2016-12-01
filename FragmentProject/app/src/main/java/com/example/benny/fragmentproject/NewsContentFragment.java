package com.example.benny.fragmentproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by benny on 16/11/19.
 */
public class NewsContentFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }

    public void refresh(String newsTitile, String content) {
        View contentLayout = view.findViewById(R.id.content_layout);
        contentLayout.setVisibility(View.VISIBLE);
        TextView titleview = (TextView) view.findViewById(R.id.news_title);
        TextView contentview = (TextView) view.findViewById(R.id.news_content);
        titleview.setText(newsTitile);
        contentview.setText(content);
    }
}
