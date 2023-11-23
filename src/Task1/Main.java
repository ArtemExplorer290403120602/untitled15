package Task1;

import java.io.*;

public class Main {
    //В задании приложен файл Ромео и Джульетта на английском, вычитать его в Idea.
    //Проанализировать и записать в другой файл самое длинное слово.
    public static void main(String[] args) throws IOException {
        try (FileReader fileReader = new FileReader("G:\\tms\\book.txt");
             FileWriter fileWriter = new FileWriter("G:\\tms\\bookTwo.txt")) {
            StringBuilder text = new StringBuilder();
            int maxWordLenght = 0;
            String maxWord = "";
            int i;
            while ((i = fileReader.read()) != -1) {
                char c = (char) i;
                System.out.print(c);

                if (Character.isLetter(c)) {
                    text.append(c);
                } else if (text.length() > 0) {
                    String word = text.toString();
                    if (word.length() > maxWordLenght) {
                        maxWordLenght = word.length();
                        maxWord = word;
                    }
                    text.setLength(0);
                }
            }

            // Проверяем последнее слово после окончания файла
            if (text.length() > 0) {
                String word = text.toString();
                if (word.length() > maxWordLenght) {
                    maxWordLenght = word.length();
                    maxWord = word;
                }
            }

            fileWriter.write(maxWord);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}