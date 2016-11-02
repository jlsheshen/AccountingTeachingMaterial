package com.edu.accountingteachingmaterial.adapter;

import java.util.List;

import com.edu.accountingteachingmaterial.bean.ExampleBean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ExampleGVAdapter  extends BaseAdapter {
	private Context context;
	
	private List<ExampleBean> beans;
	

	public ExampleGVAdapter(Context context) {
		super();
		this.context = context;
	}

	public void setBeans(List<ExampleBean> beans) {
		this.beans = beans;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return beans == null? 0:beans.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
