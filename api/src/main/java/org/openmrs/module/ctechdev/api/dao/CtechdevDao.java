/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ctechdev.api.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.ctechdev.CtechDeveloper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ctechdev.CtechdevDao")
public class CtechdevDao {
	
	private Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public CtechDeveloper getDeveloperById(Integer id) {
		return (CtechDeveloper) getSession().createCriteria(CtechDeveloper.class).add(Restrictions.eq("id", id))
		        .uniqueResult();
		
	}
	
	public CtechDeveloper saveDeveloper(CtechDeveloper ctechDeveloper) {
		getSession().persist(ctechDeveloper);
		logger.info("Developer saved successfully, Developer details=" + ctechDeveloper);
		return ctechDeveloper;
	}
	
	public void deleteDeveloper(Integer id) {
		CtechDeveloper developer = (CtechDeveloper) getSession().load(CtechDeveloper.class, new Integer(id));
		if (null != developer) {
			getSession().delete(developer);
		}
		logger.info("Developer deleted successfully, Developer details=" + developer);
	}
	
	@SuppressWarnings("unchecked")
	public List<CtechDeveloper> getAllDevelopers() {
		
		List<CtechDeveloper> developerList = getSession().createQuery("from CtechDeveloper as ct order by ct.jobid").list();
		for (CtechDeveloper developer : developerList) {
			logger.info("Developer List::" + developer);
		}
		return developerList;
	}
	
	public void updateDeveloper(CtechDeveloper developer) {
		getSession().update(developer);
		logger.info("Developer updated successfully, Developer Details=" + developer);
	}
}
