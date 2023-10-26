import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class SantaClaus implements NiceList {
	private SortedAList<Name> niceList; // Sorted data structure
	private AList<Name> naughtyList; // Unsorted data structure
	private SortedAList<Name> allNames; // Sorted data structure

	public SantaClaus() {
		niceList = new SortedAList<>();
		naughtyList = new AList<>();
		allNames = new SortedAList<>();
		loadNamesFromFile("people.txt");
	}

	private void loadNamesFromFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("\\s+");
				String firstName = parts[0];
				String lastName = parts[1];

				if (parts.length > 2) {
					Name name = new Name(firstName, lastName);
					niceList.add(name);
					allNames.add(name);
					String[] gifts = Arrays.copyOfRange(parts, 2, parts.length);
					for (String gift : gifts) {
						name.addGift(gift);
					}
				} else {
					addNaughtyPerson(firstName, lastName);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addNicePerson(String firstName, String lastName, String[] gifts) {
		Name name = new Name(firstName, lastName);
		niceList.add(name);
		allNames.add(name);
		for (String gift : gifts) {
			name.addGift(gift);
		}
	}

	public void addNaughtyPerson(String firstName, String lastName) {
		Name name = new Name(firstName, lastName);
		naughtyList.add(name);
		allNames.add(name);
	}

	@Override
	public void addGift(String firstName, String lastName, String gift) {
		Name name = new Name(firstName, lastName);
		int index = indexOfName(name, allNames);
		if (index >= 0) {
			Name existingName = allNames.get(index);
			existingName.addGift(gift);
		}
	}

	@Override
	public void makeNiceToNaughty(String firstName, String lastName) {
		Name name = new Name(firstName, lastName);
		int niceIndex = indexOfName(name, niceList);
		if (niceIndex >= 0) {
			Name removedName = niceList.get(niceIndex);
			niceList.remove(niceIndex);
			naughtyList.add(removedName);
		}
	}

	// Custom method to find the index of a Name in a SortedAList
	private int indexOfName(Name name, SortedAList<Name> list) {
		for (int i = 0; i < list.size(); i++) {
			int comparison = list.get(i).compareTo(name);
			if (comparison == 0) {
				return i;
			} else if (comparison > 0) {
				// The name is not in the list
				break;
			}
		}
		return -1;
	}

	@Override
	public void makeNaughtyToNice(String firstName, String lastName) {
		Name name = new Name(firstName, lastName);
		int index = naughtyList.indexOf(name);
		if (index >= 0) {
			naughtyList.remove(index);
			niceList.add(name);
		}
	}

	@Override
	public void printNiceList() {
		System.out.println("Nice List:");
		for (int i = 0; i < niceList.size(); i++) {
			Name name = niceList.get(i);
			System.out.println(name);
			System.out.println("Gifts: " + Arrays.toString(name.getGifts()));

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	@Override
	public void printNaughtyList() {
		System.out.println("Naughty List:");
		for (int i = 0; i < naughtyList.size(); i++) {
			Name name = naughtyList.get(i);
			System.out.println(name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}