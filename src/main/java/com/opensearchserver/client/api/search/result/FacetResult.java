/**
 * Copyright 2014-2015 OpenSearchServer Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.opensearchserver.client.api.search.result;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class FacetResult {

	@XmlElement(name = "fieldName")
	public String fieldName;

	@XmlElement(name = "terms")
	public Map<String, Long> terms;

	public FacetResult() {
		terms = null;
		fieldName = null;
	}

	/**
	 * @param fieldName
	 *            the fieldName to set
	 */
	@XmlTransient
	@JsonIgnore
	public FacetResult setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	/**
	 * @param terms
	 *            the terms to set
	 */
	@XmlTransient
	@JsonIgnore
	public void setTerms(Map<String, Long> terms) {
		this.terms = terms;
	}

}