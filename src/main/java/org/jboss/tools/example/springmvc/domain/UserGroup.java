package org.jboss.tools.example.springmvc.domain;

import java.io.Serializable;

public class UserGroup implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	private String uid;

	private String gid;

	private String uidClicked;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getUidClicked() {
		return uidClicked;
	}

	public void setUidClicked(String uidClicked) {
		this.uidClicked = uidClicked;
	}

}