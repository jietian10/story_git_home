package com.hfxt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-10-12 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="roominformation" )
public class Roominformation implements Serializable {

	private static final long serialVersionUID =  2758700811316416399L;

	/**
	 * 房间信息id
	 */
	@Id
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 房间号
	 */
   	@Column(name = "roomid" )
	private Integer roomid;

	/**
	 * 标题
	 */
   	@Column(name = "title" )
	private String title;

	/**
	 * 时间限制
	 */
   	@Column(name = "timelimit" )
	private Integer timelimit;

	/**
	 * 开篇主旨
	 */
   	@Column(name = "openingtheme" )
	private String openingtheme;

	/**
	 * 识别码
	 */
   	@Column(name = "identifier" )
	private String identifier;

	/**
	 * 创建时间
	 */
	@Column(name = "createtime" )
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createtime;

}
