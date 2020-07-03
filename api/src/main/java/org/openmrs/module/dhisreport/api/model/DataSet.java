package org.openmrs.module.dhisreport.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DataSet implements Serializable, Identifiable {

	private Integer id;

	private String uid;

	private String code;

	private String name;

	private String periodType;

	private String reportUuid;

	private Set<DataElement> dataElements = new HashSet<DataElement>(0);

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public String getReportUuid() {
		return reportUuid;
	}

	public void setReportUuid(String reportUuid) {
		this.reportUuid = reportUuid;
	}

	public Set<DataElement> getDataElements() {
		return dataElements;
	}

	public void setDataElements(Set<DataElement> dataElements) {
		this.dataElements = dataElements;
	}
}
