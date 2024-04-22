package io.emailadministration.devcomponents.logging.errorsclasification;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum InputErrors implements ICustomError {
    IMPROPER_GIVEN_TEXT_SHOULD_BE_BACK("improper_given_text_should_be_back", Severities.WARN,
            "INPUT_WARN: Improper input value from user. In this case should be back, please check!"),

    NON_VALID_OPTION_FROM_THOSE_ABOVE("non_valid_option_from_those_above", Severities.WARN,
            "INPUT_WARN: Please use an option from those mentioned above!"),

    IMPROPER_GIVEN_TEXT_SHOULD_BE_QUIT("improper_given_text_should_be_quit", Severities.WARN,
            "INPUT_WARN: Improper input value from user. In this case should be quit, please check!"),

    NULL_OR_EMPTY_TEXT("null_or_empty_text", Severities.WARN,
            "INPUT_WARN: Input value is null or empty. Please provide a proper value!"),

    INCORRECT_NUMERICAL_VALUE("incorrect_numerical_value", Severities.WARN,
            "INPUT_WARN: Input numerical value is not ok. Please provide another one!"),

    NULL_OR_BLANK_USERNAME("null_or_blank_username", Severities.ERROR,
            "INPUT_ERROR: Blank or null value for username, value is not accepted!"),

    NULL_OR_BLANK_MENU_OPTION_GIVEN("null_or_blank_menu_option_to_be_added", Severities.ERROR,
            "INPUT_ERROR: Blank or null value for menu option to be added is not accepted"),

    UNAVAILABLE_MAIN_CONFIG_INPUT_FILE("unavailable_main_config_file", Severities.FATAL,
    "INPUT_ERROR: Issues with main config .yml file from where we load the config."),

    INDEX_FOR_MENU_OPTION_NOT_VALID("index_for_adding_a_menu_option_not_valid", Severities.ERROR,
            "INPUT_ERROR: Index for menu option to add it is not valid!");

    private String content;
    private String name;
    private ISeverity severity;

    InputErrors(String name, ISeverity severity, String content) {
        this.name = name;
        this.severity = severity;
        this.content = content;
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
        return content;
    }
}
