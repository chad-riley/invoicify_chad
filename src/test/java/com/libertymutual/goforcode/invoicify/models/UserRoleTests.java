package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.springframework.security.core.GrantedAuthority;

public class UserRoleTests {

	@Test
	public void test_all_gets_and_sets_for_rate_based_billing() {
		new BeanTester().testBean(UserRole.class);
	}

	@Test
    public void test_that_getAuthorities_returns_correct_authorities() {
        User user = new User();
        List<UserRole> roles = new ArrayList<UserRole>();
        roles.add(new UserRole("ADMIN", user));
        roles.add(new UserRole("CLERK", user));
        user.setRoles(roles);
        
       List<? extends GrantedAuthority> actualRoles = user.getAuthorities().stream().collect(Collectors.toList());
        
       assertThat(actualRoles.get(0).getAuthority()).isEqualTo("ROLE_ADMIN");
        
   }
}
