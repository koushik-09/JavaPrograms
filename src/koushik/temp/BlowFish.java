package koushik.temp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key; import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
public class BlowFish {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGenerator= KeyGenerator.getInstance("Blowfish"); keyGenerator. init(128);
        Key secretKey = keyGenerator.generateKey();
        Cipher cipherOut = Cipher.getInstance("Blowfish/CFB/NoPadding");
        cipherOut. init(Cipher.ENCRYPT_MODE,secretKey);
        Base64.Encoder encoder = Base64.getEncoder();
        byte iv[] = cipherOut.getIV();
        if(iv!=null){
            System.out.println("Initialization vector of the Cipher:" + encoder.encodeToString(iv));
        }
        //absolute path to input.txt file
        FileInputStream fin = new FileInputStream("/Users/koushikreddy/IdeaProjects/JavaPrograms/src/koushik/temp/inputFile.txt");
        //absolute path to output.txt file
        FileOutputStream fout = new FileOutputStream("/Users/koushikreddy/IdeaProjects/JavaPrograms/src/koushik/temp/outputFile.txt");
        CipherOutputStream cout = new CipherOutputStream(fout, cipherOut);
        int input;
        while((input = fin.read()) != -1) {
            cout. write(input);
        }
        fin.close();
        cout.close();
    }
}