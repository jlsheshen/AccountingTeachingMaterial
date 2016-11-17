package com.edu.myviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/11/15.
 */

public class MyFragment extends Fragment {
    private static final String TAG_POSITION = "fragmentPositionTag";
    ViewPager viewPager2;
    List<Fragment> fragments2;
    MyAdapter myAdapter2;
    ImageView view1;
    View viewLayout;
    ScrollView scrollView,backgroundSv;
    LinearLayout linearLayout;
    private int startX;
    private int startY;
Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

    }

    public MyFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewLayout = LayoutInflater.from(context).inflate(R.layout.one_fragment,container,false);
view1 = (ImageView) viewLayout.findViewById(R.id.on_down);
        scrollView = (ScrollView) viewLayout.findViewById(R.id.blow_sv);
        viewPager2 = (ViewPager)viewLayout.findViewById(R.id.small_vp);
        backgroundSv = (ScrollView) viewLayout.findViewById(R.id.background_sv);
          linearLayout = (LinearLayout) viewLayout.findViewById(R.id.blow_ly);
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 初始化起点坐标
                        //startX = (int) motionEvent.getRawX();
                        startY = (int) motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                      //  int endX = (int) motionEvent.getRawX();
                        int endY = (int) motionEvent.getRawY();

                        // 计算移动偏移量
                       // int dx = endX - startX;
                        int dy = endY - startY;
//                       ViewGroup.LayoutParams layoutParams =  viewPager2.getLayoutParams();
//                        layoutParams.height =view.getBottom() + dy;

                        // 更新左上右下距离
//                        int l = view.getLeft() + dx;
//                        int r = view.getRight() + dx;
                        int t = view.getTop() + dy;
                        int b = view.getBottom() + dy;
                        // 判断是否超出屏幕边界, 注意状态栏的高度
//                        if (l < 0 || r > winWidth || t < 0 || b > winHeight - 20) {
//                            break;
//                        }

                        // 更新界面
                      //  view.layout(view.getLeft(), t, view.getRight(), b);
    //                    viewPager2.setTop( view.getBottom() + dy);
                   //    scrollView.setTop(view.getBottom() + dy);
                       backgroundSv.setBottom(backgroundSv.getBottom()+ dy);
                        Log.d("MyFragment", "getScrollY: " + backgroundSv.getScrollY());
//                        Log.d("MyFragment", "getMaxScrollAmount: " + backgroundSv.getChildAt(0).getMeasuredHeight());
                        Log.d("MyFragment", "backgroundSv.getHeight(): " + backgroundSv.getHeight());
//                        Log.d("MyFragment", "dy " + dy);

                        if (backgroundSv.getScrollY()+ backgroundSv.getHeight() >= backgroundSv.getChildAt(0).getMeasuredHeight() ){
                            Log.d("MyFragment", "走没走这里: ");
                            backgroundSv.scrollTo(0,backgroundSv.getChildAt(0).getMeasuredHeight()- backgroundSv.getHeight());
                        }
                        //backgroundSv.scrollTo(0,backgroundSv.getBottom()+ dy);
                        linearLayout.setTop(linearLayout.getTop() + dy);

                        // 重新初始化起点坐标
                        //startX = (int) motionEvent.getRawX();
                        startY = (int) motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


        return viewLayout;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        fragments2 = new ArrayList<>();
        for (int i = 0; i<3;i++){
            fragments2.add(new TwoFragment());
        }
        myAdapter2 = new MyAdapter(getActivity().getSupportFragmentManager());
        myAdapter2.setFragments(fragments2);
        viewPager2.setAdapter(myAdapter2);
    }

    public static MyFragment newInstance(int position) {
        Bundle args = new Bundle();
        //在这里只需 给bundle赋值 ( key_value的形式)
        args.putInt(TAG_POSITION, position);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;


    }
}
