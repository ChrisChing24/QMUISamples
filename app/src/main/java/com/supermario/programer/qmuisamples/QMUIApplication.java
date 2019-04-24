package com.supermario.programer.qmuisamples;

import android.app.Application;

import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;

/**
 * Function: Application
 * Author Name: Chris
 * Date: 2019/4/23 10:00
 */

public class QMUIApplication extends Application {

    public static QMUIApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        //初始化可以侧滑退出activity
        QMUISwipeBackActivityManager.init(this);
    }

    public static Application getInstance() {
        return sApplication;
    }
}
