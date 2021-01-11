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
@Table ( name ="hallinformation" )
public class Hallinformation implements Serializable {

	private static final long serialVersionUID =  1629007888778814823L;

	/**
	 * 公告id
	 */
	@Id
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 区域
	 */
   	@Column(name = "region" )
	private String region;

	/**
	 * 公告
	 */
   	@Column(name = "announcement" )
	private String announcement;

	/**
	 * 创建时间
	 */
	@Column(name = "createtime" )
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createtime;

}
