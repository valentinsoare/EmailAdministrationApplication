package io.emailadministration.dbutils;

import jakarta.persistence.*;
import org.hibernate.procedure.ProcedureOutputs;

import java.util.*;

public class DBInfo extends DBConnection implements DatabaseMetaData {
    private String nameOfTheDB;
    private int numberOfTables;
    private int numberOfRecords;

    public DBInfo() {}

    @Override
    public int getNumberOfRecords() {
        int howManyRecords = 0;
        EntityTransaction transaction = null;

        EntityManager em = generateEntityManager();

        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("CountNumberOfRecords")
                .registerStoredProcedureParameter("name_of_the_database", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("number_of_records", Integer.class, ParameterMode.OUT)
                .setParameter("name_of_the_database", "EmailAppAdmin");

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            storedProcedureQuery.execute();
            howManyRecords = (int) storedProcedureQuery.getOutputParameterValue("number_of_records");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            storedProcedureQuery.unwrap(ProcedureOutputs.class).release();
        }

        this.numberOfRecords = howManyRecords;
        return howManyRecords;
    }

    @Override
    public String getNameOfTheDatabase() {
        this.nameOfTheDB = "EmailAppAdmin";
        return nameOfTheDB;
    }

    @Override
    public int getNumberOfTables() {
        int howManyTablesInDB = -1;
        EntityTransaction transaction = null;

        EntityManager em = generateEntityManager();

        StoredProcedureQuery storedProcedureQueryForNumberOfTables =
                em.createStoredProcedureQuery("CountTables")
                        .registerStoredProcedureParameter("name_of_the_database", String.class, ParameterMode.IN)
                        .registerStoredProcedureParameter("number_tables", Integer.class, ParameterMode.OUT)
                        .setParameter("name_of_the_database", "EmailAppAdmin");

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            storedProcedureQueryForNumberOfTables.execute();
            howManyTablesInDB = (int) storedProcedureQueryForNumberOfTables.getOutputParameterValue("number_tables");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            storedProcedureQueryForNumberOfTables.unwrap(ProcedureOutputs.class).release();
        }

        this.numberOfTables = howManyTablesInDB;
        return howManyTablesInDB;
    }

    @Override
    public List<NumberOfRecordsPerEachTable> getNumberOfRecordsPerTable() {
        EntityTransaction transaction = null;
        EntityManager em = generateEntityManager();
        List<NumberOfRecordsPerEachTable> records = new ArrayList<>();

        StoredProcedureQuery c = em.createStoredProcedureQuery("CountRecordsPerEachTable");

         try (em) {
             transaction = em.getTransaction();
             transaction.begin();

             List<Object[]> results = c.getResultList();

             for (Object[] e : results) {
                 records.add(
                         new NumberOfRecordsPerEachTable(
                                 (String) e[0],
                                 (Long) e[1]
                         )
                 );
             }

             transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
             c.unwrap(ProcedureOutputs.class).release();
        }

        return records;
    }

    public static DBInfo getNewInstanceOfDBInfo() {
        return new DBInfo();
    }
}
