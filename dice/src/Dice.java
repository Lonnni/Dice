import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Dice {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secret = random.nextInt(100) + 1;
        String input = "";
        int num = 0;
        int attempts = 0;
        int best = Integer.MAX_VALUE;
        boolean guessed = false;
        File file = new File ("best.txt");
        if (file.exists()){
            Scanner fileScanner = new Scanner(file);
            best = fileScanner.nextInt();
            System.out.println("Текущий рекорд: "+best+ " попыток");
        } else {
            System.out.println("Рекорд пока не установлен");}
        System.out.println("Угадай число от 1 до 100");
        System.out.println("Или введи RESULT для отображения статистики");
        while (!guessed) {
            System.out.println("Твой вариант: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("RESULT")) {
                System.out.println("Текущее количество попыток: " + attempts);
                if (best == Integer.MAX_VALUE) {
                    System.out.println("Лучший результат пока не уcтановлен");
                } else {
                    System.out.println("Лучший результат: " + best + " попыток");
                }
                continue;}
            num=Integer.parseInt(input);
            attempts++;
            if (num < secret) {
                System.out.println("Я сам в шоке, но, загаданное число больше, брат");
            } else if (num > secret) {
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
            } else{
                guessed = true;
                System.out.println("Загаданное число: " + secret);
                System.out.println("Текущее количество попыток: " + attempts);
                if (attempts < best) {
                    best = attempts;
                    FileWriter writer = new FileWriter("best.txt");
                    writer.write (String.valueOf(best));
                    writer.close();
                    System.out.println("Новый рекорд! Число отгадано за " + attempts + " попыток");
                } else {
                    System.out.println("Лучший результат: " + best + " попыток");
                }
            }
        }
        scanner.close();
    }
}