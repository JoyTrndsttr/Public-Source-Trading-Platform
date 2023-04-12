package org.csu.prtp.service;

import org.csu.prtp.common.Relationship;
import org.csu.prtp.dao.ProjectDao;
import org.csu.prtp.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProjectService {
    @Autowired
    ProjectDao projectDao;

    public Project findByProjectId(int projectId){
        return projectDao.findByProjectId(projectId);
    }

    public Project findByProjectName(String projectName){
        return projectDao.findByProjectName(projectName);
    }

    public Iterable<Project> findAll(){
        return  projectDao.findAll();
    }

    public Set<Tenderee> getTendereesByRelationship(Project project, String rel){
        if(rel.equals(Relationship.BID.getRelation())){
            System.out.println("Bid");
            return project.getTenderees();
        }
        else{
            return null;
        }
    }
    public Set<Winner> getWinnersByRelationship(Project project, String rel){
        if(rel.equals(Relationship.WIN.getRelation()))
        {
            System.out.println(project.getWinners().size());
            return project.getWinners();
        }
        else{
            return null;
        }
    }


}
