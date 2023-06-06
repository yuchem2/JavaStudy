import java.util.Random;

/**
 * CollegeStudent: add data member GPA from Student class.
 * 
 * @author JaeHyun Yoon
 * @since 06-06-2023
 * @see Student
 */
class CollegeStudent extends Student {
	
	private double GPA = 0.0;

	// Constructor
	public CollegeStudent() {
		super();
		Random random = new Random();
		GPA = Math.round(random.nextDouble(4.5) * 10) / 10.0;
	}

	public CollegeStudent(String department, String gender, double height, double weight) {
		super(department, gender, height, weight);
		Random random = new Random();
		GPA = random.nextGaussian() * 4.5 + 2.0;
	}

	public CollegeStudent(String department, String gender, double height, double weight, double GPA) {
		super(department, gender, height, weight);
		this.GPA = GPA;
	}
	public CollegeStudent(String department, int studentId, String gender, double height, double weight, double GPA) {
		super(department, studentId, gender, height, weight);
		this.GPA = GPA;
	}

	// Getters and Setters
	public double getGPA() {
		return GPA;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

}
