package com.taotao.rest.service;

import java.util.List;

import com.taotao.pojo.TbContent;

/**
 * 内容管理接口
 * @author wufenbin
 * 2017年7月19日
 */
public interface ContentService {
	
	/**
	 * 获取内容列表
	 * @param contentCid
	 * @return
	 */
	List<TbContent> getContentList(long contentCid);

}
