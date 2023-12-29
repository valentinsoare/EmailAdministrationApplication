package io.emailadministration.devcomponents.startingtheappeffect;

import io.emailadministration.devcomponents.auxiliary.Position.CPosition;
import io.emailadministration.devcomponents.header.Frame.HFrameWithContent;
import io.emailadministration.devcomponents.header.Message.HMessage;
import io.emailadministration.devcomponents.header.Message.HMessageNullObject;
import io.emailadministration.devcomponents.header.Message.IStylizedMessage;
import io.emailadministration.devcomponents.header.Message.MessageStyle;
import io.emailadministration.devcomponents.loading.LoadingEffect;
import io.emailadministration.devcomponents.loading.LoadingFactory;
import lombok.Getter;

import java.util.Optional;

@Getter
public class LoadStartingTheAppEffect {
    private HMessage message;
    private LoadingEffect progressBar;
    private HFrameWithContent frame;

    public LoadStartingTheAppEffect() {
        loadStylizedMessage();
        loadProgressBar();
        loadFrame();
    }

    private void loadProgressBar() {
        try {
            this.progressBar =
                    LoadingFactory.getLoadEffect("linesdirection", "loading",
                            5);
        } catch (InterruptedException e) {
            System.out.printf("%nERROR - [loadProgressBarStartingTheAppEffect] - %s", e.getMessage());
        }
    }

    private void loadStylizedMessage() {
         Optional<IStylizedMessage> nameOfTheApp = new HMessage("My Email", true, MessageStyle.ASCII,
                new CPosition(2, 10, 10, 5))
                .stylizeIt(true, true);

         if (nameOfTheApp.isPresent()) {
             this.message = nameOfTheApp.get().getCustomizedMessage();
         } else {
             this.message = new HMessageNullObject();
         }
    }

    private void loadFrame() {
         HFrameWithContent.addClassicFrameWithCharsUpAndBellow('-', 80,message,
                new CPosition(2, 0, 2, 2));
    }

    private void runTheEffect() {
        System.out.printf("%s", message);

        try {
            progressBar.loadProgressIndicator(40, 16,
                    1, 2, 35);
        } catch (InterruptedException e) {
            System.out.printf("%nERROR - [runTheAppEffect] - %s", e.getMessage());
        }
    }

    public static void start() {
        new LoadStartingTheAppEffect().runTheEffect();
    }
}
