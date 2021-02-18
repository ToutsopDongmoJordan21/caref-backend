/**
 *
 */
package com.project.caref.audit;


import com.project.caref.security.util.SecurityUtils;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


/**
 * @author alexk
 *
 */
public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		final String uname = SecurityUtils.getCurrentUserLogin();
		return Optional.ofNullable(uname);
	}

}
