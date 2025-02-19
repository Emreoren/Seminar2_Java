package seminar2;

public class Course {
	//variables
	private long c_ID;
	private String title;
	private int creditPoints;
	private Professor professor;
	
	private static long counter = 20000;
	//getters

	public long getC_ID() {
		return c_ID;
	}

	public String getTitle() {
		return title;
	}

	public int getCreditPoints() {
		return creditPoints;
	}

	public Professor getProfessor() {
		return professor;
	}

	//setters

	public void setC_ID(long c_ID) {
		c_ID = counter++;
		
	}

	public void setTitle(String inputTitle) {
		if(inputTitle != null && inputTitle.matches("[A-Za-z()]{4,40}"))  {
		title = inputTitle;	
	}
	else {
		title = "No Title";
	}
	}
	

    public void setCreditPoints(int inputCreditPoints) {
    	if(inputCreditPoints > 0 && inputCreditPoints <= 30) {
    		creditPoints = inputCreditPoints;
    	}
    	else
    	{
    		creditPoints = 3;
    	}
    }
    

	public void setProfessor(Professor inputProfessor) {
		if(inputProfessor != null) {
			professor = inputProfessor;
			
		}
		else {
			
			professor = new Professor();
		}
	}
	
	//default cons
	
	public Course()
	{
		setC_ID();
		setTitle("Test Course");
		setCreditPoints(3);
		setProfessor(new Professor());
		
		
	}
	//arg. cons
	public Course(String inputTitle, int inputCreditPoints, Professor inputProfessor)
	{
		setC_ID();
		setTitle(inputTitle);
		setCreditPoints(inputCreditPoints);
		setProfessor(inputProfessor);
		
	}
	//toString
	  public String toString() {
	    	return c_ID + " " + title + " " + creditPoints + " " 
	    + professor.getName().charAt(0) + ". " + professor.getSurname();
	    }
	//other functions
}

