package com.muxi.api.terminal.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Terminal extends AbstractEntity {
	
    @Id
	private int logic;
    
    @Column(nullable = false)
    private String serial;
	@Column(nullable = false)
	private String model;
	@Column(nullable = false)
	private String version;
	
	private int sam;
	private String ptId;	
	private Integer plat;
	private Integer mxr;
	private Integer mxf;
	private String verFm;
	
	public Terminal() { }
	
	public void setPtId(String ptId) {
		this.ptId = ptId;
	}
	
	public void setModel(String model) {
		if(IsNullOrEmptySpace(model)) 
			throw new IllegalArgumentException("Version não pode ser nulo");
		this.model = model;
	}
	
	public void setVersion(String version) {
		if(IsNullOrEmptySpace(version)) 
			throw new IllegalArgumentException("Version não pode ser nulo");
		this.version = version;
	}
	
	public void setVerFm(String verFm) {
		this.verFm = verFm;
	}
	
	public void setSerial(String serial) {
		if(IsNullOrEmptySpace(serial)) 
			throw new IllegalArgumentException("Serial não pode ser nulo");
		this.serial = serial;
	}
	
	public void setLogic(int logic) {
		this.logic = logic;
	}
	
	public void setSam(int sam) {
		if(sam < 0)
			throw new IllegalArgumentException("Sam must be equal or greater than 0");
		this.sam = sam;
	}
	
	public void setPlat(int plat) {
		this.plat = plat;
	}
	
	public void setMxr(int mxr) {
		this.mxr = mxr;
	}
	
	public void setMxf(int mxf) {
		this.mxf = mxf;
	}
	
	public int getLogic() {
		return logic;
	}
	
	public int getSam() {
		return sam;
	}
	
	public int getPlat() {
		return plat;
	}
	
	public int getMxr() {
		return mxr;
	}
	
	public int getMxf() {
		return mxf;
	}
	
	public String getPtId() {
		return ptId;
	}
		
	public String getModel() {
		return model;
	}
	
	public String getVersion() {
		return version;
	}
	
	public String getVerFm() {
		return verFm;
	}
	
	public String getSerial() {
		return serial;
	}	
	
	private boolean IsNullOrEmptySpace(String variable) {
		if(variable == null || variable.equals(""))
			return true;
		return false;
	}
}