import java.io.*;
import java.util.Random;
/**
 * Create file with random numbers
 * Count the summ of numbers from the file
 * @author katrin
 *
 */
public class MyMain {
	static Random random = new Random();
	private static final int MAX_VALUE = 10;
	private static final int COUNT_NUMBERS = 3;

	public static void main(String[] args) {

		File file = new File("d:\\numbers.txt");
		 checkFile(file);
		 createNumbers(file);
		countNumbers(file);
	}

	private static void countNumbers(File file) {
		try (FileInputStream input = new FileInputStream(file)) {
			byte [] arr = new byte[input.available()];
			input.read(arr);
			String str = new String(arr);
			String [] strArr = str.split(" ");
			int res=0;
			for (int i=0 ; i<strArr.length ; i++){
				res += Integer.parseInt(strArr[i]);
			}
			System.out.println(res);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void createNumbers(File file) {
		try (FileOutputStream output = new FileOutputStream(file)) {
			StringBuilder str = new StringBuilder(String.valueOf(random.nextInt(MAX_VALUE)));
			for (int i = 1; i < COUNT_NUMBERS; i++) {
				str.append(" ").append(random.nextInt(MAX_VALUE));
			}
			System.out.println(str);
			byte[] arr = str.toString().getBytes();
			output.write(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void checkFile(File file) {
		if (!file.exists()) {
			System.out.println("File is empty");
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
