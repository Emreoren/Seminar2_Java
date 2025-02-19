package seminar2;


public class Grade {
	//variables
	private long gId;
	private int grValue;
	private Student student;
	private Course course;
	
	private static long counter = 30000;


	//getters

	public int getGrValue() {
		return grValue;
	}

	public long getgId() {
		return gId;
	}

	public Student getStudent() {
		return student;
	}

	public Course getCourse() {
		return course;
	}
	//setters
	public void setGId() {
		gId = counter++;
	}
	
	public void setGrValue(int inputGradeValue) {
		if(inputGradeValue > 0 && inputGradeValue <= 10)
		{
			grValue = inputGradeValue;
		}
		else 
		{
			
			grValue = 0;
			
		}
	}
	public void setStudent(Student inputStudent)
	{
		if(inputStudent != null) {
			student = inputStudent;
		}
		else {
			student = new Student();
			
		}
	}

	public void setCourse(Course inputCourse) {
		if(inputCourse != null) {
			course = inputCourse;
		}
		else
		{
			course = new Course();
		}
	}

	//default cons.
	public Grade()
	{
		setGId();
		setGrValue(0);
		setStudent(new Student());
		setCourse(new Course());
	}
	//arg. cons.
	public Grade(int inputGradeValue, Student inputStudent, Course inputCourse)
	{
	setGId();
	setGrValue(inputGradeValue);
	setStudent(inputStudent);
	setCourse(inputCourse);
	
	}
	//toString
	
	public String toString () {
		
		return gId + ": " + grValue + "-> " 	+ student.getName().charAt(0) + ". " + student.getSurname()	+ " (" + course.getTitle() + ")";
	}
	
	
	
	
	
	
	
}
