package io.emailadministration.operationsWithDB;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.entities.companydepartments.Development;
import io.emailadministration.operationsWithDB.execute.ExecQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

import java.util.List;

public class WithDevelopmentDepartment implements DepartmentDAO<Development> {

    private DBConnection connection;

    public WithDevelopmentDepartment() {
        this.connection = DBConnection.getInstance();
    }

    public static WithDevelopmentDepartment getNewInstance() {
        return new WithDevelopmentDepartment();
    }

    @Override
    public Development get() {
        EntityManager em = connection.generateEntityManager();

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("GetDepartment", Development.class)
                .registerStoredProcedureParameter("name_of_the_department", String.class, ParameterMode.IN)
                .setParameter("name_of_the_department", "development");

        List<Development> objects = ExecQuery.ofGet(em, storedProcedureQuery, Development.class);

        if (objects.isEmpty()) return new Development();
        return objects.get(0);
    }

    @Override
    public boolean create(Development development) {
        if (development == null) {
            return false;
        }

        EntityManager em = connection.generateEntityManager();
        return ExecQuery.ofInsert(em, development);
    }

    @Override
    public boolean update(long id, Development o) {
        if (o == null) {
            return false;
        }

        EntityManager em = connection.generateEntityManager();
        EntityTransaction transaction = null;

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            Development dev = em.find(Development.class, id);
            dev.updateElement(o);

            em.merge(dev);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            return false;
        }

        return true;
    }

    @Override
    public boolean delete() {
        EntityManager em = connection.generateEntityManager();

        StoredProcedureQuery deleteQuery = em.createStoredProcedureQuery("DeleteDepartment", Development.class)
                .registerStoredProcedureParameter("name_of_the_department", String.class, ParameterMode.IN)
                .setParameter("name_of_the_department", "development");

        return ExecQuery.ofDelete(em, deleteQuery, Development.class);
    }

    @Override
    public boolean checkIfElementExists() {
        return this.get().getId() >= 0;
    }
}
