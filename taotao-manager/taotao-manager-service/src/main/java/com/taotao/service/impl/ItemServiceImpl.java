package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.visitor.functions.Insert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;

/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月2日上午10:47:14
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}

	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(page,rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取出记录总条数
		PageInfo<TbItem> pageInfo =new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public TaotaoResult createItem(TbItem tbItem,String desc,String tbItemParam) throws Exception {

		//tbitem信息补全
		Long itemId =  IDUtils.genItemId();
		tbItem.setId(itemId);
		//商品状态，1-正常，2-下架，3-删除
		tbItem.setStatus((byte) 1);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		//插入到数据库
		itemMapper.insert(tbItem);
		//添加商品描述信息
		TaotaoResult result = insertItemDesc(tbItem, desc);
		
		if(result.getStatus() != 200){
			throw new Exception();
		}
		
		//向表中添加规格参数数据
		result = insertItemParam(itemId, tbItemParam);
		if(result.getStatus() != 200){
			throw new Exception();
		}
		
		return TaotaoResult.ok();
		
		
	}
	/**
	 * 添加商品描述
	 * @param tbItem 商品其他信息
	 * @param desc  商品描述
	 * @return
	 */
	private TaotaoResult insertItemDesc(TbItem tbItem,String desc){
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemId(tbItem.getId());
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setCreated(new Date());
		tbItemDesc.setUpdated(new Date());
		itemDescMapper.insert(tbItemDesc);
		return TaotaoResult.ok();
		
		
		
	}

	/**
	 * 向表中添加规格参数
	 * @param cid
	 * @param tbItemParam
	 * @return
	 */
	private TaotaoResult insertItemParam(Long cid,String tbItemParam){
		TbItemParamItem tbItemParamItem = new TbItemParamItem();
		
		tbItemParamItem.setId(cid);
		tbItemParamItem.setParamData(tbItemParam);
		tbItemParamItem.setCreated(new Date());
		tbItemParamItem.setUpdated(new Date());
		
		//向表中添加数据
		itemParamItemMapper.insert(tbItemParamItem);

		return TaotaoResult.ok();
		
	}
	

}
