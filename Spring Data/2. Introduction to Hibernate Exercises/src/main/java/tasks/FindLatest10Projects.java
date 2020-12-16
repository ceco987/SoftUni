package tasks;

import entities.Project;
import resources.Engine;

import javax.persistence.EntityManager;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class FindLatest10Projects {
    private static EntityManager entityManager;

    public static void run(){
        entityManager = Engine.entityManager;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        entityManager.createQuery("SELECT p from Project p " +
                "order by p.startDate desc", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p->{
                    System.out.printf("Project name: %s%n",p.getName());
                    System.out.printf("\tProject Description: %s%n",p.getDescription());
                    System.out.printf("\tProject Start Date: %s%n",p.getStartDate().format(format));
                    System.out.print("\tProject End Date: ");
                    if (null==p.getEndDate()) System.out.println("null");
                    else System.out.println(p.getEndDate().format(format));
                });
    }
}
