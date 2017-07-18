package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	
	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;

	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {

		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
		
		List<EUTreeNode> resultList = new ArrayList<>();
	
		for (TbContentCategory tbContentCategory : list) {
			//创建一个节点
			EUTreeNode euTreeNode = new EUTreeNode();
			euTreeNode.setId(tbContentCategory.getId());
			euTreeNode.setText(tbContentCategory.getName());
			euTreeNode.setState(tbContentCategory.getIsParent()?"closed":"open");
			
			resultList.add(euTreeNode);
		}
		
		// TODO Auto-generated method stub
		return resultList;
	}

	
	@Override
	public TaotaoResult insertContentCategory(long parentId, String name) {
		//创建一个pojo
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		//'状态。可选值:1(正常),2(删除)',
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//添加记录
		tbContentCategoryMapper.insert(contentCategory);
		//查看父节点的isParent列是否为true，如果不是true改成true
		TbContentCategory parentCat = tbContentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			//更新父节点
			tbContentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return TaotaoResult.ok(contentCategory);
	}


	@Override
	public TaotaoResult deleteContentCategory(Long parentId, Long id) {
		//创建一个pojo
//		TbContentCategory contentCategory = new TbContentCategory();
//		contentCategory.setParentId(parentId);
//		contentCategory.setId(id);
//		TbContentCategoryExample example = new TbContentCategoryExample();
//		Criteria criteria =  example.createCriteria();
//		criteria.andIdEqualTo(id);
		tbContentCategoryMapper.deleteByPrimaryKey(id);
		//查看父节点的isParent列是否为true，如果不是true改成true
    	TbContentCategory parentCat = tbContentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(parentCat!=null && parentCat.getIsParent()) {
			parentCat.setIsParent(true);
		}
		return TaotaoResult.ok();
	}


	@Override
	public TaotaoResult updateContentCategory(Long id, String name) {
		
		TbContentCategory tbContentCategory = new TbContentCategory();
		tbContentCategory.setId(id);
		tbContentCategory.setName(name);
//		TbContentCategoryExample example = new TbContentCategoryExample();
//		Criteria criteria =  example.createCriteria();
//		criteria.
		tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
		
		return TaotaoResult.ok();
	}

}
