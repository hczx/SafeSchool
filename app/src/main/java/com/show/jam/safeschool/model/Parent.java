package com.show.jam.safeschool.model;

import android.os.Parcel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smartydroid.android.starter.kit.model.entity.Entity;

/**
 * Created by 99165 on 2016/3/2.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Parent extends Entity {

    public Integer id;
    public String content;
    public String created_at;
    public User account;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.content);
        dest.writeString(this.created_at);
        dest.writeParcelable(this.account, 0);
    }

    public Parent() {
    }

    protected Parent(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.content = in.readString();
        this.created_at = in.readString();
        this.account = in.readParcelable(User.class.getClassLoader());
    }

    public static final Creator<Parent> CREATOR = new Creator<Parent>() {
        public Parent createFromParcel(Parcel source) {
            return new Parent(source);
        }

        public Parent[] newArray(int size) {
            return new Parent[size];
        }
    };
}
