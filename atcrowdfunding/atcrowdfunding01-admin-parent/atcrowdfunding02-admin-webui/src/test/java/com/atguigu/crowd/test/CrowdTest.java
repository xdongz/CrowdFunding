
package com.atguigu.crowd.test;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 在类上标记必要的注解，Spring整合Junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-persist-mybatis.xml")
public class CrowdTest {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private AdminMapper adminMapper;

  @Test
  public void testConnection() throws SQLException {
    Connection connection = dataSource.getConnection();
    System.out.println(connection);

  }

  @Test
  public void testInsertAdmin() {
    Admin admin;
    admin = new Admin(null,"Rachel","123123","rui","rui@qq.com",null);
    int count = adminMapper.insert(admin);
    System.out.println(count);
  }

  @Test
  public void testLog() {
    //1.获取Logger对象
    Logger logger = LoggerFactory.getLogger(CrowdTest.class);

    // 2. 根据不同日志级别打印日志
    logger.debug("Hello, I am Debug level!");

    logger.info("Hello, I am info level!");


    logger.warn("Hello, I am warn level!");

    logger.error("Hello, I am error level!");

  }

}
