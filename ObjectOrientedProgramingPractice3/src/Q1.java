import javax.swing.JFrame;

/**
 * Q1: Calculate mean, max, min value for 10,000 students. And Calculate User height, weight differ from the 10,000 students.
 * 
 * @author JaeHyun Yoon
 * @since 06-06-2023
 * @see Q1GUI
 * @see Student
 */

public class Q1 extends SimpleStatistics {

	private static final int STUDENT_NUM = 10000;

	private Student[] studentList = null;
	private double[] weights = null;
	private double[] heights = null;

	public Q1() {
		studentList = new Student[STUDENT_NUM];
		weights = new double[STUDENT_NUM];
		heights = new double[STUDENT_NUM];

		for (int i = 0; i < STUDENT_NUM; i++) {
			studentList[i] = new Student();
			weights[i] = studentList[i].getWeight();
			heights[i] = studentList[i].getHeight();
		}

		double heightMean = Math.round(getMean(heights));
		double maleHeightMean = Math.round(getConditionalMean("Sex: Male", heights));
		double femaleHeightMean = Math.round(getConditionalMean("Sex: Female", heights));
		double maxHeight = Math.round(getMax(heights));
		double minHeight = Math.round(getMin(heights));

		double weightMean = Math.round(getMean(weights));
		double maleWeightMean = Math.round(getConditionalMean("Sex: Male", weights));
		double femaleWeightMean = Math.round(getConditionalMean("Sex: Female", weights));
		double maxWeight = Math.round(getMax(weights));
		double minWeight = Math.round(getMin(weights));

		System.out.println("Height Mean: " + heightMean);
		System.out.println("Male Height Mean: " + maleHeightMean);
		System.out.println("Female Height Mean: " + femaleHeightMean);
		System.out.println("Max Height: " + maxHeight);
		System.out.println("Min Height: " + minHeight);
		System.out.println();
		System.out.println("Weight Mean: " + weightMean);
		System.out.println("Male Weight Mean: " + maleWeightMean);
		System.out.println("Female Weight Mean: " + femaleWeightMean);
		System.out.println("Max Weight:" + maxWeight);
		System.out.println("Min Weight:" + minWeight);

		JFrame window = new Q1GUI(heightMean, weightMean);
	}

	public static void main(String[] args) {
		new Q1();
	}

	@Override
	public double getMean(double[] variable) {
		double sum = 0.0;
		for (double value : variable)
			sum += value;
		return sum / STUDENT_NUM;
	}

	@Override
	public double getConditionalMean(String condition, double[] variable) {
		int idx = condition.indexOf(':');
		String feature = condition.substring(0, idx);
		String cond = condition.substring(idx + 2, condition.length());
		double sum = 0.0;
		int cnt = 0;
		if (feature.equals("Sex")) {
			for (int i = 0; i < STUDENT_NUM; i++) {
				if (cond.equals(studentList[i].getGender())) {
					sum += variable[i];
					cnt += 1;
				}

			}

		} else if (feature.equals("Department")) {
			for (int i = 0; i < STUDENT_NUM; i++) {
				if (cond.equals(studentList[i].getDepartment())) {
					sum += variable[i];
					cnt += 1;
				}

			}
		} else
			return getMean(variable);

		return sum / cnt;
	}

	@Override
	public double getMax(double[] variable) {
		double max = variable[0];
		for (double value : variable)
			if (value > max)
				max = value;

		return max;
	}

	@Override
	public double getMin(double[] variable) {
		double min = variable[0];
		for (double value : variable)
			if (value < min)
				min = value;

		return min;
	}
}
