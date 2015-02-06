package org.azkfw.document.database.xlsx;

import java.util.Date;

public class WriterOption {

	private String systemName;
	private String subSystemName;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;

	public WriterOption() {
		systemName = null;
		subSystemName = null;
		createUser = null;
		createDate = null;
		updateUser = null;
		updateDate = null;
	}

	public void setSystemName(final String name) {
		systemName = name;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSubSystemName(final String name) {
		subSystemName = name;
	}

	public String getSubSystemName() {
		return subSystemName;
	}

	public void setCreateUser(final String user) {
		createUser = user;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateDate(final Date date) {
		createDate = date;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setUpdateUser(final String user) {
		updateUser = user;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateDate(final Date date) {
		updateDate = date;
	}

	public Date getUpdateDate() {
		return updateDate;
	}
}
