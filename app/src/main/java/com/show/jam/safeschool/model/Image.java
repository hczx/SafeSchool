package com.show.jam.safeschool.model;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;

import com.smartydroid.android.starter.kit.model.entity.Entity;

/**
 * Created by 99165 on 2016/3/2.
 */
public class Image extends Entity {

    public Integer id;
    public String url;
    public int width;
    public int height;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.url);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
    }

    public Image() {
    }

    protected Image(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.url = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        public Image[] newArray(int size) {
            return new Image[size];
        }
    };


    /**
     * 将图片链接字符串转换成Uri
     *
     * @return
     */
    public Uri uri() {
        if (TextUtils.isEmpty(url)) return null;
        if (url.startsWith("http://")) {
            return Uri.parse(url);
        }
        return null;
    }

    public Uri uri(int width, int height) {
        if (TextUtils.isEmpty(url)) return null;
        if (url.startsWith("http://"))
            return Uri.parse(url);
        return null;
    }

}
