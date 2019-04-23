package com.supermario.programer.qmuisamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.CircularProgressDrawable;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButtonDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Function: QMUIGroupListView Samples
 * Author Name: Chris
 * Date: 2019/4/22 18:29
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.top_bar)
    QMUITopBar mTopBar;
    @BindView(R.id.group_list_view)
    QMUIGroupListView mGroupListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        mTopBar.setTitle("MainActivity");
        mTopBar.addLeftBackImageButton();

        //展示普通文字的item
        QMUIGroupListView.newSection(this)
                .setTitle("section 1 title")
                .setDescription("section 1 description")
                .addItemView(mGroupListView.createItemView("item 1"),
                        v -> startActivity(new Intent(MainActivity.this, DialogActivity.class)))
                .addItemView(mGroupListView.createItemView("item 2"),
                        v -> startActivity(new Intent(MainActivity.this, RefreshLoadingActivity.class)))
                .addTo(mGroupListView);

        //展示带drawable的item
        QMUIGroupListView.newSection(this)
                .setTitle("section 2 title")
                .setDescription("section 2 description")
                .addItemView(mGroupListView.createItemView(new CircularProgressDrawable(this),
                        "section 2 item 1 title", "section 2 item 1 description",
                        QMUICommonListItemView.VERTICAL,
                        QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON),
                        v -> shortToast("section 2 item 1"))
                .addItemView(mGroupListView.createItemView(new QMUIRoundButtonDrawable(),
                        "section 2 item 2 title", "section 2 item 2 description",
                        QMUICommonListItemView.HORIZONTAL,
                        QMUICommonListItemView.ACCESSORY_TYPE_SWITCH),
                        v -> shortToast("section 2 item 2"))
                .addTo(mGroupListView);
    }
}
