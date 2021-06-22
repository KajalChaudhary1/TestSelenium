package com.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    //Read the properties file in the resource
    //readItem("url")
    // To use create PropertyReader instance and call readItem

    static Properties properties;

    public PropertyReader(){
        loadAllProperties();
    }

    //Load the file from the resource folder
    public void loadAllProperties()
    {
        properties=new Properties();
        //Read the file staging.config.properties

        try{
             //Can Make this function with params
            String fileName= System.getProperty("user.dir")+"/src/main/resources/staging.config.properties";
             properties.load(new FileInputStream(fileName));

        }catch (IOException e){
            throw new RuntimeException("Not able to find the file");

        }

    }

    public static String readItem(String propertyName){
        return properties.getProperty(propertyName);
    }
}
