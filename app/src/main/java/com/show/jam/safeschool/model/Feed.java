package com.show.jam.safeschool.model;

import android.os.Parcel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartydroid.android.starter.kit.model.entity.Entity;

import java.util.ArrayList;

/**
 * Created by 99165 on 2016/3/2.
 */
@JsonIgnoreProperties(ignoreUnknown = true)//过滤掉未知属性
public class Feed extends Entity {

    public int id;
    public String content;
    @JsonProperty("caeate_at")//避免遗漏属性
    public int createdAt;
    @JsonProperty("accound")
    public User user;
    public ArrayList<Image> images;
    public ArrayList<Likes> likes;
    public ArrayList<Comments> comments;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.content);
        dest.writeInt(this.createdAt);
        dest.writeParcelable(this.user, 0);
        dest.writeTypedList(images);
        dest.writeTypedList(likes);
        dest.writeTypedList(comments);
    }

    public Feed() {
    }

    protected Feed(Parcel in) {
        this.id = in.readInt();
        this.content = in.readString();
        this.createdAt = in.readInt();
        this.user = in.readParcelable(User.class.getClassLoader());
        this.images = in.createTypedArrayList(Image.CREATOR);
        this.likes = in.createTypedArrayList(Likes.CREATOR);
        this.comments = in.createTypedArrayList(Comments.CREATOR);
    }

    public static final Creator<Feed> CREATOR = new Creator<Feed>() {
        public Feed createFromParcel(Parcel source) {
            return new Feed(source);
        }

        public Feed[] newArray(int size) {
            return new Feed[size];
        }
    };
}
