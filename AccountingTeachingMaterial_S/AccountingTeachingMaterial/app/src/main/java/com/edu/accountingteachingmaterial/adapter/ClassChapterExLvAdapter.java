package com.edu.accountingteachingmaterial.adapter;

import java.util.List;

import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.bean.ClassChapterBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ClassChapterExLvAdapter extends BaseExpandableListAdapter {
	List<ClassChapterBean> datas;
	Context context;

	public ClassChapterExLvAdapter(Context context) {
		super();
		this.context = context;
	}

	public void setDatas(List<ClassChapterBean> datas) {
		this.datas = datas;
	}

	@Override
	public int getGroupCount() {
	
		return	datas == null?0:datas.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		
		
		// TODO Auto-generated method stub
		return datas.get(groupPosition).getNodes() == null? 0 : datas.get(groupPosition).getNodes().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		
		// TODO Auto-generated method stub
		return datas.get(groupPosition).getTitle();
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return datas.get(groupPosition).getNodes().get(childPosition).getTitle();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		
		convertView = LayoutInflater.from(context).inflate(R.layout.item_main_classchapter_exlv, parent,false);
		TextView textView = (TextView) convertView.findViewById(R.id.item_classchapter_tv);
		textView.setText(datas.get(groupPosition).getTitle());

		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(context).inflate(R.layout.item_main_classnode_exlv, parent,false);
		TextView textView = (TextView) convertView.findViewById(R.id.item_classnode_tv);
		textView.setText(datas.get(groupPosition).getNodes().get(childPosition).getTitle());

		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}


}
