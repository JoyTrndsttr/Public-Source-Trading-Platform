package org.csu.prtp.common;

import lombok.Getter;

@Getter
public enum Relationship {
    BID("BID","Tenderee - Project"),
    WIN("WIN","Winner - Project");
//    PREREQUISITE("PREREQUISITE","concep");
    private final String relation;
    private final String description;

    Relationship(String relation, String description) {
        this.relation = relation;
        this.description = description;
    }
}
