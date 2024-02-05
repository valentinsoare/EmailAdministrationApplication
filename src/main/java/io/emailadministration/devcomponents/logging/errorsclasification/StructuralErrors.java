package io.emailadministration.devcomponents.logging.errorsclasification;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum StructuralErrors implements ICustomError {
    NO_VALID_AUXILIARY_MENU_MESSAGE("no_valid_auxiliary_message_for_menu", Severities.FATAL,
            "STRUCT_FATAL: No valid auxiliary message for menu"),

    NO_SECONDARY_MESSAGE_FOR_HEADER("no_secondary_message_for_header", Severities.ERROR,
            "STRUCT_FATAL: No valid secondary message for header"),

    NO_AVAILABLE_FRAME_FOR_HEADER("no_available_frame_for_header", Severities.FATAL,
            "STRUCT_FATAL: No valid frame for header"),

    NULL_OBJECT_FOR_POSITION_ON_HEADER("null_object_for_position_on_header", Severities.ERROR,
    "STRUCT_ERROR: Object provided for position used on header is null"),

    NUMBER_OF_OPTIONS_OUT_OF_SYNC_MENU_CREATION("number_of_menu_options_out_of_sync", Severities.FATAL,
            "STRUCT_FATAL: Number of options provided out of sync to when the menu was created!"),

    NO_VALID_MESSAGE_HEADER("invalid_message_header", Severities.FATAL,
            "STRUCT_FATAL: Message from input is not valid for header!"),

    NO_VALID_SECONDARY_MESSAGE_HEADER("invalid_secondary_message_header", Severities.ERROR,
            "STRUCT_ERROR: Secondary message for header is not valid!"),

    LOADING_MESSAGE_INVALID("message_for_loading_invalid", Severities.ERROR,
            "STRUCT_FATAL: Message for loading bar is not valid!"),

    PROGRESS_DOTS_MESSAGE_INVALID("invalid_message_for_progress_dots", Severities.ERROR,
            "STRUCT_ERROR: Message for loading bar with dots is not valid!"),

    PROGRESS_SQUARE_MESSAGE_INVALID("invalid_message_for_progress_square", Severities.ERROR,
    "STRUCT_ERROR: Message for loading effect with square not valid"),

    MESSAGE_AT_THE_END_FOR_LOADING_INVALID("invalid_message_at_the_end_for_loading", Severities.ERROR,
            "STRUCT_ERROR: Message at the end of loading effect not valid"),

    PROGRESS_FORMS_MESSAGE_INVALID("invalid_message_for_progress_forms", Severities.ERROR,
            "STRUCT_ERROR: Message for loading effect is not valid"),

    MESSAGE_AT_THE_BOTTOM_OF_MENU_INVALID("message_at_the_bottom_of_menu_invalid", Severities.FATAL,
            "STRUCT_FATAL: Message at the bottom of the menu that was given is not valid!"),

    NO_MENU_OPTION_AVAILABLE("no_menu_options", Severities.FATAL,
            "STRUCT_FATAL: No available entries in the menu");

    private String name;
    private String content;
    private ISeverity severity;
    private LocalDate onWhichDate;
    private LocalTime onWhichTime;

    StructuralErrors(String name, ISeverity severity, String content) {
        this.name = name;
        this.content = content;
        this.severity = severity;
    }

    @Override
    public int getNumberOfErrorsDefined() {
        return allErrorsWithinCategory().size();
    }

    @Override
    public ICustomError addAdditionalMessage(String additionalMessage) {
        this.content = String.format("%s, additionalMessage: %s", this.content, additionalMessage);
        return this;
    }

    @Override
    public List<ICustomError> allErrorsWithinCategory() {
        return new ArrayList<>(Arrays.asList(NUMBER_OF_OPTIONS_OUT_OF_SYNC_MENU_CREATION, NO_VALID_MESSAGE_HEADER,
                NO_VALID_SECONDARY_MESSAGE_HEADER, LOADING_MESSAGE_INVALID, PROGRESS_DOTS_MESSAGE_INVALID,
                PROGRESS_SQUARE_MESSAGE_INVALID, MESSAGE_AT_THE_END_FOR_LOADING_INVALID, PROGRESS_FORMS_MESSAGE_INVALID,
                MESSAGE_AT_THE_BOTTOM_OF_MENU_INVALID, NO_MENU_OPTION_AVAILABLE));
    }

    @Override
    public String toString() {
        return content;
    }
}
