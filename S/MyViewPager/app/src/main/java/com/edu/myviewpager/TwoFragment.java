package com.edu.myviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/11/15.
 */

public class TwoFragment extends Fragment implements PagerScollListener{
    private static final String TAG_POSITION = "TwofragmentPositionTag";
Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(context).inflate(R.layout.two_fragment,container,false);
    }

    public static TwoFragment newInstance(int position) {
        Bundle args = new Bundle();
        //在这里只需 给bundle赋值 ( key_value的形式)
        args.putInt(TAG_POSITION, position);
        TwoFragment fragment = new TwoFragment();
        fragment.setArguments(args);
        return fragment;


    }

    @Override
    public void onPagerScoll(float i) {


    }
}
