

import java.util.Scanner;

public class NameCharactorsFinding {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the string");
		String name = sc.nextLine();
		int count[] = new int[128];
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			count[ch]++;

		}
		for (int i = 0; i < 128; i++) {
			if (count[i] != 0) {
				System.out.println((char) i + "--->" + count[i]);
			}

		}
 
	}
}