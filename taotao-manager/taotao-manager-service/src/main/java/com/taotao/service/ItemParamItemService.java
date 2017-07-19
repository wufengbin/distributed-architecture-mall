package com.taotao.service;
/**
 * 商品规格参数展示
 * @author wufenbin
 * 2017年7月19日
 */
public interface ItemParamItemService {
	/**
	 * 根据商品id获取商品规格参数
	 * @param itemId
	 * @return
	 */
	String getItemParamById(Long itemId);

}
