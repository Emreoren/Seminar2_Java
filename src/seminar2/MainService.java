package seminar2;



public class MainService {

	public static void main(String[] args) {

		Student st1 = new Student();
		System.out.println(st1.toString());
		
		Student st2 = new Student("John", "Green");
		System.out.println(st2);
		
		Student st3 = new Student("83907127", "2312511412412");
		System.out.println(st3);
		
		Student st4 = new Student (null, null);
		System.out.println(st4);
		
		Professor p1 = new Professor();
		System.out.println(p1);

		Professor p2 = new Professor("Memoli", "Oren", Degree.dr);
		System.out.println(p2);
		
		Course c1 = new Course();
		System.out.println(c1);
		
		Course c2 = new Course("JAVA Programming", 6, p2);
		System.out.println(c2);
		
		Course c3 = new Course("31312312121ghkg1fj1341khbdfdwkjhgf31re73", -4, null);
		System.out.println(c3);
				
	}

}
