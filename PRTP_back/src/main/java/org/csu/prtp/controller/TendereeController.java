package org.csu.prtp.controller;

import org.csu.prtp.common.EntityGroup;
import org.csu.prtp.common.Relationship;
import org.csu.prtp.pojo.*;
import org.csu.prtp.service.TendereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/tenderee")
public class TendereeController {
    @Autowired
    TendereeService tendereeService;

    @GetMapping("/{tendereeName}")
    public CustomNode findByTendereeName(@PathVariable("tendereeName") String tendereeName){
        System.out.println(tendereeName);
        Tenderee tenderee = tendereeService.findByTendereeName(tendereeName);
        System.out.println(tenderee);

        return new CustomNode(tenderee.getTendereeName(),EntityGroup.PROJECT.getGroup(), tenderee);

        //http://localhost:8329/api/tenderee/叶春泉
    }

    @GetMapping("/query/{relationship}/{name}")
    public List<CustomNode> getActedByName(@PathVariable("relationship")  String rel,@PathVariable("name") String name){
        Tenderee tenderee = tendereeService.findByTendereeName(name);//todo:名称不存在
        List<CustomNode> customNodes = new ArrayList<>();
        System.out.println(rel+" "+name);

        System.out.println("正在查询BID");
        Set<Project> projectSet = tendereeService.getTenderedProjectByRelationship(tenderee,rel);
        for(Project project : projectSet) {
            customNodes.add(new CustomNode(project.getProjectName(), EntityGroup.PROJECT.getGroup(), project));
        }

        return customNodes;
        //http://localhost:8329/api/tenderee/query/BID/叶春泉
        //http://localhost:8329/api/tenderee/query/WIN/叶春泉
    }

    @GetMapping({"/", "/all"})
    public List<CustomNode> findAll(){
        Iterable<Tenderee> tendereesIterable = tendereeService.findAll();
        List<CustomNode> customNodes = new ArrayList<>();
        int i = 0;
        for(Tenderee tenderee : tendereesIterable){
            if(++i > 10)
                break;
            customNodes.add(new CustomNode(tenderee.getTendereeName(), EntityGroup.PROJECT.getGroup(), tenderee));
        }
        return customNodes;
    }

    @GetMapping("/all/{relationship}") //http://localhost:8329/api/tenderee/all/BID
    public List<Object> findAllAndRelationShip(@PathVariable("relationship") String rel){
        //找所有用户
        Iterable<Tenderee> tendereesIterable = tendereeService.findAll();

        List<CustomNode> customNodes = new ArrayList<>();
        List<CustomNode> relNodes = new ArrayList<>();
        List<CustomLink> customLinks = new ArrayList<>();

        List<Tenderee> tendereeList = new ArrayList<>();
        //只传二十个
        int i = 0;
        for(Tenderee tenderee : tendereesIterable){
            i++;
            if(i == 10)
                break;
            customNodes.add(new CustomNode(tenderee.getTendereeName(), EntityGroup.PROJECT.getGroup(), tenderee));
            //课程
            Set<Project> projectSet = tendereeService.getTenderedProjectByRelationship(tenderee,rel);
            for(Project project:projectSet){
                int flag = 1;
                for (Project project1:projectSet)
                if(project.getProjectName().equals(project1.getProjectName())){
                    flag = 0;
                    break;
                }
                if (flag == 1){
                    relNodes.add(new CustomNode(project.getProjectName(),EntityGroup.PROJECT.getGroup(), project));
                }

                //关系
                customLinks.add(new CustomLink(project.getProjectName(),project.getProjectName(),10));
            }

            }

        //找与tenderees有关的所有tenderee

        //建立关系

        List<Object> result = new ArrayList<>();
        result.add(customNodes);
        result.add(relNodes);
        result.add(customLinks);

        return result;
    }

}
