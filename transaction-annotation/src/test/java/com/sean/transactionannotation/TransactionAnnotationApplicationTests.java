package com.sean.transactionannotation;

import com.sean.transactionannotation.services.ScoreInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class TransactionAnnotationApplicationTests {

    @Autowired
    private ScoreInfoService scoreInfoService;

    @Test
    void contextLoads() {
    }

    @Test
    void testMyTransaction() {
        try {
            scoreInfoService.doTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
