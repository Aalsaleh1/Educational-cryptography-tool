package project314;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Scanner;

public class KeyedTransposition extends Encrypted implements Serializable{
	private int key1ReplaceWith;
	private int key2ReplaceWith;
	private int key3ReplaceWith;
	private int key4ReplaceWith;
	private String cipheredText;
	private int decK1, decK2, decK3, decK4;
	transient 	Scanner askForKey = new Scanner(System.in);
	public KeyedTransposition(String text) {
		this.text = text;
		this.Tybe = "Keyed Transposition";
	}

	public String Encryption() {

		if (text.length() % 4 == 1)
			text += "zzz";
		if (text.length() % 4 == 2)
			text += "zz";
		if (text.length() % 4 == 3)
			text += "z";
		int x = text.length() / 4;
		String[] str = new String[x];
		int s = 0;
		for (int i = 0; i < x; i++) {
			String str1 = "";
			for (int a = 0; a < 4; a++) {
				str1 += text.toCharArray()[s];
				s++;
			}
			str[i] = str1;
		}
		for(int j =0 ;j<x;j++) {
		for (int i = 0; i < 4; i++) {
			char ch1 = str[j].toCharArray()[0];
			char ch2 = str[j].toCharArray()[3];
			str[j].toCharArray()[0] = str[j].toCharArray()[2];
			str[j].toCharArray()[2] = ch1;
			str[j].toCharArray()[3] = str[j].toCharArray()[1];
			str[j].toCharArray()[1] = ch2;
		}}
		// System.out.println(str[1]);
		String EncT1 = "", EncT2 = "", EncT3 = "", EncT4 = "";

		for (int i = 0; i < x; i++) {
			EncT1 += str[i].toCharArray()[0];
			EncT2 += str[i].toCharArray()[1];
			EncT3 += str[i].toCharArray()[2];
			EncT4 += str[i].toCharArray()[3];
		}
		
		System.out.println("please choose you want to replace column 1 with what? :");
		key1ReplaceWith = askForKey.nextInt();

		System.out.println("please choose you want to replace column 2 with what? :");
		key2ReplaceWith = askForKey.nextInt();
		System.out.println("please choose you want to replace column 3 with what? :");
		key3ReplaceWith = askForKey.nextInt();
		System.out.println("please choose you want to replace column 4 with what? :");
		key4ReplaceWith = askForKey.nextInt();
		//askForKey.close();
		String[] orderT = new String[4];
		orderT[key1ReplaceWith - 1] = EncT1;
		orderT[key2ReplaceWith - 1] = EncT2;
		orderT[key3ReplaceWith - 1] = EncT3;
		orderT[key4ReplaceWith - 1] = EncT4;

		encryptedText = orderT[0].toUpperCase() + orderT[1].toUpperCase() + orderT[2].toUpperCase()
				+ orderT[3].toUpperCase();
		cipheredText = encryptedText;

		System.out.print("-------------------------------------------------------------\n\n");
		System.out.println(" The Original  text is : " + this.text);
		System.out.println(" The Encrypted text is : " + encryptedText + "\n");
		System.out.print(" Do you want to see how it was Encrypted?\n Enter 1 for detils or 2 to Exit: ");
		
		


		if (askForKey.nextInt() == 1) {
			DetailsOfEncryption();
		//askForKey.close();
		}
		else {
		//	askForKey.close();

			System.out.println(" Done ! ");
			System.out.print("\n------------------------------------------------------------- press any key");
		
		}
this.encryptedText = encryptedText;
		return encryptedText;
	}

	public void DetailsOfEncryption() {
		System.out.println(
				"\n\nFirstly  we splite the whole text into groups depend on our key, here we take each 4 chars as a group");
		System.out.println("Then, we represnt the groups in a matrix ");
		System.out.println("|x y z d|");
		System.out.println(
				"|x y z d| then depend on our key we replace the culomns here we replace culomn 1 with 3 and 2 with 4");
		System.out.println("|x y z d|");
		System.out.println("=======================================================");
		System.out.println("|z d x y|");
		System.out.println("|z d x y| , and finaly we take the whole string by make each word from each culomn");
		System.out.println("|z d x y|");

	}

	public String Decryption() {
		int nmG = cipheredText.length() / 4;
		

		String[] str = new String[4];
		int s = 0;
		for (int i = 0; i < 4; i++) {
			str[i] = "";
			for (int j = 0; j < nmG; j++) {
				str[i] += cipheredText.toCharArray()[s];
				s++;
			}
		}
		String t = "";
		String text[] = new String[4];
		text[0] = str[key1ReplaceWith - 1];
		text[1] = str[key2ReplaceWith - 1];
		text[2] = str[key3ReplaceWith - 1];
		text[3] = str[key4ReplaceWith - 1];
		for (int i = 0; i < nmG; i++)
			for (int j = 0; j < 4; j++)
				t += text[j].toCharArray()[i];
		System.out.print("-------------------------------------------------------------\n\n");
		System.out.println(" The Encrypted text is : " + this.encryptedText);
		System.out.println(" The Decrypted text is : " + this.text + "\n");
		System.out.print(" Do you want to see how it was Decrypted?\n Enter 1 for detils or 2 to Exit: ");
	Scanner bb = new Scanner(System.in);
		if (bb.nextInt() == 1) {
			
			DetailsOfDecryption();		}
		else {

			System.out.println(" Done ! ");
			System.out.print("\n-------------------------------------------------------------");

		}
		//bb.close();

		return t.toLowerCase();
	}

	public void DetailsOfDecryption() {
		System.out.println(
				"\n\nFirstly  we splite the whole text into groups depend on our key, here we take each 4 chars as a group but here the text is ciphered");
		System.out.println("Then, we represnt the groups in a matrix ");
		System.out.println("|d x y z|");
		System.out.println("|d x y z| then depend on our key we replace the culomns to return to our old matrix");
		System.out.println("|d x y z|");
		System.out.println("=======================================================");

		System.out.println("|x y z d|");
		System.out.println("|x y z d| finnaly, we got our original text");
		System.out.println("|x y z d|");
	}
}
