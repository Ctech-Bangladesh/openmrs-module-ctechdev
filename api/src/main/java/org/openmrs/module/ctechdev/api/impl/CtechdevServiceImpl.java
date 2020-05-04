/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ctechdev.api.impl;

import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ctechdev.CtechDeveloper;
import org.openmrs.module.ctechdev.api.CtechdevService;
import org.openmrs.module.ctechdev.api.dao.CtechdevDao;

import java.util.List;

public class CtechdevServiceImpl extends BaseOpenmrsService implements CtechdevService {
	
	CtechdevDao dao;
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(CtechdevDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public CtechDeveloper getDeveloperById(Integer id) throws APIException {
		return dao.getDeveloperById(id);
	}
	
	@Override
	public CtechDeveloper saveDeveloper(CtechDeveloper ctechDeveloper) throws APIException {
		/*if (ctechDeveloper.getOwner() == null) {
			ctechDeveloper.setOwner(userService.getUser(1));
		}*/
		if (ctechDeveloper.getJobid() != null) {
			dao.saveDeveloper(ctechDeveloper);
		}
		return ctechDeveloper;
	}
	
	@Override
	public List<CtechDeveloper> getAllDevelopers() throws APIException {
		return dao.getAllDevelopers();
	}
	
	@Override
	public void deleteDeveloper(Integer id) throws APIException {
		this.dao.deleteDeveloper(id);
	}
	
	@Override
	public void updateDeveloper(CtechDeveloper developer) throws APIException {
		this.dao.updateDeveloper(developer);
	}
}
