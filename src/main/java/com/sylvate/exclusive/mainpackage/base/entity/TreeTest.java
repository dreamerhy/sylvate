package com.sylvate.exclusive.mainpackage.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author syLvate
 * @date 2022-07-12 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName ("tree_test")
public class TreeTest  implements Serializable {

	private static final long serialVersionUID =  8318539134009281480L;

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 节点id
	 */
	private String nodeId;

	/**
	 * 节点名称
	 */
	private String nodeName;

	/**
	 * 父节点id
	 */
	private String parentId;

	/**
	 * 层级
	 */
	private String level;

	/**
	 * 模版id
	 */
	private String templateId;

}
