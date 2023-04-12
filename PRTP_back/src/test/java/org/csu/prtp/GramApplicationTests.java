package org.csu.prtp;

import org.csu.prtp.dao.ProjectDao;
import org.csu.prtp.dao.TendereeDao;
import org.csu.prtp.dao.WinnerDao;
import org.csu.prtp.pojo.*;
import org.csu.prtp.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        Project project = projectDao.findByProjectId(19);
//        double price = 1.0;
        System.out.println(price);
        System.out.println(projectDao.findByProjectId(19).getTenderees());

    }

    @Autowired
    TendereeDao tendereeDao;
    @Test
    void testTendereeDao(){
        System.out.println("testTendereeDao");
        Tenderee tenderee = tendereeDao.findByTendereeId(7);
        System.out.println(tenderee.getTendereeName());
    }

    @Autowired
    WinnerDao winnerDao;
    @Test
    void testWinnerDao(){
        System.out.println("testWinnerDao");
        Winner winner = winnerDao.findByWinnerId(7);
        System.out.println(winner.getWinnerName());
    }

}
