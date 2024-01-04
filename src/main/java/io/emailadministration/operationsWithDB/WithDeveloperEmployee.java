package io.emailadministration.operationsWithDB;

import io.emailadministration.dbutils.EntityManagerScope;
import io.emailadministration.entities.companyemployees.Developer;

import java.util.*;

public class WithDeveloperEmployee implements DataAccessObject<Developer> {
    private LinkToDb link;

    public WithDeveloperEmployee() {
        this.link = new LinkToDb();
    }

    public WithDeveloperEmployee getNewInstance() {
        return new WithDeveloperEmployee();
    }

    @Override
    public Optional<Developer> get(long id) {
        return Optional.empty();
    }

    @Override
    public Set<Developer> getAll() {
        return null;
    }

    @Override
    public Set<Developer> getAll(long startId, long endId) {
        return null;
    }

    @Override
    public boolean create(Developer developer) {
        return false;
    }

    @Override
    public List<Long> createAll(Collection<? extends Developer> c) {
        return Collections.emptyList();
    }

    @Override
    public boolean update(long id, Developer developer) {
        return false;
    }

    @Override
    public List<Long> updateAll(Collection<? extends Developer> c) {
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
    public boolean checkIfElementExists(Developer developer) {
        return false;
    }
}
