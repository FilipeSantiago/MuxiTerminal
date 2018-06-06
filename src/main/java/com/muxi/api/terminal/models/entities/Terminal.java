package com.muxi.api.terminal.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Terminal {
	
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

	public Terminal(String terminalStr) throws Exception {
		String[] terminalArray = terminalStr.split(";");
		
		setLogic(terminalArray[0]);
		setSerial(terminalArray[1]);
		setModel(terminalArray[2]);
		setSam(terminalArray[3]);
		setPtId(terminalArray[4]);
		setPlat(terminalArray[5]);
		setVersion(terminalArray[6]);
		setMxr(terminalArray[7]);
		setMxf(terminalArray[8]);
		setVerFm(terminalArray[9]);		
	}
	
	public void setPtId(String ptId) {
		this.ptId = ptId;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public void setVerFm(String verFm) {
		this.verFm = verFm;
	}
	
	public void setSerial(String serial) {
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
	
	//Special Setters - String to Int
	
	public void setLogic(String logic) throws Exception {
		this.logic = Integer.parseInt(logic);
	}
	
	public void setSam(String sam) throws Exception {
		int potentialSam = Integer.parseInt(sam);
		if(potentialSam < 0)
			throw new IllegalArgumentException("Sam must be equal or greater than 0");
		
		this.sam = potentialSam;
	}
	
	public void setPlat(String plat) throws Exception {
		if(plat == null)
			this.plat = null;
		else
			this.plat = Integer.parseInt(plat);
	}
	
	public void setMxr(String mxr) throws Exception {
		if(mxr == null)
			this.mxr = null;
		else
			this.mxr = Integer.parseInt(mxr);
	}
	
	public void setMxf(String mxf) throws Exception {
		if(mxf == null)
			this.mxf = null;
		else
			this.mxf = Integer.parseInt(mxf);
	}
	
	// End Special Setters
	
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
}