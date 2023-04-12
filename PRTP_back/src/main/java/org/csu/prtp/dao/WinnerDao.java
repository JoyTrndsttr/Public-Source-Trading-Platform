package org.csu.prtp.dao;

import org.csu.prtp.pojo.Winner;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface WinnerDao extends Neo4jRepository<Winner,Long> {
    Winner findByWinnerId(int winnerId);
    Winner findByWinnerName(String winnerName);
}
