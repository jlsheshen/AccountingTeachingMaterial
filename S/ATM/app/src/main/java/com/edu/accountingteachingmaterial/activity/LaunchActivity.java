package com.edu.accountingteachingmaterial.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;







import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.base.BaseActivity;



public class LaunchActivity extends BaseActivity{
	CountDownTimer timer;

	@Override
	public int setLayout() {
		// TODO Auto-generated method stub
		return R.layout.activity_launch;
	}

	@Override
	public void initView(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		timer = new CountDownTimer(3000,1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub

			}
			
			@Override
			public void onFinish() {
				startActivity(MainActivity.class);
				finish();
			}
		}.start();
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}



	
}
