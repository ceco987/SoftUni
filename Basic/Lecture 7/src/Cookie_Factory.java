import java.util.Scanner;

public class Cookie_Factory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean eggs=false;
        boolean flour=false;
        boolean sugar=false;
        int batch=Integer.parseInt(scanner.nextLine());
        int count=0;
        for (int i = 0; i <batch ; i++) {
            String products=scanner.nextLine();
            while(!products.equals("Bake!")){
                if(products.equals("eggs")) eggs=true;
                else if(products.equals("flour")) flour=true;
                else if(products.equals("sugar")) sugar=true;
                products=scanner.nextLine();
            }
            count++;
            if(eggs&&flour&&sugar) {
                System.out.printf("Baking batch number %d...\n",count);
                eggs=false;
                sugar=false;
                flour=false;
            }
            else {
                count--;
                i--;
                System.out.println("The batter should contain flour, eggs and sugar!");
            }
        }
    }
}
