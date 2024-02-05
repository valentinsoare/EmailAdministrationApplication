package io.emailadministration.configurationmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@NoArgsConstructor
public class ReadConfiguration {
    private static Path mainConfigFile = Path.of("configs/app.yml").toAbsolutePath();
    private static Path loggingConfigFile = Path.of("configs/logging.yml").toAbsolutePath();

    static class Inner {
        private static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        private static final ApplicationConfig appConfig = loadMainConfig();
        private static final LoggingConfig loggingConfig = loadConfig(loggingConfigFile.toString(),
                LoggingConfig.class);
        private static final ReadConfiguration reader = new ReadConfiguration();

        private static ApplicationConfig loadMainConfig() {
            ApplicationConfig appConfig = null;

            try {
                appConfig = mapper.readValue(Files.newInputStream(mainConfigFile),
                        ApplicationConfig.class);
            } catch (IOException e) {
                System.out.printf("%nERROR - [ReadConfiguration.loadMainConfig] - %s", e.getMessage());
            }

            return appConfig;
        }
    }

    public static <T> T loadConfig(String configFileLocation, Class<T> typeOfReturn) {
        T config = null;

        try {
            config = Inner.mapper.readValue(Files.newInputStream(Path.of(configFileLocation)),
                    typeOfReturn);
        } catch (IOException e) {
            System.out.printf("%nERROR - [ReadConfiguration.%s.loadConfig] - %s",
                    typeOfReturn.getSimpleName(), e.getMessage());
        }

        return config;
    }

    public static ReadConfiguration getReader() {
        return Inner.reader;
    }

    public static ApplicationConfig getMainApplicationConfig() {
        return Inner.appConfig;
    }
    public static LoggingConfig getLoggingApplicationConfig() {
        return Inner.loggingConfig;
    }

    public static ObjectMapper getObjectMapperForConfig() {
        return Inner.mapper;
    }
}
