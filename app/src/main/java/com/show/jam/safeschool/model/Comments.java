package com.show.jam.safeschool.model;

import android.os.Parcel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smartydroid.android.starter.kit.model.entity.Entity;

/**
 * Created by 99165 on 2016/3/2.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comments extends Entity {

    public Integer id;
    public String content;
    public User account;
    public Parent parent;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.content);
        dest.writeParcelable(this.account, 0);
        dest.writeParcelable(this.parent, 0);
    }

    public Comments() {
    }

    protected Comments(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.content = in.readString();
        this.account = in.readParcelable(User.class.getClassLoader());
        this.parent = in.readParcelable(Parent.class.getClassLoader());
    }

    public static final Creator<Comments> CREATOR = new Creator<Comments>() {
        public Comments createFromParcel(Parcel source) {
            return new Comments(source);
        }

        public Comments[] newArray(int size) {
            return new Comments[size];
        }
    };
}
