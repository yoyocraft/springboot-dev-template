package com.youyi.example.constants;

/**
 * @author yoyocraft
 * @date 2024/09/13
 */
public class ConfigConstant {
    /**
     * database 相关
     */
    public static final String DB_CONFIG_FILE = "db.json";

    public static final String DB_TYPE = "spring.datasource.type";
    public static final String DB_DRIVER_CLASS_NAME = "spring.datasource.driver-class-name";
    public static final String DB_URL = "spring.datasource.url";
    public static final String DB_USERNAME = "spring.datasource.username";
    public static final String DB_PASSWORD = "spring.datasource.password";

    public static final String DB_TYPE_VALUE = "com.zaxxer.hikari.HikariDataSource";
    public static final String DB_DRIVER_CLASS_NAME_VALUE = "com.mysql.cj.jdbc.Driver";

    public static final String URL_KEY = "url";
    public static final String USERNAME_KEY = "username";
    public static final String PASSWORD_KEY = "password";

    /**
     * thread pool 相关
     */
    public static final int COMMON_ASYNC_CORE_POOL_SIZE = 10;
    public static final int COMMON_ASYNC_MAX_POOL_SIZE = 20;
    public static final int COMMON_ASYNC_QUEUE_CAPACITY = 100;
    public static final long COMMON_ASYNC_KEEP_ALIVE_SECONDS = 60L;
    public static final String COMMON_ASYNC_THREAD_NAME_FORMAT = "common-async-%s";
}
