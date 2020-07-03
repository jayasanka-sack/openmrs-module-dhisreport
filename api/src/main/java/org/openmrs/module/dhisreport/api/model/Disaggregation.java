/*
  Copyright 2012 Society for Health Information Systems Programmes, India (HISP India)

  <p>This file is part of DHIS2 Reporting module.

  <p>DHIS2 Reporting module is free software: you can redistribute it and/or modify it under the
  terms of the GNU General Public License as published by the Free Software Foundation, either
  version 3 of the License, or (at your option) any later version.

  <p>DHIS2 Reporting module is distributed in the hope that it will be useful, but WITHOUT ANY
  WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
  PURPOSE. See the GNU General Public License for more details.

  <p>You should have received a copy of the GNU General Public License along with DHIS2 Reporting
  module. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openmrs.module.dhisreport.api.model;

import java.io.Serializable;

public class Disaggregation implements Serializable {
	private Integer id;
	Category category;
	CategoryOption categoryOption;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CategoryOption getCategoryOption() {
		return categoryOption;
	}

	public void setCategoryOption(CategoryOption categoryOption) {
		this.categoryOption = categoryOption;
	}
}
