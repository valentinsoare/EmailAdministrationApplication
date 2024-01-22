package io.emailadministration.configurationmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadConfiguration {

    public ReadConfiguration() {}

    static class Inner {
        private Inner() {}

        private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        private static final ApplicationConfig mainConfig = loadMainConfig("src/main/resources/app_configuration.yml");

        private static ApplicationConfig loadMainConfig(String configFile) {
            ApplicationConfig appConfig = null;

            try {
                appConfig = Inner.mapper.readValue(Files.newInputStream(Path.of(configFile)),
                        ApplicationConfig.class);
            } catch (IOException e) {
                System.out.printf("%nERROR - [ReadConfiguration.loadMainConfig] - %s", e.getMessage());
            }

            return appConfig;
        }

        private static final ReadConfiguration reader = new ReadConfiguration();
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

    public static ApplicationConfig getMainConfig() {
        return Inner.mainConfig;
    }
}
