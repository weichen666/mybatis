package com.newtouch.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newtouch.domain.User;

/**
 * 定义sql映射的接口，使用注解指明方法要执行的SQL
 * 
 * tip:
 * 	　需要说明的是，我们不需要针对UserMapperI接口去编写具体的实现类代码，
 *    这个具体的实现类由MyBatis帮我们动态构建出来，我们只需要直接拿来使用即可。
 * 
 * @author Administrator
 */
public interface UserMapperI {
	
	@Insert("insert into users(name, age) values (#{name}, #{age})")
	public int add(User user);
	
	//使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("delete from users where id=#{id}")
    public int deleteById(int id);
    
    //使用@Update注解指明update方法要执行的SQL
    @Update("update users set name=#{name},age=#{age} where id=#{id}")
    public int update(User user);
    
    //使用@Select注解指明getById方法要执行的SQL
    @Select("select * from users where id=#{id}")
    public User getById(int id);
    
    //使用@Select注解指明getAll方法要执行的SQL
    @Select("select * from users")
    public List<User> getAll();
	
	
}
