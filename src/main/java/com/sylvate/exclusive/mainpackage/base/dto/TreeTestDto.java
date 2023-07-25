package com.sylvate.exclusive.mainpackage.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author syLvate
 * @date 2022-07-12 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeTestDto {

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

	/**
	 * 子节点列表
	 */
	private List<TreeTestDto> childList;

}
