package com.show.jam.safeschool.model;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.smartydroid.android.starter.kit.model.entity.Entity;

/**
 * Created by wangh on 2016-2-26-0026.
 */
@JsonIgnoreProperties(ignoreUnknown = true) public class Notice extends Entity {

  public int id;
  public String title;
  public String summary;
  public String thumbnail;
  public String dept;
  @JsonProperty("published_at") public long publishedAt;

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.title);
    dest.writeString(this.summary);
    dest.writeString(this.thumbnail);
    dest.writeString(this.dept);
    dest.writeLong(this.publishedAt);
  }

  public Notice() {
  }

  protected Notice(Parcel in) {
    this.id = in.readInt();
    this.title = in.readString();
    this.summary = in.readString();
    this.thumbnail = in.readString();
    this.dept = in.readString();
    this.publishedAt = in.readLong();
  }

  public static final Creator<Notice> CREATOR = new Creator<Notice>() {
    public Notice createFromParcel(Parcel source) {
      return new Notice(source);
    }

    public Notice[] newArray(int size) {
      return new Notice[size];
    }
  };

  public static Creator<Notice> getCREATOR() {
    return CREATOR;
  }

  public Uri uri() {
    if (TextUtils.isEmpty(thumbnail)) return null;
    if (thumbnail.startsWith("http://")) {
      return Uri.parse(thumbnail);
    }
    return null;
  }
}
