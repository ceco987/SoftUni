import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        String in = scanner.nextLine();
        String out = scanner.nextLine();
        if (in.equals("m")) {
            if (out.equals("mm")) {
                System.out.printf("%.8f", a * 1000);
            } else if (out.equals("cm")) {
                System.out.printf("%.8f", a * 100);
            } else if (out.equals("mi")) {
                System.out.printf("%.8f", a * 0.000621371192);
            } else if(out.equals("in")){
                System.out.printf("%.8f", a * 39.3700787);
            }
            else if(out.equals("km")){
                System.out.printf("%.8f", a * 0.001);
            }
            else if(out.equals("ft")){
                System.out.printf("%.8f", a * 3.2808399);
            }
            else if(out.equals("yd")){
                System.out.printf("%.8f", a * 1.0936133);
            }
            else if(out.equals("m")){
                System.out.printf("%.8f",a);
            }
        }
        else if (in.equals("mm")){
            a=a/1000;
            if (out.equals("mm")) {
                System.out.printf("%.8f", a * 1000);
            } else if (out.equals("cm")) {
                System.out.printf("%.8f", a * 100);
            } else if (out.equals("mi")) {
                System.out.printf("%.8f", a * 0.000621371192);
            } else if(out.equals("in")){
                System.out.printf("%.8f", a * 39.3700787);
            }
            else if(out.equals("km")){
                System.out.printf("%.8f", a * 0.001);
            }
            else if(out.equals("ft")){
                System.out.printf("%.8f", a * 3.2808399);
            }
            else if(out.equals("yd")){
                System.out.printf("%.8f", a * 1.0936133);
            }
            else if(out.equals("m")){
                System.out.printf("%.8f",a);
            }
        }
        else if(in.equals("cm")){
            a=a/100;
            if (out.equals("mm")) {
                System.out.printf("%.8f", a * 1000);
            } else if (out.equals("cm")) {
                System.out.printf("%.8f", a * 100);
            } else if (out.equals("mi")) {
                System.out.printf("%.8f", a * 0.000621371192);
            } else if(out.equals("in")){
                System.out.printf("%.8f", a * 39.3700787);
            }
            else if(out.equals("km")){
                System.out.printf("%.8f", a * 0.001);
            }
            else if(out.equals("ft")){
                System.out.printf("%.8f", a * 3.2808399);
            }
            else if(out.equals("yd")){
                System.out.printf("%.8f", a * 1.0936133);
            }
            else if(out.equals("m")){
                System.out.printf("%.8f",a);
            }
        }
        else if(in.equals("mi")){
            a=a/0.000621371192;
            if (out.equals("mm")) {
                System.out.printf("%.8f", a * 1000);
            } else if (out.equals("cm")) {
                System.out.printf("%.8f", a * 100);
            } else if (out.equals("mi")) {
                System.out.printf("%.8f", a * 0.000621371192);
            } else if(out.equals("in")){
                System.out.printf("%.8f", a * 39.3700787);
            }
            else if(out.equals("km")){
                System.out.printf("%.8f", a * 0.001);
            }
            else if(out.equals("ft")){
                System.out.printf("%.8f", a * 3.2808399);
            }
            else if(out.equals("yd")){
                System.out.printf("%.8f", a * 1.0936133);
            }
            else if(out.equals("m")){
                System.out.printf("%.8f",a);
            }
        }
        else if(in.equals("in")){
            a=a/39.3700787;
            if (out.equals("mm")) {
                System.out.printf("%.8f", a * 1000);
            } else if (out.equals("cm")) {
                System.out.printf("%.8f", a * 100);
            } else if (out.equals("mi")) {
                System.out.printf("%.8f", a * 0.000621371192);
            } else if(out.equals("in")){
                System.out.printf("%.8f", a * 39.3700787);
            }
            else if(out.equals("km")){
                System.out.printf("%.8f", a * 0.001);
            }
            else if(out.equals("ft")){
                System.out.printf("%.8f", a * 3.2808399);
            }
            else if(out.equals("yd")){
                System.out.printf("%.8f", a * 1.0936133);
            }
            else if(out.equals("m")){
                System.out.printf("%.8f",a);
            }
        }
        else if(in.equals("km")){
            a=a/0.001;
            if (out.equals("mm")) {
                System.out.printf("%.8f", a * 1000);
            } else if (out.equals("cm")) {
                System.out.printf("%.8f", a * 100);
            } else if (out.equals("mi")) {
                System.out.printf("%.8f", a * 0.000621371192);
            } else if(out.equals("in")){
                System.out.printf("%.8f", a * 39.3700787);
            }
            else if(out.equals("km")){
                System.out.printf("%.8f", a * 0.001);
            }
            else if(out.equals("ft")){
                System.out.printf("%.8f", a * 3.2808399);
            }
            else if(out.equals("yd")){
                System.out.printf("%.8f", a * 1.0936133);
            }
            else if(out.equals("m")){
                System.out.printf("%.8f",a);
            }
        }
        else if(in.equals("ft")){
            a=a/3.2808399;
            if (out.equals("mm")) {
                System.out.printf("%.8f", a * 1000);
            } else if (out.equals("cm")) {
                System.out.printf("%.8f", a * 100);
            } else if (out.equals("mi")) {
                System.out.printf("%.8f", a * 0.000621371192);
            } else if(out.equals("in")){
                System.out.printf("%.8f", a * 39.3700787);
            }
            else if(out.equals("km")){
                System.out.printf("%.8f", a * 0.001);
            }
            else if(out.equals("ft")){
                System.out.printf("%.8f", a * 3.2808399);
            }
            else if(out.equals("yd")){
                System.out.printf("%.8f", a * 1.0936133);
            }
            else if(out.equals("m")){
                System.out.printf("%.8f",a);
            }
        }
        else if(in.equals("yd")){
            a=a/1.0936133;
            if (out.equals("mm")) {
                System.out.printf("%.8f", a * 1000);
            } else if (out.equals("cm")) {
                System.out.printf("%.8f", a * 100);
            } else if (out.equals("mi")) {
                System.out.printf("%.8f", a * 0.000621371192);
            } else if(out.equals("in")){
                System.out.printf("%.8f", a * 39.3700787);
            }
            else if(out.equals("km")){
                System.out.printf("%.8f", a * 0.001);
            }
            else if(out.equals("ft")){
                System.out.printf("%.8f", a * 3.2808399);
            }
            else if(out.equals("yd")){
                System.out.printf("%.8f", a * 1.0936133);
            }
            else if(out.equals("m")){
                System.out.printf("%.8f",a);
            }
        }
    }
}