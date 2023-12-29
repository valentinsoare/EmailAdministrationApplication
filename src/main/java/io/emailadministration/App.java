package io.emailadministration;

import io.emailadministration.DButils.DBConnection;
import io.emailadministration.devcomponents.auxiliary.Position.CPosition;
import io.emailadministration.devcomponents.header.Frame.HFrameWithContent;
import io.emailadministration.devcomponents.header.Header;
import io.emailadministration.devcomponents.header.Message.HMessage;
import io.emailadministration.devcomponents.header.Message.IStylizedMessage;
import io.emailadministration.devcomponents.header.Message.MessageStyle;
import io.emailadministration.devcomponents.startingtheappeffect.LoadStartingTheAppEffect;

import java.util.Optional;

public class App extends DBConnection {
    public static void main( String[] args ) {
        LoadStartingTheAppEffect.start();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Optional<IStylizedMessage> mainMessage = new HMessage("Using My Email", true, MessageStyle.MODERN,
                new CPosition(0, 0, 25, 2))
                .stylizeIt(true, true);

        Optional<IStylizedMessage> secondaryMessage = new HMessage("main menu", false, MessageStyle.CLASSIC,
                new CPosition(0, 2, 6, 2))
                .stylizeIt(false, true);

        HFrameWithContent hFrameWithContent = HFrameWithContent.addClassicFrameWithCharsOnAllSides('-', '|', 60,
                mainMessage.get(), new CPosition(2, 0, 5, 2),
                true, secondaryMessage.get());


        Header h = new Header(true, hFrameWithContent);

        System.out.printf("%s", h);


        //------------------------------------------------------------
//        Logger.getLogger("org.hibernate").setLevel(Level.INFO);

//        DBConnection instanceOfDB = getInstance();
//
//        EntityManager em = instanceOfDB.generateEntityManager(
//                EntityManagerScope.EMAIL_GENERATE
//        );
//
//        EntityTransaction transaction = null;

//        try (em) {
//            transaction = em.getTransaction();
//            transaction.begin();
//
//            HMessage msg = new HMessage("Go Go Go", true,MessageStyle.ASCII,
//                    new CPosition<>(2, 4, 2, 2));
//
//            System.out.printf("%n%s", msg.createAsciiStyleMessage(200, 10));
//
//
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }

//        IStylizedMessage nameOfTheApp = new HMessage("My Email", true,MessageStyle.ASCII,
//                new CPosition<>(1, 10, 10, 5));
//
//        nameOfTheApp.stylizeIt(true, true);
//
//        String s = HFrameWithContent.addingFrame('-', 80,nameOfTheApp,
//                new CPosition<>(2, 2, 2, 2));
//
//        System.out.printf("%n%s", s);

//
//        System.out.printf("%n%s", nameOfTheApp);



    }
}
