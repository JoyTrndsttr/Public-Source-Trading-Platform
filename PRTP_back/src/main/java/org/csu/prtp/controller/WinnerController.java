package org.csu.prtp.controller;

import org.csu.prtp.common.EntityGroup;
import org.csu.prtp.pojo.CustomLink;
import org.csu.prtp.pojo.CustomNode;
import org.csu.prtp.pojo.Project;
import org.csu.prtp.pojo.Winner;
import org.csu.prtp.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/winner")
public class WinnerController {
    @Autowired
    WinnerService winnerService;

    @GetMapping("/{winnerName}")
    public CustomNode findByWinnerName(@PathVariable("winnerName") String winnerName){
        System.out.println(winnerName);
        Winner winner = winnerService.findByWinnerName(winnerName);
        System.out.println(winner);

        return new CustomNode(winner.getWinnerName(),EntityGroup.PROJECT.getGroup(), winner);

        //http://localhost:8329/api/winner/叶春泉
    }

    @GetMapping("/query/{relationship}/{name}")
    public List<CustomNode> getActedByName(@PathVariable("relationship")  String rel,@PathVariable("name") String name){
        Winner winner = winnerService.findByWinnerName(name);//todo:名称不存在
        List<CustomNode> customNodes = new ArrayList<>();
        System.out.println(rel+" "+name);

        System.out.println("正在查询WIN");
        Set<Project> projectSet = winnerService.getWinnedProjectByRelationship(winner,rel);
        for(Project project : projectSet) {
            customNodes.add(new CustomNode(project.getProjectName(), EntityGroup.PROJECT.getGroup(), project));
        }

        return customNodes;
        //http://localhost:8329/api/winner/query/BID/叶春泉
        //http://localhost:8329/api/winner/query/WIN/叶春泉
    }

    @GetMapping({"/", "/all"})
    public List<CustomNode> findAll(){
        Iterable<Winner> winnersIterable = winnerService.findAll();
        List<CustomNode> customNodes = new ArrayList<>();
        int i = 0;
        for(Winner winner : winnersIterable){
            if(++i > 10)
                break;
            customNodes.add(new CustomNode(winner.getWinnerName(), EntityGroup.PROJECT.getGroup(), winner));
        }
        return customNodes;
    }

    @GetMapping("/all/{relationship}") //http://localhost:8329/api/winner/all/BID
    public List<Object> findAllAndRelationShip(@PathVariable("relationship") String rel){
        //找所有用户
        Iterable<Winner> winnersIterable = winnerService.findAll();

        List<CustomNode> customNodes = new ArrayList<>();
        List<CustomNode> relNodes = new ArrayList<>();
        List<CustomLink> customLinks = new ArrayList<>();

        List<Winner> winnerList = new ArrayList<>();
        //只传二十个
        int i = 0;
        for(Winner winner : winnersIterable){
            i++;
            if(i == 10)
                break;
            customNodes.add(new CustomNode(winner.getWinnerName(), EntityGroup.PROJECT.getGroup(), winner));
            //课程
            Set<Project> projectSet = winnerService.getWinnedProjectByRelationship(winner,rel);
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

        //找与winners有关的所有winner

        //建立关系

        List<Object> result = new ArrayList<>();
        result.add(customNodes);
        result.add(relNodes);
        result.add(customLinks);

        return result;
    }

}
