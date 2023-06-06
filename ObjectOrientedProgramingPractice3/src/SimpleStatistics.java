/**
 * SimpleStatistics
 * 
 * @author JaeHyun Yoon
 * @since 06-06-2023
 */
abstract class SimpleStatistics {
	/**
	 * getMean() method
	 * 
	 * @param variable: one-dimensional numeric vector such as Height and Weight
	 * @return mean of input values
	 */
	public abstract double getMean(double[] variable);

	/**
	 * getConditionalMean() method
	 * 
	 * @param condition: given condition (i.e. Sex: female and male respectively)
	 * @param variable:  one-dimensional number vector such as Height and Weight
	 * @return mean of input values
	 */
	public abstract double getConditionalMean(String condition, double[] variable);

	/**
	 * getMax() method
	 * 
	 * @param variable: one-dimensional numeric vector such as Height and Weight
	 * @return maximum value of input values
	 */
	public abstract double getMax(double[] variable);

	/**
	 * getMin() method
	 * 
	 * @param variable: on-dimensional numeric vector such as Height and Weight
	 * @return value of input values
	 */
	public abstract double getMin(double[] variable);
}
