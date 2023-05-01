import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Simple English and Korean language translation program. Only translate known
 * words.
 * 
 * @author Jaehyun Yoon
 * @since 04-17-2023
 * @version 1.0
 */
public class Q8 {

	public static void main(String[] args) {

		String[] eng = { "apple", "is", "red", "My", "house", "in", "Seoul", "I", "am", "love", "him" };
		String[] kor = { "사과", "는", "빨간색", "내", "집", "에", "서울", "나", "는", "사랑하다", "그를" };
		List<String> result = new ArrayList<String>();
		int wordNum = 1;

		Scanner scanner = new Scanner(System.in);

		// Input
		System.out.print("Input: ");
		String inputStr = scanner.nextLine();

		// Calculate
		while (inputStr.length() > 0) {
			String buff;
			if (inputStr.indexOf(" ") != -1) {
				buff = inputStr.substring(0, inputStr.indexOf(" "));
				inputStr = inputStr.substring(buff.length() + 1);
			} else {
				buff = inputStr;
				inputStr = "";
			}

			for (int i = 0; i < eng.length; i++) {
				if (buff.equalsIgnoreCase(eng[i])) {
					result.add(kor[i]);
					break;
				} else if (buff.equals(kor[i])) {
					result.add(eng[i]);
					break;
				}
			}
			if (wordNum > result.size()) {
				System.out.println("I don't know \"" + buff + "\"");
				result.add("Unknown(모름)");
			}
			wordNum++;
		}

		// Output
		System.out.print("Output: ");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
		scanner.close();

	}

}
