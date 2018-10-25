package org.learn.mockito.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.learn.mockito.model.Course;
import org.learn.mockito.model.Student;
import org.learn.mockito.repository.CourseRepository;
import org.learn.mockito.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RoutineService routineService;
	
	
	
	public CourseService() {
		System.out.println("Empty Cons");
	}
	
	
	public CourseService(StudentRepository studentRepository, CourseRepository courseRepository,
			StudentService studentService, RoutineService routineService, SecureRandom random) {
		super();
		System.out.println("Para Cons");
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
		this.studentService = studentService;
		this.routineService = routineService;
		this.random = random;
	}

	
	
	
	public StudentRepository getStudentRepository() {
		return studentRepository;
	}


	public void setStudentRepository(StudentRepository studentRepository) {
		System.out.println("Setter");
		this.studentRepository = studentRepository;
	}


	public CourseRepository getCourseRepository() {
		return courseRepository;
	}


	public void setCourseRepository(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}


	public StudentService getStudentService() {
		return studentService;
	}


	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}


	public RoutineService getRoutineService() {
		return routineService;
	}


	public void setRoutineService(RoutineService routineService) {
		this.routineService = routineService;
	}


	public static List<Student> getStudents() {
		return students;
	}


	public static void setStudents(List<Student> students) {
		CourseService.students = students;
	}


	public SecureRandom getRandom() {
		return random;
	}


	public void setRandom(SecureRandom random) {
		this.random = random;
	}




	private static List<Student> students = new ArrayList<>();

	static {
		//Initialize Data
		Course course1 = new Course("Course1", "Spring", "10 Steps", Arrays
				.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));
		Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));
		Course course3 = new Course("Course3", "Spring Boot", "6K Students",
				Arrays.asList("Learn Maven", "Learn Spring",
						"Learn Spring MVC", "First Example", "Second Example"));
		Course course4 = new Course("Course4", "Maven",
				"Most popular maven course on internet!", Arrays.asList(
						"Pom.xml", "Build Life Cycle", "Parent POM",
						"Importing into Eclipse"));

		Student ranga = new Student("Student1", "Ranga Karanam",
				"Hiker, Programmer and Architect", new ArrayList<>(Arrays
						.asList(course1, course2, course3, course4)));

		Student satish = new Student("Student2", "Satish T",
				"Hiker, Programmer and Architect", new ArrayList<>(Arrays
						.asList(course1, course2, course3, course4)));

		students.add(ranga);
		students.add(satish);
	}

	public List<Student> retrieveAllStudents() {
		return students;
	}

	public Student retrieveStudent(String studentId) {
		studentService.retrieveCourse(null, null);
		for (Student student : students) {
			if (student.getId().equals(studentId)) {
				return student;
			}
		}
		return null;
	}

	public List<Course> retrieveCourses(String studentId) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		return student.getCourses();
	}

	public Course retrieveCourse(String studentId, String courseId) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		for (Course course : student.getCourses()) {
			if (course.getId().equals(courseId)) {
				return course;
			}
		}

		return null;
	}

	private SecureRandom random = new SecureRandom();

	public Course addCourse(String studentId, Course course) {
		Student student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		String randomId = new BigInteger(130, random).toString(32);
		course.setId(randomId);

		student.getCourses().add(course);

		return course;
	}
}