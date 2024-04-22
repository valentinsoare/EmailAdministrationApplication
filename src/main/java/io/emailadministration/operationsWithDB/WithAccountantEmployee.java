package io.emailadministration.operationsWithDB;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.entities.companyemployees.Accountant;
import io.emailadministration.operationsWithDB.execute.ExecQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class WithAccountantEmployee implements EmployeeDAO<Accountant> {

    private DBConnection connection;

    public WithAccountantEmployee() {
        this.connection = DBConnection.getInstance();
    }

    public static WithAccountantEmployee getNewInstance() {
        return new WithAccountantEmployee();
    }

    @Override
    public Accountant get(long id) {
        EntityManager em = connection.generateEntityManager();

        StoredProcedureQuery q = em.createStoredProcedureQuery("GetAnAccountantById",Accountant.class)
                .registerStoredProcedureParameter("type_of_employee", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("id_number", Long.class, ParameterMode.IN)
                .setParameter("type_of_employee", "accountant")
                .setParameter("id_number", id);

        List<Accountant> objects = ExecQuery.ofGet(em, q, Accountant.class);
        if (objects.isEmpty()) return new Accountant();

        return objects.get(0);
    }

    @Override
    public Set<Accountant> getAll() {
        return null;
    }

    @Override
    public Set<Accountant> getAll(long startId, long endId) {
        return null;
    }

    @Override
    public boolean create(Accountant accountant) {
        return false;
    }

    @Override
    public List<Long> createAll(Collection<? extends Accountant> c) {
        return Collections.emptyList();
    }

    @Override
    public boolean update(long id, Accountant accountant) {
        return false;
    }

    @Override
    public List<Long> updateAll(Collection<? extends Accountant> c) {
        return Collections.emptyList();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Long> deleteAll(Collection<Accountant> c) {
        return Collections.emptyList();
    }

    @Override
    public boolean checkIfElementExists(long id) {
        return false;
    }

    @Override
    public boolean checkIfElementExists(Accountant accountant) {
        return false;
    }
}
