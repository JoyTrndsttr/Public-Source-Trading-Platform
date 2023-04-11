package org.csu.mooc.service;

import org.csu.mooc.dao.ProjectDao;
import org.csu.mooc.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectDao projectDao;

    public Project findByProjectName(int projectId){
        return projectDao.findByProjectId(projectId);
    }



}
