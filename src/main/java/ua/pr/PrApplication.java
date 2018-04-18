package ua.pr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

import ua.pr.entities.Student;
import ua.pr.entities.Teacher;
import ua.pr.worker.*;


public class PrApplication {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

		Student testStudent = new Student("Vlad Valt", 5);
		WorkWithStudents worker = (WorkWithStudents) context.getBean("worker");

		worker.saveStudentToDb(testStudent);
		worker.getStudentFromDb(1);


		WorkWithTeacher workWithTeacher = (WorkWithTeacher) context.getBean("teachersWorker");
		Teacher teacher = new Teacher();
		teacher.setFirstname("Andrii");
		teacher.setLastname("Glybovets");
		teacher.setCellphone("+380675097865");
		teacher = workWithTeacher.addTeacher(teacher);

		workWithTeacher.saveTacher(teacher);
	}
}
