package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
/**
 * 商品对各参数模板管理
 * @author Administrator
 *
 */
public interface ItemParamService {
	/**
	 * 根据id查询参数模板
	 * @param cid
	 * @return
	 */
	TaotaoResult getItemparamByCid(long cid);
	/**
	 * 插入新的模板
	 * @param tbItemParam
	 * @return
	 */
	TaotaoResult insertItemparam(TbItemParam tbItemParam);
	
	/**
	 * 查询所有过个参数模板分类
	 * @return
	 */
	EUDataGridResult ItemparamList(int page,int rows);
}
