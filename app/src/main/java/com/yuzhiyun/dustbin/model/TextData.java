package com.yuzhiyun.dustbin.model;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuzhiyun on 2016-10-09.
 */
public class TextData {
    public static int[] colors = new int[] {
            Color.parseColor("#e51c23"),
            Color.parseColor("#e91e63"),
            Color.parseColor("#9c27b0"),
            Color.parseColor("#673ab7"),
            Color.parseColor("#3f51b5"),
            Color.parseColor("#5677fc"),
            Color.parseColor("#ffc107"),
            Color.parseColor("#009688"),
            Color.parseColor("#259b24"),
    };

    public static List<String> textFromJson=new ArrayList<>();
//    public static String[] texts = new String[] {
//            "Android",
//            "弹幕哟~",
//            "挺有意思的~",
//            "我也这么觉的~",
//            "有意思~",
//            "我只是吐槽一下产品~",
//            "这个地方不要写死",
//            "***是这个世界上最好的语言!!",
//            "请叫我攻城狮~~",
//            "~O(∩_∩)O~~"
//    };
    public static String[] textsPrompt = new String[] {
            "发泄你的怨气",
            "吐槽吧~",
            "~O(∩_∩)O~~"
    };
}
