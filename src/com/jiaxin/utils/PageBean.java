package com.jiaxin.utils;

import java.util.List;

/**
 * ��ҳ��ʵ����,������page,totalCount,totalPage,limit
 * @author Benson_Tom
 *
 * @param <T>
 */
public class PageBean<T> {
	private int page;//��ǰҳ��
    private int totalCount;//�ܼ�¼��
    private int totalPage;//��ҳ��(�ܼ�¼��/ÿҳ��¼��)
    private int limit;//ÿҳ��¼��
    private List<T> list;//������Ϣ�ļ���
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
    
}
