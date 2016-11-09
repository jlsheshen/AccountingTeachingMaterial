package com.edu.accountingteachingmaterial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.edu.accountingteachingmaterial.R;
import com.edu.accountingteachingmaterial.bean.ExerciseBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class ExerciseExLvAdapter extends BaseExpandableListAdapter {
    private static final int GROUP_KEY = 1;
    private static final int CHILD_KEY = 2;

    Context context;
    List<ExerciseBean> datas;

    public ExerciseExLvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<ExerciseBean> datas) {
        this.datas = datas;
    }


    @Override
    public int getGroupCount() {
        return datas == null?0:datas.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return datas.get(i).getExerciseBeanList() == null?0:datas.get(i).getExerciseBeanList().size();
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupViewHolder  groupViewHolder= null;
      if ( view == null||view.getTag(GROUP_KEY) == null){
          view= LayoutInflater.from(context).inflate(R.layout.item_exercise_exlv,viewGroup,false);
          groupViewHolder = new GroupViewHolder(view);
          view.setTag(GROUP_KEY);
      }else {
          groupViewHolder = (GroupViewHolder) view.getTag(GROUP_KEY);
      }
        ExerciseBean exerciseBean = datas.get(i);




        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {


        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class GroupViewHolder{
        TextView titleTv,textimeTv,testNumTv;
        ImageView headIv,stautsIv;
        ProgressBar progressBar;
        public GroupViewHolder(View view) {
            titleTv = (TextView) view.findViewById(R.id.item_exercise_title_tv);
            textimeTv = (TextView) view.findViewById(R.id.item_exercise_time_tv);
            testNumTv = (TextView) view.findViewById(R.id.item_exercise_testnum_tv);
            headIv = (ImageView) view.findViewById(R.id.item_exercise_head_iv);
            stautsIv = (ImageView) view.findViewById(R.id.item_exercise_type_iv);
            progressBar = (ProgressBar) view.findViewById(R.id.item_exercise_type_pb);
        }

    }

}
