package com.fleet.frontend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.fleet.config.PersistenceJPAConfig;

@Configuration
@Import({PersistenceJPAConfig.class})
public class ContextConfiguration {

}
