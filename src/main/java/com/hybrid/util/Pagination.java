package com.hybrid.util;

public class Pagination {
	/*
	 * read-write
	 */
	private int totalItem; // select count(*) from city
	private int pageNo; // request Parameter pageNo
	/*
	 * read-only
	 */
	private int totalPage;
	private int firstItem;
	private int lastItem;
	private int firstPage;
	private int lastPage;
	/*
	 * read-write
	 */
	private int itemsPerPage = 10;
	private int PagesPerGroup = 10;

	public void calculate() {

		/*
		 * pageNo validation
		 */
		if (pageNo < 1)
			pageNo = 1;

		/*
		 * totalPAge
		 */
		this.totalPage = totalItem / itemsPerPage;
		if (totalItem % itemsPerPage > 0)
			totalPage++;

		/*
		 * pageNo validation
		 */
		if (pageNo > totalPage)
			pageNo = (totalPage == 0) ? 1 : totalPage;

		/*
		 * firstItem
		 */
		firstItem = (pageNo - 1) * itemsPerPage + 1;

		/*
		 * lastItem
		 */
		lastItem = firstItem + itemsPerPage - 1;
		if (lastItem > totalItem)
			lastItem = totalItem;

		/*
		 * firstItem
		 */
		firstPage = (pageNo - 1) / PagesPerGroup * PagesPerGroup + 1;

		/*
		 * lastPage
		 */

		lastPage = ((firstPage + PagesPerGroup - 1) > totalPage) ? totalPage : (firstPage + PagesPerGroup - 1);
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;

		/*
		 * 유도 변수들을 계산
		 */

		calculate();
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(int itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public int getPagesPerGroup() {
		return PagesPerGroup;
	}

	public void setPagesPerGroup(int pagesPerGroup) {
		PagesPerGroup = pagesPerGroup;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getFirstItem() {
		return firstItem;
	}

	public int getLastItem() {
		return lastItem;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public boolean isFirstGroup() {

		return (firstPage == 1) ? true : false;
	}

	public boolean isLastGroup() {
		return (lastPage == totalPage) ? true : false;
	}

}
