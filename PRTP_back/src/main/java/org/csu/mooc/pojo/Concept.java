package org.csu.mooc.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;


@NodeEntity
public class Concept {

    @Id
    @GeneratedValue
    private Long id;
    private String conceptId;
    private String conceptName;

    @JsonIgnore
    @Relationship(type = "PREREQUISITE", direction = Relationship.OUTGOING)
    private Set<Concept> dependencyConcept = new HashSet<>();

    public Set<Concept> getDependencyConcept() {
        return dependencyConcept;
    }

    public void setDependencyConcept(Set<Concept> dependencyConcept) {
        this.dependencyConcept = dependencyConcept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Concept() {
    }

    public String getConceptId() {
        return conceptId;
    }

    public void setConceptId(String conceptId) {
        this.conceptId = conceptId;
    }

    public String getConceptName() {
        return conceptName;
    }

    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }
}
