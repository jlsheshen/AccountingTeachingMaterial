package com.edu.accountingteachingmaterial.fragment;

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

	//	gridView = bindView(R.id.exmaple_gv);
		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initData() {
		loadData();
		exampleGVAdapter.setBeans(exampleBeans);
		
		ThumbnailUtils.createVideoThumbnail(filePath, kind)
		//通过ThumbnailUtils的三种静态方法。

//		1. static Bitmap createVideoThumbnail(String filePath, int kind) //获取视频文件的缩略图，第一个参数为视频文件的位置，比如/sdcard/android123.3gp，而第二个参数可以为MINI_KIND或 MICRO_KIND最终和分辨率有关
//		2. static Bitmap extractThumbnail(Bitmap source, int width, int height, int options) //直接对Bitmap进行缩略操作，最后一个参数定义为OPTIONS_RECYCLE_INPUT ，来回收资源
//		3. static Bitmap extractThumbnail(Bitmap source, int width, int height) // 这个和上面的方法一样，无options选项
		// TODO Auto-generated method stub
		
	}

	private void loadData() {
		for (int i = 0; i < 5; i++) {
			ExampleBean exampleBean = new ExampleBean();
			
			
		//	exampleBeans
			
		}
	
		// TODO Auto-generated method stub
		
	}

}
