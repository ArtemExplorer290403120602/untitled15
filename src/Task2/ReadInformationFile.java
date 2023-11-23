package Task2;

import java.io.FileReader;
import java.util.Scanner;

public class ReadInformationFile extends SystemFile {

    public static void readInformationFileAboutMyComputer() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите путь к файлу: ");
            String myFile = scanner.nextLine();
            try (FileReader fileReader = new FileReader(myFile)) {
                int i;
                System.out.println("------------------------");
                while ((i = fileReader.read()) != -1) {
                    char textInMyFile = (char) i;
                    System.out.print(textInMyFile);
                }
                break;
            } catch (Exception e) {
                System.out.println("Ошибка при открытии файла. Попробуйте снова.");
            }
        }
    }
}
