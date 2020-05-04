/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ctechdev.api;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.ctechdev.CtechDeveloper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
public interface CtechdevService extends OpenmrsService {
	
	/**
	 * Returns an item by id. It can be called by any authenticated user. It is fetched in read only
	 * transaction.
	 * 
	 * @param id
	 * @return
	 * @throws APIException
	 */
	@Authorized()
	@Transactional(readOnly = true)
	CtechDeveloper getDeveloperById(Integer id) throws APIException;
	
	/**
	 * Saves an item. Sets the owner to superuser, if it is not set. It can be called by users with
	 * this module's privilege. It is executed in a transaction.
	 * 
	 * @param ctechDeveloper
	 * @return
	 * @throws APIException
	 */
	//@Authorized(CtechdevConfig.MODULE_PRIVILEGE)
	@Transactional
	CtechDeveloper saveDeveloper(CtechDeveloper ctechDeveloper) throws APIException;
	
	@Transactional
	List<CtechDeveloper> getAllDevelopers() throws APIException;
	
	@Transactional
	void deleteDeveloper(Integer id) throws APIException;
	
	@Transactional
	void updateDeveloper(CtechDeveloper developer) throws APIException;
}
