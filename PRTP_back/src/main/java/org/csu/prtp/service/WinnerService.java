package org.csu.prtp.service;

import org.csu.prtp.common.Relationship;
import org.csu.prtp.dao.WinnerDao;
import org.csu.prtp.pojo.Project;
import org.csu.prtp.pojo.Winner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WinnerService {
    @Autowired
    WinnerDao winnerDao;

    public Winner findByWinnerId(int winnerId){
        return winnerDao.findByWinnerId(winnerId);
    }

    public Winner findByWinnerName(String winnerName){
        return winnerDao.findByWinnerName(winnerName);
    }

    public Iterable<Winner> findAll(){
        return  winnerDao.findAll();
    }

    public Set<Project> getWinnedProjectByRelationship(Winner winner, String rel){
        if(rel.equals(Relationship.WIN.getRelation())){
            return winner.getWinnedProjects();
        }
        else{
            return null;
        }
    }
}
