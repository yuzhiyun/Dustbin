package com.yuzhiyun.dustbin.view.barrage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


import java.util.Random;

public class BrrrageItem {

    private int width;
    private int height;

    private float startX;
    private float startY;
    private float sizeX;
    private float sizeY;
    private float opt;
    private Paint paint;
    private Random random;
    String text;

    private int size = 20;
    private int color;
//	private boolean randColor = false;

    public BrrrageItem(int width, int height, int size, int color, String text) {
        this.color = color;
        this.size = size;
        this.width = width;
        this.height = height;
        this.text = text;
        init();
    }


    private void init() {
        if (null == random)
            random = new Random();
//		sizeX = 1 + random.nextInt(size / 2);
        sizeX = 10;
//		sizeY = 10 + random.nextInt(size);
        sizeY = 30;
        startX = random.nextInt(width);
        startY = random.nextInt(height);
        opt = 0.2f + random.nextFloat();
        paint = new Paint();
        paint.setColor(color);
        paint.setTextSize(size);
    }

    public void draw(Canvas canvas) {
        //绘制背景
//        Paint colorPaint = new Paint();
//        colorPaint.setColor(Color.parseColor("#e0ffffff"));
//        Rect rect=new Rect();
//        rect.
//        canvas.drawRect(startX, startY - 60, startX + 800, startY, colorPaint);
//        canvas.drawLine(startX, startY, stopX, stopY, paint);
//        绘制文字
        canvas.drawText(text, startX, startY, paint);


    }

    public void move() {

        startX += sizeX * opt;
//        stopX += sizeX * opt;

//        startY += sizeY * opt;
//        stopY += sizeY * opt;
        if (startX > width) {
            init();
        }
    }

}
