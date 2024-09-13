package com.youyi.example.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.youyi.example.constants.ConfigConstant;
import com.youyi.example.constants.SymbolConstant;
import com.youyi.example.enums.ReturnCodeEnum;
import com.youyi.example.exception.BusinessException;
import lombok.NonNull;
import org.apache.commons.io.FileUtils;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author yoyocraft
 * @date 2024/09/13
 */
@Component
public class DataSourceConfigLoader implements BeanPostProcessor, EnvironmentAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfigLoader.class);
    @Value("${datasource.config-path}")
    private String configPath;

    private ConfigurableEnvironment environment;

    @Override
    public void setEnvironment(@NonNull Environment environment) {
        this.environment = (ConfigurableEnvironment) environment;
    }

    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (bean instanceof MybatisAutoConfiguration) {
            String config = readDataSourceConfig();
            JSONObject configJson = JSON.parseObject(config);
            Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
            systemEnvironment.put(ConfigConstant.DB_TYPE, ConfigConstant.DB_TYPE_VALUE);
            systemEnvironment.put(ConfigConstant.DB_DRIVER_CLASS_NAME, ConfigConstant.DB_DRIVER_CLASS_NAME_VALUE);
            systemEnvironment.put(ConfigConstant.DB_URL, configJson.getString(ConfigConstant.URL_KEY));
            systemEnvironment.put(ConfigConstant.DB_USERNAME, configJson.getString(ConfigConstant.USERNAME_KEY));
            systemEnvironment.put(ConfigConstant.DB_PASSWORD, configJson.getString(ConfigConstant.PASSWORD_KEY));
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    private String readDataSourceConfig() {
        try {
            String filePath = configPath + SymbolConstant.SLASH + ConfigConstant.DB_CONFIG_FILE;
            return FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error("read datasource config error, configPath: {}", configPath, e);
            throw new BusinessException(ReturnCodeEnum.SYSTEM_ERROR);
        }
    }
}
