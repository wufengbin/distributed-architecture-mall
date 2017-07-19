package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
/**
 * 商品对各参数模板管理
 * @author wufenbin
 * 2017年7月19日
 */
public interface ItemService {

	/**
	 * 根据id查询商品信息
	 * @param itemId
	 * @return
	 */
	TbItem getItemById(long itemId);
	/**
	 * 分页查询商品
	 * @param page 起始页码
	 * @param rows 单次查询记录数
	 * @return
	 */
	EUDataGridResult getItemList(int page,int rows);
	/**
	 * 添加商品信息
	 * @param tbItem 商品对象
	 * @return
	 */
	TaotaoResult createItem(TbItem tbItem,String desc,String tbItemParam) throws Exception;

	
	

}
