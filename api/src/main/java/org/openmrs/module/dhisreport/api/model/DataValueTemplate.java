/*
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
package org.openmrs.module.dhisreport.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/** @author bobj */
public class DataValueTemplate implements Serializable {
	private Integer id;
	private String name;
	private DataSet dataSet;
	private DataElement dataElement;
	private String reportDefinitionUuid;
	private String reportDefinitionLabel;
	private Set<Disaggregation> disaggregations = new HashSet<Disaggregation>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DataSet getDataSet() {
		return dataSet;
	}

	public void setDataSet(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	public DataElement getDataElement() {
		return dataElement;
	}

	public void setDataElement(DataElement dataElement) {
		this.dataElement = dataElement;
	}

	public String getReportDefinitionUuid() {
		return reportDefinitionUuid;
	}

	public void setReportDefinitionUuid(String reportDefinitionUuid) {
		this.reportDefinitionUuid = reportDefinitionUuid;
	}

	public String getReportDefinitionLabel() {
		return reportDefinitionLabel;
	}

	public void setReportDefinitionLabel(String reportDefinitionLabel) {
		this.reportDefinitionLabel = reportDefinitionLabel;
	}

	public Set<Disaggregation> getDisaggregations() {
		return disaggregations;
	}

	public void setDisaggregations(Set<Disaggregation> disaggregations) {
		this.disaggregations = disaggregations;
	}
}
