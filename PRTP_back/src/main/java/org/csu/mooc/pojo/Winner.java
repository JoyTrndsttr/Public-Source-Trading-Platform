package org.csu.mooc.pojo;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Winner {
    //默认的id
    @Id
    @GeneratedValue
    private Long id;
    private String WinnerName;

    public Winner() {

    }

    @Relationship(type = "BID", direction = Relationship.OUTGOING)
    private Set<Project> winnedProjects = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWinnerName() {
        return WinnerName;
    }

    public void setWinnerName(String winnerName) {
        WinnerName = winnerName;
    }

    public Set<Project> getWinnedProjects() {
        return winnedProjects;
    }

    public void setWinnedProjects(Set<Project> winnedProjects) {
        this.winnedProjects = winnedProjects;
    }
}
