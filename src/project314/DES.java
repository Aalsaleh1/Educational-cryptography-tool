package project314;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;

import java.util.Scanner;

public class DES

{
public void runDES( )
	
	{
	
	System.out.println("\nDES Encryption ****");

	Scanner input,input2;

	int digit;

	String key, plain_text, cipher_text;
	
	
	print();

	input = new Scanner(System.in);

	try{digit = input.nextInt();}

	catch(Exception ex)

	{ 

		digit = 0;

	}
	
	

	switch (digit) 

	{

	case 1: 

	{

		System.out.println("Enter plaint text & key in order");  

		System.out.println("Enter plain text:");      

		Scanner input1 = new Scanner(System.in);
		
		String plainText = input1.nextLine();
		
		System.out.println("Enter key:");      
		
		Scanner key1 = new Scanner(System.in);
		
		String keyTxt = key1.nextLine();
		
		
		
		if(input1==null || key1==null)
		
		{
			System.out.println("should insert input (plain test) & key in order..");
		}

		try {
		String x =   encrypt(plainText.trim(), keyTxt.trim());
		
		
		System.out.println("");
		
		System.out.println("The ciphertxt is:"+x);
		
		System.out.println("");
		
		System.out.println("would you like to know how DES works? \nif yes, please enter: y, if no, enter: n");
		
		input2 = new Scanner (System.in);
		
		String m = input2.nextLine();
		
		if (m.equalsIgnoreCase("y"))
			
			DESExplained();
		
		else if (m.equalsIgnoreCase("n"))
		{
			System.out.println("Goodbye");
			
			break;
			
		}
		
		else 
			
		{
			
			System.out.println("Invalid input!!");
			
			System.out.println("Goodbye!");
			
		}
		
		} catch (Exception e) 
		
		{
			System.out.println(e);
			
		}
		
		break;
		
	}
	
	
	case 2: 
	
	{
		
		System.out.println("Enter cipher text & key in order");  
		
		System.out.println("Enter cipher text :");      
		
		Scanner input1 = new Scanner(System.in);
		
		String cipher_text1 = input1.nextLine();
		
		System.out.println("Enter key:");      
		
		Scanner key1 = new Scanner(System.in);
		
		String key11 = key1.nextLine();
		
		
		
		if(input1==null || key1==null)
		
		{
			System.out.println("should insert input (cipher test) & key in order..");
		}
		

		try {
			
		
		String x = decrypt(cipher_text1.trim(), key11.trim());
		
		System.out.println("gen plain txt:"+x);
		
		} catch (Exception p)
		
		{
			System.out.println(p);
		}
		
		break;
		
		
	}

	
	default: 
	
	{
		
		if (digit == 3) 
		
		{
			break;
		}
		
		
		System.out.println("Please type correct digit...");
		
	}
	
	}
	

	if (digit == 3) 
	
	{
		System.out.println("Goodbye");
		
	}
	

	}
	
	
	public static void mainstatic(String[] args) throws Exception 
	
	{
		
		String plainText = "Hello, DES!";
		
		String keyString = "0123456789ABCDEF"; // 16-character key in hexadecimal format

		// Encrypt
		String encryptedText = encrypt(plainText, keyString);
		
		System.out.println("Encrypted text: " + encryptedText);

		// Decrypt
		String decryptedText = decrypt(encryptedText, keyString);
		
		System.out.println("Decrypted text: " + decryptedText);
		
	}
	
	
	
	public static String encrypt(String plainText, String keyString) throws Exception
	
	{
		
		byte[] keyBytes = hexStringToByteArray(keyString);
		
		DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		
		SecretKey key = keyFactory.generateSecret(desKeySpec);

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
		
		return byteArrayToHexString(encryptedBytes);
		
	}
	
	public static String decrypt(String encryptedText, String keyString) throws Exception 
	
	{
		
		
		byte[] keyBytes = hexStringToByteArray(keyString);
		
		DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		
		SecretKey key = keyFactory.generateSecret(desKeySpec);

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");//PKCS5Padding.
		
		cipher.init(Cipher.DECRYPT_MODE, key);

		byte[] encryptedBytes = hexStringToByteArray(encryptedText);
		
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		
		return new String(decryptedBytes, StandardCharsets.UTF_8);
		
	}
	
	
	public static byte[] hexStringToByteArray(String s) 
	
	{
		
		int len = s.length();
		
		byte[] data = new byte[len / 2];
		
		for (int i = 0; i < len; i += 2)
		
		{
			
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					
					+ Character.digit(s.charAt(i + 1), 16));

		}
		
		return data;
	}
	
	
	
	public static void print()
	
	{
		
		System.out.println("\nPlease ");
		
		System.out.print("Enter 1 for encrypting text: \n");
		
		System.out.print("Enter 2 for decrypting text: \n");
		
		System.out.print("Enter 3 for exit: \n");
		
	}
	
	
	public static String byteArrayToHexString(byte[] bytes) 
	
	{
		
		StringBuilder sb = new StringBuilder();
		
		for (byte b : bytes) 
		
		{
			
			sb.append(String.format("%02X", b));
			
			//System.out.println(sb);
			
		}
		
		return sb.toString();
		
	}
	
	
	public void DESExplained()
	
	{
		
		System.out.println("\r\n"
				+ "DES Algorithm Explained:-\r\n"
				+ "\r\n"
				+ "DES encrypt the plaintext by first converting it from text to bits. \r\n"
				+ "\r\n"
				+ "i.e. the plaintext: \"engineer!\" = 101 110 103 105 110 101 101 114 33 in (ASCII table). and in binary:\r\n"
				+ "\r\n"
				+ "plaintext: 11001011101110110011111010011101110110010111001011110010100001(00) \r\n"
				+ "(the last two bits are padding, since engineer! = 62 bits)\r\n"
				+ "\r\n"
				+ "The plaintext then is broken into a 64-bit block (64-bit block = 16 hexadecimal numbers)\r\n"
				+ "to be encrypt it. DES uses a key that's 16 numbers long of hexadecimal base,i.e.(2A1D54B8F201E73C) \r\n"
				+ "or 64 bit long number (0010101000011101010101001011100011110010000000011110011100111100). \r\n"
				+ "Every 8th bit in DES key is ignored, so that the key is 56 bit long instead of 64 bit:\r\n"
				+ "0010101(0)0001110(1)0101010(0)1011100(0)1111001(0)0000000(1)1110011(1)0011110(0).\r\n"
				+ "The result: 00101010001110010101010111001111001000000011100110011110 (56 bit key).\r\n"
				+ "When breaking the converted plaintext into 64 bit block, most of the time, the total number \r\n"
				+ "of bits is not a multiplicand of 64, so we are left with some blocks that are not a 64 bit block.\r\n"
				+ "The solution to this problem lies in what it's called padding. There are different Schemes of \r\n"
				+ "padding, one of which is where we add zeros at the end of the incomplete block to complete\r\n"
				+ "it. After the decryption, the extra bits (zero bits) are discarded. After resizing the key from 64 bit \r\n"
				+ "to a 56 bit, we make 16 subkeys that are 48 bit.\r\n"
				+ "\r\n"
				+ "The process in details:-\r\n"
				+ "\r\n"
				+ "first: we take the key's 64 bits, and make a permutation table with it. The table is 8 rows and 7 columns.\r\n"
				+ " Every intersection of the rows and columns has a number, it ranges from 1 - 64 (but it has only 56 numbers, not in order).\r\n"
				+ " Every number in the table represent the position of the binary digit in the original key (64 bit key). \r\n"
				+ "We build the 56 bit key by taking the first position number in top row (from left to right then from top to bottom)\r\n"
				+ "i.e.\r\n"
				+ "\r\n"
				+ "---->\r\n"
				+ "| 57 49 41 33 25 17 9\r\n"
				+ "| 1 58 50 42 34 26 18\r\n"
				+ "| 10 2 59 51 43 35 27\r\n"
				+ "V 19 11 3 60 52 44 36\r\n"
				+ "  63 55 47 39 31 23 15     ---> has only 56 numbers of positions.\r\n"
				+ "  7 62 54 46 38 30 22\r\n"
				+ "  14 6 61 53 45 37 29\r\n"
				+ "  21 13 5 28 20 12 4  \r\n"
				+ " \r\n"
				+ " Lets take the original key (64 bit key) example we saw earlier, to build the 56 bit key:\r\n"
				+ " \r\n"
				+ " The original key (64 bit key): 0010101000011101010101001011100011110010000000011110011100111100.\r\n"
				+ " \r\n"
				+ " 56 bit key starts with: the bit in the 57th position in the 64 bit key, then the bit in the 49th \r\n"
				+ " position in the 64 bit key, then 41th position,... 9th position, then 1st position, ...etc.\r\n"
				+ " \r\n"
				+ " 56 bit key:0101100001010100110110011001 0101000111000110100010111110.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ " Next, split this key into left and right halves, C0 and D0, where each half has 28 bits.\r\n"
				+ " \r\n"
				+ " C0: 0101100001010100110110011001.\r\n"
				+ " \r\n"
				+ " D0: 0101000111000110100010111110.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ " From C0 and D0, we make 16 blocks, The original block is C0 & D0, but it not counted as part of \r\n"
				+ " 16 blocks. Every block is made from the block that precedes it (C5,D5 block is made from block C4,D4).\r\n"
				+ " using the following schedule of \"left shifts\" of the previous block. To do a left \r\n"
				+ " shift, move each bit one place to the left, except for the first bit, \r\n"
				+ " which is cycled to the end of the block.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ " Iteration       Number of\r\n"
				+ "  Number        Left Shifts\r\n"
				+ "    1               1\r\n"
				+ "    2               1\r\n"
				+ "    3               2\r\n"
				+ "    4               2\r\n"
				+ "    5               2\r\n"
				+ "    6               2\r\n"
				+ "    7               2\r\n"
				+ "    8               2\r\n"
				+ "    9               1\r\n"
				+ "   10               2\r\n"
				+ "   11               2\r\n"
				+ "   12               2\r\n"
				+ "   13               2\r\n"
				+ "   14               2\r\n"
				+ "   15               2\r\n"
				+ "   16               1\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C0: 0101100001010100110110011001.\r\n"
				+ " \r\n"
				+ "D0: 0101000111000110100010111110.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C1: 1011000010101001101100110010.\r\n"
				+ " \r\n"
				+ "D1: 1010001110001101000101111100.\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "C2: 0110000101010011011001100101.\r\n"
				+ " \r\n"
				+ "D2: 0100011100011010001011111001.\r\n"
				+ "  \r\n"
				+ "  \r\n"
				+ "C3: 1000010101001101100110010101.\r\n"
				+ " \r\n"
				+ "D3: 0001110001101000101111100101.\r\n"
				+ "  \r\n"
				+ " \r\n"
				+ "C4: 0001010100110110011001010110.\r\n"
				+ " \r\n"
				+ "D4: 0111000110100010111110010100.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C5: 0101010011011001100101011000.\r\n"
				+ " \r\n"
				+ "D5: 1100011010001011111001010001.\r\n"
				+ "  \r\n"
				+ " \r\n"
				+ "C6: 0101001101100110010101100001.\r\n"
				+ " \r\n"
				+ "D6: 0001101000101111100101000111.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C7: 0100110110011001010110000101.\r\n"
				+ " \r\n"
				+ "D7: 0110100010111110010100011100.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C8: 0011011001100101011000010101.\r\n"
				+ " \r\n"
				+ "D8: 1010001011111001010001110001.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C9: 0110110011001010110000101010.\r\n"
				+ " \r\n"
				+ "D9: 0100010111110010100011100011.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C10: 1011001100101011000010101001.\r\n"
				+ " \r\n"
				+ "D10: 0001011111001010001110001101.\r\n"
				+ "\r\n"
				+ " \r\n"
				+ "C11: 1100110010101100001010100110.\r\n"
				+ " \r\n"
				+ "D11: 0101111100101000111000110100.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C12: 0011001010110000101010011011.\r\n"
				+ " \r\n"
				+ "D12: 0111110010100011100011010001.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C13: 1100101011000010101001101100.\r\n"
				+ " \r\n"
				+ "D13: 1111001010001110001101000101.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C14: 0010101100001010100110110011.\r\n"
				+ " \r\n"
				+ "D14: 1100101000111000110100010111.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C15: 1010110000101010011011001100.\r\n"
				+ " \r\n"
				+ "D15: 0010100011100011010001011111.\r\n"
				+ " \r\n"
				+ " \r\n"
				+ "C16: 0101100001010100110110011001.\r\n"
				+ " \r\n"
				+ "D16: 0101000111000110100010111110.\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "  \r\n"
				+ "Now we concatenate all the 16 keys and put them through a permutation table of size 48 (8 row by 6 columns).\r\n"
				+ "\r\n"
				+ "Now we have a 16 permuted key of size 48 bits.\r\n"
				+ "\r\n"
				+ "Now, we start working on the message itself. We put the message 64 bit block through a permutation table\r\n"
				+ "of size 64 (8 rows by 8 columns), then we divide the permuted message block into left (32 bit) and right\r\n"
				+ "(32 bit) and take it thought 16 iterations, using a function f which operates on two blocks, a data block\r\n"
				+ " of 32 bits and a key Kn of 48 bits to produce a block of 32 bits. In every iteration, in each iteration, we take the right 32 bits\r\n"
				+ " of the previous result and make them the left 32 bits of the current step. For the right 32 bits in the current step, \r\n"
				+ " we XOR the left 32 bits of the previous step with the calculation f. \r\n"
				+ " \r\n"
				+ " After we are done with 16 iterations, we have one more permutation table to put the results of the 16 iteration through.\r\n"
				+ " Finally, we end up witha 64 bit block that we convert to hexadecimal, which is our ciphertext.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
	
	
	
	

