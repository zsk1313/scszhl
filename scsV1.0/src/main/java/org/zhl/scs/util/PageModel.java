package org.zhl.scs.util;

import org.zhl.scs.util.common.ScsConstants;

/**
 *  分页实体 
 */
public class PageModel {
	/** 分页总数据条数  */
	private int recordCount;
	/** 当前页面 */
	private int pageIndex ;
	/** 每页分多少条数据   */
	private int pageSize = ScsConstants.PAGE_DEFAULT_SIZE;
	
	/** 总页数  */
	private int totalSize;

	public int getRecordCount() {
		this.recordCount = Math.max(this.recordCount, 0);
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageIndex() {
		this.pageIndex = this.pageIndex <= 0?1:this.pageIndex;
		/** 判断当前页面是否超过了总页数:如果超过了默认给最后一页作为当前页  */
		this.pageIndex = Math.min(this.pageIndex, this.getTotalSize());
		
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		this.pageSize = Math.max(this.pageSize, ScsConstants.PAGE_DEFAULT_SIZE);
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalSize() {
		if(this.getRecordCount() <=0){
			totalSize = 0 ;
		}else{
			totalSize = (this.getRecordCount() -1)/this.getPageSize() + 1;
		}
		return totalSize;
	}
	
	
	public int getFirstLimitParam(){
		if (getPageIndex() <= 0) {
			return 0;
		}
		return (this.getPageIndex()-1)*this.getPageSize() ;
	}
	
	
	
	
}
