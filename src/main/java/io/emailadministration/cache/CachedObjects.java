package io.emailadministration.cache;

import io.emailadministration.devcomponents.Component;

import java.util.HashMap;
import java.util.Map;

public class CachedObjects {

    private CachedObjects() {}

    private static final Map<String, Component> cachedObjects;

    static {
        cachedObjects = new HashMap<>();
    }

    public static void addObjectInCache(String key, Component item) {
        cachedObjects.put(key, item);
    }

    public static Map<String, Component> loadCachedObjects() {
        return cachedObjects;
    }
}
