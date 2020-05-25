import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hello_France {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> buy = Arrays.stream(scanner.nextLine().split("[|\\->]"))
                .collect(Collectors.toList());
        List<Double> newPrice = new ArrayList<>();
        buy.removeIf(String::isEmpty);
        double initialBudget = Double.parseDouble(scanner.nextLine());
        double budget=initialBudget;

        double clothesPrice = 50;
        double shoesPrice = 35;
        double accessoriesPrice = 20.5;

        String[]items = new String[buy.size()];
        Double[] prices = new Double[buy.size()];
        int itemsCount=0;
        int pricesCount=0;

        for (int i = 0; i < buy.size(); i++) {
            if(i%2==0){
                items[itemsCount]=buy.get(i);
                itemsCount++;
            }
            else {
                prices[pricesCount]=Double.parseDouble(buy.get(i));
                pricesCount++;
            }
        }

        for (int i = 0; i < items.length; i++) {
        switch(items[i]){
            case "Clothes":
                if(prices[i]>clothesPrice||prices[i]>budget) continue;
                else{
                    budget-=prices[i];
                    newPrice.add(prices[i]*1.4);
                }
                break;
            case "Shoes":
                if(prices[i]>shoesPrice||prices[i]>budget) continue;
                else{
                    budget-=prices[i];
                    newPrice.add(prices[i]*1.4);

                }
                break;
            case "Accessories":
                if(prices[i]>accessoriesPrice||prices[i]>budget) continue;
                else{
                    budget-=prices[i];
                    newPrice.add(prices[i]*1.4);
                }
                break;
        }
        if(budget<shoesPrice||budget<accessoriesPrice||budget<clothesPrice){
            break;
        }
        }
        for (Double cena : newPrice) {
            budget+=cena;
        }
        double profit=budget-initialBudget;
        String[] submit = new String[newPrice.size()];
        DecimalFormat df = new DecimalFormat("0.00");
        List<String> submitList = new ArrayList<>();
        for (int i = 0; i < newPrice.size(); i++) {
            submit[i]=(df.format(newPrice.get(i)));
            submitList.add(submit[i]);
        }
        System.out.println(submitList.toString().replaceAll("[\\[\\],]",""));
        System.out.printf("Profit: %.2f%n",profit);
            if(budget>=150){
                System.out.println("Hello, France!");
            }
            else System.out.println("Time to go.");

    }
}
