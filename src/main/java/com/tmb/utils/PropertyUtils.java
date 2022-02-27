package com.tmb.utils;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.InvalidPathForPropertyFileException;
import com.tmb.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils() {

    }

    private static Properties property = new Properties();
    private  static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
//        FileInputStream fis = null;
        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
//            fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(fis);

//            for(Object key : property.keySet()) {
//                CONFIGMAP.put(String.valueOf(key), String.valueOf(property.get(key)));

                for(Map.Entry<Object, Object> entry : property.entrySet()) {
                    CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());//remove trailing and leading spaces
                }
            } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    public static String get(ConfigProperties key) {
        //doing null check for key and value
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("Property name "+ key +" is not found. Please check config.properties file");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
