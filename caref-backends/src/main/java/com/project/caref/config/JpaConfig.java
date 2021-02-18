/**
 *
 */
package com.project.caref.config;

import com.project.caref.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Copyright (c) 2020, Iforce5, All Right Reserved.
 * https://iforce5.com
 * <p>
 * When : 16/09/2020 -- 21:59
 * By : @author alexk
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
}
