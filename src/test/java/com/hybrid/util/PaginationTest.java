package com.hybrid.util;

import java.util.Scanner;


public class PaginationTest {

	public static void main(String[] args) {
		Pagination paging = new Pagination();
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.print("pageNo = ");
			
			int no = scan.nextInt();

			paging.setPageNo(no);
			paging.setTotalItem(4076);

			for (int i = paging.getFirstItem(); i <= paging.getLastItem(); i++)
				System.out.println("item index = " + i);

			if (!paging.isFirstGroup())
				System.out.print("[이전] ");
			else
				System.out.print("      ");

			for (int j = paging.getFirstPage(); j <= paging.getLastPage(); j++)
				System.out.printf("[%03d] ", j);

			if (!paging.isLastGroup())
				System.out.println("[다음] ");
			else
				System.out.println("      ");
		}

	}

	static void test() {

		Pagination paging = new Pagination();
		for (int i = -2; i < 26; i++) {
			paging.setPageNo(i);
			paging.setTotalItem(250);

			String line = "totalPage = " + paging.getTotalPage() + ",firstGroup = " + paging.isFirstGroup()
					+ ", firstItem = " + paging.getFirstItem() + ", LastItem = " + paging.getLastItem() + ", PageNo = "
					+ paging.getPageNo() + ", FirstPage = " + paging.getFirstPage() + ", LastPage = "
					+ paging.getLastPage() + ", isLastGroup = " + paging.isLastGroup();
			System.out.println(line);
		}

	}

}
