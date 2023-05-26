package com.ojas.jpawebapplication.config;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.ojas.jpawebapplication.model.Employee;
import com.ojas.jpawebapplication.serviceimpl.EmployeeServiceImplementation;

@Configuration
@EnableScheduling
public class SchedularConfig implements SchedulingConfigurer, Runnable {
	@Autowired
	private EmployeeServiceImplementation serviceImpl;

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ", executing run() method!");
		List<Employee> list = serviceImpl.getAllEmployees();
		String genetatePdf = PdfGeneration.genetatePdf(list);
		String filepah = "D:\\SpringBootMicroservices\\JpaWebapplication\\src\\main\\resources\\employee.pdf";
		String toMail = "nanivinaykumar19@gmail.com";
		String msg = "";
		String cc = "pendyalajashwanth07@gmail.com,gdivya1232@gmail.com";
		boolean emailSend = SentAttachment.emailSend(toMail, cc, filepah);
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

		Trigger trigger = new Trigger() {
			@Override

			public Date nextExecutionTime(TriggerContext triggerContext) {

				CronTrigger crontrigger = new CronTrigger("0 0/30 * * * *");

				return crontrigger.nextExecutionTime(triggerContext);

			}
		};
		scheduledTaskRegistrar.addTriggerTask(this::run, trigger);
	}

}
