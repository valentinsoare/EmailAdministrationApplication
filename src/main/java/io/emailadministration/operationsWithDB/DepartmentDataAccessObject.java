package io.emailadministration.operationsWithDB;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.StoredProcedureQuery;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public interface DepartmentDataAccessObject<T> {
    T get();
    boolean create(T o);
    boolean update(long id, T o);
    boolean delete();
    boolean checkIfElementExists();

    default Set<Department> getAll() {
        DBConnection connection = DBConnection.getInstance();

        Set<Department> allDepartments = Collections.emptySet();

        EntityManager em = connection.generateEntityManager();
        EntityTransaction transaction = null;

        StoredProcedureQuery queryForAllDepartments =
                em.createStoredProcedureQuery("",Department.class);

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            allDepartments = new HashSet<>();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return allDepartments;
    }
}
