package com.taotao.rest.service;

import java.util.List;

import com.taotao.pojo.TbContent;

/**
 * 内容管理接口
 * @author Administrator
 *
 */
public interface ContentService {
	
	List<TbContent> getContentList(long contentCid);

}
