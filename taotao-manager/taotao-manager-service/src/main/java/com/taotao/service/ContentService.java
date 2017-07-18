package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * 内容管理service
 * @author Administrator
 *
 */
public interface ContentService {
	
	/**
	 * 根据id分类 分页查询内容管理
	 * @param categoryId
	 * @return
	 */
	EUDataGridResult getContentList(int page,int rows,Long categoryId);
	
	/**
	 * 插入内容管理信息
	 * @param tbContent
	 * @return
	 */
	
	TaotaoResult insertContent(TbContent tbContent);

}
