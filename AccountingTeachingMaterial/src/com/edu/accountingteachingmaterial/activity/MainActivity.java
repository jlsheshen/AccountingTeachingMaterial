package com.edu.accountingteachingmaterial.activity;




import java.util.ArrayList;
import java.util.List;

import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.adapter.ClassChapterExLvAdapter;
import com.edu.accountingteachingmaterial.base.BaseActivity;
import com.edu.accountingteachingmaterial.bean.ClassChapterBean;
import com.edu.accountingteachingmaterial.bean.NodeBean;
import com.edu.library.util.ToastUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;


public class MainActivity extends BaseActivity {
	ExpandableListView expandableListView;
	List<ClassChapterBean> datas;
	ClassChapterExLvAdapter chapterExLvAdapter;
	@Override
	public int setLayout() {
		// TODO Auto-generated method stub
		return R.layout.activity_main;
	}
	@Override
	public void initView(Bundle savedInstanceState) {
		expandableListView = (ExpandableListView) bindView(R.id.main_classchapter_exlv);
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public void initData() {
		loadData();
		chapterExLvAdapter = new ClassChapterExLvAdapter(this);
		chapterExLvAdapter.setDatas(datas);
		expandableListView.setAdapter(chapterExLvAdapter);
		expandableListView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				String id1 =  datas.get(groupPosition).getNodes().get(childPosition).getNodeId();
				Log.e("www", id1);
				startActivity(ClassActivity.class);
				// TODO Auto-generated method stub
				return false;
			}
		});
	
	}
	private void loadData() {
		datas = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ClassChapterBean chapterBean = new ClassChapterBean();
			List<NodeBean>  nodes = new ArrayList<>();
			chapterBean.setChapterId(i);
			chapterBean.setTitle("章节标题 编号--" + i);
			for (int j = 0; j < 10; j++) {
				NodeBean node =  new NodeBean();
				
				node.setNodeId(i + "--" + j);
				node.setTitle("小节编号" + node.getNodeId());
				nodes.add(node);
				
			}
			chapterBean.setNodes(nodes);
			datas.add(chapterBean);
		}
		// TODO Auto-generated method stub
		
	}
}
