package com.dib.test;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		JobLauncher launcher = null;
		Job job1 = null;
		JobExecution execution = null;
		
		ctx = new ClassPathXmlApplicationContext("com/dib/configurations/applicationContext.xml");
		
		launcher = ctx.getBean("joblauncher", JobLauncher.class);
		job1 = ctx.getBean("job1", Job.class);
		 
		try {
			execution = launcher.run(job1, new JobParameters());
			System.out.println(execution.getStatus());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		((AbstractApplicationContext) ctx).close();
		
		
	}
	
}
