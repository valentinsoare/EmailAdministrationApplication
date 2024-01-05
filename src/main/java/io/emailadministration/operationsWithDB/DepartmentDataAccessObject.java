package io.emailadministration.operationsWithDB;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface DepartmentDataAccessObject<T> {
    T get();

    boolean create(T o);

    boolean update(long id, T o);

    boolean delete(long id);

    boolean checkIfElementExists(long id);
}
