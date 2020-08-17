package harvestingFields;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Class<RichSoilLand> cl =  RichSoilLand.class;
		String input = "";
		while (!"HARVEST".equals(scanner.nextLine())){
			if (!input.equals("all")){

			}
			else{
				Arrays.stream(cl.getDeclaredFields())
						.forEach(e-> System.out.println(e.getModifiers()));
			}
		}
	}
}
