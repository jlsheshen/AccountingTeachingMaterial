package com.edu.accountingteachingmaterial.activity;


import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.base.BaseActivity;
import com.edu.accountingteachingmaterial.fragment.ClassFragment;
import com.edu.accountingteachingmaterial.fragment.ExamFragment;
import com.edu.accountingteachingmaterial.fragment.MyFragment;
import com.edu.library.util.ToastUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.RadioButton;

public class MainActivity extends BaseActivity implements OnClickListener, DrawerListener {


	RadioButton classButton,examButton, myButton, settingButton;
	Fragment classFragment,examFragment,myFragment;
	DrawerLayout drawerLayout;

	@Override
	public int setLayout() {
		// TODO Auto-generated method stub
		return R.layout.activity_main;
	}

	@Override
	public void initView(Bundle savedInstanceState) {
		bindAndListener(classButton, R.id.main_class_iv);
		bindAndListener(examButton, R.id.main_exam_iv);
		bindAndListener(myButton, R.id.main_my_iv);
		bindAndListener(settingButton, R.id.main_setting_iv);
		drawerLayout = bindView(R.id.main_aty_seeting);
		

		// TODO Auto-generated method stub

	}

	@Override
	public void initData() {
		if (null == classFragment) {
			classFragment = new ClassFragment();
        }
		replaceFragment(classFragment );

		
		

	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_class_iv:
			if (null == classFragment) {
				classFragment = new ClassFragment();
            }
			replaceFragment(classFragment );
           
			break;
		case R.id.main_exam_iv:
			if (null == examFragment) {
				examFragment = new ExamFragment();
            }
			replaceFragment(examFragment );
			
			break;
		case R.id.main_my_iv:
			if (null == myFragment) {
				myFragment = new MyFragment();
            }
			replaceFragment(myFragment );

			break;
		case R.id.main_setting_iv:
			
	           drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

               drawerLayout.setDrawerListener(this);
               //从左侧划出
               drawerLayout.openDrawer(Gravity.LEFT);
               
               //设置背景颜色
        //       drawerLayout.setScrimColor(Color.TRANSPARENT);

			break;
		}
		// TODO Auto-generated method stub

	}


	private void replaceFragment(Fragment fragment) {
		FragmentTransaction transaction  =  getSupportFragmentManager().beginTransaction();
         transaction.replace(R.id.main_aty_view,fragment);             
         // Commit the transaction
         transaction.commit();
		
	}

	private void bindAndListener(View view, int id) {
		view = bindView(id);
		view.setOnClickListener(this);
	}

	@Override
	public void onDrawerClosed(View arg0) {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
		
	}

	@Override
	public void onDrawerOpened(View arg0) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDrawerSlide(View arg0, float arg1) {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
		
	}

	@Override
	public void onDrawerStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}





	
}
