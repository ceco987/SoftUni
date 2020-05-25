package com.intellij;

import java.util.Scanner;

public class Alcohol_Market {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double whpr=Double.parseDouble(scanner.nextLine());
        double b=Double.parseDouble(scanner.nextLine());
        double wi=Double.parseDouble(scanner.nextLine());
        double ra=Double.parseDouble(scanner.nextLine());
        double wh=Double.parseDouble(scanner.nextLine());
        double rapr=whpr/2;
        double wipr=rapr*0.6;
        double bpr=rapr*0.2;
        double ralv=ra*rapr;
        double blv=b*bpr;
        double wilv=wi*wipr;
        double whlv=wh*whpr;
        double total=ralv+blv+wilv+whlv;
        System.out.printf("%.2f",total);
    }
}