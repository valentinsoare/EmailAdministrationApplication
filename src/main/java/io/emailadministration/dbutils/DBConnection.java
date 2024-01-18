package io.emailadministration.dbutils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private EntityManager entityManger;

    public DBConnection() {}

    static class Inner {

        private Inner() {}

        private static final EntityManagerFactory entityManagerFactory =
                generateEntityManagerFactory();

        private static final DBConnection connToDb = new DBConnection();

        private static EntityManagerFactory generateEntityManagerFactory() {
            return Persistence.createEntityManagerFactory(
                    DatabaseUtilInfo.UNIT_PERSISTENCE_NAME.toString()
            );
        }
    }

    public EntityManager generateEntityManager() {
        this.entityManger = Inner.entityManagerFactory.createEntityManager();
        return entityManger;
    }

    public Optional<EntityManagerFactory> getEntityManagerFactory() {
        return Optional.ofNullable(Inner.entityManagerFactory);
    }

    public static DBConnection getInstance() {
        return Inner.connToDb;
    }

    public static void setLoggingLevel(Level loggingLevel) {
        Logger.getLogger("org.hibernate").setLevel(loggingLevel);
    }
}

