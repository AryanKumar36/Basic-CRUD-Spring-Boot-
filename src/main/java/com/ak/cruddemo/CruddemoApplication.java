package com.ak.cruddemo;

import com.ak.cruddemo.dao.StudentDAO;
import com.ak.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


//1. create the student object

//2. save the student object

//3. display id of the saved student
@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);

			 createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted= studentDAO.deleteAll();
		System.out.println("Number of rows deleted are "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//Select id
		int studentId = 3;
		//Display Student
		System.out.println("Deleting Student with id" + studentId);
		//Delete Student
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting the student id " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Updating student....");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDAO.update(myStudent);

		//display the update student
		System.out.println("Updated student: " +myStudent);
	}

	private void queryForLastName(StudentDAO studentDAO) {
		//Get List of Student
		List<Student> myStudent = studentDAO.findByLastName("Doe");
		//Display them
		for(Student tempStudent: myStudent)
		{
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get list of students
		List<Student> myStudent = studentDAO.findAll();
		//display the list of student
		System.out.println("Displaying all Students");
		for (Student tempStudent: myStudent)
		{
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student
		System.out.println("Creating the Student...");
		Student tempStudent = new Student("KJ", "sharma", "kj@gmail.com");

		// save the student
		System.out.println("Saving the Student..");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId= tempStudent.getId();
		System.out.println("Saved Student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the Student : "+ myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating 3 student Object....");

		Student tempStudent1 =new Student("John", "Doe", "j1@ak.com");
		Student tempStudent2 =new Student("John2", "Doe", "j2@ak.com");
		Student tempStudent3 =new Student("John3", "Doe", "j3@ak.com");

		System.out.println("Saving the student....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating student Object....");
		Student tempStudent =new Student("Paul", "Doe", "paul@ak.com");

		//save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved Student. Generating id:" + tempStudent.getId());
	}
}
