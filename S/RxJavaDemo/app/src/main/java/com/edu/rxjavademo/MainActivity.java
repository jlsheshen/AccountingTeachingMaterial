package com.edu.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    String TAG = "rxjava";
    List<String> strings  = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

//        Subscriber<String> observer = new Subscriber<String>() {
//
//            @Override
//            public void onCompleted() {
//                Log.d(TAG, "onCompleted: ");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "onError: ");
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d(TAG, "onNext: " + s);
//
//            }
//
//            @Override
//            public void onStart() {
//                super.onStart();
//            }
//
//        };
//        //解绑
//        observer.unsubscribe();
//
//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Hello");
//                subscriber.onNext("Wrold");
//                subscriber.onCompleted();
//            }
//        });
//        observable.subscribe(observer);
//    }


//    Observable.just("Hello","word").subscribe(new Action1<String>() {
//        @Override
//        public void call(String s) {
//            Log.d(TAG, "call: "+s);
//        }
//    });
        Student s1 = new Student("123",1);
        Student s2 = new Student("456",2);
        Student s3 = new Student("789",3);
////
////
//        Observable.just(s1,s2,s3).map(new Func1<Student, String>() {
//            @Override
//            public String call(Student student) {
//                String s= student.getName();
//
//                Log.d("MainActivity", "aaaaaaaa" + s);
//
//                return s;
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.d("MainActivity", "bbbbbbbb" + s);
//                strings.add(s);
//                TextView textView = (TextView) findViewById(R.id.string);
//                textView.setText(s);
//            }
//        }
//                );
//        for (int i = strings.size() - 1; i >= 0; i--) {
//
//            Log.d("MainActivity", strings.get(i).toString());
//        }
        Observable.just(s1,s2,s3).subscribeOn(Schedulers.newThread()).map(new Func1<Student, String>() {

            @Override
            public String call(Student student) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return student.getName();
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Toast.makeText(MainActivity.this, "wwww" + s, Toast.LENGTH_SHORT).show();
            }
        });

//        Observable.just("Hello", "Wrold")
//                .subscribeOn(Schedulers.newThread())//指定：在新的线程中发起
//                .observeOn(Schedulers.io())         //指定：在io线程中处理
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        return handleString(s);       //处理数据
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())//指定：在主线程中处理
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        show(s);                       //消费事件
//                    }
//                });



}
}
