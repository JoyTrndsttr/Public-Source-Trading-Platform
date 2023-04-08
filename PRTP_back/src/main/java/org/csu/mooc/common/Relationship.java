package org.csu.mooc.common;

import lombok.Getter;

@Getter
public enum Relationship {
    LEARN("LEARN","User - Course"),
    WATCH("WATCH","User - Video"),
    PREREQUISITE("PREREQUISITE","concep");
    private final String relation;
    private final String description;

    Relationship(String relation, String description) {
        this.relation = relation;
        this.description = description;
    }
}
