package in.co.greenwave.brandschedule.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class SqlServerConfig {

		@Bean(name = "SqlServer")
		 DataSource getDataSource() {
			
				HikariConfig hikariConfig = new HikariConfig();
				
				hikariConfig.setUsername("sa");
				hikariConfig.setPassword("Greenwave@123");
				hikariConfig.setJdbcUrl("jdbc:sqlserver://192.168.5.3:1433;encrypt=true;trustServerCertificate=true;databaseName=Filter_PI");
				hikariConfig.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				DataSource hikariDataSource = new HikariDataSource(hikariConfig);
				
				return hikariDataSource;
		}
		
		
		@Bean
		@Qualifier("SqlServer")
		 JdbcTemplate getJdbcTemplate() {
			
			JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
			
			return jdbcTemplate;
		}
}
