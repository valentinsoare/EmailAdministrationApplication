package io.emailadministration.devcomponents.errorsclasification;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum InputErrors implements ICustomError {
    IMPROPER_GIVEN_TEXT_SHOULD_BE_BACK("improper_given_text_should_be_back", 3,
            "INPUT_WARN: Improper input value from user. In this case should be back, please check!",
            LocalDate.now(), LocalTime.now()),

    NON_VALID_OPTION_FROM_THOSE_ABOVE("non_valid_option_from_those_above", 3,
            "INPUT_WARN: Please use an option from those mentioned above!",
            LocalDate.now(), LocalTime.now()),

    IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT("improper_given_text_should_be_quit", 3,
            "INPUT_WARN: Improper input value from user. In this case should be quit, please check!",
            LocalDate.now(), LocalTime.now()),

    NULL_OR_EMPTY_TEXT("null_or_empty_text", 3,
            "INPUT_WARN: Input value is null or empty. Please provide a proper value!",
            LocalDate.now(), LocalTime.now()),

    INCORRECT_NUMERICAL_VALUE("incorrect_numerical_value", 3,
            "INPUT_WARN: Input numerical value is not ok. Please provide another one!",
            LocalDate.now(), LocalTime.now()),

    NULL_OR_BLANK_USERNAME("null_or_blank_username", 2,
            "INPUT_ERROR: Blank or null value for username, value is not accepted!",
            LocalDate.now(), LocalTime.now()),

    NULL_OR_BLANK_MENU_OPTION_GIVEN("null_or_blank_menu_option_to_be_added", 2,
            "INPUT_ERROR: Blank or null value for menu option to be added is not accepted",
            LocalDate.now(), LocalTime.now()),

    INDEX_FOR_MENU_OPTION_NOT_VALID("index_for_adding_a_menu_option_not_valid", 2,
            "INPUT_ERROR: Index for menu option to add it is not valid!",
            LocalDate.now(), LocalTime.now());

    private String content;
    private String name;
    private int severity;
    private LocalDate onWhichDate;
    private LocalTime onWhichTime;

    InputErrors(String name, int severity, String content, LocalDate onWhichDate, LocalTime onWhichTime) {
        this.name = name;
        this.severity = severity;
        this.content = content;
        this.onWhichDate = onWhichDate;
        this.onWhichTime = onWhichTime;
    }

    @Override
    public List<ICustomError> allErrorsWithinCategory() {
        return new ArrayList<>(Arrays.asList(NULL_OR_EMPTY_TEXT, INCORRECT_NUMERICAL_VALUE, NULL_OR_BLANK_USERNAME,
                NULL_OR_BLANK_MENU_OPTION_GIVEN, INDEX_FOR_MENU_OPTION_NOT_VALID));
    }

    @Override
    public ICustomError addAdditionalMessage(String additionalMessage) {
        this.content = String.format("%s, additionalMessage: %s", this.content, additionalMessage);
        return this;
    }

    @Override
    public int getNumberOfErrorsDefined() {
        return allErrorsWithinCategory().size();
    }

    @Override
    public String toString() {
        return String.format("%s [%s - %s]", content, onWhichDate, onWhichTime);
    }
}
