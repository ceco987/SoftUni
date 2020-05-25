import java.util.Scanner;

public class Currency_Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cash = Double.parseDouble(scanner.nextLine());
        String curr = scanner.nextLine();
        String curr2 = scanner.nextLine();
        if(curr.equals("USD"))
        {
            if(curr2.equals("BGN"))
            {
                cash = cash*1.79549;
                System.out.printf("%.2f BGN", cash);
            }
            else if(curr2.equals("EUR"))
            {
                cash = cash*1.79549/1.95583;
                System.out.printf("%.2f EUR",cash);
            }
            else if(curr2.equals("GBP"))
            {
                cash = cash*1.79549/2.53405;
                System.out.printf("%.2f GBP",cash);
            }
        }
        else if(curr.equals("BGN"))
        {
            if(curr2.equals("USD")) {
                cash = cash / 1.79549;
                System.out.printf("%.2f USD", cash);
            }
            else if(curr2.equals("EUR")) {
                cash = cash / 1.95583;
                System.out.printf("%.2f EUR", cash);
            }
            else if(curr2.equals("GBP"))
            {
                cash=cash/2.53405;
                System.out.printf("%.2f GBP",cash);
            }
        }
        else if(curr.equals("GBP"))
        {
            if(curr2.equals("BGN"))
            {
            cash=cash*2.53405;
            System.out.printf("%.2f BGN",cash);
            }
            else if(curr2.equals("USD"))
            {
            cash=cash*2.53405/1.79549;
            System.out.printf("%.2f USD",cash);
            }
            else if(curr2.equals("EUR"))
            {
            cash=cash*2.53405/1.95583;
            System.out.printf("%.2f EUR",cash);
            }
        }
        else if(curr.equals("EUR"))
        {
            if(curr2.equals("BGN"))
            {
            cash=cash*1.95583;
            System.out.printf("%.2f BGN",cash);
            }
            else if(curr2.equals("USD"))
            {
            cash=cash*1.95583/1.79549;
            System.out.printf("%.2f USD",cash);
            }
            else if(curr2.equals("GBP"))
            {
                cash=cash*1.95583/2.53405;
                System.out.printf("%.2f GBP",cash);
            }
        }

    }
}