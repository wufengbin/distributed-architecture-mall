package com.taotao.common.pojo;

import java.util.List;

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
