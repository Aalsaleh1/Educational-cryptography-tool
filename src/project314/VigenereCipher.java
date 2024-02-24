package project314;

import java.io.Serializable;
import java.util.Scanner;

public class VigenereCipher extends Encrypted implements Serializable{
	public String text;
	public String encryptedText;
	public String Tybe;
	public String key;
	public char TempText[];
	public char TempEncryptedText[];
	public char x[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
			't', 'u', 'v', 'w', 'x', 'y', 'z' };
	transient	Scanner s = new Scanner(System.in); // for text
	transient	Scanner b = new Scanner(System.in);// for Numbers

	public VigenereCipher(String text) {
		this.text = text.replace(" ", "").toLowerCase();
		this.Tybe = "VigenereCipher";

		TempText = new char[this.text.length()];
		TempEncryptedText = new char[this.text.length()];

	}

	public void SetArrayOfText() {
		for (int i = 0; i < this.text.length(); i++)
			TempText[i] = this.text.charAt(i);
	}

	public void SetListOfKey() {
		LinkedList.SetFirst();
		for (int i = 0; i < key.length(); i++)
			LinkedList.InsertAtEnd(key.charAt(i));
	}

	public void SetArrayOfEncryptedText() {
		for (int i = 0; i < this.encryptedText.length(); i++)
			TempEncryptedText[i] = this.encryptedText.charAt(i);
	}

	public int GetKeyDiget() {
		int KeyDiget = 0;
		for (int l = 0; l < 26; l++) {
			if (LinkedList.IsNull())
				LinkedList.SetFirst();
			if (LinkedList.retrieve() == x[l])
				KeyDiget = l;
		}
		return KeyDiget;
	}

	@Override
	public String Encryption() {
		System.out.print("Enter the key :");
		key = s.next().replace(" ", "").toLowerCase();

		SetArrayOfText();
		SetListOfKey();
		LinkedList.SetFirst();

		int TextDiget = 0, KeyDiget = 0, CyferDegit;
		String CyferText = "";
		for (int i = 0; i < text.length(); i++) {

			for (int j = 0; j < 26; j++)
				if (TempText[i] == x[j])
					TextDiget = j;

			KeyDiget = GetKeyDiget();

			LinkedList.MoveCurrent();
			int sum = TextDiget + KeyDiget;
			if (sum >= 26)
				CyferDegit = sum - 26;
			else
				CyferDegit = sum;
			CyferText = CyferText + x[CyferDegit];

		}
		this.encryptedText = CyferText;
	//	System.out.print("-------------------------------------------------------------\n\n");
		System.out.print("\n");
		System.out.println("The Original  text is : " + this.text);
		System.out.println("The Encrypted text is : " + encryptedText + "\n");
		System.out.print("Do you want to see how it was Encrypted?\n Enter 1 for detils or 2 to Exit: ");

	

		if (b.nextInt() == 1) {
			
		//	System.out.print("\n\n");
			DetailsOfEncryption();
			super.encryptedText=	encryptedText.toUpperCase();
			return encryptedText;
		} else {

			System.out.println(" Done ! ");
			System.out.print("\n-------------------------------------------------------------");
			super.encryptedText=	encryptedText.toUpperCase();
			return encryptedText;
		}

		// return encryptedText;
	}

	@Override
	public String Decryption() {

		SetArrayOfEncryptedText();
		SetListOfKey();
		LinkedList.SetFirst();

		int EncryptedTextDiget = 0, KeyDiget = 0, PlaneDegit;
		String text = "";
		for (int i = 0; i < this.encryptedText.length(); i++) { // i=9
			for (int j = 0; j < 26; j++) {
				if (TempEncryptedText[i] == x[j])
					EncryptedTextDiget = j; // j = 6
			}
			KeyDiget = GetKeyDiget();
			LinkedList.MoveCurrent();
			if (EncryptedTextDiget >= KeyDiget)
				PlaneDegit = EncryptedTextDiget - KeyDiget;
			else
				PlaneDegit = (EncryptedTextDiget + 26) - KeyDiget;
			text = text + x[PlaneDegit];
		}

		System.out.print("-------------------------------------------------------------\n\n");
		System.out.println("The Encrypted text is : " + encryptedText);
		System.out.println("The Original  text is : " + text + "\n");
		System.out.print("Do you want to see how it was Decrypted?\n Enter 1 for detils or 2 to Exit: ");
		Scanner bb = new Scanner(System.in);
		if (bb.nextInt() == 1) {
			System.out.print("\n\n");
			DetailsOfDecryption();
		}
		else {

			System.out.println(" Done ! ");
			System.out.print("\n-------------------------------------------------------------");

		}

		return text;

	}

	public void PrintPlaneText() {

		System.out.print("Plane text:");
		System.out.print("|");
		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			System.out.print(" |");
		}
		System.out.println();
	}

	public void PrintTextDiget() {
		int TextDiget = 0;
		System.out.print("P's values:");
		System.out.print("|");
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < 26; j++)
				if (TempText[i] == x[j])
					TextDiget = j;
			if (TextDiget / 10 > 0) {
				System.out.print(TextDiget);
				System.out.print("|");
			} else {
				System.out.print(TextDiget);
				System.out.print(" |");
			}
		}
		System.out.println();
	}

	public void PrintKeyText() {
		LinkedList.SetFirst();
		System.out.print("|");
		for (int i = 0; i < text.length(); i++) {
			for (int l = 0; l < 26; l++) {
				if (LinkedList.IsNull())
					LinkedList.SetFirst();
			}
			System.out.print(LinkedList.retrieve());
			System.out.print(" |");
			LinkedList.MoveCurrent();
		}
		System.out.println();
	}

	public void PrintKeyDiget() {
		LinkedList.SetFirst();
		int KeyDiget = 0;

		System.out.print("Key stream:");
		System.out.print("|");
		for (int i = 0; i < text.length(); i++) {
			KeyDiget = GetKeyDiget();
			LinkedList.MoveCurrent();
			if (KeyDiget / 10 > 0) {
				System.out.print(KeyDiget);
				System.out.print("|");
			} else {
				System.out.print(KeyDiget);
				System.out.print(" |");
			}
		}
		System.out.println();
	}

	public void PrintCyferDegit() {
		int TextDiget = 0, KeyDiget = 0, CyferDegit;
		LinkedList.SetFirst();

		System.out.print("C's values:");
		System.out.print("|");
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < 26; j++)
				if (TempText[i] == x[j])
					TextDiget = j;
			KeyDiget = GetKeyDiget();
			LinkedList.MoveCurrent();
			int sum = TextDiget + KeyDiget;
			if (sum >= 26)
				CyferDegit = sum - 26;
			else
				CyferDegit = sum;

			if (CyferDegit / 10 > 0) {
				System.out.print(CyferDegit);
				System.out.print("|");
			} else {
				System.out.print(CyferDegit);
				System.out.print(" |");
			}
		}
		System.out.println();
	}

	public void PrintCyferText() {
		System.out.print("Cyfer Text:");
		System.out.print("|");
		for (int i = 0; i < text.length(); i++) {
			System.out.print(encryptedText.charAt(i));
			System.out.print(" |");
		}
		System.out.println();
	}

	@Override
	public void DetailsOfEncryption() {
		System.out.print("\n\n");
		SetArrayOfText();
		SetListOfKey();
		PrintPlaneText();
		PrintTextDiget();
		PrintKeyDiget();
		PrintCyferDegit();
		PrintCyferText();
		System.out.println();
		System.out.println(
				"As we can see if we want to get the cyfer values we are going to add the P's values with the Key stream");
		System.out.println("if the the addtion result is more than 26 We will subtract 26 from the total result\n");
	}

	@Override
	public void DetailsOfDecryption() {
		SetArrayOfText();
		SetListOfKey();
		PrintCyferText();
		PrintCyferDegit();
		PrintKeyDiget();
		PrintTextDiget();
		PrintPlaneText();
		System.out.println();
		System.out.println(
				"As we can see if we want to get the P's values we are going to subtract the C's values from the Key stream");
		System.out.println("if the Key stream is greater than the C's values we are going to add 26 to the C's values"
				+ " then  We will subtract C's values from the Key stream  \n");

	}
}
