package koushik.temp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class CreateTextFile {
    public static void main(String[] args) {
        String fileName = "String.txt";
        String content = "techouts logical java test";

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.close();
            System.out.println("File '" + fileName + "' created successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
}
