import java.io.*;

/**
 * Q1: decrypt the binary file
 * 
 * @author Jaehyun Yoon
 * @since 06-18-2023
 * @see FileLoader
 */

public class Q1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File binary = new File("Q1.data");
		FileInputStream binaryInpuStream = new FileInputStream(binary);
		DataInputStream inBinary = new DataInputStream(binaryInpuStream);

		File decrpytionCode = new File("Q1_CodeBook.data");
		FileReader dectyptionReader = new FileReader(decrpytionCode);
		BufferedReader inDecryption = new BufferedReader(dectyptionReader);

		String buff1;
		FileLoader intFile = new FileLoader("Q1_int.txt");
		FileLoader boolFile = new FileLoader("Q1_Boolean.txt");
		FileLoader doubleFile = new FileLoader("Q1_Double.txt");
		FileLoader charFile = new FileLoader("Q1_char.txt");
		FileLoader longFile = new FileLoader("Q1_Long.txt");

		double sum = 0.0;

		while ((buff1 = inDecryption.readLine()) != null) {
			if (buff1.equals("double")) {
				double buff2 = inBinary.readDouble();
				sum += buff2;
				doubleFile.getWriter().println(buff2);
			} else if (buff1.equals("int")) {
				intFile.getWriter().println(inBinary.readInt());
			} else if (buff1.equals("boolean")) {
				boolFile.getWriter().println(inBinary.readBoolean());
			} else if (buff1.equals("char")) {
				charFile.getWriter().println(inBinary.readChar());
			} else if (buff1.equals("long")) {
				longFile.getWriter().println(inBinary.readLong());
			}
		}
		
		System.out.println("The sum of all data of type double as a result of decryption is: " + sum);
		System.out.println("================================");
		System.out.println("# of integer values: " + intFile.getLine());
		System.out.println("# of boolean values: " + boolFile.getLine());
		System.out.println("# of double values: " + doubleFile.getLine());
		System.out.println("# of char values: " + charFile.getLine());
		System.out.println("# of long values: " + longFile.getLine());
		

		inBinary.close();
		binaryInpuStream.close();
		inDecryption.close();
		dectyptionReader.close();
		intFile.close();
		boolFile.close();
		doubleFile.close();
		charFile.close();
		longFile.close();
	}

}
