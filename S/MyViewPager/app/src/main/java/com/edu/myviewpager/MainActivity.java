package com.edu.myviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager1,viewPager2;
    List<Fragment> fragments1,fragments2;
    MyAdapter myAdapter1,myAdapter2;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments1 = new ArrayList<>();
        for (int i = 0; i<5;i++){
            fragments1.add(new MyFragment());
        }
        viewPager1 = (ViewPager) findViewById(R.id.big_vp);
        myAdapter1 = new MyAdapter(getSupportFragmentManager());
        myAdapter1.setFragments(fragments1);
        viewPager1.setAdapter(myAdapter1);


    }
}
