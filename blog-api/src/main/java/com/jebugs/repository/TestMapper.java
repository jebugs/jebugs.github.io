package com.jebugs.repository;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author haozx1
 * @Date 2019/9/3 16:38
 */
@Repository
public interface TestMapper {

    @Insert("insert into tbl_test (name) values ('haozhaoxu');")
    int insertTest();
}
