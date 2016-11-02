package com.edu.accountingteachingmaterial.fragment;

import android.view.View;
import android.webkit.WebView;

import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.base.BaseFragment;

import constant.URLConstant;

public class ClassEmphasisFragment  extends BaseFragment{
	 WebView wView;
	@Override
	protected int initLayout() {
		// TODO Auto-generated method stub
		return R.layout.fragment_class_emphasis;
	}

	@Override
	protected void initView(View view) {

		 wView = bindView(R.id.emphasis_wv);
		 wView.loadUrl(URLConstant.filePath + "san360.html");		
	}

	@Override
	protected void initData() {
		// TODO Auto-generated method stub
		
	}

}
