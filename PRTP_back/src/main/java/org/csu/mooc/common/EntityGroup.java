package org.csu.mooc.common;

import lombok.Getter;

@Getter
public enum EntityGroup {
    USER(1,"用户类组号"),
    COURSE(2,"课程"),
    CONCEPT(3,"概念"),
    VIDEO(4,"视频");//一个枚举对象
    private final int group;
    private final String description;


    EntityGroup(int group, String description) {
        this.group = group;
        this.description = description;
    }

}
