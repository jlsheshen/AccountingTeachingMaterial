package com.edu.rxjavademo;

import java.util.HashMap;

import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/11/17.
 */

public class RxBux {
    private static volatile RxBux mInstance;
    private SerializedSubject<Object,Object> mSubject;
    private HashMap<String,CompositeSubscription> mSubscription;

    private RxBux() {
        mSubject = new SerializedSubject<>(PublishSubject.create());

    }
}
