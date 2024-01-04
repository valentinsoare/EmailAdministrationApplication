package io.emailadministration.operationsWithDB;

import io.emailadministration.dbutils.EntityManagerScope;
import io.emailadministration.entities.companyemployees.Accountant;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class WithAccountantEmployee implements DataAccessObject<Accountant> {
    private LinkToDb link;

    public WithAccountantEmployee() {
        this.link = LinkToDb.getNewInstance();
    }

    public static WithAccountantEmployee getNewInstance() {
        return new WithAccountantEmployee();
    }

    @Override
    public Optional<Accountant> get(long id) {
        return Optional.empty();
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
    public List<Long> deleteAll(Collection<Long> c) {
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
