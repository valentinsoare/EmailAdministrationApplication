package io.emailadministration.operationsWithDB;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.entities.companydepartments.Accounting;
import io.emailadministration.entities.companydepartments.Sales;
import io.emailadministration.operationsWithDB.execute.ExecQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

import java.util.List;

public class WithAccountingDepartment implements DepartmentDataAccessObject<Accounting> {

    private final DBConnection connection;

    public WithAccountingDepartment() {
        this.connection = DBConnection.getInstance();
    }

    public static WithAccountingDepartment getNewInstance() {
        return new WithAccountingDepartment();
    }

    public Accounting get() {
        EntityManager em = connection.generateEntityManager();

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("GetDepartment", Accounting.class)
                .registerStoredProcedureParameter("name_of_the_department", String.class, ParameterMode.IN)
                .setParameter("name_of_the_department", "accounting");

        List<Accounting> objects = ExecQuery.ofGet(em, storedProcedureQuery, Accounting.class);

        if (objects.isEmpty()) return new Accounting();

        return objects.get(0);
    }

    @Override
    public boolean create(Accounting accounting) {
        if (accounting == null) {
            return false;
        }

        EntityManager em = connection.generateEntityManager();
        return ExecQuery.ofInsert(em, accounting);
    }

    @Override
    public boolean update(long id, Accounting o) {
        if (o == null) {
            return false;
        }

        EntityManager em = connection.generateEntityManager();
        EntityTransaction transaction = null;

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            Accounting accounting = em.find(Accounting.class, id);
            accounting.updateElement(o);

            em.merge(accounting);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return true;
    }

    @Override
    public boolean delete() {
        EntityManager em = connection.generateEntityManager();

        StoredProcedureQuery deleteQuery = em.createStoredProcedureQuery("DeleteDepartment", Accounting.class)
                .registerStoredProcedureParameter("name_of_the_department", String.class, ParameterMode.IN)
                .setParameter("name_of_the_department", "accounting");

        return ExecQuery.ofDelete(em, deleteQuery, Accounting.class);
    }

    @Override
    public boolean checkIfElementExists() {
        return this.get().getId() >= 0;
    }
}
