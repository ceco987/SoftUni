package BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = "";
        BankAccount account = null;
        HashMap<Integer, BankAccount> database = new HashMap<>();
        while (!"End".equals(data = scanner.nextLine())) {
            String[] input = data.split("\\s+");
            switch (input[0]) {
                case "Create":
                    account = new BankAccount();
                    database.put(account.getId(), account);
                    break;
                case "Deposit":
                    if (!database.containsKey(Integer.parseInt(input[1]))) {
                        System.out.println("Account does not exist");
                    } else {
                        database.get(Integer.parseInt(input[1])).deposit(Double.parseDouble(input[2]));
                        }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(input[1]));
                    break;
                case "GetInterest":
                    if (!database.containsKey(Integer.parseInt(input[1]))) {
                        System.out.println("Account does not exist");
                    } else {
                        System.out.printf("%.2f%n",database.get(Integer.parseInt(input[1])).getInterest(Integer.parseInt(input[2])));
                    }
                    break;
            }
        }
    }
}
