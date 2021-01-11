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
@Table ( name ="gameroom" )
public class Gameroom implements Serializable {

	private static final long serialVersionUID =  7079134712988195278L;

	/**
	 * 游戏房间id
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
	 * 房间在线人数
	 */
   	@Column(name = "roompeople" )
	private String roompeople;

	/**
	 * 聊天信息
	 */
   	@Column(name = "chat" )
	private String chat;

	/**
	 * 故事
	 */
   	@Column(name = "story" )
	private String story;

	/**
	 * 座位1
	 */
   	@Column(name = "people1" )
	private String people1;

	/**
	 * 座位2
	 */
   	@Column(name = "people2" )
	private String people2;

	/**
	 * 座位3
	 */
   	@Column(name = "people3" )
	private String people3;

	/**
	 * 座位4
	 */
   	@Column(name = "people4" )
	private String people4;

	/**
	 * 座位5
	 */
   	@Column(name = "people5" )
	private String people5;

	/**
	 * 座位6
	 */
   	@Column(name = "people6" )
	private String people6;

	/**
	 * 所有人的准备状态
	 */
   	@Column(name = "ready" )
	private String ready;

	/**
	 * 是否继续游戏
	 */
   	@Column(name = "ifgo" )
	private String ifgo;

	/**
	 * 创建时间
	 */
	@Column(name = "createtime" )
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createtime;

}
