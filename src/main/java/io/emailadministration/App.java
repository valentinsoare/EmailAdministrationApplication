package io.emailadministration;

import io.emailadministration.configurationmapper.ApplicationConfig;
import io.emailadministration.configurationmapper.ReadConfiguration;
import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.devcomponents.errorsclasification.InputErrors;
import io.emailadministration.devcomponents.errorsclasification.StructuralErrors;
import io.emailadministration.entities.companydepartments.*;
import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.DepartmentBuilder;
import io.emailadministration.entities.companyemployees.DepartmentType;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.EmployeeBuilder;
import io.emailadministration.operationsWithDB.WithAccountingDepartment;
import io.emailadministration.operationsWithDB.WithDevelopmentDepartment;
import io.emailadministration.operationsWithDB.WithSalesDepartment;
import io.emailadministration.runningsessionsentireapp.SessionStartingTheApp;
import io.emailadministration.runningsessionsentireapp.SessionWithLoginSignInStartingTheApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;

public class App {

    static Logger LOGGER = LogManager.getLogger(App.class);

    public static void main( String[] args ) {
        DBConnection.setLoggingLevel(Level.INFO);

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

//        WithAccountingDepartment withAccountingDepartment = WithAccountingDepartment.getNewInstance();

//        boolean acc001 = withAccountingDepartment.create(
//            new AccountingBuilder().setupDepartmentBusinessId("ACC001")
//                    .setupDepartmentType(DepartmentType.ACCOUNTING)
//                    .setupLastYearEvaluation(89)
//
//                    .setupNumberOfEmployeesPerDepartment(23)
//                    .build()
//        );

//        System.out.printf("%nResult of creating: %s", acc001);
        //--------------------------------------------------------

//        Accounting accounting1 = withAccountingDepartment.get();
//        System.out.printf("%n%s", accounting1);

        //--------------------------------------------------------

//        Accounting accounting = withAccountingDepartment.get();
//
//        System.out.printf("%n%s", accounting);
//
//        withAccountingDepartment.update(1,
//                new AccountingBuilder().setupDepartmentBusinessId("ceva")
//                        .setupDepartmentType(DepartmentType.ACCOUNTING)
//                        .setupLastYearEvaluation(12)
//                        .setupNumberOfEmployeesPerDepartment(0)
//                        .build()
//        );

//        System.out.printf("%n%s", withAccountingDepartment.get());
//
//        withAccountingDepartment.delete();
        //------------------------------------------------------------

//            boolean acc001 = withAccountingDepartment.create(
//                    new AccountingBuilder().setupDepartmentBusinessId("ACC001")
//                .setupDepartmentType(DepartmentType.ACCOUNTING)
//                .setupLastYearEvaluation(89)
//
//                .setupNumberOfEmployeesPerDepartment(23)
//                .build()
//            );

        //-----------------------------------------------------------
//        WithAccountingDepartment withAccountingDepartment = WithAccountingDepartment.getNewInstance();

//        boolean acc001 = withAccountingDepartment.create(
//                    new AccountingBuilder().setupDepartmentBusinessId("ACC001")
//                .setupDepartmentType(DepartmentType.ACCOUNTING)
//                .setupLastYearEvaluation(89)
//
//                .setupNumberOfEmployeesPerDepartment(23)
//                .build()
//        );

//        withAccountingDepartment.delete();
//        System.out.printf("%n%s", withAccountingDepartment.get());


//        WithDevelopmentDepartment devDepartment = WithDevelopmentDepartment.getNewInstance();

//        boolean b = devDepartment.create(
//                new DevelopmentBuilder().setupDepartmentBusinessId("DEV001")
//                        .setupDepartmentType(DepartmentType.DEVELOPMENT)
//                        .setupLastYearEvaluation(78)
//                        .setupNumberOfProjectsCompletedLastYear(2)
//                        .setupNumberOfProjectsCompletedThisYear(22)
//                        .setupNumberOfProjectsInWorking(2)
//                        .build()
//        );

//        devDepartment.delete();
//        Development development = devDepartment.get();

//        System.out.printf("%n%s", development);


//        WithSalesDepartment salesDepartment = WithSalesDepartment.getNewInstance();

//        salesDepartment.create(
//                new SalesBuilder().setupDepartmentBusinessId("SALES001")
//                        .setupDepartmentType(DepartmentType.SALES)
//                        .setupLastYearEvaluation(23)
//                        .setupLastYearTargetWasReached(false)
//                        .setupTargetForSalesLastYear(new BigDecimal("44.000"))
//                        .setupTargetForSalesThisYear(new BigDecimal("22.000"))
//                        .build()
//        );

//        salesDepartment.delete();
//        System.out.printf("%n%s", salesDepartment.get());

        //---------------------------------------------------------------------------
//        Development sales001 = new DepartmentBuilder()
//                .setupDepartmentBusinessId("SALES001")
//                .setupDepartmentType(DepartmentType.SALES)
//                .setupLastYearEvaluationOfTheDepartment(99)
//                .constructDevelopmentDepartment()
//                .setupNumberOfProjectsInWorking(2)
//                .setupNumberOfProjectsCompletedThisYear(5)
//                .setupNumberOfProjectsCompletedLastYear(10)
//                .setupNumberOfEmployeesPerDepartment(10)
//                .build();
//
//        System.out.printf("%n%s%n", sales001);

        //-----------------------------------------------------------------------------

//        ReadConfiguration readConfiguration = new ReadConfiguration();
//
//        ApplicationConfig cfg = readConfiguration.loadMainConfig("src/main/resources/app_configuration.yml");
//        System.out.printf("%n%s", cfg.getOptions());

        //-------------------------------------------------------------------------------

//        LOGGER.error(StructuralErrors.PROGRESS_DOTS_MESSAGE_INVALID);
//        LOGGER.warn(InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT);

        //--------------------------------------------------------------------------------


//        System.out.printf("%n%s", InputErrors.IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT
//                .addAdditionalMessage("ERROR my friend, go go go!!")
//        );

        //--------------------------------------------------------------------------------


    }
}
