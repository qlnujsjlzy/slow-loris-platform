package com.supermarket.yun.platform.slowloris.common.utils;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * Properties文件工具类
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/20 19:26
 */
public class PropertiesUtil extends ObjectSwitchHelper {
    private final static Logger LOGGER = LogManager.getLogger();

    private Properties properties;
    private String[] resourcesPaths;
    private String properiesName = "";

    public PropertiesUtil() {

    }

    public PropertiesUtil(String... resourcesPaths) {
        load(resourcesPaths);
    }

    public static PropertiesUtil create(String... resourcesPaths) {
        PropertiesUtil propertiesUtil = new PropertiesUtil(resourcesPaths);
        return propertiesUtil;
    }

    public void load(String... resourcesPaths) {
        this.resourcesPaths = resourcesPaths;
        properties = new Properties();
        for(String location : resourcesPaths) {
            LOGGER.debug("Loading properties file from:" + location);
            InputStream is = null;
            try {
                is = new FileInputStream(getAbsolutePath(location));
                properties.load(is);
            } catch(IOException ex) {
                LOGGER.info("Could not load properties from path:" + location + ", " + ex.getMessage());
            } catch(Exception ex) {
                LOGGER.info("Could not load properties from path:" + location + ", " + ex.getMessage());
            } finally {
                IOUtils.closeQuietly(is);
            }
        }
    }

    /**
     * 更新与删除时指定文件名称
     *
     * @param properiesName
     */
    public void setOptProperiesName(String properiesName) {
        this.properiesName = properiesName;
    }

    @Override
    public Object get(String key) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        }
        return "";
    }

    public String getAbsolutePath(String filename) {
        if (!FileUtil.isAbsolutePath(filename)) {
            filename = PropertiesUtil.class.getClassLoader().getResource(filename).getPath();
        }
        return filename;
    }

    @Override
    public void set(String key, Object value) {
        if (StringUtils.isEmpty(this.properiesName)) {
            this.properiesName = this.resourcesPaths[0];
        }
        InputStream is = null;
        OutputStream os = null;
        Properties p = new Properties();
        try {
            FileUtil.createFile(getAbsolutePath(this.properiesName));
            is = new FileInputStream(getAbsolutePath(this.properiesName));
            p.load(is);
            os = new FileOutputStream(getAbsolutePath(this.properiesName));
            p.setProperty(key, value + "");
            p.store(os, "====配置更新====");
            os.flush();
            os.close();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }
        this.properiesName = "";
    }

    public void set(Map<String, Object> dataMap) {
        if (StringUtils.isEmpty(this.properiesName)) {
            this.properiesName = this.resourcesPaths[0];
        }
        InputStream is = null;
        OutputStream os = null;
        Properties p = new Properties();
        try {
            FileUtil.createFile(getAbsolutePath(this.properiesName));
            is = new FileInputStream(getAbsolutePath(this.properiesName));
            p.load(is);
            os = new FileOutputStream(getAbsolutePath(this.properiesName));
            for(Map.Entry<String, Object> entry : dataMap.entrySet()) {
                p.setProperty(entry.getKey(), entry.getValue() + "");
            }
            p.store(os, "====配置更新====");
            os.flush();
            os.close();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }
        this.properiesName = "";
    }

    @Override
    public boolean remove(String key) {
        if (StringUtils.isEmpty(this.properiesName)) {
            this.properiesName = this.resourcesPaths[0];
        }
        InputStream is = null;
        OutputStream os = null;
        Properties p = new Properties();
        try {
            is = new FileInputStream(getAbsolutePath(this.properiesName));
            p.load(is);
            os = new FileOutputStream(getAbsolutePath(this.properiesName));
            p.remove(key);
            p.store(os, "");
            os.flush();
            os.close();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }
        this.properiesName = "";
        return false;
    }

}
