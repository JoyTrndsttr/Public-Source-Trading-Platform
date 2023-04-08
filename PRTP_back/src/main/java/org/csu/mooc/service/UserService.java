package org.csu.mooc.service;

import org.csu.mooc.common.Relationship;
import org.csu.mooc.dao.UserDao;
import org.csu.mooc.pojo.Course;
import org.csu.mooc.pojo.User;
import org.csu.mooc.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User findByUserName(String userName){
        return userDao.findByUserName(userName);
    }

    public Iterable<User> findAll(){
        return  userDao.findAll();
    }

    public Set<Course> getCoursesByRelationship(User user, String rel){
        if(rel.equals(Relationship.LEARN.getRelation())){
            return user.getStudiedInCourse();
        }
        else{
            return null;
        }
    }
    public Set<Video> getVideosByRelationship(User user, String rel){
      if(rel.equals(Relationship.WATCH.getRelation()))
        {
            return user.getWatchedVideo();
        }
        else{
            return null;
        }
    }

}
