import java.io.Serializable;
import java.util.Random;

/**
 * Basic Student Class
 * 
 * @author JaeHyun Yoon
 * @since 06-06-2023
 */
class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	protected static int globalStudentId = 1;
	protected static final String[] DEPARTMENT_LIST = { "CS", "Philosophy", "History", "Law" };

	protected String department;
	protected int studentId;
	protected String gender;
	protected double height;
	protected double weight;

	// Constructor
	public Student(String department, int studentId, String gender, double height, double weight) {
		this.department = department;
		this.studentId = studentId;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	}

	public Student(String department, String gender, double height, double weight) {
		this.department = department;
		this.studentId = globalStudentId++;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	}

	public Student(String department, String gender) {
		this.department = department;
		this.gender = gender;

		// Set student ID globally and increment by one for each new object
		this.studentId = globalStudentId++;

		// Generate random height based on gender
		if (gender.equalsIgnoreCase("Male")) {
			this.height = generateRandomHeight(173, 5);
			this.weight = generateRandomWeight(68, 5);
		} else if (gender.equalsIgnoreCase("Female")) {
			this.height = generateRandomHeight(162, 5);
			this.weight = generateRandomWeight(52, 5);
		} else {
			// If gender is not specified correctly, set default values
			this.height = 0;
			this.weight = 0;
		}
	}

	public Student() {
		this.studentId = globalStudentId++;

		// Generate random gender
		this.gender = generateRandomGender();

		// Generate random department
		this.department = generateRandomDepartment();

		// Generate random height and weight based on gender
		if (gender.equalsIgnoreCase("Male")) {
			this.height = generateRandomHeight(173, 1);
			this.weight = generateRandomWeight(68, 1);
		} else if (gender.equalsIgnoreCase("Female")) {
			this.height = generateRandomHeight(162, 1);
			this.weight = generateRandomWeight(52, 1);
		} else {
			// If gender is not specified correctly, set default values
			this.height = 0;
			this.weight = 0;
		}
	}

	// Method to generate random height based on mean and standard deviation
	protected double generateRandomHeight(double mean, double standardDeviation) {
		Random random = new Random();
		return random.nextGaussian() * standardDeviation + mean;
	}

	// Method to generate random weight based on mean and standard deviation
	protected double generateRandomWeight(double mean, double standardDeviation) {
		Random random = new Random();
		return random.nextGaussian() * standardDeviation + mean;
	}

	// Method to generate random gender
	protected String generateRandomGender() {
		Random random = new Random();
		int randomIndex = random.nextInt(2); // 0 or 1
		return randomIndex == 0 ? "Male" : "Female";
	}

	protected String generateRandomDepartment() {
		Random random = new Random();
		int randomIndex = random.nextInt(4); // 0 to 3
		return DEPARTMENT_LIST[randomIndex];
	}

	// Getters and Setters
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String[] getDepartmentList() {
		return DEPARTMENT_LIST;
	}
}
