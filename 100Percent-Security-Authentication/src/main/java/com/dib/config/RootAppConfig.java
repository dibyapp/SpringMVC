package com.dib.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfig.class, PersistenceConfig.class, SecurityConfig.class})
public class RootAppConfig {

}
