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
import com.edu.accountingteachingmaterial.bean.ExercisePracticeBean;
import com.edu.accountingteachingmaterial.constant.ClassContstant;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class ExerciseExLvAdapter extends BaseExpandableListAdapter {


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
        return datas == null ? 0 : datas.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return datas.get(i).getExerciseBeanList() == null ? 0 : datas.get(i).getExerciseBeanList().size();
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
        GroupViewHolder groupViewHolder = null;
        if (view == null || view.getTag(R.id.tag_group) == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_exercise_exlv, viewGroup, false);
            AutoUtils.autoSize(view);

            groupViewHolder = new GroupViewHolder(view);
            view.setTag(R.id.tag_group,groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) view.getTag(R.id.tag_group);
        }
        ExerciseBean exerciseBean = datas.get(i);
        groupViewHolder.testNumTv.setText("" + exerciseBean.getItemNumber());
        groupViewHolder.textimeTv.setText(exerciseBean.getTime());

        switch (exerciseBean.getQuestionType()) {
            case ClassContstant.EXERCISE_BEFORE_CLASS:
                groupViewHolder.headIv.setImageResource(R.mipmap.touxiang_keqian);
                groupViewHolder.titleTv.setText(exerciseBean.getTitle() + "课前预习");
                break;
            case ClassContstant.EXERCISE_IN_CLASS:
                groupViewHolder.headIv.setImageResource(R.mipmap.touxiang_suitang);
                groupViewHolder.titleTv.setText(exerciseBean.getTitle() + "随堂测验");
                break;
            case ClassContstant.EXERCISE_AFTER_CLASS:
                groupViewHolder.headIv.setImageResource(R.mipmap.touxiang_kehou);
                groupViewHolder.titleTv.setText(exerciseBean.getTitle() + "课后作业");
                break;
        }
        switch (exerciseBean.getExerciseStatus()) {
            case ClassContstant.EXAM_COMMIT:
                groupViewHolder.stautsIv.setImageResource(R.mipmap.btn_yituijiao_n);

                break;
            case ClassContstant.EXAM_DOWNLOADING:
                groupViewHolder.stautsIv.setVisibility(View.GONE);
                groupViewHolder.progressBar.setVisibility(View.VISIBLE);
                break;
            case ClassContstant.EXAM_NOT:

                break;
            case ClassContstant.EXAM_READ:
                groupViewHolder.stautsIv.setImageResource(R.mipmap.btn_yipiyue_n);

                break;
            case ClassContstant.EXMA_UNDONE:
                groupViewHolder.stautsIv.setImageResource(R.mipmap.btn_weitijiao_n);

                break;
        }
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ChildViewHolder childViewHolder = null;
        if (view == null || view.getTag(R.id.tag_child) == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_exercise_practice_exlv, viewGroup, false);
            AutoUtils.autoSize(view);

            childViewHolder = new ChildViewHolder(view);
            view.setTag(R.id.tag_child, childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) view.getTag(R.id.tag_child);
        }
        ExercisePracticeBean exercisePracticeBean = datas.get(i).getExerciseBeanList().get(i1);
        childViewHolder.contentTv.setText(exercisePracticeBean.getContent());
        String s = null;
        switch (exercisePracticeBean.getQuestionType()) {
            case ClassContstant.SUBJECT_SINGLE_CHOSE:
                s = ClassContstant.SUBJECT_SINGLE_CHOSE_STRING;
                break;
            case ClassContstant.SUBJECT_MULITI_CHOSE:
                s = ClassContstant.SUBJECT_MULITI_CHOSE_STRING;
                break;
            case ClassContstant.SUBJECT_JUDGE:
                s = ClassContstant.SUBJECT_JUDGE_STRING;
                break;
            case ClassContstant.SUBJECT_PRACTIAL:
                s = ClassContstant.SUBJECT_PRACTIAL_STRING;
                break;
            case ClassContstant.SUBJECT_ENTRY:
                s = ClassContstant.SUBJECT_ENTRY_STRING;
                break;
            case ClassContstant.SUBJECT_BILL:
                s = ClassContstant.SUBJECT_BILL_STRING;
                break;
            case ClassContstant.SUBJECT_GROUP_BILL:
                s = ClassContstant.SUBJECT_GROUP_BILL_STRING;
                break;
        }
        childViewHolder.numTv.setText(exercisePracticeBean.getPracticeNum() + " " + s);
        switch (exercisePracticeBean.isRight()) {
            case ClassContstant.ANSWER_RIGHT:
                childViewHolder.isRightIv.setImageResource(R.mipmap.icon_dui_n);
                childViewHolder.isRightIv.setVisibility(View.VISIBLE);
                break;
            case ClassContstant.ANSWER_ERROR:
                childViewHolder.isRightIv.setImageResource(R.mipmap.icon_cuo_n);
                childViewHolder.isRightIv.setVisibility(View.VISIBLE);

                break;
            default:
                break;
        }
        return view;
    }
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    class GroupViewHolder {
        TextView titleTv, textimeTv, testNumTv;
        ImageView headIv, stautsIv;
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

    class ChildViewHolder {
        TextView numTv, contentTv;
        ImageView isRightIv;

        public ChildViewHolder(View view) {
            numTv = (TextView) view.findViewById(R.id.item_practice_number_tv);
            contentTv = (TextView) view.findViewById(R.id.item_practice_content_tv);
            isRightIv = (ImageView) view.findViewById(R.id.item_practice_isright_iv);

        }
    }


}
