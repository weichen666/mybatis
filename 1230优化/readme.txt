1> 数据源在 db.properties 文件中配置
	

2> 为实体类定义别名，简化sql映射xml文件中的引用
　parameterType="me.gacl.domain.User"这里写的实体类User的全类名me.gacl.domain.User，
   每次都写这么一长串内容挺麻烦的
<insert id="addUser" parameterType="me.gacl.domain.User">
    insert into users(name,age) values(#{name},#{age})
</insert>

简化写法：
　parameterType="_User"这样写就简单多了，为了达到这种效果，
   我们需要在conf.xml文件中为实体类="me.gacl.domain.User"定义一个名为"_User"，
<insert id="addUser2" parameterType="_User">
    insert into users(name,age) values(#{name},#{age})
</insert>

	配置方法：
	在<configuration></configuration>
	<typeAliases>
    	<typeAlias type="me.gacl.domain.User" alias="_User"/>
	</typeAliases>


批量为某个包下的所有实体类设置别名
<!-- 配置实体类的别名，配置实体类别名的目的是为了在引用实体类时可以使用实体类的别名来代替实体类，达到简写的目的 -->
    <typeAliases>
        <!-- 为实体类me.gacl.domain.User配置一个别名_User -->
        <!-- <typeAlias type="me.gacl.domain.User" alias="_User"/> -->
        <!-- 为me.gacl.domain包下的所有实体类配置别名，MyBatis默认的设置别名的方式就是去除类所在的包后的简单的类名
        比如me.gacl.domain.User这个实体类的别名就会被设置成User
         -->
        <package name="me.gacl.domain"/>
    </typeAliases>
	
	
	
	
	