package io.emailadministration.operationsWithDB;

import io.emailadministration.entities.companyemployees.SalesAgent;

import java.util.*;

public class WithSalesAgentEmployee implements EmployeeDAO<SalesAgent> {

    public WithSalesAgentEmployee getNewInstance() {
        return new WithSalesAgentEmployee();
    }

    @Override
    public SalesAgent get(long id) {
        return null;
    }

    @Override
    public Set<SalesAgent> getAll() {
        return null;
    }

    @Override
    public Set<SalesAgent> getAll(long startId, long endId) {
        return null;
    }

    @Override
    public boolean create(SalesAgent salesAgent) {
        return false;
    }

    @Override
    public List<Long> createAll(Collection<? extends SalesAgent> c) {
        return Collections.emptyList();
    }

    @Override
    public boolean update(long id, SalesAgent salesAgent) {
        return false;
    }

    @Override
    public List<Long> updateAll(Collection<? extends SalesAgent> c) {
        return Collections.emptyList();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<Long> deleteAll(Collection<SalesAgent> c) {
        return Collections.emptyList();
    }

    @Override
    public boolean checkIfElementExists(long id) {
        return false;
    }

    @Override
    public boolean checkIfElementExists(SalesAgent salesAgent) {
        return false;
    }
}
