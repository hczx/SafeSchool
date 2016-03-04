package com.show.jam.safeschool.model.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 99165 on 2016/3/2.
 * 枚举判断文章种类
 */
public enum ArticleType {
    SAFE("safe"), CLASSES("classes"), INFO("info"), ONLINE("365"), FOCUS("focus");

    private final String mValue;

    ArticleType(String mValue) {
        this.mValue = mValue;
    }

    @Override
    public String toString() {
        return mValue;
    }

    private static final Map<String, ArticleType> STRING_MAPPING = new HashMap<>();

    static {
        for (ArticleType calorieType : ArticleType.values()
                ) {
            STRING_MAPPING.put(calorieType.toString().toUpperCase(), calorieType);
        }
    }

    @JsonCreator
    public static ArticleType fromValue(String value) {
        return STRING_MAPPING.get(value.toUpperCase());
    }

    public String toZhString() {
        switch (this) {
            case SAFE:
                return "安全教育";
            case CLASSES:
                return "家长课堂";
            case INFO:
                return "资讯教育";
            default:
                return null;
        }
    }

}
