package seminar2;

import java.util.ArrayList;
import java.util.Arrays;

public class MainService {
	
	private static ArrayList<Student> allStudents = new ArrayList<Student>();
	private static ArrayList<Professor> allProfessors = new ArrayList<Professor>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();

	
	

	public static void main(String[] args) {

		System.out.println("------------------STUDENTS-------------------");
		
		Student st1 = new Student();
		//System.out.println(st1.toString());
		
		Student st2 = new Student("John", "Green");
		//System.out.println(st2);
		
		Student st3 = new Student("83907127", "2312511412412");
		//System.out.println(st3);
		
		Student st4 = new Student (null, null);
		//System.out.println(st4);
		
		allStudents.addAll(Arrays.asList(st1, st2, st3, st4));
		System.out.println(allStudents);
		
		System.out.println("------------------PROFESSORS-------------------");

		Professor p1 = new Professor();
		//System.out.println(p1);

		Professor p2 = new Professor("Memoli", "Oren", Degree.dr);
		//System.out.println(p2);
		
		allProfessors.addAll(Arrays.asList(p1, p2));
		
		try
		{
			createProfessor("Estere", "Vitola", Degree.mg);
			//createProfessor("Estere", "Vitola", Degree.mg); //this will be exception
			createProfessor("Karlis", "Immers", Degree.mg);
			System.out.println("Retrieve example: " + retrieveProfessorById(10001));//Memoli
			updateProfessorById(10000, "Vairis", "Caune", Degree.dr);
			System.out.println("Arrayslist after the update: " +allProfessors);
			deleteProfessorById(10002);
			System.out.println("Arraylist after deleting Estere: " + allProfessors);
			System.out.println("Professors with dr: " + filterProfessorsByDegree(Degree.dr));
			System.out.println("Average Grade for this guy : " + calculateAvgGradeForStudentById(1));
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println(allProfessors);
		
		System.out.println("------------------COURSES-------------------");
		
		Course c1 = new Course();
		//System.out.println(c1);
		
		Course c2 = new Course("JAVA Programming", 6, p2);
		//System.out.println(c2);
		
		Course c3 = new Course("31312312121ghkg1fj1341khbdfdwkjhgf31re73", -4, null);
		//System.out.println(c3);
		
		allCourses.addAll(Arrays.asList(c1, c2, c3));
		System.out.println(allCourses);
		
		System.out.println("------------------GRADES-------------------");
		
		Grade g1 = new Grade();
		//System.out.println(g1);
		
 		Grade g2 = new Grade(4, st2 ,c2); //st2  is john green c2 is java 
 		//System.out.println(g2);

 		allGrades.addAll(Arrays.asList(g1, g2));
		System.out.println(allGrades);
	}
	
	// CRUD - C - create - R - Retrieve - U - Update - D - Delete
	
	public static void createProfessor(String name, String surname, Degree degree) throws Exception{
		
		if (name == null || surname == null || degree == null) {
			throw new Exception("Input parameters cannot be null");
		}
		
		for(Professor tempP : allProfessors) {
			if(tempP.getName().equals(name)
					&& tempP.getSurname().equals(surname)
					&& tempP.getDegree().equals(degree)) 
			{
				throw new Exception("This professor is already registered in the system");
			}
				
		}
		
		allProfessors.add(new Professor(name,surname,degree));
		
		
	}
	
	
	//R retrieve
	
	public static Professor retrieveProfessorById(long id) throws Exception
	{
		if(id < 10000)
		{	
			throw new Exception("Id should be in the parameters");
		}
		
		for(Professor tempP : allProfessors)
		{
			if(tempP.getpId() == id)
				return tempP;
		}
		throw new Exception("Professor is not found");
		
	}
	
	//U - Update
	
	public static void updateProfessorById(int id, String name, String surname, Degree degree) throws Exception
	{
		Professor foundProfessor = retrieveProfessorById(id);
		
		if(name != null && !foundProfessor.getName().equals(name))
		{
			foundProfessor.setName(name);
		}
		
		if(surname !=null && !foundProfessor.getSurname().equals(surname))
		{
			foundProfessor.setSurname(surname);
		}
		
		if(degree != null && !foundProfessor.getDegree().equals(degree))
		{
			foundProfessor.setDegree(degree);
		}
		
		
		
	}
	// D - delete
	
	
	public static void deleteProfessorById (int id) throws Exception
	{
		
		Professor foundProfessor = retrieveProfessorById(id);
		
		allProfessors.remove(foundProfessor);
		
	}
	
	//filter out every professor which degree is dr
	
	public static ArrayList <Professor> filterProfessorsByDegree(Degree degree) throws Exception
	{
		if(degree == null) 
		{
			throw new Exception ("The degree is null");
		}
		
		ArrayList<Professor> results = new ArrayList<Professor>();
		
		for(Professor tempP : allProfessors)
		{
			if(tempP.getDegree().equals(degree))
			{
				results.add(tempP);
			}
		}
		
		return results;
	}
	
	
	
	//filter out every failed grade
	
	
	public static ArrayList <Grade> filterFailedGrades()
	{
		
		ArrayList<Grade> results = new ArrayList<Grade>();
		
		for (Grade tempG : allGrades)
			if(tempG.getGrValue() < 4)
			{
				results.add(tempG);
			}
		
		
		
		return results;
	}	
	//calculate average grade for spesific student
	
	public static float calculateAvgGradeForStudentById(int id) throws Exception
	{
		if(id <0)
		{
			throw new Exception ("Id is non existent");
		}
		
		int howManyGrades = 0;
		float sum = 0;
		
		for(Grade tempG :allGrades)
		{
			if(tempG.getStudent().getStID() == id)
			{
				howManyGrades++;
				sum = sum + tempG.getGrValue();
			}
		}
		
		if(howManyGrades == 0)
		{
			throw new Exception("Student with id: " + id +"has no grades.");
		}
		
		
		return sum/howManyGrades;
		
	}
	//find out the max creditPoint value that is stored in the system
	//calculate average grade in spesific course
	//calculate 
	

	
	
}
