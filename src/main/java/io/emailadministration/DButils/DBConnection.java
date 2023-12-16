package io.emailadministration.DButils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class DBConnection {
    private EntityManager entityManger;

    private DBConnection() {}

    static class Inner {
        private Inner() {}

        private static final EntityManagerFactory entityManagerFactory = generateEntityManagerFactory();

        private static final Map<EntityManagerScope, EntityManager> entityManagerInstances
                = new EnumMap<>(EntityManagerScope.class);

        private static DBConnection connToDb = new DBConnection();

        private static EntityManagerFactory generateEntityManagerFactory() {
            return Persistence.createEntityManagerFactory(
                    DatabaseUtilInfo.UNIT_PERSISTENCE_NAME.toString()
            );
        }
    }

    public EntityManager generateEntityManager(EntityManagerScope scope) {
        if (Inner.entityManagerInstances.containsKey(scope)) {
            return Inner.entityManagerInstances.get(scope);
        }

        this.entityManger = Inner.entityManagerFactory.createEntityManager();

        Inner.entityManagerInstances.put(scope, entityManger);
        return entityManger;
    }

    public Optional<EntityManagerFactory> getEntityManagerFactory() {
        return Optional.ofNullable(Inner.entityManagerFactory);
    }

    public static DBConnection getInstance() {
        return Inner.connToDb;
    }

    public Optional<EntityManager> getEntityManagerInstance(EntityManagerScope scope) {
        return Optional.ofNullable(Inner.entityManagerInstances.get(scope));
    }

    public Map<EntityManagerScope, EntityManager> getAllEntityManagers() {
        return Inner.entityManagerInstances;
    }
}

