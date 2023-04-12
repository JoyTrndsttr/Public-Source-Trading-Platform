package org.csu.prtp.dao;

import org.csu.prtp.pojo.Project;
import org.csu.prtp.pojo.Tenderee;
import org.springframework.data.neo4j.annotation.Depth;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProjectDao extends Neo4jRepository<Project,Long> {
    Project findByProjectId(int projectId);
    Project findByProjectName(String projectName);

//    @Query("MATCH (p:Project)-[r:BID]->(t:Tenderee) " +
//            "WHERE p.projectId = $0 " +
//            "RETURN t")
//    Iterable<Tenderee> getTenderees(Project project, Depth depth);

}
