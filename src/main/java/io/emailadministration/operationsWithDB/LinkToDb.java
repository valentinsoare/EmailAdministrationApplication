package io.emailadministration.operationsWithDB;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.dbutils.EntityManagerScope;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.FlushModeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkToDb extends DBConnection {
    private EntityManager em;
    private EntityTransaction transaction;

    protected LinkToDb() {
        this.em = getInstance().generateEntityManager();
        this.em.setFlushMode(FlushModeType.COMMIT);
    }

    public static LinkToDb getNewInstance() {
        return new LinkToDb();
    }
}
