package org.csu.prtp.dao;

import org.csu.prtp.pojo.Tenderee;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TendereeDao extends Neo4jRepository<Tenderee,Long> {
    Tenderee findByTendereeId(int tendereeId);
    Tenderee findByTendereeName(String tendereeName);
}
