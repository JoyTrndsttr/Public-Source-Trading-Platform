package org.csu.mooc.dao;

import org.csu.mooc.pojo.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserDao extends Neo4jRepository<User,Long> {
    User findByUserName(String userName);
}
