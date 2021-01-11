package com.hfxt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-10-12 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="account" )
public class Account implements Serializable {  

	private static final long serialVersionUID =  1036638836600614253L;

	/**
	 * 用户id
	 */
	@Id
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 用户名
	 */
   	@Column(name = "username" )
	private String username;

	/**
	 * 密码
	 */
   	@Column(name = "password" )
	private String password;

	/**
	 * 昵称
	 */
   	@Column(name = "nickname" )
	private String nickname;

	/**
	 * 性别
	 */
   	@Column(name = "sex" )
	private String sex;

	/**
	 * 生日
	 */
   	@Column(name = "birthday" )
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date birthday;

	/**
	 * 个性签名
	 */
   	@Column(name = "signature" )
	private String signature;

	/**
	 * 头像的地址
	 */
   	@Column(name = "avatar" )
	private String avatar;

	/**
	 * 识别码
	 */
   	@Column(name = "idm" )
	private String idm;

	/**
	 * 创建时间
	 */
	@Column(name = "createtime" )
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createtime;


}
