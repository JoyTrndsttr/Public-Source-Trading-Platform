package org.csu.prtp.pojo;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Tenderee{

    //默认的id
    @Id
    @GeneratedValue
    private Long id;
    private int tendereeId;
    private String tendereeName;

    public Tenderee() {

    }

    @Relationship(type = "BID", direction = Relationship.OUTGOING)
    private Set<Project> tenderedProjects = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTendereeId() {
        return tendereeId;
    }

    public void setTendereeId(int tendereeId) {
        this.tendereeId = tendereeId;
    }

    public String getTendereeName() {
        return tendereeName;
    }

    public void setTendereeName(String tendereeName) {
        this.tendereeName = tendereeName;
    }

    public Set<Project> getTenderedProjects() {
        return tenderedProjects;
    }

    public void setTenderedProjects(Set<Project> tenderedProjects) {
        this.tenderedProjects = tenderedProjects;
    }
}
