package org.jboss.tools.example.springmvc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class EventGroupDetail implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	public EventGroupDetail() {
	}

	public EventGroupDetail(int USER_ID, int GROUP_ID) {
		this.USER_ID = USER_ID;
		this.GROUP_ID = GROUP_ID;
	}

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private int USER_ID;

	@NotNull
	private int GROUP_ID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public int getGROUP_ID() {
		return GROUP_ID;
	}

	public void setGROUP_ID(int gROUP_ID) {
		GROUP_ID = gROUP_ID;
	}

}