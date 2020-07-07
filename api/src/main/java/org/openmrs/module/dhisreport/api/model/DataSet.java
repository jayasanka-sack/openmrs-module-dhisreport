package org.openmrs.module.dhisreport.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "dataSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataSet implements Serializable, Identifiable {

	@XmlTransient
	private Integer id;

	@XmlAttribute(name = "id")
	private String uid;

	@XmlAttribute
	private String code;

	@XmlAttribute
	private String name;

	@XmlElement(name = "periodType", required = true)
	private String periodType;

	@XmlTransient
	private String reportUuid;

	@XmlTransient
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
