package io.emailadministration.operationsWithDB;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.dbutils.EntityManagerScope;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.FlushModeType;

public class LinkToDb extends DBConnection {
    private EntityManager em;
    private EntityTransaction transaction;

    protected LinkToDb(EntityManagerScope scope) {
        this.em = getInstance().generateEntityManager(scope);
        this.em.setFlushMode(FlushModeType.COMMIT);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(EntityTransaction transaction) {
        this.transaction = transaction;
    }
}
