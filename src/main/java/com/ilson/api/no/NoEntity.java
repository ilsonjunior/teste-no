package com.ilson.api.no;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_no")
public class NoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "no_id", nullable = false, unique = true)
	@JsonProperty("id")
	private Long	id;
	
	@Column(name = "no_code")
	@JsonProperty("code")
	private String code;
	
	@Column(name = "no_description")
	@JsonProperty("description")
	private String description;
	
	@Column(name = "no_detail")
	@JsonProperty("detail")
	private String detail;
	
	@Column(name = "no_parentId")
	@JsonProperty("parentId")
	private Long parentId;
	
    @JoinColumns({@JoinColumn(name = "no_parentId", referencedColumnName = "no_id")})
    @JsonProperty("clildren")
    @OneToMany()
    private List<NoEntity> noEntity;

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public List<NoEntity> getNoEntity() {
		return noEntity;
	}

	public void setNoEntity(List<NoEntity> noEntity) {
		this.noEntity = noEntity;
	}
}
