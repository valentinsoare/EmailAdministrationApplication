package io.emailadministration;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.devcomponents.auxiliary.position.PositionBuilder;
import io.emailadministration.devcomponents.header.HeaderBuilder;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.header.frame.HFrameWithContent;
import io.emailadministration.devcomponents.header.message.IStylizedMessage;
import io.emailadministration.devcomponents.header.message.MessageBuilder;
import io.emailadministration.devcomponents.header.message.MessageStyle;

public class App extends DBConnection {
    public static void main( String[] args ) {
//        LoadStartingTheAppEffect.start();

        System.out.print("\033[H\033[2J");
        System.out.flush();

//        Optional<IStylizedMessage> mainMessage = new HMessage("Using My Email", true, MessageStyle.MODERN,
//                new CPosition(0, 0, 25, 2))
//                .stylizeIt(true, true);
//
//        Optional<IStylizedMessage> secondaryMessage = new HMessage("loving sending email", false, MessageStyle.CLASSIC,
//                new CPosition(0, 2, 0, 2))
//                .stylizeIt(true, true);
//
//        HFrameWithContent hFrameWithContent = HFrameWithContent.addClassicFrameWithCharsOnAllSides('-', '|', 40,
//                mainMessage.get(), new CPosition(2, 0, 5, 2),
//                true, secondaryMessage.get());
//
//
//        Header h = new Header(true, hFrameWithContent);
//
//        System.out.printf("%s", h);

        IStylizedMessage usingMyEmail = new MessageBuilder()
                .setupPosition(
                    new PositionBuilder().setupWhiteSpaceUp(0)
                            .setupWhiteSpaceDown(0)
                            .setupWhiteSpaceLeft(5)
                            .setupWhiteSpaceRight(5)
                            .build()
                    )
                .setupHeaderMessage("using my email")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.MODERN)
                .addStyleToTheMessage(true, true)
                .build();

        IStylizedMessage lovingSendingEmail = new MessageBuilder()
                .setupPosition(
                        new PositionBuilder().setupWhiteSpaceUp(0)
                                .setupWhiteSpaceDown(0)
                                .setupWhiteSpaceRight(2)
                                .setupWhiteSpaceLeft(0)
                                .build()
                        )
                .setupHeaderMessage("loving sending email")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();


        HFrameWithContent hFrameWithContent = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 40,usingMyEmail,
                new PositionBuilder().setupWhiteSpaceUp(0)
                        .setupWhiteSpaceDown(2)
                        .setupWhiteSpaceLeft(10)
                        .setupWhiteSpaceRight(2)
                        .build(),
                true, lovingSendingEmail);

        IHeader h = new HeaderBuilder().setupFrameWithMessage(hFrameWithContent)
                .setupAllBorders(true)
                .build();

        System.out.printf("%n%s", h);


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
