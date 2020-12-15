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
        HorizonView horizonView = view.findViewById(R.id.horizon_view);
        //取消默认背景
        horizonView.setDefaultBack(false);
        //设置布局的背景圆角角度，颜色，边框宽度，边框颜色
        horizonView.setStroke(5, Color.BLUE, 1, Color.BLUE);
        //添加地址文字描述，第一个参数为文字大小，单位：sp ，第二个参数为文字颜色，默认白色
        horizonView.addLocation(14, Color.WHITE);
        //添加预警图标，参数为图标大小，单位：dp
        horizonView.addAlarmIcon(14);
        //添加预警文字
        horizonView.addAlarmTxt(14);
        //添加温度描述
        horizonView.addTemp(14, Color.WHITE);
        //添加天气图标
        horizonView.addWeatherIcon(14);
        //添加天气描述
        horizonView.addCond(14, Color.WHITE);
        //添加风向图标
        horizonView.addWindIcon(14);
        //添加风力描述
        horizonView.addWind(14, Color.WHITE);
        //添加文字：AQI
        horizonView.addAqiText(14, Color.WHITE);
        //添加空气质量描述
        horizonView.addAqiQlty(14);
        //添加空气质量数值描述
        horizonView.addAqiNum(14);
        //添加降雨图标
        horizonView.addRainIcon(14);
        //添加降雨描述
        horizonView.addRainDetail(14, Color.WHITE);
        //设置控件的对齐方式，默认居中
        horizonView.setViewGravity(HeContent.GRAVITY_CENTER);
        //设置控件的内边距，默认为0
        horizonView.setViewPadding(10, 10, 10, 10);
        //显示控件
        horizonView.show();

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