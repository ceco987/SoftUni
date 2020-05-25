import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double people = Double.parseDouble(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double price =0;
        switch (type){
            case "Students":
                switch(day){
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.8;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch(day){
                    case "Friday":
                        price = 10.9;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
                break;
            case "Regular":
                switch(day){
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                break;
        }
        double totalPrice =people*price;
        if(type.equals("Students")&&people>=30) {
            totalPrice*=0.85;
        }
        else if(type.equals("Business")&&people>=100){
            totalPrice=price*(people-10);
        }
        else if(type.equals("Regular")&&people>=10&&people<=20){
            totalPrice*=0.95;
        }
        System.out.printf("Total price: %.2f",totalPrice);
    }
}
