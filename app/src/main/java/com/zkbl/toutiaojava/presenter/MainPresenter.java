package com.zkbl.toutiaojava.presenter;

import android.content.Context;
import android.util.Log;
import android.util.Xml;

import com.zkbl.toutiaojava.bean.BaseModel;
import com.zkbl.toutiaojava.bean.ManuFacture;
import com.zkbl.toutiaojava.http.DownLoadUtil;
import com.zkbl.toutiaojava.http.DownloadListener;
import com.zkbl.toutiaojava.http.HttpUtil;
import com.zkbl.toutiaojava.http.ResponseListener;
import com.zkbl.toutiaojava.presenter.View.BaseView;
import com.zkbl.toutiaojava.presenter.View.MainView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;

/**
 * Create by StoneBang at 2021/9/12
 */
public class MainPresenter extends BasePresenter<MainView> {
    private Context context;

    public MainPresenter(Context context) {
        this.context = context;
    }

    public void loadData(){
//        HttpUtil.getManufacturerList(new ResponseListener<BaseModel<ManuFacture>>() {
//            @Override
//            public void onSuccess(BaseModel<ManuFacture> data) {
//                Log.e("TAG", "onSuccess: " );
//                getBaseView().setData(data);
//            }
//
//            @Override
//            public void onFail(String msg) {
//                Log.e("TAG", "fail: " );
//            }
//        });
//        parseXml("/data/data/com.zkbl.toutiaojava/files.xml");
        DownLoadUtil.download("/data/data/com.zkbl.toutiaojava/files.xml", new DownloadListener() {
            @Override
            public void onStart() {
                Log.e("TAG", "onStart: ");
            }

            @Override
            public void onProgress(int progress) {
                Log.e("TAG", "onProgress: "+progress);
            }

            @Override
            public void onFinish(String path) {
                Log.e("TAG", "onFinish: ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        parseXml(path);
                    }
                }).start();
            }

            @Override
            public void onFail(String errorInfo) {
                Log.e("TAG", "onFail: ");
            }
        });

    }
    public void parseXml(String path){

        try {
            //创建XmlPullParser
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            // 获得xml解析类的引用
            XmlPullParser parser = factory.newPullParser();
            FileInputStream fileInputStream = new FileInputStream(path);
            //解析文件输入流
            parser.setInput(fileInputStream,"UTF-8");

            int eventType=parser.getEventType();
            //当解析工作还没完成时，调用next（）方法得到下一个解析事件
            while (eventType!=XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:

                        break;
                    case XmlPullParser.START_TAG:
                        if(!"config".equals(parser.getName()) && !"apk_info".equals(parser.getName())&& !"program_path".equals(parser.getName())){
                            Log.e("TAG",String.valueOf(parser.nextText()));
                        }

//                        if("program_list".equals(parser.getName())){
//
//                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("step".equals(parser.getName())){
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

