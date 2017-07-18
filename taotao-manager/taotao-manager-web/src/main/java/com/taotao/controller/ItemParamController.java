package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

/**
 * 商品规格参数管理模板
 * @author Administrator
 * 2016年9月12日
 * ItemParamController.java
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	@Autowired
	private ItemParamService itemParamService;
	
	
	/**
	 * 根据id查询参数模板
	 * @param cid 规格参数模板id
	 * @return
	 */
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public TaotaoResult getItemparamByCid(@PathVariable Long cid){
		TaotaoResult result = itemParamService.getItemparamByCid(cid);
		return result;
		
	}
	
	/**
	 * 添加规格参数模板
	 * @param cid 规格参数模板id
	 * @param paramData 规格参数模板数据
	 * @return
	 */
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemparam(@PathVariable Long cid,String paramData){
		TbItemParam tbItemParam = new TbItemParam();
		tbItemParam.setId(cid);
		tbItemParam.setParamData(paramData);
		
		TaotaoResult result =  itemParamService.insertItemparam(tbItemParam);
		return result;
	}
	
	/**
	 * 查询规格参数模板列表
	 * @param page 页数
	 * @param rows 每页记录数
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemParamService.ItemparamList(page, rows);
		//System.out.println(result+"      controller ..........................");
		return result;
	}
	

}
