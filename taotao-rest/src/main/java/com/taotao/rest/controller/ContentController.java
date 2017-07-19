package com.taotao.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.ExceptionUtil;
import com.taotao.pojo.TbContent;
import com.taotao.rest.service.ContentService;
/**
 * 
 * @author wufenbin
 * 2017年7月19日
 */
@RequestMapping("/content")
@Controller
public class ContentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public TaotaoResult getContentList(@PathVariable Long contentCategoryId){
		
		try {
			List<TbContent> list =  contentService.getContentList(contentCategoryId);
			return TaotaoResult.ok(list);
			
		} catch (Exception e) {
			//LOGGER.error(""+e.getMessage());
			e.printStackTrace();
			return TaotaoResult.build(500,ExceptionUtil.getStackTrace(e));
		}
		
	}
}
