package io.emailadministration.operationsWithDB;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.entities.companydepartments.Sales;
import io.emailadministration.operationsWithDB.execute.ExecQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

import java.util.List;

public class WithSalesDepartment implements DepartmentDAO<Sales> {

    private final DBConnection connection;

    public WithSalesDepartment() {
        this.connection = DBConnection.getInstance();
    }

    public static WithSalesDepartment getNewInstance() {
        return new WithSalesDepartment();
    }

    @Override
    public Sales get() {
        EntityManager em = connection.generateEntityManager();

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("GetDepartment", Sales.class)
                .registerStoredProcedureParameter("name_of_the_department", String.class, ParameterMode.IN)
                .setParameter("name_of_the_department", "sales");

        List<Sales> objects = ExecQuery.ofGet(em, storedProcedureQuery, Sales.class);

        if (objects.isEmpty()) return new Sales();
        return objects.get(0);
    }

    @Override
    public boolean create(Sales o) {
        if (o == null) {
            return false;
        }

        EntityManager em = connection.generateEntityManager();
        return ExecQuery.ofInsert(em, o);
    }

    @Override
    public boolean update(long id, Sales o) {
        if (o == null) {
            return false;
        }

        EntityManager em = connection.generateEntityManager();
        EntityTransaction transaction = null;

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            Sales sales = em.find(Sales.class, id);
            sales.updateElement(o);

            em.merge(sales);

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

        StoredProcedureQuery deleteQuery = em.createStoredProcedureQuery("DeleteDepartment", Sales.class)
                .registerStoredProcedureParameter("name_of_the_department", String.class, ParameterMode.IN)
                .setParameter("name_of_the_department", "sales");

        return ExecQuery.ofDelete(em, deleteQuery, Sales.class);
    }

    @Override
    public boolean checkIfElementExists() {
        return this.get().getId() >= 0;
    }
}
