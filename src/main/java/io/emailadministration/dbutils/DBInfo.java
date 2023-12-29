package io.emailadministration.dbutils;

import java.util.Map;

public class DBInfo implements DatabaseMetaData {
    private String nameOfTheDB;
    private int numberOfTables;
    private int numberOfRecords;

    public DBInfo() {
        getNameOfTheDatabase();
        getNumberOfTables();
        getNumberOfRecords();
    }

    @Override
    public int getNumberOfRecords() {
        int recordsInDB = 0;
        this.numberOfRecords = recordsInDB;

        return recordsInDB;
    }

    @Override
    public String getNameOfTheDatabase() {
        String dbName = "";
        this.nameOfTheDB = dbName;

        return dbName;
    }

    @Override
    public Map<String, String> getDescriptionPerTable() {
        return null;
    }

    @Override
    public int getNumberOfTables() {
        int howManyTablesInDB = 0;

        this.numberOfTables = howManyTablesInDB;
        return howManyTablesInDB;
    }

    @Override
    public Map<String, Integer> getNumberOfRecordsPerTable() {
        return null;
    }
}
