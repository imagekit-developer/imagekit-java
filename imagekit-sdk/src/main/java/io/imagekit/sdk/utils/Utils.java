package io.imagekit.sdk.utils;

import io.imagekit.sdk.config.Configuration;

import java.io.*;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Utils {

    public static String listToString(List<String> list){
        StringBuilder builder=new StringBuilder();
        for (int i=0; i<list.size(); i++){
            if (null!=list.get(i)) {
                builder.append(list.get(i));
                if (i < list.size() - 1) {
                    builder.append(",");
                }
            }
        }
        return builder.toString();
    }

    public static String fileToBase64(File file){
        String base64File = "";
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a file from file system
            byte fileData[] = new byte[(int) file.length()];
            imageInFile.read(fileData);
            base64File = Base64.getEncoder().encodeToString(fileData);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the file " + ioe);
        }
        return base64File;
    }

    public static byte[] fileToBytes(File file) {
        byte[] bytes=null;
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a file from file system
            bytes = new byte[(int) file.length()];
            imageInFile.read(bytes);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the file " + ioe);
        }
        return bytes;
    }

    public static String bytesToBase64(byte[] fileData){
        String base64File = "";
        base64File = Base64.getEncoder().encodeToString(fileData);
        return base64File;
    }

    /**
     *
     * @param cls is a Class name from which this method will invoke
     * @return it will return object of Configuration class
     * @throws IOException if config.properties file doesn't exists
     */
    public static Configuration getSystemConfig(Class<?> cls) throws IOException{
        Properties properties=new Properties();
        String configFile="config.properties";
        InputStream is=cls.getClassLoader().getResourceAsStream(configFile);
        if (null!=is){
            properties.load(is);
        }
        else {
            throw new FileNotFoundException("Property file '"+configFile+"' not found in classpath");
        }
        Configuration config=new Configuration();
        config.setUrlEndpoint(properties.getProperty("UrlEndpoint"));
        config.setPublicKey(properties.getProperty("PublicKey"));
        config.setPrivateKey(properties.getProperty("PrivateKey"));
        config.validate();
        return config;
    }

    public static Map<String, String> mapListOfStringToString(Map<String, List<String>> listMap) {
        Map<String, String> stringMap = new HashMap<>();
        listMap.forEach((key, value) -> value.forEach(k -> stringMap.put(key, k)));
        return stringMap;
    }

}
