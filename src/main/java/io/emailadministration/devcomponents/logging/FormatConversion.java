package io.emailadministration.devcomponents.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class FormatConversion {
    private static final ObjectMapper jsonMapper;
    private static final XmlMapper xmlMapper;
    private static final ObjectMapper yamlMapper;

    private static final FormatConversion formatter;

    static {
        jsonMapper = new ObjectMapper();
        xmlMapper = new XmlMapper();
        yamlMapper = new ObjectMapper(new YAMLFactory());

        jsonMapper.registerModule(new JavaTimeModule());
        xmlMapper.registerModule(new JavaTimeModule());
        yamlMapper.registerModule(new JavaTimeModule());

        formatter = new FormatConversion();
    }

    private FormatConversion() {}

    public <T> String toXML(T object) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(object);
    }

    public <T> String toPrettyXML(T object) throws JsonProcessingException {
        return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    public <T> String toJSON(T object) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(object);
    }

    public <T> String toPrettyJSON(T object) throws JsonProcessingException {
        return jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    public <T> String toYAML(T object) throws JsonProcessingException {
        return yamlMapper.writeValueAsString(object);
    }

    public <T> String toPrettyYAML(T object) throws JsonProcessingException {
        return yamlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    public <T> T toObject(String input, Class<T> clazz, TypeOfFormat inputFormat) throws JsonProcessingException {
        return switch (inputFormat.toString()) {
            case "XML" -> xmlMapper.readValue(input, clazz);
            case "JSON" -> jsonMapper.readValue(input, clazz);
            case "YAML" -> yamlMapper.readValue(input, clazz);
            default -> (T) input.trim();
        };
    }

    public static FormatConversion getFormatter() {
        return formatter;
    }

    public static ObjectMapper getJsonMapper() {
        return jsonMapper;
    }

    public static XmlMapper getXmlMapper() {
        return xmlMapper;
    }

    public static ObjectMapper getYamlMapper() {
        return yamlMapper;
    }
}
