package com.infor.model.dimension;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BI_Dim_Service_Department_Mst_View database table.
 * 
 */
@Deprecated
@Entity
@Table(name="BI_Dim_Service_Department_Mst_View")
//@NamedQuery(name="ServiceDepartment.findAll", query="SELECT s FROM ServiceDepartment s")
public class ServiceDepartment implements Serializable {
	private static final long serialVersionUID = 1L;
	private Object department;
	private Object description;
	private Object division;
	private Object manager;
	private Object managerName;

	public ServiceDepartment() {
	}


	@Column(name="Department")
	public Object getDepartment() {
		return this.department;
	}

	public void setDepartment(Object department) {
		this.department = department;
	}


	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = description;
	}


	public Object getDivision() {
		return this.division;
	}

	public void setDivision(Object division) {
		this.division = division;
	}


	public Object getManager() {
		return this.manager;
	}

	public void setManager(Object manager) {
		this.manager = manager;
	}


	@Column(name="manager_name")
	public Object getManagerName() {
		return this.managerName;
	}

	public void setManagerName(Object managerName) {
		this.managerName = managerName;
	}

}