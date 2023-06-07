import java.util.Vector;
/**
 * SumThread: Summing for multiple thread
 * @author JaeHyunYoon
 * @since 06-07-2023
 */
class SumThread extends Thread {

	private static double sum = 0;
	private static Vector<CollegeStudent> list = null;
	private int start, end;

	public SumThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		double temp = 0;
		for (int i = start; i < end; i++) {
			temp += list.get(i).getGPA();
		}
		sum += temp;
	}
	
	
	public static void setList(Vector<CollegeStudent> inList) {
		list = inList;
	}
	
	public static void setSum(int num) {
		sum = num;
	}
	public static double getSum() {
		return sum;
	}
}
