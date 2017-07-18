package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;

/**
 * 内容分类管理
 * @author Administrator
 * 2016年9月17日
 * ContentCategoryController.java
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	/**
	 * 内容分类列表查询
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCategoryList(@RequestParam(value="id",defaultValue="0") long parentId){
		List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
		
		return list;
	}
	/**
	 * 添加分类信息
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("/create")
	public TaotaoResult createContentCategory(long parentId,String name){
		
		TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
		return  result;
	}
	
	/**
	 * 物理删除分类信息
	 * @param parentId
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public TaotaoResult deleteContentCategory(Long parentId,Long id){
		TaotaoResult result = contentCategoryService.deleteContentCategory(parentId, id);
		return result;
	}
	/**
	 * 根据id更新分类信息 
	 * @param id 分类id
	 * @param name 分类新名称
	 * @return
	 */
	@RequestMapping("/update")
	public TaotaoResult updateContentCategory(Long id,String name){
		TaotaoResult result = contentCategoryService.updateContentCategory(id, name);
		
		return result;
	}
}
