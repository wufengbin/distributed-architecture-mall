package com.taotao.common.pojo;

import java.util.List;
/**
 * 自定义返回POJO
 * @author wufenbin
 * 2017年7月19日
 */
public class EUDataGridResult {

	//总数量
	private long total;
	//行数
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
	
}
