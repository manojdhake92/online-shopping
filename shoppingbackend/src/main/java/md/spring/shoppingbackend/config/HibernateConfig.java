package md.spring.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration    //This tells framework that it contains some hibernate related config beans
@ComponentScan(basePackages={"md.spring.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

		private final static String DATABASE_URL="jdbc:mysql://localhost:3306/online_shopping";
		private final static String DATABASE_DRIVER="com.mysql.jdbc.Driver";
		private final static String DATABASE_DIALECT="org.hibernate.dialect.MySQLDialect";
		private final static String DATABASE_USERNAME="root";
		private final static String DATABASE_PASSWORD="root";
		
		@Bean
		public DataSource getDatasource() {
			BasicDataSource datasource  = new BasicDataSource();
			
			datasource.setDriverClassName(DATABASE_DRIVER);
			datasource.setUrl(DATABASE_URL);
			datasource.setUsername(DATABASE_USERNAME);
			datasource.setPassword(DATABASE_PASSWORD);
			
			return datasource;
			
		}
		
		@Bean
		public SessionFactory getsessionFactory(DataSource datasource){
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
			builder.addProperties(getProperties());
			builder.scanPackages("md.spring.shoppingbackend.dto");
			return builder.buildSessionFactory();
			
		}

		private Properties getProperties() {
			Properties props = new Properties();
			props.setProperty("hibernate.dialect", DATABASE_DIALECT);
			props.setProperty("hibernate.show_sql", "true");
			props.setProperty("hibernate.format_sql","true");
			
			return props;
		}
		
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory session){
			
			return new HibernateTransactionManager(session);
		}
}
