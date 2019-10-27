package com.jebugs.service;

import com.jebugs.repository.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author haozx1
 * @Date 2019/9/3 16:37
 */
@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    @Transactional
    public int insertTest() {

        return testMapper.insertTest();
    }

}
