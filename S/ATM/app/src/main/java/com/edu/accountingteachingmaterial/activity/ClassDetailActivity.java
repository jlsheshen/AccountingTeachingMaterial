package com.edu.accountingteachingmaterial.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.base.BaseActivity;
import com.edu.accountingteachingmaterial.fragment.ClassEmphasisFragment;
import com.edu.accountingteachingmaterial.fragment.ClassExampleFragment;
import com.edu.accountingteachingmaterial.fragment.ClassFragment;

public class ClassDetailActivity extends BaseActivity implements OnClickListener {
	// 重点难点,经典实例,精选练习,自我检测
	RadioButton classEmphasisButton, classExampleButton, classExerciseButton, classReviewButton;
	Fragment classEmphasisFragment, classExampleFragment, classExerciseFragment, classReviewFragment;

	@Override
	public int setLayout() {
		// TODO Auto-generated method stub
		return R.layout.activity_class_detail;
	}

	@Override
	public void initView(Bundle savedInstanceState) {
		bindAndListener(classEmphasisButton, R.id.class_emphasis_iv);
		bindAndListener(classExampleButton, R.id.class_example_iv);
		bindAndListener(classExerciseButton, R.id.class_exercise_iv);
		bindAndListener(classReviewButton, R.id.class_review_iv);


	}

	@Override
	public void initData() {
		if (null == classEmphasisFragment) {
			classEmphasisFragment = new ClassEmphasisFragment();
        }
		replaceFragment(classEmphasisFragment );

		// TODO Auto-generated method stub

	}

	private void replaceFragment(Fragment fragment) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.class_aty_view, fragment);
		// Commit the transaction
		transaction.commit();

	}

	private void bindAndListener(View view, int id) {
		view = bindView(id);
		view.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.class_emphasis_iv:
			if (null == classEmphasisFragment) {
				classEmphasisFragment = new ClassEmphasisFragment();
            }
			replaceFragment(classEmphasisFragment );
			break;

		case R.id.class_example_iv:
			if (null == classExampleFragment) {
				classExampleFragment = new ClassExampleFragment();
            }
			replaceFragment(classExampleFragment );
			break;
		case R.id.class_exercise_iv:
			if (null == classExerciseFragment) {
				classExerciseFragment = new ClassFragment();
            }
			replaceFragment(classExerciseFragment );
			break;
		case R.id.class_review_iv:
			if (null == classReviewFragment) {
				classReviewFragment = new ClassFragment();
            }
			replaceFragment(classReviewFragment );
			break;

		}

	}

}
