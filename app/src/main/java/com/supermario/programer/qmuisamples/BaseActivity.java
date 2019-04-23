package com.supermario.programer.qmuisamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.qmuiteam.qmui.arch.QMUIActivity;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

/**
 * Function: base
 * Author Name: Chris
 * Date: 2019/4/23 13:21
 * Copyright © 2006-2018 高顿网校, All Rights Reserved.
 */

public class BaseActivity extends QMUIActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(this);
    }

    public void initView() {
    }

    public void shortToast(String text) {
        Toast.makeText(QMUIApplication.getInstance(), text, Toast.LENGTH_SHORT).show();
    }

    public void shortToast(int resId) {
        Toast.makeText(QMUIApplication.getInstance(), resId, Toast.LENGTH_SHORT).show();
    }

    public void longToast(String text) {
        Toast.makeText(QMUIApplication.getInstance(), text, Toast.LENGTH_LONG).show();
    }

    public void longToast(int resId) {
        Toast.makeText(QMUIApplication.getInstance(), resId, Toast.LENGTH_LONG).show();
    }
}
