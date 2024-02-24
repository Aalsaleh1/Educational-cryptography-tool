package project314;

import java.io.Serializable;
import java.util.Scanner;

public class playfair extends Encrypted implements Serializable{
	String text;
	String Tybe;
	String key;
	private String litterX;

	private String[] encryptionarray;
	private String[] decryptionarray;
	private int[] positions;

	private String encryptedText;
	private String decryptedText;
	private char[][] chars = new char[5][5];// table of encryotion and decryption
	transient	Scanner s = new Scanner(System.in);
	transient Scanner b = new Scanner(System.in);

	public playfair() {
	}

	public playfair(String text) {
		this.Tybe = "playfair";
		this.text = text.toLowerCase();// plaintext

	}

	public playfair(String text, String key) {
		this.Tybe = "playfair";
		this.text = text;

		this.key = spaceRemover(key.toLowerCase());
		chars = tableGenerator(chars, key);
	}

	@Override
	public String Encryption() {

		if (key == null) {
			System.out.print("Enter the key :");
			key = b.next().toLowerCase().replaceAll(" ", "");
		}
		chars = tableGenerator(chars, key);
		encryptionarray = splitter(spaceRemover(text));
		for (int i = 0; i < encryptionarray.length; i++) {
			positions = positionfinder(encryptionarray[i]);
			// j ==j
			if (positions[1] == positions[3]) {
				if (positions[0] == 4) {
					positions[0] = -1;
				} else if (positions[2] == 4) {
					positions[2] = -1;
				}
				int temp1 = positions[0], temp2 = positions[2];
				++temp1;
				++temp2;

				encryptionarray[i] = "";
				encryptionarray[i] += chars[temp1][positions[1]];
				encryptionarray[i] += chars[temp2][positions[3]];
			}
			// i ==i
			else if (positions[0] == positions[2]) {
				if (positions[1] == 4) {
					positions[1] = -1;
				} else if (positions[3] == 4) {
					positions[3] = -1;
				}

				int temp1 = positions[1], temp2 = positions[3];
				++temp1;
				++temp2;

				encryptionarray[i] = "";
				encryptionarray[i] += chars[positions[0]][temp1];
				encryptionarray[i] += chars[positions[2]][temp2];
			} else {

				encryptionarray[i] = "";
				encryptionarray[i] += chars[positions[0]][positions[3]];
				encryptionarray[i] += chars[positions[2]][positions[1]];
			}
		}

		this.encryptedText = "";
		for (int i = 0; i < encryptionarray.length; i++) {
			this.encryptedText += encryptionarray[i];
		}
		System.out.print("\n");

		// System.out.print("-------------------------------------------------------------\n\n");
		System.out.println(" The Original  text is : " + this.text);
		System.out.println(" The Encrypted text is : " + encryptedText + "\n");
		System.out.print(" Do you want to see how it was encrepted?\n Enter 1 for detils or 2 to Exit: ");

		if (s.nextInt() == 1)
			DetailsOfEncryption();
		else {

			System.out.println(" Done ! ");
			System.out.print("\n-------------------------------------------------------------");
		}super.encryptedText=	encryptedText.toUpperCase();
		return encryptedText.toUpperCase();
	}

	@Override
	public void DetailsOfEncryption() {

		String[] plaintext = splitter(text);
		System.out.println(
				"\nfirstly, \nyou must split up the plain text \ninto many parts each part has two characters \nthen generate a table for encryption");

		if (key == null) {
			System.out.println();
			System.out.println("because there is no key for encryption \nthe table based on alphabitic order");
		} else {
			System.out.println();
			System.out.println("the order based on the key \"" + this.key + "\"");
		}

		for (int i = 0; i < 5.; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(chars[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\nthirdly,\nthere are 3 cases of arrangement");
		System.out.println("1-if the two litters on the same row litters must be shifted to the right by 1");
		System.out.println("2-if the two litters on the same column litters must be shifted down to the by 1");
		System.out.println("3-if the two litters on the reactangle swiched up");
		System.out.println();
		for (int i = 0; i < plaintext.length; i++) {
			positions = positionfinder(encryptionarray[i]);
			if (positions[0] == positions[2]) {// x axis
				System.out.println(plaintext[i] + "-->" + encryptionarray[i] + " by case 1");
			} else if (positions[1] == positions[3]) {// y axis
				System.out.println(plaintext[i] + "-->" + encryptionarray[i] + " by case 2");

			} else {
				System.out.println(plaintext[i] + "-->" + encryptionarray[i] + " by case 3");
			}

		}
		System.out.println(litterX);

	}

	public String Decryption(String encryptedText1, String key1) {

		this.encryptedText = encryptedText1.toLowerCase();
		chars = tableGenerator(chars, key1);
		decryptionarray = splitter(encryptedText);
		for (int i = 0; i < decryptionarray.length; i++) {
			positions = positionfinder(decryptionarray[i]);

			// j ==j
			if (positions[1] == positions[3]) {

				if (positions[0] == 0) {
					positions[0] = 5;
				}
				if (positions[2] == 0) {
					positions[2] = 5;
				}
				int temp1 = positions[0], temp2 = positions[2];
				--temp1;
				--temp2;

				decryptionarray[i] = "";
				decryptionarray[i] += chars[temp1][positions[1]];
				decryptionarray[i] += chars[temp2][positions[3]];

			}
			// j ==j
			else if (positions[0] == positions[2]) {
				if (positions[1] == 0) {
					positions[1] = 5;
				} else if (positions[3] == 0) {
					positions[3] = 5;
				}

				int temp1 = positions[1], temp2 = positions[3];
				--temp1;
				--temp2;

				decryptionarray[i] = "";
				decryptionarray[i] += chars[positions[0]][temp1];
				decryptionarray[i] += chars[positions[2]][temp2];

			} else {
				decryptionarray[i] = "";
				decryptionarray[i] += chars[positions[0]][positions[3]];
				decryptionarray[i] += chars[positions[2]][positions[1]];

			}

		}
		decryptedText = "";
		for (int i = 0; i < decryptionarray.length; i++) {
			this.decryptedText += decryptionarray[i];
		}

		System.out.print("-------------------------------------------------------------\n\n");
		System.out.println(" The Encrypted text is : " + encryptedText);
		System.out.println(" The Original  text is : " + text + "\n");
		System.out.print(" Do you want to see how it was Decrypted?\n Enter 1 for detils or 2 to Exit: ");
		if (s.nextInt() == 1)
			DetailsOfDecryption();
		else {

			System.out.println(" Done ! ");
			System.out.print("\n-------------------------------------------------------------");

		}

		return decryptedText.toUpperCase();
	}

	@Override
	public void DetailsOfDecryption() {

		String[] plaintext = splitter(encryptedText);

		System.out.println(
				"\nfirstly, \nyou must split up the decrypted text \ninto many parts each part has two characters \nthen generate a table for decryption");

		if (key == null) {
			System.out.println();
			System.out.println("because there is no key for decryption /nthe table based on alphabitic order");
		} else {
			System.out.println();
			System.out.println("the order based on the key \"" + key + "\"");
		}

		for (int i = 0; i < 5.; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(chars[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\nthirdly,\nthere are 3 cases of arrangement:");
		System.out.println("1-if the two litters on the same row litters must be shifted to the right by 1");
		System.out.println("2-if the two litters on the same column litters must be shifted down to the by 1");
		System.out.println("3-if the two litters on the reactangle swiched up");
		System.out.println();
		for (int i = 0; i < decryptionarray.length; i++) {
			positions = positionfinder(encryptionarray[i]);
			if (positions[0] == positions[2]) {// x axis
				System.out.println(plaintext[i] + "-->" + decryptionarray[i] + " by case 1");
			} else if (positions[1] == positions[3]) {// y axis
				System.out.println(plaintext[i] + "-->" + decryptionarray[i] + " by case 2");
			} else {
				System.out.println(plaintext[i] + "-->" + decryptionarray[i] + " by case 3");
			}

		}
		System.out.println(decryptedText);

	}

	private char[][] tableGenerator(char[][] keyAlphabit, String key) {

		if (key == null) {
			keyAlphabit = arrayfiller(keyAlphabit, key);
		} else {
			String newKey = keyWithAlphabits(key);
			keyAlphabit = arrayfiller(keyAlphabit, newKey);
		}
		return keyAlphabit;
	}

	private String keyWithAlphabits(String key) {

		int counter = 0;
		String litters = "abcdefghijklmnopqrstuvwxyz";
		char[] unique = key.toCharArray();
		for (int i = 0; i < unique.length - 1; i++) {
			for (int j = i + 1; j < unique.length; j++) {
				if (unique[i] == unique[j]) {
					unique[j] = ' ';
				}
			}
		}
		key = "";
		for (int i = 0; i < unique.length; i++) {
			if (unique[i] == ' ') {
				continue;
			}
			key += unique[i];
		}
		boolean istheirJ = false;
		if (key.contains("j")) {
			istheirJ = true;
		}
		for (int i = 0; i < litters.length(); i++) {

			if (istheirJ && litters.charAt(counter) == 'i') {
				counter++;
				continue;
			} else if (litters.charAt(counter) == 'j') {
				counter++;
				continue;
			}
			if (key.contains(Character.toString(litters.charAt(counter)))) {
				counter++;
				continue;
			}
			key += litters.charAt(counter);
			counter++;
		}
		return key;
	}

	private char[][] arrayfiller(char[][] chars, String key) {
		int counter = 0;
		String litters = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (key != null) {
					chars[i][j] = key.charAt(counter);
					counter++;
				} else {
					if (litters.charAt(counter) == 'j') {
						counter++;
					}
					chars[i][j] = litters.charAt(counter);
					counter++;
				}
			}
		}
		return chars;
	}

	private String[] splitter(String plainText) {// this method split the word into many parts each part contains two
		int counter = 0;
		int size = 0;
		String newPlainText = "";
		litterX = "";

		for (int i = 0; i < plainText.length(); i++) {
			if (i == plainText.length() - 1) {
				newPlainText += plainText.charAt(plainText.length() - 1);
				size++;
				newPlainText += "z";
				break;
			}
			if (plainText.charAt(i) != plainText.charAt(i + 1)) {
				newPlainText += plainText.charAt(i);
				newPlainText += plainText.charAt(i + 1);
				i++;
			} else {

				newPlainText += plainText.charAt(i);
				litterX += ("i used x to seperate " + plainText.subSequence(i, i + 1));
				newPlainText += "x";
				
			}
			size++;
		}

		String[] newarr = new String[size];
		for (int i = 0; i < newarr.length; i++) {
			newarr[i] = "";
		}

		for (int i = 0; i < newarr.length; i++) {

			newarr[i] += Character.toString(newPlainText.charAt(counter));
			counter++;
			newarr[i] += Character.toString(newPlainText.charAt(counter));
			counter++;

		}
		return newarr;
	}

	private int[] positionfinder(String x) {// this method returns a list contains position in xy of first and second
											// character
		int[] position = new int[4];
		int counter = 0;
		for (int f = 0; f < x.length(); f++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (x.charAt(f) == chars[i][j]) {
						position[counter] = i;
						counter++;
						position[counter] = j;
						counter++;
					}
				}
			}
		}
		return position;
	}

	private String spaceRemover(String sentence) {
		String combined = "";

		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == ' ') {
				continue;
			}
			combined += sentence.charAt(i);
		}
		return combined;
	}

	
	@Override
	public String Decryption() {
		String encryptedText1 = this.encryptedText;
		String key1 = this.key;
		this.encryptedText = encryptedText1.toLowerCase();
		chars = tableGenerator(chars, key1);
		decryptionarray = splitter(encryptedText);
		for (int i = 0; i < decryptionarray.length; i++) {
			positions = positionfinder(decryptionarray[i]);

			// j ==j
			if (positions[1] == positions[3]) {

				if (positions[0] == 0) {
					positions[0] = 5;
				}
				if (positions[2] == 0) {
					positions[2] = 5;
				}
				int temp1 = positions[0], temp2 = positions[2];
				--temp1;
				--temp2;

				decryptionarray[i] = "";
				decryptionarray[i] += chars[temp1][positions[1]];
				decryptionarray[i] += chars[temp2][positions[3]];

			}
			// j ==j
			else if (positions[0] == positions[2]) {
				if (positions[1] == 0) {
					positions[1] = 5;
				} else if (positions[3] == 0) {
					positions[3] = 5;
				}

				int temp1 = positions[1], temp2 = positions[3];
				--temp1;
				--temp2;

				decryptionarray[i] = "";
				decryptionarray[i] += chars[positions[0]][temp1];
				decryptionarray[i] += chars[positions[2]][temp2];

			} else {
				decryptionarray[i] = "";
				decryptionarray[i] += chars[positions[0]][positions[3]];
				decryptionarray[i] += chars[positions[2]][positions[1]];

			}

		}
		decryptedText = "";
		for (int i = 0; i < decryptionarray.length; i++) {
			this.decryptedText += decryptionarray[i];
		}
		System.out.print("-------------------------------------------------------------\n\n");
		System.out.println(" The Encrypted text is : " + encryptedText);
		System.out.println(" The Original  text is : " + text + "\n");
		System.out.print(" Do you want to see how it was Decrypted?\n Enter 1 for detils or 2 to Exit: ");
		Scanner bb = new Scanner(System.in);
		if (bb.nextInt() == 1)
			DetailsOfDecryption();
		else {

			System.out.println(" Done ! ");
			System.out.print("\n-------------------------------------------------------------");

		}

		return decryptedText;

	}
}
