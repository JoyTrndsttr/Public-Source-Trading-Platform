package org.csu.prtp.controller;

import org.csu.prtp.common.EntityGroup;
import org.csu.prtp.common.Relationship;
import org.csu.prtp.pojo.*;
import org.csu.prtp.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/{projectName}")
    public CustomNode findByProjectName(@PathVariable("projectName") String projectName){
        System.out.println(projectName);
        Project project = projectService.findByProjectName(projectName);
        System.out.println(project);

        return new CustomNode(project.getProjectName(),EntityGroup.PROJECT.getGroup(), project);

        //http://localhost:8329/api/project/叶春泉
    }

    @GetMapping("/query/{relationship}/{name}")
    public List<CustomNode> getActedByName(@PathVariable("relationship")  String rel,@PathVariable("name") String name){
        Project project = projectService.findByProjectName(name);//todo:名称不存在
        List<CustomNode> customNodes = new ArrayList<>();
        System.out.println(rel+" "+name);


        if (rel.equals(Relationship.BID.getRelation()))
        {
            System.out.println("正在查询BID");
            Set<Tenderee> tendereeSet = projectService.getTendereesByRelationship(project,rel);
            for(Tenderee tenderee : tendereeSet){
                customNodes.add(new CustomNode(tenderee.getTendereeName(),EntityGroup.TENDEREE.getGroup(), tenderee));

            }
        }else if(rel.equals(Relationship.WIN.getRelation())){
            System.out.println("正在查询WIN");
            Set<Winner> winnerSet = projectService.getWinnersByRelationship(project,rel);
            for (Winner winner : winnerSet){
                System.out.println(winner.getWinnerName());
                customNodes.add(new CustomNode(winner.getWinnerName(),EntityGroup.WINNER.getGroup(), winner));
            }
        }
        return customNodes;
        //http://localhost:8329/api/project/query/BID/叶春泉
        //http://localhost:8329/api/project/query/WIN/叶春泉
    }

//    http://localhost:8329/api/project/query/WIN/叶春泉/田祖国
    @GetMapping("/query/{relationship}/{name1}/{name2}")
    public List<CustomNode> getActedByTwoName(@PathVariable("relationship")  String rel,
                                              @PathVariable("name1") String name1,@PathVariable("name2") String name2){
        Project project1 = projectService.findByProjectName(name1);
        Project project2 = projectService.findByProjectName(name2);
        List<CustomNode> customNodes = new ArrayList<>();
        customNodes.add(new CustomNode(project1.getProjectName(),EntityGroup.PROJECT.getGroup(), project1));
        customNodes.add(new CustomNode(project2.getProjectName(),EntityGroup.PROJECT.getGroup(), project2));

        if (rel.equals(Relationship.BID.getRelation()))
        {
            Set<Tenderee> tendereeSet1 = projectService.getTendereesByRelationship(project1,rel);
            Set<Tenderee> tendereeSet2 = projectService.getTendereesByRelationship(project2,rel);
            for(Tenderee tenderee : tendereeSet1){
                if(tendereeSet2.contains(tenderee))
                customNodes.add(new CustomNode(tenderee.getTendereeName(),EntityGroup.TENDEREE.getGroup(), tenderee));

            }
        }else if(rel.equals(Relationship.WIN.getRelation())){
            Set<Winner> winnerSet1 = projectService.getWinnersByRelationship(project1,rel);
            Set<Winner> winnerSet2 = projectService.getWinnersByRelationship(project2,rel);
            for(Winner winner : winnerSet1){
                if(winnerSet2.contains(winner))
                    customNodes.add(new CustomNode(winner.getWinnerName(),EntityGroup.WINNER.getGroup(), winner));

            }

        }
        return customNodes;
        //http://localhost:8329/api/project/query/BID/叶春泉
        //http://localhost:8329/api/project/query/WIN/叶春泉
    }

    @GetMapping({"/", "/all"})
    public List<CustomNode> findAll(){
        Iterable<Project> projectsIterable = projectService.findAll();
        List<CustomNode> customNodes = new ArrayList<>();
        int i = 0;
        for(Project project : projectsIterable){
            if(++i > 10)
                break;
            customNodes.add(new CustomNode(project.getProjectName(), EntityGroup.PROJECT.getGroup(), project));
        }
        return customNodes;
    }

    @GetMapping("/all/{relationship}") //http://localhost:8329/api/project/all/BID
    public List<Object> findAllAndRelationShip(@PathVariable("relationship") String rel){
        //找所有用户
        Iterable<Project> projectsIterable = projectService.findAll();

        List<CustomNode> customNodes = new ArrayList<>();
        List<CustomNode> relNodes = new ArrayList<>();
        List<CustomLink> customLinks = new ArrayList<>();

        List<Tenderee> tendereeList = new ArrayList<>();
        //只传二十个
        int i = 0;
        for(Project project : projectsIterable){
            i++;
            if(i == 10)
                break;
            customNodes.add(new CustomNode(project.getProjectName(), EntityGroup.PROJECT.getGroup(), project));
            //课程
            Set<Tenderee> tendereeSet = projectService.getTendereesByRelationship(project,rel);
            for(Tenderee tenderee:tendereeSet){
                int flag = 1;
                for (Tenderee tenderee1:tendereeSet)
                if(tenderee.getTendereeName().equals(tenderee1.getTendereeName())){
                    flag = 0;
                    break;
                }
                if (flag == 1){
                    relNodes.add(new CustomNode(tenderee.getTendereeName(),EntityGroup.TENDEREE.getGroup(), tenderee));
                }

                //关系
                customLinks.add(new CustomLink(project.getProjectName(),tenderee.getTendereeName(),10));
            }

            }

        //找与projects有关的所有tenderee

        //建立关系

        List<Object> result = new ArrayList<>();
        result.add(customNodes);
        result.add(relNodes);
        result.add(customLinks);

        return result;
    }

}
