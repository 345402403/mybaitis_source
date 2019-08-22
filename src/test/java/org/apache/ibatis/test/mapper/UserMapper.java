package org.apache.ibatis.test.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.test.User;

public interface UserMapper {

  @Select("SELECT * FROM User WHERE id = #{id}")
  User selectBlog(int id);

  @Insert("INSERT into User values(#{id},#{name})")
  void insertUser(@Param("id") int id, @Param("name") String name);
}
