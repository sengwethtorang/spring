package polymorphism;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("TV :");
		String tv = scanner.nextLine();
		RemoteControl rc;
		switch (tv) {
		case "LG":
			rc = new LGRC();
			break;

		default:
			rc = new SamsungRC();
			break;
		}
		rc.turnOn();
	}
}
