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

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class DocumentResult {

	@XmlAttribute
	public Integer pos;

	@XmlAttribute
	public Float score;

	@XmlAttribute
	public Float distance;

	@XmlAttribute
	public Integer collapseCount;

	@XmlAttribute
	public String joinParameter;

	@XmlElement(name = "field")
	public Map<String, List<String>> fields;

	@XmlElement(name = "snippet")
	public Map<String, List<String>> snippets;

	@XmlElement(name = "function")
	public List<FunctionFieldValue> functions;

	@XmlElement(name = "position")
	public List<VectorPosition> positions;

	@XmlElement(name = "join")
	public List<DocumentResult> joins;

	public DocumentResult() {
		fields = null;
		snippets = null;
		functions = null;
		positions = null;
		collapseCount = null;
		pos = null;
		score = null;
		distance = null;
		joins = null;
		joinParameter = null;
	}

	/**
	 * @param pos
	 *            the pos to set
	 */
	public void setPos(Integer pos) {
		this.pos = pos;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(Float score) {
		this.score = score;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(Float distance) {
		this.distance = distance;
	}

	/**
	 * @param collapseCount
	 *            the collapseCount to set
	 */
	public void setCollapseCount(Integer collapseCount) {
		this.collapseCount = collapseCount;
	}

	/**
	 * @param joinParameter
	 *            the joinParameter to set
	 */
	public void setJoinParameter(String joinParameter) {
		this.joinParameter = joinParameter;
	}

	/**
	 * @param fields
	 *            the fields to set
	 */
	public void setFields(Map<String, List<String>> fields) {
		this.fields = fields;
	}

	/**
	 * @param snippets
	 *            the snippets to set
	 */
	public void setSnippets(Map<String, List<String>> snippets) {
		this.snippets = snippets;
	}

	/**
	 * @param functions
	 *            the functions to set
	 */
	public void setFunctions(List<FunctionFieldValue> functions) {
		this.functions = functions;
	}

	/**
	 * @param positions
	 *            the positions to set
	 */
	public void setPositions(List<VectorPosition> positions) {
		this.positions = positions;
	}

	/**
	 * @param joins
	 *            the joins to set
	 */
	public void setJoins(List<DocumentResult> joins) {
		this.joins = joins;
	}

}
