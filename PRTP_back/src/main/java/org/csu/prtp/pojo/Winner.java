package org.csu.prtp.pojo;

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
    private int winnerId;
    private String winnerName;

    public Winner() {

    }

    @Relationship(type = "WIN", direction = Relationship.OUTGOING)
    private Set<Project> winnedProjects = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public Set<Project> getWinnedProjects() {
        return winnedProjects;
    }

    public void setWinnedProjects(Set<Project> winnedProjects) {
        this.winnedProjects = winnedProjects;
    }
}
