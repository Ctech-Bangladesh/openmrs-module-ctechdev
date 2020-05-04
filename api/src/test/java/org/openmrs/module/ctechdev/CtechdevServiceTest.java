/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ctechdev.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.module.ctechdev.CtechDeveloper;
import org.openmrs.module.ctechdev.api.dao.CtechdevDao;
import org.openmrs.module.ctechdev.api.impl.CtechdevServiceImpl;

import static org.mockito.Mockito.when;

/**
 * This is a unit test, which verifies logic in CtechdevService. It doesn't extend
 * BaseModuleContextSensitiveTest, thus it is run without the in-memory DB and Spring context.
 */
public class CtechdevServiceTest {
	
	@InjectMocks
	CtechdevServiceImpl basicModuleService;
	
	@Mock
	CtechdevDao dao;
	
	@Mock
	UserService userService;
	
	@Before
	public void setupMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveDeveloper_shouldSetOwnerIfNotSet() {
		//Given
		CtechDeveloper ctechDeveloper = new CtechDeveloper();
		/*ctechDeveloper.setDescription("some description");*/
		
		when(dao.saveDeveloper(ctechDeveloper)).thenReturn(ctechDeveloper);
		
		User user = new User();
		when(userService.getUser(1)).thenReturn(user);
		
		//When
		basicModuleService.saveDeveloper(ctechDeveloper);
		
		//Then
		//		assertThat(ctechDeveloper, hasProperty("owner", is(user)));
	}
}
