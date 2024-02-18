package koushik.leetcode;

import java.util.Scanner;

public class rangoli {
    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        int n =sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" *");
            }
            for (int j = i - 1; j >= 0; j--) {
                System.out.print(" *");
            }
            System.out.println();
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" *");
            }
            for (int j = i - 1; j >= 0; j--) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
