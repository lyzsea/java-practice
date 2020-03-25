package com.sean.transactionannotation.services;

import com.sean.transactionannotation.common.jdbc.MyJdbcTemplate;
import com.sean.transactionannotation.common.jdbc.annotation.MyTransactional;
import com.sean.transactionannotation.pojo.ScoreInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class ScoreInfoService {
    @Autowired
    private MyJdbcTemplate myJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ScoreInfo getScoreInfo(int idNum) {
        return null;
    }

    @MyTransactional
    public void doTransaction() throws SQLException {
        String sql = "DELETE FROM score_info WHERE ID=%d;";
        myJdbcTemplate.execute(String.format(sql,19));
        myJdbcTemplate.execute(String.format(sql,18));

        //int i = 1/0;
    }
}
