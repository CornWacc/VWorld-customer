package com.corn.vworld;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Corn
 * dubbo自动化配置扫描
 */
@EnableDubbo(scanBasePackages = "com.corn.vworld.integration")
@PropertySource("classpath:application-dev.yml")
@Configuration
public class DubboAutoScanConfiguration {
}
