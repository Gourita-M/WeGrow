package org.example.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Database {

    private static final EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("WeGrow");

    public static EntityManager jpa() {
        return factory.createEntityManager();
    }
}