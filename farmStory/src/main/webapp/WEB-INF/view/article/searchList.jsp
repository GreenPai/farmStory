<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>글목록</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/farm/community.css"/>
</head>
<body>
	<div id="wrapper">
		<%@ include file="../layout/_header_bg.jsp"%>
		<main id="article">
			<section class="list">
				<nav>
					<h1>
						<a href="/farmStory/article/list.do">글목록 전체</a>
					</h1>
					<form action="/farmStory/article/search.do">
						<select name="searchType" style="padding: 6px;">
							<c:if test="${searchType eq 'title'}">
								<option value="title" selected>제목</option>
								<option value="content">내용</option>
								<option value="writer">글쓴이</option>
							</c:if>
							<c:if test="${searchType eq 'content'}">
								<option value="title">제목</option>
								<option value="content" selected>내용</option>
								<option value="writer">글쓴이</option>
							</c:if>
							<c:if test="${searchType eq 'writer'}">
								<option value="title">제목</option>
								<option value="content">내용</option>
								<option value="writer" selected>글쓴이</option>
							</c:if>
						</select> <input type="text" name="keyword" value="${keyword}"
							placeholder="검색 키워드 입력"> <input type="submit" value="검색">
					</form>
				</nav>

				<table border="0">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>날짜</th>
						<th>조회</th>
					</tr>
					<c:forEach var="article" items="${requestScope.articles}">
						<tr>
							<td>${pageStartNum}</td>
							<td><a href="/farmStory/article/view.do">${article.title}[${article.comment}]</a></td>
							<td>${article.nick}</td>
							<td>${article.wdate}</td>
							<td>${article.hit}</td>
						</tr>
						<c:set var="pageStartNum" value="${pageStartNum - 1}" />
					</c:forEach>
				</table>
				<div class="page">
					<c:if test="${pageGroupDTO.start > 1}">
						<a
							href="/farmStory/article/search.do?searchType=${searchType}&keyword=${keyword}&pg=${pageGroupDTO.start - 1}"
							class="prev">이전</a>
					</c:if>
					<c:forEach var="num" begin="${pageGroupDTO.start}"
						end="${pageGroupDTO.end}">
						<a
							href="/farmStory/article/search.do?searchType=${searchType}&keyword=${keyword}&pg=${num}"
							class="num ${currentPage == num ? 'current':''}">${num}</a>
					</c:forEach>
					<c:if test="${pageGroupDTO.end < lastPageNum}">
						<a
							href="/farmStory/article/search.do?searchType=${searchType}&keyword=${keyword}&pg=${pageGroupDTO.end + 1}"
							class="next">다음</a>
					</c:if>
				</div>
				<a href="/farmStory/article/write.do" class="btn btnWrite">글쓰기</a>
			</section>
		</main>
		<%@ include file="../layout/_footer.jsp"%>
	</div>
</body>
</html>