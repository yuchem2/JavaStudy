/**
 * Student Class
 * 
 * @see Q1
 * @author Jaehyun Yoon
 * @since 04-17-2023
 * @version 1.0
 */

public class Student {
	/**
	 * data members
	 */
	public String studentName;
	private int studentID;
	private String studentSex;
	private double studentGPA;

	/**
	 * Constructor of the student. Initialize the data members.
	 */
	public Student() {
		studentName = "None";
		studentID = 0;
		studentSex = "Male";
		studentGPA = 0.0;
	}

	/**
	 * Constructor of the student. Can randomly initialize the data members.
	 * 
	 * @param rand whether initialization is random or not
	 */
	public Student(boolean rand) {
		if (rand) {
			this.setRandomName();
			this.setRandomID();
			this.setRandomSex();
			studentGPA = Math.random() * 4.5;
		} else {
			studentName = "None";
			studentID = 0;
			studentSex = "Male";
			studentGPA = 0.0;
		}
	}

	/**
	 * Set studentName randomly.(name length: 5-8) number of cases: 25^5 + 16276
	 */
	public void setRandomName() {
		int nameLen = (int) (Math.random() * 3 + 5);
		studentName = "";
		char nameCh = (char) (int) (Math.random() * 25 + 65);
		studentName += nameCh;
		for (int i = 0; i < nameLen - 1; i++) {
			nameCh = (char) (int) (Math.random() * 25 + 97);
			studentName += nameCh;
		}

	}

	/**
	 * Set studentID randomly.(0-100000) number of cases: 100,000 (can be
	 * overlapped)
	 */
	public void setRandomID() {
		studentID = (int) (Math.floor(Math.random() * 100000));
	}

	/**
	 * Set studentSex randomly. Male or Female
	 */
	public void setRandomSex() {
		int sex = (int) Math.round(Math.random());
		if (sex == 0) {
			studentSex = "Male";
		} else {
			studentSex = "Female";
		}
	}

	/**
	 * Set studentID with parameter
	 * 
	 * @param ID will be studentID
	 */
	public void setID(int ID) {
		studentID = ID;
	}

	/**
	 * Set studentSex with the parameter
	 * 
	 * @param sex will be studentSex
	 */
	public void setSex(String sex) {
		studentSex = sex;
	}

	/**
	 * Set StudentGPA with parameter
	 * 
	 * @param gpa will be studentGPA
	 */
	public void setGPA(double gpa) {
		studentGPA = gpa;
	}

	/**
	 * Return studentID
	 * 
	 * @return studentID
	 */
	public int getID() {
		return studentID;
	}

	/**
	 * Return studentSex
	 * 
	 * @return studentSex
	 */
	public String getSex() {
		return studentSex;
	}

	/**
	 * Return studentGPA
	 * 
	 * @return studentGPA
	 */
	public double getGPA() {
		return studentGPA;
	}

	/**
	 * Print all information of the student by CUI
	 */
	public void printInfo() {
		System.out.format(studentName + "%6d\t" + studentSex + "\t%.1f\n", studentID, studentGPA);
	}
}
