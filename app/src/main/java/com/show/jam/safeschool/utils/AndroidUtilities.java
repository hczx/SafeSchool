package com.show.jam.safeschool.utils;

import android.graphics.Typeface;

import com.smartydroid.android.starter.kit.app.StarterKitApp;

import java.util.Hashtable;

/**
 * Created by 99165 on 2016/3/2.
 * android 适配工具类
 */
public class AndroidUtilities {

    /**
     * 定义一个屏幕密度
     */
    public static float density = 1;

    /**
     * 定义一个容器来存放字体对象
     */
    private static final Hashtable<String, Typeface> typefaceCache = new Hashtable<>();

    /**
     * 获取字体对象
     *
     * @param assetPath 字体文件路径
     * @return字体对象
     */
    public static Typeface getTypeface(String assetPath) {
        synchronized (typefaceCache) {
            if (!typefaceCache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(StarterKitApp.appContext().getAssets(), assetPath);
                    typefaceCache.put(assetPath, t);
                } catch (Exception e) {
                    FileLog.e("Typefaces", "Could not get typefaces'" + assetPath + "' because " + e.getMessage());
                    return null;
                }
            }
            return typefaceCache.get(assetPath);
        }
    }

    /**
     * 获取屏幕密度
     */
    static {
        density = StarterKitApp.appResources().getDisplayMetrics().density;
    }

    /**
     * 转换为dp单位
     * @param value
     * @return
     */
    public static int dp(float value) {
        if (value == 0) {
            return 0;
        }
        return (int) Math.ceil(density * value);
    }
}
