package kr.or.ddit.config.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

//<context:property-placeholder location="classpath:kr/or/ddit/config/db/DB.properties"/>
@PropertySource("classpath:kr/or/ddit/config/db/DB.properties")
@Configuration
public class DataSourseContext {
/*
 <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
	<property name="url" value="${jdbc.url}"/>
	<property name="driverClassName" value="${jdbc.driver}"/>
	<property name="username" value="${jdbc.user}"/>
	<property name="password" value="${jdbc.pass}"/>
</bean>
<bean> ==> @Bean method
 */
	@Autowired
	private Environment env;
	
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
// xml에서 ${key} ==> 문자열 key로 보내준다.
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		return dataSource;
	}
	
	/*
	 <bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="configLocation" value="classpath:kr/or/ddit/config/db/mybatis-config.xml"></property>
		<property name="dataSource" ref="dataSource"></property>
	</bean> 
	 */
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		// classpath: 제거
		factoryBean.setConfigLocation(new ClassPathResource("kr/or/ddit/config/db/mybatis-config.xml"));
		// 해당 메서드를 주입받는다 => spring에서 관리
		factoryBean.setDataSource(dataSource());
		
		return factoryBean.getObject();
	}
	
//	<!-- 	sqlSession -->
//	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
//		<constructor-arg ref="sqlSessionFactoryBean"/>
//	</bean>	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactoryBean());
		return sqlSessionTemplate;
		
	}
		
}
























