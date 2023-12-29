package io.emailadministration.devcomponents.errorsclasification;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public enum StructuralErrors implements ICustomError {
    NO_VALID_AUXILIARY_MENU_MESSAGE("no_valid_auxiliary_message_for_menu", 1,
            String.format("STRUCT_ERROR, SEV: %s - No valid auxiliary nessage for menu", Severities.ONE)),

    NO_SECONDARY_MESSAGE_FOR_HEADER("no_secondary_message_for_header", 2,
            String.format("STRUCT_ERROR, SEV: %s - No valid secondary message for header", Severities.TWO)),

    NO_AVAILABLE_FRAME_FOR_HEADER("no_available_frame_for_header", 1,
            String.format("STRUCT_ERROR, SEV: %s - No valid frame for header", Severities.ONE)),

    NULL_OBJECT_FOR_POSITION_ON_HEADER("null_object_for_position_on_header", 3,
    String.format("STRUCT_ERROR, SEV: %s - Object provided for position used on header is null", Severities.THREE)),

    NUMBER_OF_OPTIONS_OUT_OF_SYNC_MENU_CREATION("number_of_menu_options_out_of_sync", 1,
            String.format("STRUCT_ERROR, SEV: %s - Number of options provided out of sync to when the menu was created!", Severities.ONE)),

    NO_VALID_MESSAGE_HEADER("invalid_message_header", 1,
            String.format("STRUCT_ERROR, SEV: %s - Message from input is not valid for header!", Severities.ONE)),

    NO_VALID_SECONDARY_MESSAGE_HEADER("invalid_secondary_message_header", 2,
            String.format("STRUCT_ERROR, SEV: %s - Secondary message for header is not valid!", Severities.TWO)),

    LOADING_MESSAGE_INVALID("message_for_loading_invalid", 2,
            String.format("STRUCT_ERROR, SEV: %s - Message for loading bar is not valid!", Severities.TWO)),

    PROGRESS_DOTS_MESSAGE_INVALID("invalid_message_for_progress_dots", 3,
            String.format("STRUCT_ERROR, SEV: %s - Message for loading bar with dots is not valid!", Severities.THREE)),

    PROGRESS_SQUARE_MESSAGE_INVALID("invalid_message_for_progress_square", 3,
    String.format("STRUCT_ERROR, SEV: %s - Message for loading effect with square not valid", Severities.THREE)),

    MESSAGE_AT_THE_END_FOR_LOADING_INVALID("invalid_message_at_the_end_for_loading", 3,
            String.format("STRUCT_ERROR, SEV: %s - Message at the end of loading effect not valid", Severities.THREE)),

    PROGRESS_FORMS_MESSAGE_INVALID("invalid_message_for_progress_forms", 3,
            String.format("STRUCT_ERROR, SEV: %s - Message for loading effect is not valid", Severities.THREE)),

    MESSAGE_AT_THE_BOTTOM_OF_MENU_INVALID("message_at_the_bottom_of_menu_invalid", 3,
            String.format("STRUCT_ERROR, SEV: %s - Message at the bottom of the menu that was given is not valid!", Severities.THREE)),

    NO_MENU_OPTION_AVAILABLE("no_menu_options", 2,
            String.format("STRUCT_ERROR, SEV: %s - No available entries in the menu", Severities.TWO));

    private final String name;
    private final String content;
    private final int severity;

    StructuralErrors(String name, int severity, String content) {
        this.name = name;
        this.content = content;
        this.severity = severity;
    }

    @Override
    public int getNumberOfErrorsDefined() {
        return allErrorsWithinCategory().size();
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
        return this.content;
    }
}
