package com.hezy.config;

import com.mybatisflex.core.datasource.DataSourceDecipher;
import com.mybatisflex.core.datasource.DataSourceProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    
    @Bean
    public DataSourceDecipher decipher(){
        DataSourceDecipher decipher = (property, value) -> {
            //解密用户名，通过编码支持任意加密方式的解密
            if (property == DataSourceProperty.USERNAME) {
                return value.substring(0, 4);
            }
            //解密密码
            else if (property == DataSourceProperty.PASSWORD) {
                return value.substring(0, 6);
            }
            return value;
        };
        return decipher;
    }
}