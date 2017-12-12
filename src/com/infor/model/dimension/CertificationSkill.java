package com.infor.model.dimension;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BI_Dim_Certification_Skill_Mst_View database table.
 * 
 */
@Entity
@Table(name="BI_Dim_Certification_Skill_Mst_View")
//@NamedQuery(name="CertificationSkill.findAll", query="SELECT c FROM CertificationSkill c")
public class CertificationSkill implements Serializable {
	private static final long serialVersionUID = 1L;
	private String allcertifications;
	
	private String certificationSkill;
	private String description;

	public CertificationSkill() {
	}


	@Column(length=32)
	public String getAllcertifications() {
		return this.allcertifications;
	}

	public void setAllcertifications(String allcertifications) {
		this.allcertifications = allcertifications;
	}


	@Column(name="certification_skill", nullable=false)
	public Object getCertificationSkill() {
		return this.certificationSkill;
	}

	public void setCertificationSkill(String certificationSkill) {
		this.certificationSkill = certificationSkill;
	}


	public Object getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}