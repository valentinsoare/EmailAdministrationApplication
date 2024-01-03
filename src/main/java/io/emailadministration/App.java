package io.emailadministration;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.dbutils.DBInfo;
import io.emailadministration.dbutils.NumberOfRecordsPerEachTable;
import io.emailadministration.runningsessionsentireapp.SessionStartingTheApp;
import io.emailadministration.runningsessionsentireapp.SessionWithLoginSignInStartingTheApp;

import java.util.List;

public class App extends DBConnection {

    public static void main( String[] args ) {
//        SessionStartingTheApp.logoAndProgressBar();
//        new SessionWithLoginSignInStartingTheApp().execute();

        //-----------------------------------------------------------

        List<NumberOfRecordsPerEachTable> numberOfRecordsPerTable =
                new DBInfo().getNumberOfRecordsPerTable();

        System.out.printf("%n%s", numberOfRecordsPerTable);

        //------------------------------------------------------------
    }
}
