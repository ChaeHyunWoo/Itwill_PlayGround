package com.util;

public class MyUtil {

	// ��ü������
	public int getPageCount(int numPerPage, int dataCount) {

		int pageCount = 0;

		pageCount = dataCount / numPerPage;

		if (dataCount % numPerPage != 0) {

			pageCount++;
		}

		return pageCount;

	}

	// ������ ó�� �޼���
	// currentPage : ���� ǥ���� ������  /  totalPage : ��ü ������ ��
	// listUrl : ��ũ�� ������ url(list.jsp)
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {

		int numPerBlock = 5; // ǥ���� ������ ������ 6 7 8 9 10 ������ -> ����Ʈ �ؿ� ������ ��������ȣ ��� ����
		int currentPageSetup;// ���� ���ִ� �� -> ǥ���� ù �������� -1 ���� ��
		int page; // 6 7 8 9 10 -> �����۸�ũ�� �� page index ����

		StringBuffer sb = new StringBuffer();
		
		//�����Ͱ� ���� ��
		if (currentPage == 0 || totalPage == 0) {
			return ""; // null�� ��ȯ
		}

		// list.jsp?pageNum=2
		// list.jsp?searchKey=subject&searchValue=aa&pageNum=2
		if (listUrl.indexOf("?") != -1) {

			listUrl = listUrl + "&";
		} else {
			listUrl = listUrl + "?";
		}

		// 1 2 3 4 5 ������
		// ������ 6 7 8 9 10 ������
		// ������ 11 12 13 14 15 ������
		currentPageSetup = (currentPage / numPerBlock) * numPerBlock;

		if (currentPage % numPerBlock == 0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}

		// ������
		if (totalPage > numPerBlock && currentPageSetup > 0) {

			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">������</a>&nbsp;");
			// <a href="list.jsp?pageNum=5>������</a>
		}

		// �ٷΰ���������(6 7 8 9 10)
		page = currentPageSetup + 1;

		while (page <= totalPage && page <= (currentPageSetup + numPerBlock)) {

			if (page == currentPage) {

				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
				// <font color="Fuchsia">9</font>

			} else {

				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a>&nbsp;");
				// <a href="list.jsp?pageNum=7">7</a>&nbsp;

			}

			page++;
		}

		// ������
		// ������ 6 7 8 9 10 ������
		// ������ 11 12
		if (totalPage - currentPageSetup > numPerBlock) {

			sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">������</a>&nbsp;");
			// <a href="list.jsp?pageNum=11;>������</a>&nbsp;

		}

		return sb.toString();

	}

}
