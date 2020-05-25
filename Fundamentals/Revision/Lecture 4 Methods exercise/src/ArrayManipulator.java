import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arr = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
        String [] input = scanner.nextLine().split(" ");
        String output="";
        while(!"end".equals(input[0])){
            switch (input[0]){
                case "exchange":
                    exchange(arr,Integer.parseInt(input[1]));
                    break;
                case "max":
                    max(arr,input[1]);
                    break;
                case "min":
                    min(arr,input[1]);
                    break;
                case "first":
                    first(arr, Integer.parseInt(input[1]),input[2]);
                    break;
                case "last":
                    last(arr,Integer.parseInt(input[1]),input[2]);
                    break;
            }
            input=scanner.nextLine().split(" ");
        }
        String[]arrOutput=new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrOutput[i] = String.valueOf(arr[i]);
        }
        printFirstString(arrOutput);
    }
    static void printFirstString(String[] a){
        System.out.println("["+String.join(", ",a)+"]");
    }
    static void printLastString(String[] a){
        System.out.println("["+String.join(", ",a)+"]");
    }
    static void exchange(int[] arr,int index){
        if(index<0||index>arr.length){
            System.out.println("Invalid index");
        }
        else{
            int tempFirst [] = new int[index+1];
            int tempSecond[] = new int[arr.length-(index+1)];

            for (int i = 0; i <= index; i++) {              //assigning first half
                tempFirst[i]=arr[i];
            }

            int count =0;
            for (int i = index+1; i <arr.length ; i++) {   //assigning second half
                tempSecond[count]=arr[i];
                count++;
            }
            count=0;

            for (int i = 0; i < tempSecond.length ; i++){  //shifting first half of the arr
                arr[i]=tempSecond[i];
            }

            for (int i = tempSecond.length; i < arr.length; i++) {    //shifting second half of the arr
                arr[i]=tempFirst[count];
                count++;
            }
        }
    }
    static void max(int[] arr,String comm){
        int max=Integer.MIN_VALUE;
        int index=-1;
        for (int i = 0; i < arr.length; i++) {
            if((comm.equals("odd")&&arr[i]%2!=0)&&max<=arr[i]) {
                max=arr[i];
                index = i;
            }
            else if((comm.equals("even")&&arr[i]%2==0)&&max<=arr[i]) {
                max=arr[i];
                index = i;
            }
        }
        if(index==-1) System.out.println("No matches");
        else System.out.println(index);
    }
    static void min(int[] arr,String comm){
        int min=Integer.MAX_VALUE;
        int index=-1;
        for (int i = 0; i < arr.length; i++) {
            if((comm.equals("odd")&&arr[i]%2!=0)&&min>=arr[i]) {
                min=arr[i];
                index = i;
            }
            else if((comm.equals("even")&&arr[i]%2==0)&&min>=arr[i]) {
                min=arr[i];
                index = i;
            }
        }
        if(index==-1) System.out.println("No matches");
        else System.out.println(index);

    }
    static void first(int[] arr,int num,String comm){
        String output="";
        if(num>arr.length) {
            System.out.println("Invalid count");
            return;
        }
        else if(comm.equals("even")){
            int count=0;
                for (int value : arr) {
                if (value % 2 == 0) {
                    output += value+" ";
                    count++;
                    if (count == 2) {
                        String[] arrOutput=output.split(" ");
                        printFirstString(arrOutput);
                        return;
                    }
                }
            }
        }
        else if(comm.equals("odd")){
            int count=0;
            for (int value: arr) {
                if(value%2!=0){
                    output+=value+" ";
                    count++;
                    if(count==2){
                        String[] arrOutput=output.split(" ");
                        printFirstString(arrOutput);
                        return;
                    }
                }
            }
        }
        if(output.equals("")) System.out.println("[]");
        else {
            String[] arrOutput = output.split(" ");
        printFirstString(arrOutput);
        }
    }
    static void last (int[] arr, int num, String comm){
        String output="";
        if(num>arr.length) {
            System.out.println("Invalid count");
            return;
        }
        else if(comm.equals("even")){
            int count=0;
            for (int i = arr.length-1; i >=0; i--) {
                if (arr[i] % 2 == 0) {
                    output += arr[i]+" ";
                    count++;
                    if (count == 2) {
                        String[] arrOutput=output.split(" ");
                        printLastString(arrOutput);
                        return;
                    }
                }
            }
        }
        else if(comm.equals("odd")){
            int count=0;
            for (int i = arr.length-1; i >=0; i--) {
                if (arr[i] % 2 != 0) {
                    output += arr[i]+" ";
                    count++;
                    if (count == 2) {
                        String[] arrOutput=output.split(" ");
                        printLastString(arrOutput);
                        return;
                    }
                }
            }
        }
        if(output.equals("")) System.out.println("[]");
        else {
            String[] arrOutput = output.split(" ");
            printLastString(arrOutput);
        }
    }
}
