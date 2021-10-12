package com.zkbl.toutiaojava.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zkbl.toutiaojava.R;
import com.zkbl.toutiaojava.base.BaseActivity;
import com.zkbl.toutiaojava.bean.github.GithubUser;
import com.zkbl.toutiaojava.greenDaoBean.Good;
import com.zkbl.toutiaojava.http.github.GithubService;
import com.zkbl.toutiaojava.http.github.ServiceFactory;
import com.zkbl.toutiaojava.http.github.User;
import com.zkbl.toutiaojava.presenter.BasePresenter;
import com.zkbl.toutiaojava.presenter.MainPresenter;
import com.zkbl.toutiaojava.presenter.View.MainView;
import com.zkbl.toutiaojava.ui.customerView.spinner.NiceSpinner;
import com.zkbl.toutiaojava.ui.customerView.spinner.OnSpinnerItemSelectedListener;
import com.zkbl.toutiaojava.util.GreenDaoUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

public class MainActivity extends BaseActivity<MainView> implements MainView {

    private  final String[] mFamousUsers =  {"SpikeKing", "JakeWharton", "rock3r", "Takhion", "dextorer", "Mariuxtheone"};
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        GithubService gitHubService = ServiceFactory.createServiceFrom(GithubService.class, GithubService.ENDPOINT);
//        Observable.interval(2000,TimeUnit.MILLISECONDS).take(10).subscribe(new Observer<Long>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Long aLong) {
//                Log.e("TAG", "得到的数据"+aLong );
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        Observable.fromArray(mFamousUsers) //我的参数是什么呢？ {}
                .flatMap(gitHubService::getUserData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GithubUser>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull GithubUser githubUser) {
                        Log.e("TAG", "得到的数据"+githubUser );
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
//        NiceSpinner spinner = findViewById(R.id.nice_spinner);
//        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
//        spinner.attachDataSource(dataset);
//        spinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
//            @Override
//            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
//                String item = parent.getItemAtPosition(position).toString();
//                Toast.makeText(MainActivity.this, "Selected: " + item, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void queryClick(View view) {
        List<Good> goodList = GreenDaoUtils.getInstance(this).queryGoods();
        Log.e("TAG", "queryClick: "+goodList.size() );
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
//        LCObject testObject = new LCObject("TestObject");
//        testObject.put("words", "Hello world!");
//        testObject.saveInBackground().blockingSubscribe();
//        ((MainPresenter)getPresenter()).loadData();
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