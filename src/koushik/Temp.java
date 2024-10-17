package koushik;

import java.util.*;
public class Temp{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print((char)('A' + j));
            }
            for (int j = i - 1; j >= 0; j--) {
                System.out.print((char)('A' + j));
            }
            System.out.println();
        }
    }
}