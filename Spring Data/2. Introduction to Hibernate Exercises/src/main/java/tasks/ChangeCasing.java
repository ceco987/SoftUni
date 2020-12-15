package tasks;

import entities.Town;
import resources.Engine;

import javax.persistence.EntityManager;
import java.util.List;

public class ChangeCasing {
    private static EntityManager entityManager;

    public static void run() {
        entityManager = Engine.entityManager;
        List<Town> towns = entityManager
                .createQuery("SELECT t FROM Town t " +
                        "WHERE length(t.name) <=5", Town.class)
                .getResultList();
        entityManager.getTransaction().begin();
        towns.forEach(entityManager::detach);
        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }
        towns.forEach(entityManager::merge);
        entityManager.flush();
        entityManager.getTransaction().commit();
        System.out.println();
    }
}
