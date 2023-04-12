package org.csu.prtp.pojo;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Project {

    //默认的id
    @Id
    @GeneratedValue
    private Long id;

    private int projectId;
    private String projectName;
    private double price;

    public Project() {

    }
    public Project(int projectId,String projectName,double price){
        this.projectId = projectId;
        this.projectName = projectName;
        this.price = price;
    }

    @Relationship(type = "BID", direction = Relationship.OUTGOING)
    private Set<Tenderee> tenderees = new HashSet<>();
    @Relationship(type = "WIN", direction = Relationship.OUTGOING)
    private Set<Winner> winners = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Tenderee> getTenderees() {
        return tenderees;
    }

    public void setTenderees(Set<Tenderee> tenderees) {
        this.tenderees = tenderees;
    }

    public Set<Winner> getWinners() {
        return winners;
    }

    public void setWinners(Set<Winner> winners) {
        this.winners = winners;
    }
}
