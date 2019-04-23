package com.supermario.programer.qmuisamples;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.qmuiteam.qmui.widget.QMUIEmptyView;
import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import com.qmuiteam.qmui.widget.pullRefreshLayout.QMUIPullRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Function: 有关刷新和loadingView的页面
 * Author Name: Chris
 * Date: 2019/4/23 14:14
 * Copyright © 2006-2018 高顿网校, All Rights Reserved.
 */

public class RefreshLoadingActivity extends BaseActivity {
    @BindView(R.id.empty_view)
    QMUIEmptyView mEmptyView;
    @BindView(R.id.refresh_layout)
    QMUIPullRefreshLayout mRefreshLayout;
    @BindView(R.id.iv_refresh)
    ImageView mIvRefresh;
    @BindView(R.id.progress_bar)
    QMUIProgressBar mProgressBar;
    @BindView(R.id.loading_view)
    QMUILoadingView mLoadingView;
    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_loading);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        mLoadingView.setColor(getResources().getColor(R.color.colorAccent));
        mLoadingView.setSize(120);
        mLoadingView.start();
        mHandler = new Handler();
        mHandler.postDelayed(() -> {
            mLoadingView.stop();
            mLoadingView.setVisibility(View.GONE);
        }, 3000);
        mRefreshLayout.setOnPullListener(new QMUIPullRefreshLayout.OnPullListener() {
            @Override
            public void onMoveTarget(int offset) {

            }

            @Override
            public void onMoveRefreshView(int offset) {

            }

            @Override
            public void onRefresh() {
                mHandler.postDelayed(() -> {
                    mRefreshLayout.finishRefresh();
                    mRefreshLayout.setVisibility(View.GONE);
                    mEmptyView.show(false, "error", "loading error",
                            "click to reload", v -> {
                                mEmptyView.setLoadingShowing(true);
                                mProgressBar.setVisibility(View.VISIBLE);
                                mProgressBar.setProgress(66, true);
                            });
                }, 2000);

                mHandler.postDelayed(() -> {
                    if (mEmptyView.isShowing() && mEmptyView.isLoading()) {
                        mEmptyView.hide();
                        mRefreshLayout.setVisibility(View.VISIBLE);
                        mIvRefresh.setVisibility(View.VISIBLE);
                        mProgressBar.setVisibility(View.GONE);
                    }
                }, 5000);
            }
        });
    }
}
