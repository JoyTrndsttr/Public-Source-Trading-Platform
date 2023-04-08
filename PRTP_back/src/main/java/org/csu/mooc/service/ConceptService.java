package org.csu.mooc.service;

import org.csu.mooc.common.Relationship;
import org.csu.mooc.dao.ConceptDao;
import org.csu.mooc.pojo.Concept;
import org.csu.mooc.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ConceptService {
    @Autowired
    ConceptDao conceptDao;

    public Concept findByConceptName(String conceptName) {

        return conceptDao.findConceptByConceptName(conceptName);
    }

    public Set<Concept> getDependencyConcept(Concept concept, String rel) {
        if(rel.equals(Relationship.PREREQUISITE.getRelation())){
            return concept.getDependencyConcept();
        }
        else{
            return null;
        }
    }

    public Iterable<Concept> findAll() {
       return conceptDao.findAll();
    }
}
