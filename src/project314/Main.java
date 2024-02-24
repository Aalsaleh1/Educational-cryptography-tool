package project314;
import java.io.*;
import java.security.spec.ECFieldF2m;
import java.util.Scanner;
public class Main implements Serializable{
private	transient static  Scanner  s = new  Scanner(System.in);
private	transient	static ObjectOutputStream o;
private	transient	static ObjectOutputStream o2;
private static int sizeF ;
	public static void main(String[] args) throws Exception{
	int sizeOfFile=0 ; 
		
		File f = new File("ciphera");
		File f2 = new File("cipherb");
		
o = new ObjectOutputStream(new FileOutputStream(f,true));
o2 = new ObjectOutputStream(new FileOutputStream(f2,true));
int x = 9 ; 
		while(x!=0) {
			try{
			s = new  Scanner(System.in);
			System.out.println("Wellcome to our Eductional Cipher tool :)");
			System.out.println("Please choose the number of function that you want: ");
			System.out.println("1-Encrypt text");
			System.out.println("2-Decrypt text/Decrypy text by analysis");
			System.out.println("0-Exit");
			x = s.nextInt();

switch(x) {
case 1:
	System.out.println("Choose the algorithm: \n 1-Keyed Transposition \n 2-Play Fair \n 3-Mono Alphabetic \n 4-Vigenere \n 5- Mono and playfair \n 6-DES");
	x = s.nextInt();
switch(x) {
case 1:System.out.println("*********Please enter the text:");	
	s.nextLine();	
String text = s.nextLine();
	KeyedTransposition k = new KeyedTransposition(text);
	k.Encryption();
	o.writeObject(k);
	o2.writeObject(k);
	s.nextLine();
	break ; 
case 2:System.out.println("*********Please enter the text:");	
	s.nextLine();String text1 = s.nextLine();
playfair p = new playfair(text1);
p.Encryption();
o.writeObject(p);
o2.writeObject(p);
break ; 
case 3:System.out.println("*********Please enter the text:");
	s.nextLine();String text3 = s.nextLine();
Monoalphabetic m = new Monoalphabetic(text3);
m.Encryption();
o.writeObject(m);o2.writeObject(m);
break ; 
case 4:System.out.println("*********Please enter the text:");
	s.nextLine();String text4 = s.nextLine();
VigenereCipher v = new VigenereCipher(text4); 
v.Encryption();
o.writeObject(v);o2.writeObject(v);
break ; 
case 5: System.out.println("*********Please enter the text:");
	s.nextLine();String text5 = s.nextLine();
	MixedOfMonoAndPlayFair me = new MixedOfMonoAndPlayFair(text5);
	me.Encryption();
	o.writeObject(me);o2.writeObject(me);
	break ; 
case 6:
	DES d = new DES();
	d.runDES();
	break;
	default:	
	System.out.println("=====================================================================");
}
break ;
case 2:
	System.out.println("Choose 1 for old text or 2 for Decrypy text by analysis");
	x = s.nextInt();
	if(x==1) {
	ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
	ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(f2));
	System.out.println("Choose the number of text that you want to decrypt");	
	try {
		Encrypted e1 = null ; 
		int t = 0;
		while((e1=(Encrypted)in.readObject())!=null) {
			if(e1 instanceof playfair)
			System.out.println((t+1)+"-"+((playfair)e1).text);
			System.out.println((t+1)+"-"+e1.encryptedText);
			t++;
		}
	}catch(Exception e) {
		x = s.nextInt();
	}
	
	for(int i = 0; i<x ;i++) {
		if(i==(x-1)) {
			Encrypted  e = (Encrypted)in2.readObject();
			e.Decryption();
	break;}
		in2.readObject();
	}

	break;}
	else {
		System.out.println("Enter the encrypted text: ");
		s.nextLine();String str = s.nextLine();
		FreDec f1 = new FreDec();
		f1.freqAnalysis(str);
		break;
	}
case 0 :
System.exit(0);	
break;

default:
System.out.println("Wrong input");	
}
			}catch(Exception e){
				System.out.println("Wrong input!!!");
			}	
}	
		s.close();	

	}
}
