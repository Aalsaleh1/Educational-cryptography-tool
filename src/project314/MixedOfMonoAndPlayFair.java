package project314;

import java.io.Serializable;
import java.util.Scanner;

public class MixedOfMonoAndPlayFair extends Encrypted {
	public String text;
	public String text2;
	public String encryptedText;
	public String Tybe;
	private Monoalphabetic FirstEncreypted;
	private playfair ScunedEncreypted;

	public MixedOfMonoAndPlayFair(String text) {
		FirstEncreypted = new Monoalphabetic(text);
		this.text = text;
		this.Tybe = "MixedOfMonoAndPlayFair";
	}

	@Override
	public String Encryption() {
		System.out.println("firstly, we will Encrypt by Using Monoalphabetic \n ");
		text2 = FirstEncreypted.Encryption();
		System.out.println("\nSecondly, we will Encrypt by Using Plafyer \n ");
		ScunedEncreypted = new playfair(text2);
		encryptedText = ScunedEncreypted.Encryption();
		System.out.println(encryptedText);
		return encryptedText;
	}

	@Override
	public void DetailsOfEncryption() {
		// TODO Auto-generated method stub
		

	}

	@Override
	public String Decryption() {
		System.out.print("\n-------------------------------------------------------------\n\n");
		System.out.println("firstly, we will Decrypt by Using playfair \n ");
		ScunedEncreypted.Decryption();
		System.out.println(
				"\nSecondly, we will Decrypt by Using Monoalphabetic and the key we used to encrypt was " + FirstEncreypted.key + " \n ");
		String x = FirstEncreypted.Decryption();
		
System.out.println(x);		return x;
	}

	@Override
	public void DetailsOfDecryption() {
		// TODO Auto-generated method stub

	}
}







