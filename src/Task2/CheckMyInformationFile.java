package Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class CheckMyInformationFile extends SystemFile {

    public static void checkInformationFileAboutMyComputer() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("G:\\tms\\myDocuments.txt"))) {
            FileWriter validDocuments = new FileWriter("G:\\tms\\validDocuments.txt");
            FileWriter invalidDocuments = new FileWriter("G:\\tms\\invalidDocuments.txt");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (isValid(line)) {
                    validDocuments.write(line);
                    validDocuments.write("\n");
                } else {
                    invalidDocuments.write(line);
                    invalidDocuments.write(" - Это документ не начинается с cocnum или contract или он больше 15 символво");
                    invalidDocuments.write("\n");
                }
            }
            validDocuments.flush();
            invalidDocuments.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean isValid(String numberText) {
        if (numberText.startsWith("docnum") || numberText.startsWith("contract") && numberText.length() == 15) {
            return true;
        }
        return false;
    }
}
