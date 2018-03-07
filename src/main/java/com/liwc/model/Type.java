package com.liwc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "account_type")
public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3853711593995407361L;

	@Id
	@Column(name = "ACCOUNT_TYPE_ID")
	String typeId;

	@Column(name = "ACCOUNT_TYPE_NAME")
	String typeName;

	@Column(name = "ACCOUNT_TYPE_CODE")
	String typeCode;
	
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	@Override
	public String toString(){
		return "typeId="+typeId +",typeName="+typeName+",typeCode="+typeCode;
	}
	
	
}
