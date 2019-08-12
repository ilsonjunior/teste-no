package com.ilson.api.no;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ilson Junior
 * @since 12/08/2019
 */

public class NoDTO  implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long	id;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("detail")
	private String detail;
	
	@JsonProperty("parentId")
	private Long parentId;

	@JsonProperty("hasChildren")
	private Boolean hasChildren;

	public NoDTO(NoEntity no) {

		this.id = no.getId();
		this.code = no.getCode();
		this.description = no.getDescription();
		this.detail = no.getDetail();
		this.parentId = no.getParentId();
		this.hasChildren = !no.getNoEntity().isEmpty();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Boolean getHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

}
