package org.csu.prtp.service;

import org.csu.prtp.common.Relationship;
import org.csu.prtp.dao.TendereeDao;
import org.csu.prtp.pojo.Project;
import org.csu.prtp.pojo.Tenderee;
import org.csu.prtp.pojo.Tenderee;
import org.csu.prtp.pojo.Winner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TendereeService {
    @Autowired
    TendereeDao tendereeDao;

    public Tenderee findByTendereeId(int tendereeId){
        return tendereeDao.findByTendereeId(tendereeId);
    }

    public Tenderee findByTendereeName(String tendereeName){
        return tendereeDao.findByTendereeName(tendereeName);
    }

    public Iterable<Tenderee> findAll(){
        return  tendereeDao.findAll();
    }

    public Set<Project> getTenderedProjectByRelationship(Tenderee tenderee, String rel){
        if(rel.equals(Relationship.BID.getRelation())){
            return tenderee.getTenderedProjects();
        }
        else{
            return null;
        }
    }
}
