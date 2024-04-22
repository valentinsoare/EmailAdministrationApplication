package io.emailadministration.configurationmapper;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ApplicationConfig {
    private String applicationName;
    private String applicationVersion;
    private int numberOfOptionsForMainMenu;

    private Map<String, List<String>> options;

    public ApplicationConfig() {}

    public ApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationName = new String(applicationConfig.getApplicationName());
        this.applicationVersion = new String(applicationConfig.getApplicationVersion());
        this.numberOfOptionsForMainMenu = applicationConfig.getNumberOfOptionsForMainMenu();
        this.options = new HashMap<>(applicationConfig.getOptions());
    }

    public ApplicationConfig getNewInstance(ApplicationConfig applicationConfig) {
        return new ApplicationConfig(applicationConfig);
    }
}
