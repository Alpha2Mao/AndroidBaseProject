package com.example.androidbaseproject;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qweather.plugin.view.HeContent;
import com.qweather.plugin.view.HorizonView;
import com.squareup.picasso.Picasso;

public class MineFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView mImage;
//    private



    public MineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        mToolbar = (Toolbar)view.findViewById(R.id.toolbar);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout)view.findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle("Test For Toolbar");
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.RED);
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.YELLOW);
        mCollapsingToolbarLayout.setContentScrimColor(Color.GREEN);
        mImage = (ImageView)view.findViewById(R.id.image);
        Picasso.get()
                .load("http://img.keaitupian.cn/uploads/2020/10/27/4adfb2ef24.jpg")
                .placeholder(R.drawable.image)
                .error(R.drawable.image_error)
                .into(mImage);


        return view;
    }


    private void setRecycleView(View view){

    }
}