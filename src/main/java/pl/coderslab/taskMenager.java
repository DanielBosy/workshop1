package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class taskMenager {

    public static void main(String[] args) throws IOException {
        Head();

    }

    public static void Head() throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println(ConsoleColors.BLUE_BOLD + "Please select an option:");
            System.out.println(ConsoleColors.RESET + "add");
            System.out.println(ConsoleColors.RESET + "remove");
            System.out.println(ConsoleColors.RESET + "list");
            System.out.println(ConsoleColors.RESET + "exit");

            String text = scan.nextLine();
            if (text.equals("exit")) {
                System.out.println(ConsoleColors.RED_BOLD + "Goodbey");
                break;
            }
            if (text.equals("list")) {
                list();
            }
            if (text.equals("add")) {
                add();
            }
            System.out.println(text);
        }

    }

    public static void list() {

        File file = new File("tasks.csv");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("błąd");
        }
    }

    public static void add() throws IOException {
        Path path = Paths.get("tasks.csv");
        Scanner scan = new Scanner(System.in);
            try (PrintWriter writer = new PrintWriter("tasks.csv")) {
                while (true) {
                    System.out.println("wpisz zadanie");
                    String s = scan.nextLine();
                    System.out.println("data");
                    String t = scan.nextLine();
                    System.out.println("czy ważne true/folse");
                    String u = scan.nextLine();
                    System.out.println(s);
                    System.out.println(t);
                    System.out.println(u);
                    if (s.equals("quit")) {
                       break;
                    }
                    writer.println(s);
                    writer.println(t);
                    writer.println(u);

                }
            } catch (FileNotFoundException e) {
                System.out.println("błąd");
            }

        }
    }


