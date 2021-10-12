package com.zkbl.toutiaojava.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.zkbl.toutiaojava.greenDao.DaoMaster;
import com.zkbl.toutiaojava.greenDao.DaoSession;

import org.greenrobot.greendao.database.Database;

import cn.leancloud.LCLogger;
import cn.leancloud.LeanCloud;

/**
 * Create by StoneBang at 2021/9/27
 */
public class TouTiaoApplication extends Application {
    public DaoSession daoSession;

    public DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDataBase();
        LeanCloud.setLogLevel(LCLogger.Level.DEBUG);
        LeanCloud.initialize(this,"RhlN9dAQ2NdA9xN5EQLlP86f-gzGzoHsz","eSqsG0qebrow3M7sKwvdo4yV","https://rhln9daq.lc-cn-n1-shared.com");
    }

    public void initDataBase(){
        DataBaseOpenHelper dbHelper = new DataBaseOpenHelper(getApplicationContext(),"cassette");
        SQLiteDatabase dbDataBase = dbHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(dbDataBase);
        daoSession = daoMaster.newSession();
    }
    public static class DataBaseOpenHelper extends DaoMaster.OpenHelper {

        public DataBaseOpenHelper(Context context, String name) {
            super(context, name);
        }

        @Override
        public void onCreate(Database db) {
            super.onCreate(db);
//            db.execSQL("INSERT INTO "+ "ConfigDao.TABLENAME"+" VALUES(1,'','','','','','','')");
            // Insert some example data.
            // INSERT INTO NOTE (_id, DATE, TEXT) VALUES(1, 0, 'Example Note')
//			db.execSQL("INSERT INTO " + StepInfoDao.TABLENAME + " (" +
//					StepInfoDao.Properties.Id.columnName + ", " +
//					StepInfoDao.Properties.ProgramId.columnName + ", " +
//					StepInfoDao.Properties.StepName.columnName + ", " +
//					StepInfoDao.Properties.HolePosition.columnName + ", " +
//					StepInfoDao.Properties.Volume.columnName + ", " +
//					StepInfoDao.Properties.Speed.columnName + ", " +
//					StepInfoDao.Properties.Time.columnName +
//					") VALUES(1,1,'成功名字',1,1.0,1.0,1)");
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String date = simpleDateFormat.format(new Date());
//			db.execSQL("INSERT INTO " + ProgramInfoDao.TABLENAME + " (" +
//					ProgramInfoDao.Properties.Id.columnName + ", " +
//					ProgramInfoDao.Properties.ProgramName.columnName + ", " +
//					ProgramInfoDao.Properties.CreateTime.columnName + ", " +
//					ProgramInfoDao.Properties.IsCheck.columnName+
//					") VALUES(1,'测试流程','"+date+"',1)");
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            super.onUpgrade(db, oldVersion, newVersion);
//            DaoMaster.dropAllTables(db,true);
//            onCreate(db);
        }
    }
}
