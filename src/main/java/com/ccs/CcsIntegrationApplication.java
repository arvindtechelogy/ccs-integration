package com.ccs;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @author Arvind Maurya
 * @since 2020-01-23
 * @copyright 2020
 *
 */
@EnableScheduling
@SpringBootApplication
public class CcsIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcsIntegrationApplication.class, args);
	}

	// function for getting connection url,name,password from configuration file
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	@Primary
	public DataSource dataSource() {
		Properties props = new Properties();
		try {
			String rootPath = CcsIntegrationApplication.class.getClassLoader().getResource("").getPath();
			File file = new File(
					File.separatorChar + Paths.get(rootPath.substring(1)).getParent().getParent().getParent().toString()
							+ File.separatorChar + "dbconfiguration.properties");
			FileReader reader = new FileReader(file);
			props.load(reader);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return DataSourceBuilder.create().username(props.getProperty("USER_NAME"))
				.password(props.getProperty("PASSWORD")).url(props.getProperty("CON_URL")).build();
	}

}