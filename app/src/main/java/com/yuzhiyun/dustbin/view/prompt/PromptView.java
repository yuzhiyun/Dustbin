package com.yuzhiyun.dustbin.view.prompt;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.yuzhiyun.dustbin.R;
import com.yuzhiyun.dustbin.model.TextData;
import com.yuzhiyun.dustbin.view.barrage.BaseView;
import com.yuzhiyun.dustbin.view.barrage.BrrrageItem;

import java.util.ArrayList;
import java.util.Random;

/**
 * 显示在主页面，用于激起用户吐槽的愿望
 * Created by yuzhiyun on 2016-10-09.
 */
public class PromptView extends BaseView {

    private ArrayList<BrrrageItem> list = new ArrayList<BrrrageItem>();
    private int mPromptNum = TextData.textsPrompt.length;
    private int size = 30;
    private int mTextColor;
    private String text;

    public PromptView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PromptView(Context context) {
        super(context);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        for (BrrrageItem item : list) {
            item.draw(canvas);
        }
    }

    @Override
    protected void logic() {
        for (BrrrageItem item : list) {
            item.move();
        }
    }

    @Override
    protected void init() {

        mTextColor=getResources().getColor(R.color.colorPrimary);
        Random random=new Random();
        for (int i = 0; i < mPromptNum; i++) {
//            文字内容
            text=TextData.textsPrompt[i];
//            大小
            int r3=random.nextInt(20);
            r3+=40;
            size=r3;
//			RainItem item = new RainItem(getWidth(), getHeight(), size, rainColor, randColor);
            BrrrageItem item = new BrrrageItem(getWidth(), getHeight(), size, mTextColor,text);
            list.add(item);
        }
    }
}
