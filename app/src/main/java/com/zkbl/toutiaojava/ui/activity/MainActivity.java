package com.zkbl.toutiaojava.ui.activity;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zkbl.toutiaojava.R;
import com.zkbl.toutiaojava.base.BaseActivity;
import com.zkbl.toutiaojava.observer.core.Emmiter;
import com.zkbl.toutiaojava.observer.core.OberservableCreate;
import com.zkbl.toutiaojava.observer.core.ObservableOnSubscribe;
import com.zkbl.toutiaojava.observer.core.Observer;
import com.zkbl.toutiaojava.presenter.BasePresenter;
import com.zkbl.toutiaojava.presenter.MainPresenter;
import com.zkbl.toutiaojava.presenter.View.MainView;
import com.zkbl.toutiaojava.ui.customerView.spinner.NiceSpinner;
import com.zkbl.toutiaojava.ui.customerView.spinner.OnSpinnerItemSelectedListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends BaseActivity<MainView> implements MainView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        NiceSpinner spinner = findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        spinner.attachDataSource(dataset);
        spinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Selected: " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }
    class Person {

        private String name;
        private String surname;

        Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        String getName() {
            return name;
        }

        String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return name + " " + surname;
        }
    }
    @Override
   protected void init() {
        ((MainPresenter)getPresenter()).loadData();
//         OberservableCreate .create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subScribe(Emmiter emmiter) {
//                Log.e("TAG", "subScribe: 订阅的内容" );
//                emmiter.onNext(3434);
//
//            }
//         }).subScribeObserver(new Observer<Integer>() {
//            @Override
//            public void onNext(Integer o) {
//                Log.e("TAG", "onNext 收到的内容为 "+ o);
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//
//            }
//
//            @Override
//            public void onSubscribe() {
//                Log.e("TAG", "subScribe: 开始订阅" );
//            }
//         });
    }

    @Override
    protected BasePresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void setData(Object data) {
        Log.e("TAG", "setData: "+data );
    }

    @Override
    public void setError() {

    }
}