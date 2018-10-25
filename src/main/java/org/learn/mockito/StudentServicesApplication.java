package org.learn.mockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jillesvangurp.springdepend.SpringDependencyAnalyzer;

@EnableJpaRepositories
@SpringBootApplication
public class StudentServicesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StudentServicesApplication.class, args);
//		SpringDependencyAnalyzer analyzer = new SpringDependencyAnalyzer((GenericApplicationContext) context);
//		//analyzer.printReport(analyzer.getClass());
//		System.out.println(analyzer.beanGraphCypher());
	}
}
