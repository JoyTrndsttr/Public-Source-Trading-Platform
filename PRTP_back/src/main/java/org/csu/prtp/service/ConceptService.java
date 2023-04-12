//package org.csu.prtp.service;
//
//import org.csu.prtp.common.Relationship;
//import org.csu.prtp.dao.ConceptDao;
//import org.csu.prtp.pojo.Concept;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//
//@Service
//public class ConceptService {
//    @Autowired
//    ConceptDao conceptDao;
//
//    public Concept findByConceptName(String conceptName) {
//
//        return conceptDao.findConceptByConceptName(conceptName);
//    }
//
//    public Set<Concept> getDependencyConcept(Concept concept, String rel) {
//        if(rel.equals(Relationship.PREREQUISITE.getRelation())){
//            return concept.getDependencyConcept();
//        }
//        else{
//            return null;
//        }
//    }
//
//    public Iterable<Concept> findAll() {
//       return conceptDao.findAll();
//    }
//}
