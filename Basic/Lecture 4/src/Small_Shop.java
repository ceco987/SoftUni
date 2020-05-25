import java.util.Scanner;

public class Small_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quant = Double.parseDouble(scanner.nextLine());
        if (city.equalsIgnoreCase("Sofia")){
            if(product.equalsIgnoreCase("coffee")) System.out.println(quant*0.5);
            else if(product.equalsIgnoreCase("water")) System.out.println(quant*0.8);
            else if(product.equalsIgnoreCase("beer")) System.out.println(quant*1.2);
            else if(product.equalsIgnoreCase("sweets")) System.out.println(quant*1.45);
            else if(product.equalsIgnoreCase("peanuts")) System.out.println(quant*1.6);
        }
        else if(city.equalsIgnoreCase("Plovdiv")){
            if(product.equalsIgnoreCase("coffee")) System.out.println(quant*0.4);
            else if(product.equalsIgnoreCase("water")) System.out.println(quant*0.7);
            else if(product.equalsIgnoreCase("beer")) System.out.println(quant*1.15);
            else if(product.equalsIgnoreCase("sweets")) System.out.println(quant*1.3);
            else if(product.equalsIgnoreCase("peanuts")) System.out.println(quant*1.5);
        }
        else if(city.equalsIgnoreCase("Varna")){
            if(product.equalsIgnoreCase("coffee")) System.out.println(quant*0.45);
            else if(product.equalsIgnoreCase("water")) System.out.println(quant*0.7);
            else if(product.equalsIgnoreCase("beer")) System.out.println(quant*1.1);
            else if(product.equalsIgnoreCase("sweets")) System.out.println(quant*1.35);
            else if(product.equalsIgnoreCase("peanuts")) System.out.println(quant*1.55);
        }
    }
}

