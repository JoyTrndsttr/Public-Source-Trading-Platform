package org.csu.mooc.pojo;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class User {

    //默认的id
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String userId;

    public User(){

    }
    @Relationship(type = "LEARN", direction = Relationship.OUTGOING)
    private Set<Course> studiedInCourse = new HashSet<>();
    @Relationship(type = "WATCH", direction = Relationship.OUTGOING)
    private Set<Video> watchedVideo = new HashSet<>();



    public Set<Video> getWatchedVideo() {
        return watchedVideo;
    }

    public void setWatchedVideo(Set<Video> watchedVideo) {
        this.watchedVideo = watchedVideo;
    }



    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<Course> getStudiedInCourse() {
        return studiedInCourse;
    }

    public void setStudiedInCourse(Set<Course> studiedInCourse) {
        this.studiedInCourse = studiedInCourse;
    }

}
