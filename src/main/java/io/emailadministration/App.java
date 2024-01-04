package io.emailadministration;

import io.emailadministration.runningsessionsentireapp.SessionStartingTheApp;
import io.emailadministration.runningsessionsentireapp.SessionWithLoginSignInStartingTheApp;

public class App { public static void main( String[] args ) {
        SessionStartingTheApp.logoAndProgressBar();
        new SessionWithLoginSignInStartingTheApp().execute();

        //-----------------------------------------------------------
//        DBInfo dbInfo = new DBInfo();
//
//        List<NumberOfRecordsPerEachTable> numberOfRecordsPerTable =
//                dbInfo.getNumberOfRecordsPerTable();
//        System.out.printf("%n%s", numberOfRecordsPerTable);
//
//        int numberOfRecords = dbInfo.getNumberOfRecords();
//        System.out.printf("%n%s", numberOfRecords);
//
//        int numberOfTables = dbInfo.getNumberOfTables();
//        System.out.printf("%n%s", numberOfTables);

        //------------------------------------------------------------
    }
}
