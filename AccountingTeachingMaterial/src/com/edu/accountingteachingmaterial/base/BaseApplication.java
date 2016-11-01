package com.edu.accountingteachingmaterial.base;

import android.content.Context;

import com.edu.library.EduCrashApplication;

public class BaseApplication extends EduCrashApplication {
	//找不到context时使用此context
	private static Context context ;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		context = this;
	}

	public static Context getContext() {
		return context;
	}

}
