import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Q3: car management program
 * 
 * @author Jaehyun Yoon
 * @since 06-18-2023
 */

public class Q3 {

	private final static int NUMBER_OF_MOBILE = 32;
	private final static String[] CONDITIONS = { "Model", "Miles/(US) gallon", "Number of cylinders",
			"Displacement (cu.in.)", "Gross horsepower", "Rear axle ratio", "Weight", "1/4 mile time", "Engine",
			"Transmission", "Number of forward gears", "Number of carburetors" };
	private static Automobile[] mobiles;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File inFile = new File("Q3.data");
		FileReader reader = new FileReader(inFile);
		BufferedReader bufReader = new BufferedReader(reader);

		mobiles = new Automobile[200];

		bufReader.readLine();
		for (int i = 0; i < NUMBER_OF_MOBILE; i++) {
			mobiles[i] = new Automobile(bufReader.readLine());
		}
		
		genAutomobile();

		for (int i = 0; i < NUMBER_OF_MOBILE + 100; i++) {
			mobiles[i].printInformation();
		}
	}

	public static void genAutomobile() {

		double[] miles = { 0, 123456789 };
		int[] cylinder = { 0, 123456789 };
		double[] displacement = { 0, 123456789 };
		int[] grossHorsepower = { 0, 123456789 };
		double[] rearAxleRatio = { 0, 123456789 };
		double[] weight = { 0, 123456789 };
		double[] mileTime = { 0, 123456789 };
		int[] forwardGears = { 0, 123456789 };
		int[] carburetors = { 0, 123456789 };

		for (int i = 0; i < NUMBER_OF_MOBILE; i++) {
			if (miles[0] < mobiles[i].getMiles())
				miles[0] = mobiles[i].getMiles();
			if (miles[1] > mobiles[i].getMiles())
				miles[1] = mobiles[i].getMiles();

			if (cylinder[0] < mobiles[i].getCylinder())
				cylinder[0] = mobiles[i].getCylinder();
			if (cylinder[1] > mobiles[i].getCylinder())
				cylinder[1] = mobiles[i].getCylinder();

			if (displacement[0] < mobiles[i].getDisplacement())
				displacement[0] = mobiles[i].getDisplacement();
			if (displacement[1] > mobiles[i].getDisplacement())
				displacement[1] = mobiles[i].getDisplacement();

			if (grossHorsepower[0] < mobiles[i].getGrossHorsepower())
				grossHorsepower[0] = mobiles[i].getGrossHorsepower();
			if (grossHorsepower[1] > mobiles[i].getGrossHorsepower())
				grossHorsepower[1] = mobiles[i].getGrossHorsepower();

			if (rearAxleRatio[0] < mobiles[i].getRearAxleRatio())
				rearAxleRatio[0] = mobiles[i].getRearAxleRatio();
			if (rearAxleRatio[1] > mobiles[i].getRearAxleRatio())
				rearAxleRatio[1] = mobiles[i].getRearAxleRatio();

			if (weight[0] < mobiles[i].getWeight())
				weight[0] = mobiles[i].getWeight();
			if (weight[1] > mobiles[i].getWeight())
				weight[1] = mobiles[i].getWeight();

			if (mileTime[0] < mobiles[i].getMileTime())
				mileTime[0] = mobiles[i].getMileTime();
			if (mileTime[1] > mobiles[i].getMileTime())
				mileTime[1] = mobiles[i].getMileTime();

			if (forwardGears[0] < mobiles[i].getForwardGears())
				forwardGears[0] = mobiles[i].getForwardGears();
			if (forwardGears[1] > mobiles[i].getForwardGears())
				forwardGears[1] = mobiles[i].getForwardGears();

			if (carburetors[0] < mobiles[i].getCarburetors())
				carburetors[0] = mobiles[i].getCarburetors();
			if (carburetors[1] > mobiles[i].getCarburetors())
				carburetors[1] = mobiles[i].getCarburetors();

		}

		for (int i = NUMBER_OF_MOBILE; i < NUMBER_OF_MOBILE + 100; i++) {
			String model = "mobile_";

			mobiles[i] = new Automobile(model + i, getRandom(miles), getRandom(cylinder), getRandom(displacement),
					getRandom(grossHorsepower), getRandom(rearAxleRatio), getRandom(weight), getRandom(mileTime),
					getRandom(0, 1), getRandom(0, 1), getRandom(forwardGears), getRandom(carburetors));

		}

	}

	public static double getRandom(double[] nums) {
		Random random = new Random();
		return nums[1] + random.nextDouble() * (nums[0] - nums[1]);
	}

	public static int getRandom(int[] nums) {
		Random random = new Random();
		return nums[1] + random.nextInt(nums[0] - nums[1] + 1);
	}

	public static int getRandom(int start, int end) {
		Random random = new Random();
		return start + random.nextInt(end - start + 1);
	}

}
