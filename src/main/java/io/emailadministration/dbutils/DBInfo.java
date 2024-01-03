package io.emailadministration.dbutils;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class DBInfo extends DBConnection implements DatabaseMetaData {
    private String nameOfTheDB;
    private int numberOfTables;
    private int numberOfRecords;

    private final EntityManager em;
    private EntityTransaction transaction;

    public DBInfo() {
        this.em = generateEntityManager(EntityManagerScope.GET_STATS);
        this.em.setFlushMode(FlushModeType.COMMIT);
    }

    @Override
    public int getNumberOfRecords() {
        int howManyRecords = -1;

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("CountNumberOfRecords")
                    .registerStoredProcedureParameter("name_of_the_databsase", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("number_of_records", Integer.class, ParameterMode.OUT)
                    .setParameter("name_of_the_database", "EmailAppAdmin");

            storedProcedureQuery.execute();

            howManyRecords = (int) storedProcedureQuery.getOutputParameterValue("number_of_records");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        this.numberOfRecords = howManyRecords;
        return numberOfRecords;
    }

    @Override
    public String getNameOfTheDatabase() {
        this.nameOfTheDB = "EmailAppAdmin";
        return nameOfTheDB;
    }

    @Override
    public int getNumberOfTables() {
        int howManyTablesInDB = -1;

        try (em) {
            transaction = em.getTransaction();
            transaction.begin();

            StoredProcedureQuery storedProcedureQueryForNumberOfTables =
                    em.createStoredProcedureQuery("CountTables")
                            .registerStoredProcedureParameter("name_of_the_database", String.class, ParameterMode.IN)
                            .registerStoredProcedureParameter("number_tables", Integer.class, ParameterMode.OUT)
                            .setParameter("name_of_the_database", "EmailAppAdmin");

            storedProcedureQueryForNumberOfTables.execute();

            howManyTablesInDB = (int) storedProcedureQueryForNumberOfTables.getOutputParameterValue("number_tables");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        this.numberOfTables = howManyTablesInDB;
        return howManyTablesInDB;
    }

    @Override
    public List<NumberOfRecordsPerEachTable> getNumberOfRecordsPerTable() {
        List<NumberOfRecordsPerEachTable> records = new ArrayList<>();

         try (em) {
             transaction = em.getTransaction();
             transaction.begin();

             StoredProcedureQuery c = em.createStoredProcedureQuery("CountRecordsPerEachTable");
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
        }

        return records;
    }

    public static DBInfo getNewInstanceOfDBInfo() {
        return new DBInfo();
    }
}
