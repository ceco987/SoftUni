package harvestingFields;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Class<RichSoilLand> cl =  RichSoilLand.class;
		String input = "";
		while (!"HARVEST".equals(input = scanner.nextLine())){
			switch(input){
				case "private":
					Arrays.stream(cl.getDeclaredFields())
							.filter(e->Modifier.isPrivate(e.getModifiers()))
							.forEach(e -> System.out.printf("private %s %s%n",e.getType().getSimpleName(),e.getName()));
					break;
				case "protected":
					Arrays.stream(cl.getDeclaredFields())
							.filter(e->Modifier.isProtected(e.getModifiers()))
							.forEach(e-> System.out.printf("protected %s %s%n",e.getType().getSimpleName(),e.getName()));
					break;
				case "public":
					Arrays.stream(cl.getDeclaredFields())
							.filter(e->Modifier.isPublic(e.getModifiers()))
							.forEach(e-> System.out.printf("public %s %s%n",e.getType().getSimpleName(),e.getName()));
					break;
				default:
					Arrays.stream(cl.getDeclaredFields())
							.forEach(e-> System.out.printf("%s %s %s%n",Modifier.toString(e.getModifiers()),
									e.getType().getSimpleName(),
									e.getName()));
			}
		}
	}
}
