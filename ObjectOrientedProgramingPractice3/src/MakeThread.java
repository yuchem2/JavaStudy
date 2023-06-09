
import java.util.Vector;

/**
 * MakeThread: For making student instance
 * 
 * @author JaeHyun Yoon
 * @since 06-07-2023
 */

class MakeThread extends Thread {

	private static Vector<CollegeStudent> buff = null;

	private int num;

	public MakeThread(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		for (int i = 0; i < num; i++)
			buff.add(new CollegeStudent());
	}

	public static void setBuff(Vector<CollegeStudent> point) {
		buff = point;
	}
}
