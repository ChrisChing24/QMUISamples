package com.supermario.programer.qmuisamples;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Function: 显示各种dialog的activity
 * Author Name: Chris
 * Date: 2019/4/23 10:44
 * Copyright © 2006-2018 高顿网校, All Rights Reserved.
 */

public class DialogActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_message, R.id.btn_confirm, R.id.btn_edittext, R.id.btn_menu,
            R.id.btn_checkable, R.id.btn_multi_checkable, R.id.btn_auto_resize,
            R.id.btn_bottom_list, R.id.btn_bottom_grid, R.id.btn_tip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_message:
                new QMUIDialog.MessageDialogBuilder(this)
                        .setMessage("this is message dialog")
                        .setTitle("Message")
                        .addAction("OK", (dialog, index) -> shortToast(String.valueOf(index)))
                        .addAction("Cancel", (dialog, index) -> dialog.dismiss())
                        .show();
                break;
            case R.id.btn_confirm:

                break;
            case R.id.btn_edittext:
                new QMUIDialog.EditTextDialogBuilder(this)
                        .setDefaultText("this is EditText dialog")
                        .setInputType(EditorInfo.TYPE_CLASS_TEXT)
                        .setPlaceholder("input text")
                        .show();
                break;
            case R.id.btn_menu:
                new QMUIDialog.MenuDialogBuilder(this)
                        .addItems(new String[]{"first", "second", "third"},
                                (dialog, which) -> shortToast(String.valueOf(which)))
                        .show();
                break;
            case R.id.btn_checkable:
                QMUIDialog.CheckableDialogBuilder checkableDialog =
                        new QMUIDialog.CheckableDialogBuilder(this);
                checkableDialog.addItems(new String[]{"first", "second", "third"},
                        (dialog, which) -> checkableDialog.setCheckedIndex(which))
                        .show();
                break;
            case R.id.btn_multi_checkable:
                QMUIDialog.MultiCheckableDialogBuilder multiCheckableDialog =
                        new QMUIDialog.MultiCheckableDialogBuilder(this);
                multiCheckableDialog.addItems(new String[]{"first", "second", "third"},
                        (dialog, which) -> multiCheckableDialog.setCheckedItems(which))
                        .show();
                break;
            case R.id.btn_auto_resize:
                new QMUIDialog.AutoResizeDialogBuilder(this) {
                    @Override
                    public View onBuildContent(QMUIDialog dialog, ScrollView parent) {
                        EditText editText = new EditText(DialogActivity.this);
                        editText.setHint("input text");
                        editText.setTextColor(getResources().getColor(R.color.colorAccent));
                        editText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
                        editText.setPadding(20, 20, 20, 20);
                        return editText;
                    }
                }.show();
                break;
            case R.id.btn_bottom_list:
                QMUIBottomSheet.BottomListSheetBuilder bottomListSheet =
                        new QMUIBottomSheet.BottomListSheetBuilder(this, true);
                bottomListSheet.addHeaderView(new ProgressBar(this))
                        .setTitle("title")
                        .addItem("item 1")
                        .addItem(R.mipmap.ic_launcher_round, "item 2", "bottom_list", true)
                        .setOnSheetItemClickListener((dialog, itemView, position, tag)
                                -> bottomListSheet.setCheckedIndex(position))
                        .build()
                        .show();
                break;
            case R.id.btn_bottom_grid:
                new QMUIBottomSheet.BottomGridSheetBuilder(this)
                        .addItem(R.mipmap.ic_launcher_round, "grid_item 1",
                                QMUIBottomSheet.BottomGridSheetBuilder.FIRST_LINE)
                        .addItem(R.mipmap.ic_launcher, "grid_item 2",
                                QMUIBottomSheet.BottomGridSheetBuilder.SECOND_LINE)
                        .setIsShowButton(true)
                        .setButtonText("button")
                        .setOnSheetItemClickListener((dialog, itemView) -> dialog.dismiss())
                        .setBottomButtonTypeFace(Typeface.DEFAULT)
                        .setButtonClickListener(v -> shortToast("clicked"))
                        .build()
                        .show();
                break;
            case R.id.btn_tip:
                new QMUITipDialog.Builder(this)
                        .setTipWord("this is tip dialog")
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_SUCCESS)
                        .create(true)
                        .show();
                break;
        }
    }

}
