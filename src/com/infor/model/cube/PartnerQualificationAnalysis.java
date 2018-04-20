package com.infor.model.cube;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the BI_fact_partner_qualification_analysis_staging database table.
 * 
 */
@Deprecated
@Entity
@Table(name="BI_fact_partner_qualification_analysis_staging")
//@NamedQuery(name="PartnerQualificationAnalysis.findAll", query="SELECT p FROM PartnerQualificationAnalysis p")
public class PartnerQualificationAnalysis implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private BigDecimal certificationCount;

	@JoinTable(name="BI_Dim_Certification_Skill_Mst_View",
			joinColumns = @JoinColumn(name = "certification_skill"))
	private String certificationSkill;

	private Timestamp recordDate;

    @JoinTable(name="BI_Dim_Service_Department_Mst_View",
            joinColumns = @JoinColumn(name = "department"))
	private String serviceDeptartment;
	@JoinTable(name="BI_Dim_Partner_Mst_View",
			joinColumns = @JoinColumn(name = "partner"))
	private String servicePartner;

	private BigDecimal skillCount;
	@JoinTable(name="BI_Dim_Partner_Mst_View",
			joinColumns = @JoinColumn(name = "partner"))
	private String supervisor;

	public PartnerQualificationAnalysis() {
	}

	@Column(name="certification_count")
	public BigDecimal getCertificationCount() {
		return this.certificationCount;
	}

	public void setCertificationCount(BigDecimal certificationCount) {
		this.certificationCount = certificationCount;
	}


	@Column(name="certification_skill")
	public Object getCertificationSkill() {
		return this.certificationSkill;
	}

	public void setCertificationSkill(String certificationSkill) {
		this.certificationSkill = certificationSkill;
	}


	@Column(name="RecordDate")
	public Timestamp getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Timestamp recordDate) {
		this.recordDate = recordDate;
	}


	@Column(name="service_deptartment")
	public Object getServiceDeptartment() {
		return this.serviceDeptartment;
	}

	public void setServiceDeptartment(String serviceDeptartment) {
		this.serviceDeptartment = serviceDeptartment;
	}


	@Column(name="service_partner")
	public Object getServicePartner() {
		return this.servicePartner;
	}

	public void setServicePartner(String servicePartner) {
		this.servicePartner = servicePartner;
	}


	@Column(name="skill_count")
	public BigDecimal getSkillCount() {
		return this.skillCount;
	}

	public void setSkillCount(BigDecimal skillCount) {
		this.skillCount = skillCount;
	}


	public Object getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

}