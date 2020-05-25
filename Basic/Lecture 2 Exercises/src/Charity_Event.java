package com.intellij;

import java.util.Scanner;

public class Charity_Event {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int bake=Integer.parseInt(scanner.nextLine());
        int tor=Integer.parseInt(scanner.nextLine());
        int gof=Integer.parseInt(scanner.nextLine());
        int pal=Integer.parseInt(scanner.nextLine());
        double torpr=tor*45;
        double gofpr=gof*5.8;
        double palpr=pal*3.2;
        double tot=(torpr+gofpr+palpr)*days*bake;
        double tot2=tot-tot/8;
        System.out.printf("%.2f",tot2);
    }

}
