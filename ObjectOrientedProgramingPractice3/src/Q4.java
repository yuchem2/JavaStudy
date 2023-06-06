import java.util.Vector;
/**
 * Calculate average GPA among student using Multi-thread.
 * 
 * @author JaeHyun Yoon
 * @since 06-06-2023
 * @see SumThread
 * @see CollegeStudent
 */
public class Q4 {
	private static final int STUDENT_NUM = 80000000;
	private static final int NUM_THREAD = 4;


	public Q4() throws InterruptedException {
		Vector<CollegeStudent> studentList = new Vector<CollegeStudent>();

		for (int i = 0; i < STUDENT_NUM; i++) {
			studentList.add(new CollegeStudent());
		}
		System.out.println("Start Calculate!");
		long start = System.currentTimeMillis();
		System.out.println("Average GPA = " + getMean(studentList));
		long end = System.currentTimeMillis();
		System.out.println("End Calculatte! Elapsed time: " + (end - start) / 1000.0 + "sec.");
		
		System.out.println("Start Calculate using multi-thread!");
		start = System.currentTimeMillis();
		
		SumThread.setSum(0);
		SumThread.setList(studentList);
		SumThread[] threads = new SumThread[NUM_THREAD];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new SumThread(i * (STUDENT_NUM / NUM_THREAD), (i + 1) * (STUDENT_NUM / NUM_THREAD));
			threads[i].start();
		}

		for (int i = 0; i < threads.length; i++)
			threads[i].join();
		System.out.println("Average GPA = " + SumThread.getSum() / STUDENT_NUM);
		end = System.currentTimeMillis();
		System.out.println("End Calculatte! Elapsed time: " + (end - start) / 1000.0 + "sec.");
	}

	public double getMean(Vector<CollegeStudent> studentList) {
		double result = 0.0;
		for (CollegeStudent student : studentList) {
			result += student.getGPA();
		}
		return result / STUDENT_NUM;
	}


	public static void main(String[] args) throws InterruptedException {
		new Q4();

	}

}
