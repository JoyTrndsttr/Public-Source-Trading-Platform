package org.csu.mooc.dao;

import org.csu.mooc.pojo.Concept;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ConceptDao extends Neo4jRepository<Concept,Long> {
    Concept findConceptByConceptName(String conceptName);
}
