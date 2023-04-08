package org.csu.mooc.controller;

import org.csu.mooc.common.EntityGroup;
import org.csu.mooc.common.Relationship;
import org.csu.mooc.pojo.*;
import org.csu.mooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{userName}")
    public CustomNode findByUserName(@PathVariable("userName") String userName){
        System.out.println(userName);
        User user = userService.findByUserName(userName);
        System.out.println(user);

        return new CustomNode(user.getUserName(),EntityGroup.USER.getGroup(), user);

        //http://localhost:8329/api/user/叶春泉
    }

    @GetMapping("/query/{relationship}/{name}")
    public List<CustomNode> getActedByName(@PathVariable("relationship")  String rel,@PathVariable("name") String name){
        User user = userService.findByUserName(name);//todo:名称不存在
        List<CustomNode> customNodes = new ArrayList<>();
        System.out.println(rel+" "+name);


        if (rel.equals(Relationship.LEARN.getRelation()))
        {
            Set<Course> courseSet = userService.getCoursesByRelationship(user,rel);
            for(Course course : courseSet){
                customNodes.add(new CustomNode(course.getCourseName(),EntityGroup.COURSE.getGroup(), course));

            }
        }else if(rel.equals(Relationship.WATCH.getRelation())){
            Set<Video> videoSet = userService.getVideosByRelationship(user,rel);
            for (Video video : videoSet){
                System.out.println(video.getVideoName());
                customNodes.add(new CustomNode(video.getVideoName(),EntityGroup.VIDEO.getGroup(), video));
            }
        }
        return customNodes;
        //http://localhost:8329/api/user/query/LEARN/叶春泉
        //http://localhost:8329/api/user/query/WATCH/叶春泉
    }

//    http://localhost:8329/api/user/query/WATCH/叶春泉/田祖国
    @GetMapping("/query/{relationship}/{name1}/{name2}")
    public List<CustomNode> getActedByTwoName(@PathVariable("relationship")  String rel,
                                              @PathVariable("name1") String name1,@PathVariable("name2") String name2){
        User user1 = userService.findByUserName(name1);
        User user2 = userService.findByUserName(name2);
        List<CustomNode> customNodes = new ArrayList<>();
        customNodes.add(new CustomNode(user1.getUserName(),EntityGroup.USER.getGroup(), user1));
        customNodes.add(new CustomNode(user2.getUserName(),EntityGroup.USER.getGroup(), user2));

        if (rel.equals(Relationship.LEARN.getRelation()))
        {
            Set<Course> courseSet1 = userService.getCoursesByRelationship(user1,rel);
            Set<Course> courseSet2 = userService.getCoursesByRelationship(user2,rel);
            for(Course course : courseSet1){
                if(courseSet2.contains(course))
                customNodes.add(new CustomNode(course.getCourseName(),EntityGroup.COURSE.getGroup(), course));

            }
        }else if(rel.equals(Relationship.WATCH.getRelation())){
            Set<Video> videoSet1 = userService.getVideosByRelationship(user1,rel);
            Set<Video> videoSet2 = userService.getVideosByRelationship(user2,rel);
            for(Video video : videoSet1){
                if(videoSet2.contains(video))
                    customNodes.add(new CustomNode(video.getVideoName(),EntityGroup.VIDEO.getGroup(), video));

            }

        }
        return customNodes;
        //http://localhost:8329/api/user/query/LEARN/叶春泉
        //http://localhost:8329/api/user/query/WATCH/叶春泉
    }
    @GetMapping("/all")
    public List<CustomNode> findAll(){
        Iterable<User> usersIterable = userService.findAll();
        List<CustomNode> customNodes = new ArrayList<>();
        int i = 0;
        for(User user : usersIterable){
            if(++i > 10)
                break;
            customNodes.add(new CustomNode(user.getUserName(), EntityGroup.USER.getGroup(), user));
        }
        return customNodes;
    }

    @GetMapping("/all/{relationship}") //http://localhost:8329/api/user/all/LEARN
    public List<Object> findAllAndRelationShip(@PathVariable("relationship") String rel){
        //找所有用户
        Iterable<User> usersIterable = userService.findAll();

        List<CustomNode> customNodes = new ArrayList<>();
        List<CustomNode> relNodes = new ArrayList<>();
        List<CustomLink> customLinks = new ArrayList<>();

        List<Course> courseList = new ArrayList<>();
        //只传二十个
        int i = 0;
        for(User user : usersIterable){
            i++;
            if(i == 10)
                break;
            customNodes.add(new CustomNode(user.getUserName(), EntityGroup.USER.getGroup(), user));
            //课程
            Set<Course> courseSet = userService.getCoursesByRelationship(user,rel);
            for(Course course:courseSet){
                int flag = 1;
                for (Course course1:courseSet)
                if(course.getCourseName().equals(course1.getCourseName())){
                    flag = 0;
                    break;
                }
                if (flag == 1){
                    relNodes.add(new CustomNode(course.getCourseName(),EntityGroup.COURSE.getGroup(), course));
                }

                //关系
                customLinks.add(new CustomLink(user.getUserName(),course.getCourseName(),10));
            }

            }

        //找与users有关的所有course

        //建立关系

        List<Object> result = new ArrayList<>();
        result.add(customNodes);
        result.add(relNodes);
        result.add(customLinks);

        return result;
    }

}
