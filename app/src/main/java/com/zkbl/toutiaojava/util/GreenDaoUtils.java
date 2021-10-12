package com.zkbl.toutiaojava.util;

import android.content.Context;

import com.zkbl.toutiaojava.base.TouTiaoApplication;
import com.zkbl.toutiaojava.greenDao.DaoSession;
import com.zkbl.toutiaojava.greenDao.GoodDao;
import com.zkbl.toutiaojava.greenDaoBean.Good;

import java.util.List;

/**
 * Create by StoneBang at 2021/9/27
 */
public class GreenDaoUtils {
    private static GreenDaoUtils instance;
    private static Context context;
    private DaoSession daoSession;
    private GoodDao goodDao;
    private GreenDaoUtils(Context context){
        this.context = context;
        this.daoSession = ((TouTiaoApplication)context.getApplicationContext()).getDaoSession();
        this.goodDao = daoSession.getGoodDao();
    }
    public static GreenDaoUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (GreenDaoUtils.class) {
                if (instance == null) {
                    instance = new GreenDaoUtils(context);
                }
            }
        }
        return instance;
    }
    public void insertGoods(List<Good> list){
        goodDao.insertInTx(list);
    }

    public List<Good>  queryGoods(String goodId){
        List<Good> queryGood = goodDao.queryBuilder().where(GoodDao.Properties.Id.eq(goodId)).list();
        return queryGood;
    }
    public List<Good>  queryGoods(){
        List<Good> queryGood = goodDao.queryBuilder().list();
        return queryGood;
    }


    public void deleteGoods(){
        goodDao.deleteAll();
    }
}
