package tasks;

import resources.Engine;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class FindEmployeesByFirstName {
    private static EntityManager entityManager;
    private static Scanner scanner;

    public static void run(){
        entityManager = Engine.entityManager;
        scanner = Engine.scanner;

    }
}
