/**
 *  Copyright 2012 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of DHIS2 Reporting module.
 *
 *  DHIS2 Reporting module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  DHIS2 Reporting module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with DHIS2 Reporting module.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/
package org.openmrs.module.dhisreport.api.db.hibernate;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.dhisreport.api.DHIS2ReportingException;
import org.openmrs.module.dhisreport.api.db.DHIS2ReportingDAO;
import org.openmrs.module.dhisreport.api.model.*;
import org.openmrs.module.dhisreport.api.utils.Period;
import org.openmrs.module.reporting.dataset.DataSet;
import org.openmrs.module.reporting.dataset.DataSetColumn;
import org.openmrs.module.reporting.dataset.DataSetRow;
import org.openmrs.module.reporting.evaluation.EvaluationContext;
import org.openmrs.module.reporting.evaluation.EvaluationException;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.report.ReportData;
import org.openmrs.module.reporting.report.ReportRequest;
import org.openmrs.module.reporting.report.definition.service.ReportDefinitionService;
import org.springframework.transaction.annotation.Transactional;
import org.openmrs.module.reporting.report.renderer.RenderingMode;
import org.openmrs.module.reporting.report.Report;
import org.openmrs.module.reporting.web.renderers.DefaultWebRenderer;
import org.openmrs.module.reporting.report.service.ReportService;

/**
 * It is a default implementation of {@link DHIS2ReportingDAO}.
 */

public class HibernateDHIS2ReportingDAO implements DHIS2ReportingDAO {

	// query parameters

	private static final String LOCATION = "locationId";

	private static final String START = "startDate";

	private static final String END = "endDate";

	protected final Log log = LogFactory.getLog(this.getClass());

	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public DataElement getDataElement(Integer id) {
		return (DataElement) getCurrentSession().get(DataElement.class, id);
	}

	@Override
	public DataElement saveDataElement(DataElement de) {
		return (DataElement) saveObject(de);
	}

	@Override
	public void deleteDataElement(DataElement de) {
		getCurrentSession().delete(de);
	}

	@Override
	public Disaggregation getDisaggregation(Integer id) {
		return (Disaggregation) getCurrentSession().get(Disaggregation.class,
				id);
	}

	@Override
	public Disaggregation saveDisaggregation(Disaggregation disagg) {
		//		return (Disaggregation) saveObject(disagg);
		return null;
	}

	@Override
	public ReportDefinition getReportDefinition(Integer id) {
		return (ReportDefinition) getCurrentSession().get(
				ReportDefinition.class, id);
	}

	@Override
	public ReportDefinition saveReportDefinition(ReportDefinition rd) {
		//        System.out.println( "sending the report definition for being saved which has period :------"
		//            + rd.getPeriodType() );
		return (ReportDefinition) saveObject(rd);
	}

	@Override
	public Collection<DataElement> getAllDataElements() {
		//		Query query = getCurrentSession().createQuery(
		//				"from DataElement order by name asc");
		//		return (List<DataElement>) query.list();
		return null;
	}

	@Override
	public Collection<Disaggregation> getAllDisaggregations() {
		//		Query query = getCurrentSession().createQuery("from Disaggregation");
		//		return (List<Disaggregation>) query.list();
		return null;
	}

	@Override
	public void deleteDisaggregation(Disaggregation disagg) {
		getCurrentSession().delete(disagg);
	}

	@Override
	public Collection<ReportDefinition> getAllReportDefinitions() {
		//		Query query = getCurrentSession().createQuery(
		//				"from ReportDefinition order by name asc");
		//		return (List<ReportDefinition>) query.list();
		return null;
	}

	@Override
	public void deleteReportDefinition(ReportDefinition rd) {
		getCurrentSession().delete(rd);
	}

	/*
	 * Should evaluateDataValueTemplates
	 * return String
	 * */
	@Override
	public String evaluateDataValueTemplate(DataValueTemplate dvt,
			Period period, Location location, boolean priority)
			throws DHIS2ReportingException {
		//		String queryString = dvt.getQuery();
		//		queryString = queryString.replaceAll("\t", " ");
		//		queryString = queryString.replaceAll("\n", " ");
		//		queryString = queryString.trim();
		//		String mappedUuid = dvt.getMappeddefinitionuuid();
		//		if (queryString == null || queryString.isEmpty()
		//				|| (priority && mappedUuid != null)) {
		//			org.openmrs.module.reporting.report.definition.ReportDefinition rrd = Context
		//					.getService(ReportDefinitionService.class)
		//					.getDefinitionByUuid(dvt.getMappeddefinitionuuid());
		//			try {
		//				return getReport(rrd, dvt.getMappeddefinitionlabel(), location,
		//						period).toString();
		//			} catch (EvaluationException ex) {
		//				log.debug("Evaluation Exception : " + ex.getMessage());
		//			}
		//		}
		//
		//		if (dvt.potentialUpdateDelete()) {
		//			throw new DHIS2ReportingException(
		//					"Attempt to execute potential update/delete query for "
		//							+ dvt.getDataelement().getName() + " : "
		//							+ dvt.getDisaggregation().getName());
		//		}
		//
		//		Query query = getCurrentSession().createSQLQuery(queryString);
		//
		//		List<String> parameters = new ArrayList<String>(Arrays.asList(query
		//				.getNamedParameters()));
		//		// loactionId is optional
		//		if (parameters.contains("locationId")) {
		//			query.setParameter("locationId", location.getId().toString());
		//		}
		//		query.setParameter("startOfPeriod", period.getStartDate());
		//		query.setParameter("endOfPeriod", period.getEndDate());
		//		return query.uniqueResult().toString();
		return null;
	}

	// --------------------------------------------------------------------------------------------------------------
	// Generic methods for DHIS2 identifiable objects
	// --------------------------------------------------------------------------------------------------------------
	public Identifiable getObjectByUid(String uid, Class<?> clazz) {
		Criteria criteria = getCurrentSession().createCriteria(clazz);
		criteria.add(Restrictions.eq("uid", uid));
		return (Identifiable) criteria.uniqueResult();
	}

	@Transactional
	public Identifiable saveReportDefinitionObject(ReportDefinition object) {
		Session session = getCurrentSession();

		// force merge if uid already exists
		Criteria criteria = session.createCriteria(object.getClass());
		criteria.add(Restrictions.eq("uid", object.getUid()));
		ReportDefinition existingObject = (ReportDefinition) criteria
				.uniqueResult();

		if (existingObject != null) {
			session.evict(existingObject);
			existingObject.setPeriodType(object.getPeriodType());
			existingObject.setName(object.getName());
			existingObject.setCode(object.getCode());
			existingObject
					.setDataValueTemplates(object.getDataValueTemplates());

			session.update(existingObject);
			return existingObject;

		}
		session.saveOrUpdate(object);
		return object;
	}

	@Transactional
	public Identifiable saveDataElementObject(DataElement object) {
		Session session = getCurrentSession();
		// force merge if uid already exists

		DataElement existingObject = (DataElement) getObjectByUid(object
				.getUid(), object.getClass());

		if (existingObject != null) {
			existingObject.setName(object.getName());
			existingObject.setCode(object.getCode());

			session.update(existingObject);
			return existingObject;

		}
		// getCurrentSession().saveOrUpdate( object );
		session.save(object);
		return object;
	}

	@Transactional
	public Identifiable saveObject(Identifiable object) {
		Session session = getCurrentSession();
		// force merge if uid already exists
		Identifiable existingObject = getObjectByUid(object.getUid(), object
				.getClass());
		if (existingObject != null) {
			session.evict(existingObject);
			object.setId(existingObject.getId());
			session.load(object, object.getId());
		}
		getCurrentSession().saveOrUpdate(object);
		return object;
	}

	@Override
	public DataElement getDataElementByUid(String uid) {
		return (DataElement) getObjectByUid(uid, DataElement.class);
	}

	@Override
	public Disaggregation getDisaggregationByUid(String uid) {
		return (Disaggregation) getObjectByUid(uid, Disaggregation.class);
	}

	@Override
	public ReportDefinition getReportDefinitionByUid(String uid) {
		return (ReportDefinition) getObjectByUid(uid, ReportDefinition.class);
	}

	@Override
	public ReportDefinition getReportDefinitionByCode(String code) {
		Criteria criteria = getCurrentSession().createCriteria(
				ReportDefinition.class);
		criteria.add(Restrictions.eq("code", code));
		return (ReportDefinition) criteria.uniqueResult();
	}

	@Override
	public DataValueTemplate getDataValueTemplate(Integer id) {
		return (DataValueTemplate) getCurrentSession().get(
				DataValueTemplate.class, id);
	}

	@Override
	public DataValueTemplate saveDataValueTemplate(DataValueTemplate dvt) {
		getCurrentSession().saveOrUpdate(dvt);
		return dvt;
	}

	@Override
	public DataValueTemplate saveDataValueTemplateTest(DataValueTemplate dvt) {

		//		ReportDefinition rd = getReportDefinitionByUid(dvt
		//				.getReportDefinition().getUid());
		//		DataElement de = getDataElementByUid(dvt.getDataelement().getUid());
		//		Disaggregation dis = getDisaggregationByUid(dvt.getDisaggregation()
		//				.getUid());
		//		dvt.setDataelement(de);
		//		dvt.setDisaggregation(dis);
		//		dvt.setReportDefinition(rd);
		//
		//		Criteria criteria = getCurrentSession().createCriteria(
		//				DataValueTemplate.class);
		//		criteria.add(Restrictions.eq("reportDefinition", rd)).add(
		//				Restrictions.eq("dataelement", de)).add(
		//				Restrictions.eq("disaggregation", dis));
		//
		//		DataValueTemplate dvt_db = (DataValueTemplate) criteria.uniqueResult();
		//
		//		if (dvt_db == null) {
		//			getCurrentSession().save(dvt);
		//			return dvt;
		//		} else {
		//			getCurrentSession().saveOrUpdate(dvt);
		//			return dvt_db;
		//		}

		return null;

	}

	@Override
	public Location getLocationByOU_Code(String OU_Code) {
		Criteria criteria = getCurrentSession().createCriteria(Location.class);
		criteria.add(Restrictions.like("name", OU_Code));
		return (Location) criteria.uniqueResult();
	}

	@Override
	public DataElement getDataElementByCode(String code) {

		Criteria criteria = getCurrentSession().createCriteria(
				DataElement.class);
		criteria.add(Restrictions.eq("code", code));
		return (DataElement) criteria.uniqueResult();

	}

	/**
	 * Gets the current hibernate session while taking care of the hibernate 3 and 4 differences.
	 *
	 * @return the current hibernate session.
	 */
	private org.hibernate.Session getCurrentSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (NoSuchMethodError ex) {
			try {
				Method method = sessionFactory.getClass().getMethod(
						"getCurrentSession", null);
				return (org.hibernate.Session) method.invoke(sessionFactory,
						null);
			} catch (Exception e) {
				throw new RuntimeException(
						"Failed to get the current hibernate session", e);
			}
		}
	}

	private Object getReport(
			org.openmrs.module.reporting.report.definition.ReportDefinition repD,
			String label, Location location, Period period)
			throws EvaluationException {
		EvaluationContext context = new EvaluationContext();
		ReportRequest reportRequest = new ReportRequest();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startDate", period.getStartDate());
		param.put("endDate", period.getEndDate());
		if (location.getId() != null) {
			param.put("location", location);
		}
		context.setParameterValues(param);

		reportRequest
				.setReportDefinition(new Mapped<org.openmrs.module.reporting.report.definition.ReportDefinition>(
						repD, context.getParameterValues()));
		ReportDefinitionService rds = Context
				.getService(ReportDefinitionService.class);

		ReportData reportData = rds.evaluate(reportRequest
				.getReportDefinition(), context);
		Object resObj = null;
		for (Map.Entry<String, DataSet> entry : reportData.getDataSets()
				.entrySet()) {
			DataSet map = entry.getValue();
			Iterator<DataSetRow> mapit = map.iterator();
			while (mapit.hasNext()) {
				DataSetRow dsr = mapit.next();
				for (Map.Entry<DataSetColumn, Object> mp : dsr
						.getColumnValues().entrySet()) {
					if (mp.getKey().getLabel().equals(label)) {
						resObj = mp.getValue();
					}
				}
			}
		}
		return resObj;
	}
}
