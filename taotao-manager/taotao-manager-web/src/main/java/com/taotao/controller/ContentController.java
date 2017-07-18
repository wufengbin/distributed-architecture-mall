package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired 
	private ContentService contentService;
	
	/**
	 * 分页查询所有分类信息
	 * @param page 页码
	 * @param rows 每页记录数 
	 * @param categoryId 分类id
	 * @return
	 */
	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows,Long categoryId) {
		EUDataGridResult result = contentService.getContentList(page, rows, categoryId);
		return result;
	}

	/**
	 * 添加新的分类信息
	 * @param tbContent
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent tbContent){
		
	    TaotaoResult result = 	contentService.insertContent(tbContent);
	  
		return result;
	}
}
