package io.emailadministration;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.dbutils.EntityManagerScope;
import io.emailadministration.devcomponents.auxiliary.position.CPosition;
import io.emailadministration.devcomponents.header.HeaderBuilder;
import io.emailadministration.devcomponents.header.IHeader;
import io.emailadministration.devcomponents.header.frame.HFrameWithContent;
import io.emailadministration.devcomponents.header.message.IStylizedMessage;
import io.emailadministration.devcomponents.header.message.MessageBuilder;
import io.emailadministration.devcomponents.header.message.MessageStyle;
import io.emailadministration.devcomponents.menu.auxmessage.AuxiliaryMessage;
import io.emailadministration.devcomponents.menu.usingmenu.IMenu;
import io.emailadministration.devcomponents.menu.usingmenu.MenuBuilder;
import io.emailadministration.devcomponents.startingtheappeffect.LoadStartingTheAppEffect;
import io.emailadministration.printing.PrintMenu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends DBConnection {
    public static void main( String[] args ) {
        LoadStartingTheAppEffect.start();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        IStylizedMessage usingMyEmail = new MessageBuilder()
                .setupPosition(new CPosition(0, 0,5, 5))
                .setupHeaderMessage("using my email")
                .setupIsMainMessage(true)
                .setupMessageStyle(MessageStyle.MODERN)
                .addStyleToTheMessage(true, true)
                .build();

        IStylizedMessage lovingSendingEmail = new MessageBuilder()
                .setupPosition(new CPosition(0, 0, 0, 0))
                .setupHeaderMessage("loving sending email")
                .setupIsMainMessage(false)
                .setupMessageStyle(MessageStyle.CLASSIC)
                .addStyleToTheMessage(true, true)
                .build();

        HFrameWithContent hFrameWithContent = HFrameWithContent.addClassicFrameWithCharsOnAllSides(
                '-', '|', 40,usingMyEmail,
                new CPosition(0, 2, 16, 2),
                true, lovingSendingEmail);

        IHeader h = new HeaderBuilder().setupFrameWithMessage(hFrameWithContent)
                .setupAllBorders(true)
                .build();

        IMenu m = new MenuBuilder().setupHeader(h)
                .setupPosition(new CPosition(2, 10, 16, 1))
                .setupNumberOfEntriesInTheCurrentMenu(13)
                .setupEntries("add employee, change employee, add user, change user, get employees, get users, " +
                        "remove employee, remove user, change password, " +
                        "change email, set user mailbox capacity, set alternate email address, quit")
                .setupAuxiliaryMessage(
                            new AuxiliaryMessage("please choose an option:",
                                new CPosition(0, 0, 1, 1)
                            )
                    )
                .build();

        PrintMenu.of(m);

        //------------------------------------------------------------
//        Logger.getLogger("org.hibernate").setLevel(Level.INFO);
//
//        DBConnection instanceOfDB = getInstance();
//
//        EntityManager em = instanceOfDB.generateEntityManager(
//                EntityManagerScope.EMAIL_GENERATE
//        );
//
//        EntityTransaction transaction = null;
//
//        try (em) {
//            transaction = em.getTransaction();
//            transaction.begin();
//
//
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
    }
}
