package Exception3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;


public class HW_Sem3_Exception {
    public static void main(String[] args) {
        try {
            HashMap<String, String> data = getUser();
            writeFile(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> getUser() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> data = new HashMap<>();
        System.out.println("Введите через пробел: <Фамилию> <Имя> <Отчество> " +
                "<Дату рождения в формате(дд.мм.гггг)> " +
                "<Номер телефона в формате(7ХХХХХХХХХХ)> " +
                "<Пол (f/m)>");
        sb.append(scanner.nextLine());
        String[] str = sb.toString().split(" ");
        if (str.length != 6)
            throw new RuntimeException("Количество элеметов должно быть равным 6, Вы ввели: " + str.length);
        for (String el : str) {
            if (Objects.equals(el.toLowerCase(), "f") || Objects.equals(el.toLowerCase(), "m"))
                data.put("Пол", el.toLowerCase());
            else if (el.contains(".")) {
                String[] date = el.split("\\.");
                if (date[0].length() != 2 || date[1].length() != 2 || date[2].length() != 4) {
                    throw new RuntimeException("Не верный формат даты");
                }
                try {
                    if (Integer.parseInt(date[0]) > 31 || Integer.parseInt(date[0]) <=0){
                        throw new RuntimeException("Дней в месяце не может быть :" + date[0]);
                    } else if (Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[1]) <= 0) {
                        throw new RuntimeException("Месяцев в году не может быть: " + date[1]);
                    } else if (Integer.parseInt(date[2]) > 2022) {
                        throw new RuntimeException("Год рождения не может быть больше 2022" + date[2]);
                    } else data.put("Дата рождения", el);
                } catch (NumberFormatException e){
                    throw new NumberFormatException("Дата должна быть цифровой");
                }
            } else if (el.matches("[0-9]+")) {
                if (el.length() == 11 && el.startsWith("7")) data.put("Номер телефона", el);
                else throw new RuntimeException("Формат номера телефона должен быть --> 7XXXXXXXXXX");
            } else if (el.toLowerCase().endsWith("vich") || el.toLowerCase().endsWith("vna") ||
                    el.toLowerCase().endsWith("вич") || el.toLowerCase().endsWith("вна"))
                data.put("Отчество", el);
            else if (el.toLowerCase().endsWith("ov") || el.toLowerCase().endsWith("ova") ||
                     el.toLowerCase().endsWith("in") || el.toLowerCase().endsWith("ina") ||
                     el.toLowerCase().endsWith("ов") || el.toLowerCase().endsWith("ова") ||
                     el.toLowerCase().endsWith("ин") || el.toLowerCase().endsWith("ина")) {
                data.put("Фамилия", el);
            } else {
                if (data.containsKey("Имя"))
                    throw new RuntimeException("Невозможно прочесть " + el);
                else data.put("Имя", el);
            }
        }
        return data;
    }

    static void writeFile(HashMap<String, String> hm) throws IOException {
        File file = new File(String.format("C:\\Users\\sony\\IdeaProjects\\New_project001\\src\\Exception3\\ %s", hm.get("Фамилия")));
        if (file.createNewFile()) {
            System.out.printf("Файл %s был создан!\n", file.getName());
        } else {
            System.out.printf("В файл %s был добавлен новый контакт.\n", file.getName());
        }
        try (FileWriter fw = new FileWriter(String.format("C:\\Users\\sony\\IdeaProjects\\New_project001\\src\\Exception3\\ %s", hm.get("Фамилия")), true)) {
            fw.append(String.format("Фамилия: %s\n", hm.get("Фамилия")));
            fw.append(String.format("Имя: %s\n", hm.get("Имя")));
            fw.append(String.format("Отчество: %s\n", hm.get("Отчество")));
            fw.append(String.format("Дата рождения: %s\n", hm.get("Дата рождения")));
            fw.append(String.format("Номер телефона: %s\n", hm.get("Номер телефона")));
            fw.append(String.format("Пол: %s\n", hm.get("Пол")));
            fw.append("\n");
        }
    }
}


