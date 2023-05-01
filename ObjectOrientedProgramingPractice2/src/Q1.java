import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Find the student with the highest GPA among 10,000 randomly generated
 * students.
 * 
 * @see Student
 * @author Jaehyun Yoon
 * @since 04-17-2023
 * @version 1.0
 */

public class Q1 {

	public static void main(String[] args) {
		Student buff;
		Map<Integer, Student> studentMap = new HashMap<Integer, Student>();

		// Create student objects
		for (int i = 0; i < 10000; i++) {
			buff = new Student(true);
			if (studentMap.isEmpty()) {
				studentMap.put(buff.getID(), buff);
			}

			// Avoid overlapping studentID
			else {
				while (studentMap.containsKey(buff.getID())) {
					buff.setRandomID();
				}
				studentMap.put(buff.getID(), buff);
			}
		}

		// Output & calculate
		System.out.println("The student with the highest GAP among 10,000 students");
		System.out.println("Name\tID\tSex\tGPA");
		studentMap.get(findHighestGPA(studentMap)).printInfo();
	}

	/**
	 * Find highest GPA
	 * 
	 * @param map the student map(ID, student)
	 * @return studentID with the highest GPA
	 */
	public static int findHighestGPA(Map<Integer, Student> map) {
		Iterator<Map.Entry<Integer, Student>> itr = map.entrySet().iterator();
		Map.Entry<Integer, Student> entry = itr.next();
		int studentID = entry.getKey();

		while (itr.hasNext()) {
			entry = itr.next();
			if (map.get(studentID).getGPA() < entry.getValue().getGPA()) {
				studentID = entry.getKey();
			}
		}
		return studentID;
	}

}
