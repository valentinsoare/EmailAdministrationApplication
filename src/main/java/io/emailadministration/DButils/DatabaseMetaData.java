package io.emailadministration.DButils;

import java.util.Map;

public interface DatabaseMetaData {
    int getNumberOfRecords();
    String getNameOfTheDatabase();
    Map<String, String> getDescriptionPerTable();
    int getNumberOfTables();
    Map<String, Integer> getNumberOfRecordsPerTable();
}
