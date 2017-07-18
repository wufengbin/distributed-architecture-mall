package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;
/**
 * 内容分类管理
 * @author Administrator
 *
 */
import com.taotao.common.pojo.TaotaoResult;
public interface ContentCategoryService {
	
	/**
	 * 获取内容分类列表
	 * @param parentId 父节点id
	 * @return
	 */
	List<EUTreeNode> getCategoryList(long parentId);
	
	/**
	 * 添加内容分类
	 * @param parentId 父节点id
	 * @param name 名称
	 * @return
	 */
	TaotaoResult insertContentCategory(long parentId,String name);

	/**
	 * 删除内容分类
	 * @param parentId
	 * @param id
	 * @return
	 */
	TaotaoResult deleteContentCategory(Long parentId,Long id);
	/**
	 * 更新内容
	 * @param id 分类id
	 * @param name 分类新名称
	 * @return
	 */
	TaotaoResult updateContentCategory(Long id,String name);
}
