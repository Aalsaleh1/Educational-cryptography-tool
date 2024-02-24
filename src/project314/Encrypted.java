package project314;

import java.io.Serializable;

public abstract class Encrypted implements Serializable {
 
	public String text;
    public String encryptedText;
    public String  Tybe;
    public static int size =0 ; 
    //private String pathFile;
    
   /*public Encrypted arr [];
     private int nb;
    
     line 10 and 11 I think we have to find another place to put it 
     in because this class is abstract class.
     */
    public abstract String Encryption();
    
    public abstract void DetailsOfEncryption();
    
    public abstract String Decryption();
    
    public abstract void DetailsOfDecryption();
    
    public void Display() {
    	
    }
    
    public void SaveToFile(Encrypted o) {
    	
    }
    
    public void ReadFromFileToArr(Encrypted o) {
    	
    }
   

}
