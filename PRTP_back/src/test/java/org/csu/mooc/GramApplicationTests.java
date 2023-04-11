package org.csu.mooc;

import org.csu.mooc.dao.ProjectDao;
import org.csu.mooc.dao.UserDao;
import org.csu.mooc.pojo.User;
import org.csu.mooc.pojo.Video;
import org.csu.mooc.service.ProjectService;
import org.csu.mooc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

@SpringBootTest
class GramApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectDao projectDao;
    @Test
    void test(){
        System.out.println("#########################");
//        System.out.println(projectService.findByProjectName(19).getPrice());
        double price = projectDao.findByProjectId(19).getPrice();
//        double price = 1.0;
        System.out.println(price);

    }

    @Autowired
    UserService userService;
    @Test
    void testUserService(){
        User user = userService.findByUserName("苏鸿斌");
        System.out.println(user);
        System.out.println("complete");
        Iterable<Video> videos = user.getWatchedVideo();
        for (Video v:videos
             ) {
            System.out.println(v.getVideoName());
        }
    }
}
