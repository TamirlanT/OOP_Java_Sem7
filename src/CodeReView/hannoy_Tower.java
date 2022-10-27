package CodeReView;

import java.util.Scanner;

public class hannoy_Tower {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println(("Введите количество колец"));
        int val = scanner.nextInt();
        scanner.close();

        int start = 1;
        int betw = 2;
        int tow = 3;
        hannoy_tower(val, start, betw, tow);
    }

    static void hannoy_tower(int val, int start, int betw, int tow){
        if (val != 0) {
            hannoy_tower(val - 1,start, tow, betw);
            System.out.printf("Переместите из '%d' в '%d'\n", start, tow);
            hannoy_tower(val - 1, betw, start, tow);
        }
    }
}
