package org.csu.mooc.dao;

import org.csu.mooc.pojo.Project;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProjectDao extends Neo4jRepository<Project,Long> {
    Project findByProjectId(int projectId);
}
