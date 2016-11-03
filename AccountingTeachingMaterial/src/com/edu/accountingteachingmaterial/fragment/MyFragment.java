package com.edu.accountingteachingmaterial.fragment;

import android.view.View;

import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.base.BaseFragment;
import com.edu.library.view.CircleImageView;

public class MyFragment extends BaseFragment {
	CircleImageView circleImageView;

	@Override
	protected int initLayout() {
		// TODO Auto-generated method stub
		return R.layout.fragment_my;
	}
	@Override
	protected void initView(View view) {
		circleImageView = bindView(R.id.my_head_civ);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		
	}



}
