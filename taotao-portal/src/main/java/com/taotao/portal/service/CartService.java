package com.taotao.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;

public interface CartService {

	/**
	 * 添加购物车
	 * @param itemId
	 * @param num
	 * @param request
	 * @param response
	 * @return
	 */
	TaotaoResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 获取购物车列表
	 * @param request
	 * @param response
	 * @return
	 */
	List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
	/**
	 * 删除购物车
	 * @param itemId
	 * @param request
	 * @param response
	 * @return
	 */
	TaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
