import java.util.Scanner;

public class SantaClausMain {
	public static void main(String[] args) {
		SantaClaus santaClaus = new SantaClaus();

		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("1. Add Nice Person");
			System.out.println("2. Add Gift to Nice Person");
			System.out.println("3. Make Nice Person Naughty");
			System.out.println("4. Make Naughty Person Nice");
			System.out.println("5. Print Nice List");
			System.out.println("6. Print Naughty List");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
			case 1:
				System.out.print("Enter first name: ");
				String firstName = scanner.nextLine();
				System.out.print("Enter last name: ");
				String lastName = scanner.nextLine();
				System.out.print("Enter gifts (comma-separated): ");
				String[] gifts = scanner.nextLine().split(",");
				santaClaus.addNicePerson(firstName, lastName, gifts);
				System.out.printf(
						"%s %s was added to the Nice List!!%nAnd the following gifts were added to %s %s's Christmas List: %s.%n%n",
						firstName, lastName, firstName, lastName, String.join(", ", gifts));
				break;

			case 2:
				System.out.print("Enter first name: ");
				firstName = scanner.nextLine();
				System.out.print("Enter last name: ");
				lastName = scanner.nextLine();
				System.out.print("Enter gift: ");
				String gift = scanner.nextLine();
				santaClaus.addGift(firstName, lastName, gift);
				System.out.printf("Done! %s was added to %s %s's Christmas List!%n%n", gift, firstName, lastName);
				break;

			case 3:
				System.out.print("Enter first name: ");
				firstName = scanner.nextLine();
				System.out.print("Enter last name: ");
				lastName = scanner.nextLine();
				System.out.printf("Done!%n%n");
				santaClaus.makeNiceToNaughty(firstName, lastName);
				System.out.printf("Done! You made %s %s NAUGHTY!!%n%n", firstName, lastName);
				break;

			case 4:
				System.out.print("Enter first name: ");
				firstName = scanner.nextLine();
				System.out.print("Enter last name: ");
				lastName = scanner.nextLine();
				santaClaus.makeNaughtyToNice(firstName, lastName);
				System.out.printf("Done! You made %s %s NICE!!.%n%n", firstName, lastName);
				break;

			case 5:
				System.out.print("PRINTING NICE LIST");
				for (int i = 0; i < 6; i++) {
					System.out.print(".");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
				santaClaus.printNiceList();
				break;

			case 6:
				System.out.print("PRINTING NAUGHTY LIST");
				for (int i = 0; i < 6; i++) {
					System.out.print(".");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
				santaClaus.printNaughtyList();
				break;

			default:
				System.out.println("Invalid choice. Please enter a valid option.");
				break;
			}

			System.out.print("Do you want to make more changes? (Enter 'yes' to continue, 'no' to exit): ");
			String response = scanner.nextLine().toLowerCase();
			if (!response.equals("yes") || response.equals("y")) {
				running = true;
				System.out.println();
			}
			if (response.equals("no") || response.equals("n")) {
				running = false;
				System.out.println("OK, GOODBYE!!");
				System.exit(0);
			}

		}
	}
}
