package io.emailadministration.Printing;


import java.util.Map;

public class CustomPrinting {

    private CustomPrinting() {}

    @SuppressWarnings("unchecked")
    public static <T> String of(Map<String, T> characteristics, String typeOfAccount) {
        StringBuilder output = new StringBuilder(typeOfAccount);

        int j = 0;
        for (Map.Entry<String, T> element : characteristics.entrySet()) {
            output.append(String.format("%s: %s", element.getKey(), element.getValue()));

            if (j++ < characteristics.size() - 1) {
                output.append(", ");
            }
        }

        output.append("]");
        return output.toString();
    }
}
