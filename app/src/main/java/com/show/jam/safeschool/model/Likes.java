package com.show.jam.safeschool.model;

import android.os.Parcel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartydroid.android.starter.kit.model.entity.Entity;

/**
 * Created by 99165 on 2016/3/2.
 */
@JsonIgnoreProperties(ignoreUnknown = true)//过滤未知属性
public class Likes extends Entity {
    private int id;
    @JsonProperty("account")//避免遗漏属性
    public User user;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeParcelable(this.user, 0);
    }

    public Likes() {
    }

    protected Likes(Parcel in) {
        this.id = in.readInt();
        this.user = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<Likes> CREATOR = new Creator<Likes>() {
        public Likes createFromParcel(Parcel source) {
            return new Likes(source);
        }

        public Likes[] newArray(int size) {
            return new Likes[size];
        }
    };
}
