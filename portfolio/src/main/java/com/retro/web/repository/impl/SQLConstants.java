package com.retro.web.repository.impl;

public class SQLConstants {

	public static final String USER_BY_USERNAME="SELECT * FROM `user` WHERE `username`=?";
	
	public static final String INSERT_USER="INSERT INTO `user` (`username`,`password`,`pin`) values (?,?,?)";
	
}
