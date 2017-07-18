package com.taotao.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class PageHelperTest {

	@Test
	public void testPageHelper() {
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	
		//从spring容器中获得Mapper的代理对象
		TbItemMapper itemMapper =  applicationContext.getBean(TbItemMapper.class);
	
		//执行查询 分页
		TbItemExample example =  new TbItemExample();
	
		//分页处理
		PageHelper.startPage(1,10);
		List<TbItem> list = itemMapper.selectByExample(example);
	
		if(list != null && list.size()>0){
			for (TbItem tbItem : list) {
				System.out.println(tbItem.getCid()+"  "+tbItem.getTitle());
				
			}
		}
		
	
		
	
	
	
	
	}

}
