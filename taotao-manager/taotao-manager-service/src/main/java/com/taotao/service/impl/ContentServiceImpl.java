package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired 
	private TbContentMapper tbContentMapper;

	@Override
	public EUDataGridResult getContentList(int page, int rows, Long categoryId) {
		//查询商品列表
		TbContentExample example = new TbContentExample();
		Criteria criteria =  example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		//分页处理
		PageHelper.startPage(page,rows);
		List<TbContent> list = tbContentMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取出记录总条数
		PageInfo<TbContent> pageInfo =new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	
	
	@Override
	public TaotaoResult insertContent(TbContent tbContent) {
		//补全pojo信息
		tbContent.setCreated(new Date());
		tbContent.setUpdated(new Date());
		tbContentMapper.insert(tbContent);
		
		return TaotaoResult.ok();
	}

	

}
