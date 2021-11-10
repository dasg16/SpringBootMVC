package com.das.learnings;

public class Family {

	@Override
	public String toString() {
		return "Family [fID=" + fID + ", fName=" + fName + ", fColor=" + fColor + "]";
	}

	public String fID;
	public String fName;
	public String fColor;

	public String getfID() {
		return fID;
	}

	public void setfID(String fID) {
		this.fID = fID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfColor() {
		return fColor;
	}

	public void setfColor(String fColor) {
		this.fColor = fColor;
	}

}
