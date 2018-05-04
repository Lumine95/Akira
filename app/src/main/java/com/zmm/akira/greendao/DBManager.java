package com.zmm.akira.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zmm.akira.dao.DaoMaster;
import com.zmm.akira.dao.DaoSession;

/**
 * Created by ZMM on 2018/5/4 13:41.
 */

public class DBManager {
    public static final boolean ENCRYPTED = true;   // 是否加密
    private static final String DB_NAME = "test.db";
    private Context mContext;
    private  static   DaoMaster.DevOpenHelper devOpenHelper;
    private static DBManager dbManager;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    public DBManager(Context context) {
        mContext = context;
        // Initialize database information.
        devOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        getDaoMaster(context);
        getDaoSession(context);
    }

    /**
     * 获取可读数据库
     *
     * @param context
     * @return
     */
    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (null == devOpenHelper) {
            getInstance(context);
        }
        return devOpenHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     *
     * @param context
     * @return
     */
    public static  SQLiteDatabase getWritableDatabase(Context context) {
        if (devOpenHelper == null) {
            getInstance(context);
        }
        return devOpenHelper.getWritableDatabase();
    }

    public  static  DaoMaster getDaoMaster(Context context) {
        if (daoMaster == null) {
            synchronized (DaoMaster.class) {
                daoMaster = new DaoMaster(getWritableDatabase(context));
            }
        }
        return daoMaster;
    }


    public static  DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            synchronized (DaoMaster.class) {
                daoSession = getDaoMaster(context).newSession();
            }
        }
        return null;
    }

    public static DBManager getInstance(Context context) {
        synchronized (DBManager.class) {
            if (dbManager == null) {
                dbManager = new DBManager(context);
            }
        }
        return dbManager;
    }
}
