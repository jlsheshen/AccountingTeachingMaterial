package com.edu.accountingteachingmaterial.fragment;

import java.util.ArrayList;
import java.util.List;

import android.media.ThumbnailUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.adapter.ExampleGVAdapter;
import com.edu.accountingteachingmaterial.base.BaseFragment;
import com.edu.accountingteachingmaterial.bean.ExampleBean;

/**
 * 经典示例
 * 
 * @author xd
 * 
 */
public class ClassExampleFragment extends BaseFragment {
	GridView gridView;
	ExampleGVAdapter exampleGVAdapter;
	List<ExampleBean> exampleBeans;

	@Override
	protected int initLayout() {
		// TODO Auto-generated method stub
		return R.layout.fragment_class_example;
	}

	@Override
	protected void initView(View view) {

		gridView = bindView(R.id.exmaple_gv);

		// TODO Auto-generated method stub

	}

	@Override
	protected void initData() {

		loadData();
		exampleGVAdapter = new ExampleGVAdapter(context);
		exampleGVAdapter.setBeans(exampleBeans);
		gridView.setAdapter(exampleGVAdapter);

	}

	private void loadData() {
		exampleBeans = new ArrayList<>();
		ExampleBean exampleBean = new ExampleBean();
		exampleBean.setName("第一节视频");
		exampleBean.setUrl("VID_20161103_125654.mp4");
		exampleBean.setType(1);
		exampleBeans.add(exampleBean);
		ExampleBean exampleBean1 = new ExampleBean();
		exampleBean1.setName("第二节图片");
		exampleBean1.setUrl("");
		exampleBean1.setType(3);

		exampleBeans.add(exampleBean1);

	}

}
