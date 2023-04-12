package org.csu.prtp.common;

import lombok.Getter;

@Getter
public enum EntityGroup {
    PROJECT(1,"Project"),
    TENDEREE(2,"Tenderee"),
    WINNER(3,"Winner");
//    VIDEO(4,"视频");//一个枚举对象
    private final int group;
    private final String description;


    EntityGroup(int group, String description) {
        this.group = group;
        this.description = description;
    }

}
