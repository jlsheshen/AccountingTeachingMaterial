package com.edu.accountingteachingmaterial.activity;


import android.os.Bundle;

import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.base.BaseActivity;
import com.edu.accountingteachingmaterial.bean.subject.BaseTestData;
import com.edu.accountingteachingmaterial.dao.SubjectTestDataDao;
import com.edu.subject.TestMode;

import java.util.List;


/**
 * Created by Administrator on 2016/11/18.
 */

public class ExamTestActivity  extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_test;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        List<BaseTestData> datas = SubjectTestDataDao.getInstance(this).getSubjects(TestMode.MODE_EXAM);


    }

    @Override
    public void initData() {

    }
}

