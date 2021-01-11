package com.hfxt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-10-22 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="menu" )
public class Menu implements Serializable {

	private static final long serialVersionUID =  4345576666434219801L;

	/**
	 * 节点id
	 */
	@Id
   	@Column(name = "id" )
	private Integer id;

	/**
	 * 父节点id
	 */
   	@Column(name = "m_p_id" )
	private Integer mPId;

	/**
	 * 路由
	 */
   	@Column(name = "m_url" )
	private String mUrl;

	/**
	 * 节点名称
	 */
   	@Column(name = "m_name" )
	private String mName;

	/**
	 * 菜单图标
	 */
   	@Column(name = "m_icon" )
	private String mIcon;

}
