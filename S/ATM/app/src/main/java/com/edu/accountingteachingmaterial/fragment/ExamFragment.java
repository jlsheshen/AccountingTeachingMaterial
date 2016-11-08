package com.edu.accountingteachingmaterial.fragment;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.activity.ClassDetailActivity;
import com.edu.accountingteachingmaterial.adapter.ClassChapterExLvAdapter;
import com.edu.accountingteachingmaterial.base.BaseFragment;
import com.edu.accountingteachingmaterial.bean.ClassChapterBean;
import com.edu.accountingteachingmaterial.bean.NodeBean;

public class ExamFragment extends BaseFragment {
	
	ExpandableListView expandableListView;
	List<ClassChapterBean> datas;
	ClassChapterExLvAdapter chapterExLvAdapter;

	@Override
	protected int initLayout() {
		// TODO Auto-generated method stub
		return R.layout.fragment_class;
	}

	@Override
	protected void initView(View view) {
		expandableListView = (ExpandableListView) bindView(R.id.class_classchapter_exlv);

	}

	@Override
	protected void initData() {
		loadData();
		chapterExLvAdapter = new ClassChapterExLvAdapter(context);
		chapterExLvAdapter.setDatas(datas);
		expandableListView.setAdapter(chapterExLvAdapter);
		expandableListView.setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				String id1 = datas.get(groupPosition).getNodes().get(childPosition).getNodeId();
				Log.e("www", id1);
				startActivity(ClassDetailActivity.class);
				// TODO Auto-generated method stub
				return false;
			}
		});
		}
	private void loadData() {
		datas = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ClassChapterBean chapterBean = new ClassChapterBean();
			List<NodeBean> nodes = new ArrayList<>();
			chapterBean.setChapterId(i);
			chapterBean.setTitle("章节标题 编号--" + i);
			for (int j = 0; j < 10; j++) {
				NodeBean node = new NodeBean();

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
