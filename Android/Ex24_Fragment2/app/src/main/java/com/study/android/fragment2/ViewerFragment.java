package com.study.android.fragment2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ViewerFragment extends Fragment {
    private static final String TAG = "lecture";

    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        ViewGroup rootView =
                (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false);

        imageView = rootView.findViewById(R.id.imageView);

        return rootView;
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }


}
