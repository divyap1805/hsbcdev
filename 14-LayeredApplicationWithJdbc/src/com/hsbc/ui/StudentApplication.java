package com.hsbc.ui;

import java.util.List;
import java.util.Scanner;

import com.hsbc.dao.StudentDao;
import com.hsbc.exceptions.NoSuchStudentException;
import com.hsbc.exceptions.StudentAlreadyExistsException;
import com.hsbc.exceptions.TechnicalException;
import com.hsbc.factory.StudentDaoFactory;
import com.hsbc.model.Student;
import com.hsbc.service.StudentServiceImpl;

public class StudentApplication {
	public static void main(String[] args) {
		StudentServiceImpl service = new StudentServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Where do you want to save your data: ");
		System.out.println("1. Array List");
		System.out.println("2. Hash Set");
		System.out.println("3. Database");
		System.out.println("Enter your choice: ");
		int ch = sc.nextInt();
		
		StudentDao dao = StudentDaoFactory.createStudentDao(ch);
		
		//StudentDao dao = new StudentDaoImpl();
		service.setDao(dao); // setup dependency
		Student student= new Student(40,"test1",60);
		
		try {
			service.addStudent(student);
			Student result = service.findStudent(24);
			System.out.println(result);
		} 
		catch (NoSuchStudentException e) {
			System.out.println("Student not found!");
		}
		catch(TechnicalException e)
		{
			System.out.println("there is some technical problem, please connect admin. ");
		}
		catch(StudentAlreadyExistsException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}







