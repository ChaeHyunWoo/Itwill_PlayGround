package com.util;

public class MyUtil {

	// 전체페이지
	public int getPageCount(int numPerPage, int dataCount) {

		int pageCount = 0;

		pageCount = dataCount / numPerPage;

		if (dataCount % numPerPage != 0) {

			pageCount++;
		}

		return pageCount;

	}

	// 페이지 처리 메서드
	// currentPage : 현재 표시할 페이지  /  totalPage : 전체 페이지 수
	// listUrl : 링크를 설정할 url(list.jsp)
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {

		int numPerBlock = 5; // 표시할 페이지 ◀이전 6 7 8 9 10 다음▶ -> 리스트 밑에 나오는 페이지번호 출력 개수
		int currentPageSetup;// ◀에 들어가있는 값 -> 표시할 첫 페이지의 -1 해준 값
		int page; // 6 7 8 9 10 -> 하이퍼링크가 될 page index 숫자

		StringBuffer sb = new StringBuffer();
		
		//데이터가 없을 때
		if (currentPage == 0 || totalPage == 0) {
			return ""; // null값 반환
		}

		// list.jsp?pageNum=2
		// list.jsp?searchKey=subject&searchValue=aa&pageNum=2
		if (listUrl.indexOf("?") != -1) {

			listUrl = listUrl + "&";
		} else {
			listUrl = listUrl + "?";
		}

		// 1 2 3 4 5 다음▶
		// ◀이전 6 7 8 9 10 다음▶
		// ◀이전 11 12 13 14 15 다음▶
		currentPageSetup = (currentPage / numPerBlock) * numPerBlock;

		if (currentPage % numPerBlock == 0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}

		// ◀이전
		if (totalPage > numPerBlock && currentPageSetup > 0) {

			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">◀이전</a>&nbsp;");
			// <a href="list.jsp?pageNum=5>◀이전</a>
		}

		// 바로가기페이지(6 7 8 9 10)
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

		// 다음▶
		// ◀이전 6 7 8 9 10 다음▶
		// ◀이전 11 12
		if (totalPage - currentPageSetup > numPerBlock) {

			sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">다음▶</a>&nbsp;");
			// <a href="list.jsp?pageNum=11;>다음▶</a>&nbsp;

		}

		return sb.toString();

	}

}
