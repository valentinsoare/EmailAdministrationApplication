package io.emailadministration;

import io.emailadministration.entities.companydepartments.Accounting;
import io.emailadministration.entities.companydepartments.AccountingBuilder;
import io.emailadministration.entities.companyemployees.DepartmentType;
import io.emailadministration.operationsWithDB.WithAccountingDepartment;

public class App {
    public static void main( String[] args ) {
//        SessionStartingTheApp.logoAndProgressBar();
//        new SessionWithLoginSignInStartingTheApp().execute();

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
         WithAccountingDepartment withAccountingDepartment = new WithAccountingDepartment();

        boolean acc001 = withAccountingDepartment.create(
            new AccountingBuilder().setupDepartmentBusinessId("ACC001")
                    .setupDepartmentType(DepartmentType.ACCOUNTING)
                    .setupLastYearEvaluation(89)

                    .setupNumberOfEmployeesPerDepartment(23)
                    .build()
        );

        System.out.printf("%nResult of creating: %s", acc001);
        //--------------------------------------------------------

        Accounting accounting1 = withAccountingDepartment.get();
        System.out.printf("%n%s", accounting1);

        //--------------------------------------------------------

        Accounting accounting = withAccountingDepartment.get();

        System.out.printf("%n%s", accounting);

        withAccountingDepartment.update(1,
                new AccountingBuilder().setupDepartmentBusinessId("ceva")
                        .setupDepartmentType(DepartmentType.ACCOUNTING)
                        .setupLastYearEvaluation(12)
                        .setupNumberOfEmployeesPerDepartment(0)
                        .build()
        );



        Accounting acc = withAccountingDepartment.get();

        System.out.printf("%n%s", acc);

    }
}
