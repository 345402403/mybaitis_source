package org.apache.ibatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.test.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

  public MybatisTest() throws IOException {

  }

  public static void main(String[] args) throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    try (SqlSession session = sqlSessionFactory.openSession()) {
      Blog blog = session.selectOne("BlogMapper.selectBlog", 1);
      System.out.println(blog.id+"--"+blog.name);
    }

    try (SqlSession session = sqlSessionFactory.openSession()) {
      UserMapper userMapper = session.getMapper(UserMapper.class);
      userMapper.insertUser(3,"XiaoLiu");
      User user = userMapper.selectBlog(3);
      System.out.println(user.id+"--"+user.name);
      session.commit();

    }
  }
}
