package com.show.jam.safeschool.model;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smartydroid.android.starter.kit.model.entity.Entity;

/**
 * Created by 99165 on 2016/3/3.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Banner extends Entity {

    public int id;
    public String thumbnail;
    public String link;
    public String title;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.thumbnail);
        dest.writeString(this.link);
        dest.writeString(this.title);
    }

    public Banner() {
    }

    protected Banner(Parcel in) {
        this.id = in.readInt();
        this.thumbnail = in.readString();
        this.link = in.readString();
        this.title = in.readString();
    }

    public static final Creator<Banner> CREATOR = new Creator<Banner>() {
        public Banner createFromParcel(Parcel source) {
            return new Banner(source);
        }

        public Banner[] newArray(int size) {
            return new Banner[size];
        }
    };

    public Uri uri() {
        if (TextUtils.isEmpty(thumbnail)) return null;
        if (thumbnail.startsWith("http://")) {
            return Uri.parse(thumbnail);
        }
        return null;
    }
}
