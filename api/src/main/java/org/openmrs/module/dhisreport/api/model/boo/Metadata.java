package org.openmrs.module.dhisreport.api.model.boo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.openmrs.module.dhisreport.api.model.DataSet;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "metadata")
public class Metadata implements Serializable {
	@XmlAttribute(name = "date")
	String date;

	@XmlElementWrapper(name = "dataSets", required = true)
	@XmlElement(name = "dataSet")
	protected Set<DataSet> dataSets;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set<DataSet> getDataSets() {
		return dataSets;
	}

	public void setDataSets(Set<DataSet> dataSets) {
		this.dataSets = dataSets;
	}
}
