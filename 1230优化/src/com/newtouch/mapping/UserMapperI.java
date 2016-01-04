package com.newtouch.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.newtouch.domain.User;

/**
 * ����sqlӳ��Ľӿڣ�ʹ��ע��ָ������Ҫִ�е�SQL
 * 
 * tip:
 * 	����Ҫ˵�����ǣ����ǲ���Ҫ���UserMapperI�ӿ�ȥ��д�����ʵ������룬
 *    ��������ʵ������MyBatis�����Ƕ�̬��������������ֻ��Ҫֱ������ʹ�ü��ɡ�
 * 
 * @author Administrator
 */
public interface UserMapperI {
	
	@Insert("insert into users(name, age) values (#{name}, #{age})")
	public int add(User user);
	
	//ʹ��@Deleteע��ָ��deleteById����Ҫִ�е�SQL
    @Delete("delete from users where id=#{id}")
    public int deleteById(int id);
    
    //ʹ��@Updateע��ָ��update����Ҫִ�е�SQL
    @Update("update users set name=#{name},age=#{age} where id=#{id}")
    public int update(User user);
    
    //ʹ��@Selectע��ָ��getById����Ҫִ�е�SQL
    @Select("select * from users where id=#{id}")
    public User getById(int id);
    
    //ʹ��@Selectע��ָ��getAll����Ҫִ�е�SQL
    @Select("select * from users")
    public List<User> getAll();
	
	
}
