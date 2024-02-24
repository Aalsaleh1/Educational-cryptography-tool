package project314;

import java.io.Serializable;
import java.util.Scanner;

public class Monoalphabetic extends Encrypted implements Serializable{
	public String text;
	public int key;
	public String encryptedText;
	public String Tybe;

	private char[] lettersList = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	private char[] Arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	transient	Scanner s = new Scanner(System.in);

	// private String pathFile;

	public Monoalphabetic(String text) {
		this.text = text;
		this.Tybe = "Monoalphabetic";
	}

	@Override
	public String Encryption() {
		System.out.print("Enter the key :");

		key = s.nextInt();
		int keyforUse = key;

		while (keyforUse > 26) {
			keyforUse = keyforUse - 26;
		}

		System.out.print("\n");

		String curent = text.replaceAll(" ", "");
		String firstpart;
		String sucendpart;
		char rblesmentChar = 'z';

		for (int i = 0; i < curent.length(); i++) {
			char findCharOfText = text.replaceAll(" ", "").charAt(i);
			for (int j = 0; j < lettersList.length; j++) {
				
				if (findCharOfText == lettersList[j]) {
					int b = j + keyforUse;
					while (b > 25)
						b = b - 26;
					rblesmentChar = lettersList[b];
				}

			}

			firstpart = curent.substring(0, i);
			sucendpart = curent.substring(i + 1);
			curent = firstpart + rblesmentChar + sucendpart;
		}
		encryptedText = curent;

		System.out.print("-------------------------------------------------------------\n\n");
		System.out.println(" The Original  text is : " + this.text);
		System.out.println(" The Encrypted text is : " + encryptedText + "\n");
		System.out.print(" Do you want to see how it was Encrypted?\n Enter 1 for detils or 2 to Exit: ");

		if (s.nextInt() == 1)
			DetailsOfEncryption();
		else {

			System.out.println(" Done ! ");
			System.out.print("\n-------------------------------------------------------------");
			super.encryptedText=	encryptedText.toUpperCase();
			return encryptedText;
		}
		super.encryptedText=	encryptedText.toUpperCase();
		return encryptedText;
		
	}

	public void ATableForExplain() {

		System.out.print(" \n");
		System.out.print("    ");
		for (int i = 1; i <= 26; i++) {
			if (i < 10) {
				System.out.print(" | " + i);
			} else
				System.out.print(" |" + i);
		}
		System.out.println("");
		System.out.print("  | ");
		for (int i = 0; i < 26; i++) {
			System.out.print(" | " + Arr[i]);
		}

		System.out.println("");
		System.out.print("  V ");
		for (int i = 0; i < 26; i++) {
			System.out.print(" | " + lettersList[i]);
		}

		System.out.println("");
		System.out.print("\n\n");

	}

	@Override
	public void DetailsOfEncryption() {

		int keyforUse = key;

		while (keyforUse > 26) {
			keyforUse = keyforUse - 26;
		}

		for (int k = 0; k < keyforUse; k++) {

			char temp = Arr[25];

			for (int i = 25; i > 0; i--) {
				Arr[i] = Arr[i - 1];

			}
			Arr[0] = temp;

		}

		ATableForExplain();
		String curent = text.replaceAll(" ", "");
		String firstpart;
		String sucendpart;
		char rblesmentChar = 'a';

		for (int i = 0; i < curent.length(); i++) {
			char findCharOfText = text.replaceAll(" ", "").charAt(i);
			for (int j = 0; j < 26; j++) {
				
				if (findCharOfText == lettersList[j]) {
					int b = j + keyforUse;
					while (b > 25)
						b = b - 26;
					rblesmentChar = lettersList[b];
					break;
				}

			}

			firstpart = curent.substring(0, i);
			sucendpart = curent.substring(i + 1);
			curent = firstpart + rblesmentChar + sucendpart;
			System.out.println("-------------------------------------------------------------");
			System.out.println(" " + (i + 1) + ") Replace the character at position " + (i + 1) + " of the text\n");
			System.out.println("  " + text.replaceAll(" ", "").charAt(i) + " well be " + rblesmentChar + " by moving +"
					+ key + "\n");
			System.out.println("  " + text.replaceAll(" ", ""));
			System.out.println("  " + curent + "\n");

		}

		System.out.println("\n  Congratulation! You'ev complted it successfully.");
		System.out.println("-------------------------------------------------------------");

	}

	@Override
	public String Decryption() {

		String curent = encryptedText;
		String firstpart;
		String sucendpart;
		char rblesmentChar = 'a';
		int dKey = key;

		while (dKey > 26) {
			dKey = dKey - 26;
		}

		for (int i = 0; i < curent.length(); i++) {
			char findCharOfText = encryptedText.charAt(i);
			for (int j = 0; j < lettersList.length; j++) {
				
				if (findCharOfText == lettersList[j]) {
					int b = j - dKey;
					while (b < 0)
						b = b + 26;
					rblesmentChar = lettersList[b];
					break;
				}
			}

			firstpart = curent.substring(0, i);
			sucendpart = curent.substring(i + 1);
			curent = firstpart + rblesmentChar + sucendpart;
		}

		System.out.print("-------------------------------------------------------------\n\n");
		System.out.println(" The Encrypted text is : " + encryptedText);
		System.out.println(" The Original  text is : " + text + "\n");
		System.out.print(" Do you want to see how it was Decrypted?\n Enter 1 for detils or 2 to Exit: ");
		Scanner b = new Scanner(System.in);
		if (b.nextInt() == 1)
			DetailsOfDecryption();
		else {

			System.out.println(" Done ! ");
			System.out.print("\n-------------------------------------------------------------");

		}

		return curent;
	}

	public void DTableForExplain() {
		System.out.print(" \n");
		System.out.print("    ");
		for (int i = 1; i <= 26; i++) {
			if (i < 10) {
				System.out.print(" | " + i);
			} else
				System.out.print(" |" + i);
		}
		System.out.println("");

		System.out.print("  | ");
		for (int i = 0; i < 26; i++) {
			System.out.print(" | " + lettersList[i]);
		}
		System.out.println("");
		System.out.print("  V ");
		for (int i = 0; i < 26; i++) {
			System.out.print(" | " + Arr[i]);
		}

		System.out.println("");
		System.out.print("\n\n");

	}

	@Override
	public void DetailsOfDecryption() {

		String curent = encryptedText;
		String firstpart;
		String sucendpart;
		char rblesmentChar = 'a';
		int dKey = key;

		while (dKey > 26) {
			dKey = dKey - 26;
		}
		for (int k = 0; k < dKey; k++) {

			char temp = Arr[25];

			for (int i = 25; i > 0; i--) {
				Arr[i] = Arr[i - 1];

			}
			Arr[0] = temp;

		}
		for (int k = 0; k < dKey; k++) {

			char temp = lettersList[25];

			for (int i = 25; i > 0; i--) {
				lettersList[i] = lettersList[i - 1];

			}
			lettersList[0] = temp;

		}
		DTableForExplain();

		for (int i = 0; i < curent.length(); i++) {

			char findCharOfText = encryptedText.charAt(i);
			for (int j = 0; j < lettersList.length; j++) {
				
				if (findCharOfText == lettersList[j]) {
					int b = j - dKey;
					while (b < 0)
						b = b + 26;
					rblesmentChar = lettersList[b];
					break;
				}
			}

			firstpart = curent.substring(0, i);
			sucendpart = curent.substring(i + 1);
			curent = firstpart + rblesmentChar + sucendpart;
			System.out.println("-------------------------------------------------------------");
			System.out.println(" " + (i + 1) + ") Replace the character at position " + (i + 1) + " of the text\n");
			System.out.println(
					"  " + encryptedText.charAt(i) + " well be " + rblesmentChar + " by moving -" + key + "\n");
			System.out.println("  " + encryptedText);

			System.out.println("  " + curent + "\n");

		}

		System.out.println("\n  Congratulation! You'ev complted it successfully.");
		System.out.println("-------------------------------------------------------------");

	}


}
