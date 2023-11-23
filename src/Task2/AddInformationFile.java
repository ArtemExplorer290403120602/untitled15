package Task2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AddInformationFile extends SystemFile {
    public static void addInformationFileAboutMyComputer() throws IOException {
        System.out.print("Введите сколько вы хотите ввести документов: ");
        Scanner scanner = new Scanner(System.in);
        int sizeDocuments = scanner.nextInt();
        scanner.nextLine();
        StringBuilder[] addTextInMyFileAboutMyComputer = new StringBuilder[sizeDocuments];
        for (int i = 0; i < sizeDocuments; i++) {
            System.out.println("Ваш " + "[" + (i+1) + "] " + "документ: ");
            addTextInMyFileAboutMyComputer[i] = new StringBuilder(scanner.nextLine());
        }

        try (FileWriter fileWriter = new FileWriter("G:\\tms\\myDocuments.txt")) {
            for (StringBuilder document : addTextInMyFileAboutMyComputer) {
                fileWriter.write(document.toString());
                fileWriter.write("\n");
            }
            fileWriter.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
