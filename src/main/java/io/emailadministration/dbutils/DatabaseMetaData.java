package io.emailadministration.dbutils;

import java.util.List;

public interface DatabaseMetaData {
    int getNumberOfRecords();
    String getNameOfTheDatabase();
    int getNumberOfTables();
    List<NumberOfRecordsPerEachTable> getNumberOfRecordsPerTable();
}
