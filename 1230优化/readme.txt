1> ����Դ�� db.properties �ļ�������
	

2> Ϊʵ���ඨ���������sqlӳ��xml�ļ��е�����
��parameterType="me.gacl.domain.User"����д��ʵ����User��ȫ����me.gacl.domain.User��
   ÿ�ζ�д��ôһ��������ͦ�鷳��
<insert id="addUser" parameterType="me.gacl.domain.User">
    insert into users(name,age) values(#{name},#{age})
</insert>

��д����
��parameterType="_User"����д�ͼ򵥶��ˣ�Ϊ�˴ﵽ����Ч����
   ������Ҫ��conf.xml�ļ���Ϊʵ����="me.gacl.domain.User"����һ����Ϊ"_User"��
<insert id="addUser2" parameterType="_User">
    insert into users(name,age) values(#{name},#{age})
</insert>

	���÷�����
	��<configuration></configuration>
	<typeAliases>
    	<typeAlias type="me.gacl.domain.User" alias="_User"/>
	</typeAliases>


����Ϊĳ�����µ�����ʵ�������ñ���
<!-- ����ʵ����ı���������ʵ���������Ŀ����Ϊ��������ʵ����ʱ����ʹ��ʵ����ı���������ʵ���࣬�ﵽ��д��Ŀ�� -->
    <typeAliases>
        <!-- Ϊʵ����me.gacl.domain.User����һ������_User -->
        <!-- <typeAlias type="me.gacl.domain.User" alias="_User"/> -->
        <!-- Ϊme.gacl.domain���µ�����ʵ�������ñ�����MyBatisĬ�ϵ����ñ����ķ�ʽ����ȥ�������ڵİ���ļ򵥵�����
        ����me.gacl.domain.User���ʵ����ı����ͻᱻ���ó�User
         -->
        <package name="me.gacl.domain"/>
    </typeAliases>
	
	
	
	
	