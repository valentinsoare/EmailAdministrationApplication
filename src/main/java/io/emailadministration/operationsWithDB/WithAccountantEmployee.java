package io.emailadministration.operationsWithDB;

import io.emailadministration.dbutils.EntityManagerScope;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
public class WithAccountantEmployee implements DataAccessObject {
    private LinkToDb link;

    public WithAccountantEmployee() {
        this.link = new LinkToDb(EntityManagerScope.OPERATIONS_WITH_EMPLOYEE);
    }

    public static WithAccountantEmployee getNewInstance() {
        return new WithAccountantEmployee();
    }

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public Set getAll() {
        return null;
    }

    @Override
    public Set getAll(long startId, long endId) {
        return null;
    }

    @Override
    public boolean create(Object o) {
        return false;
    }

    @Override
    public int[] createAll(Collection c) {
        return new int[0];
    }

    @Override
    public boolean update(long id, Object o) {
        return false;
    }

    @Override
    public int[] updateAll(Collection c) {
        return new int[0];
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean checkIfElementExists(long id) {
        return false;
    }

    @Override
    public boolean checkIfElementExists(Object o) {
        return false;
    }

    @Override
    public int[] deleteAll(Collection c) {
        return new int[0];
    }
}
