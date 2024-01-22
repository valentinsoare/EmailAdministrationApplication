package io.emailadministration.configurationmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadConfiguration {

    public ReadConfiguration() {}

    static class Inner {
        private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        private static final ApplicationConfig appConfig = loadMainConfig();
        private static final ReadConfiguration reader = new ReadConfiguration();

        private static ApplicationConfig loadMainConfig() {
            ApplicationConfig appConfig = null;

            try {
                appConfig = mapper.readValue(Files.newInputStream(Path.of("/home/vsoare/Documents/projectsLongTerm/EmailAdministrationApplication/src/main/resources/app_configuration.yml")),
                        ApplicationConfig.class);
            } catch (IOException e) {
                System.out.printf("%nERROR - [ReadConfiguration.loadMainConfig] - %s", e.getMessage());
            }

            return appConfig;
        }
    }

    public <T> T loadConfig(String configFile, Class<T> typeOfReturn) {
        T config = null;

        try {
            config = Inner.mapper.readValue(Files.newInputStream(Path.of(configFile)),
                    typeOfReturn);
        } catch (IOException e) {
            System.out.printf("%nERROR - [ReadConfiguration.%s.loadConfig] - %s",
                    typeOfReturn.getClass().getSimpleName(), e.getMessage());
        }

        return config;
    }

    public static ReadConfiguration getReader() {
        return Inner.reader;
    }

    public static ApplicationConfig getMainApplicationConfig() {
        return Inner.appConfig;
    }

    public static ObjectMapper getObjectMapperForConfig() {
        return Inner.mapper;
    }
}
