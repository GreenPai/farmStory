<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글목록</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/farm/community.css"/>
</head>

<%@ include file="../layout/_header_bg_community.jsp" %>
        <main id="notice">
        <section class="left_section">
            <aside>
              <article>
                  <ul>
                      <li>
                          <img src="/farmStory/images/sub_aside_cate5_tit.png" alt="커뮤니티">
                      </li>
                  </ul>
              </article>
  
              <article>   
                  <ul>
                      <li>
                        <a href="/farmStory/article/list.do?cate=notice">
                            <img src="/farmStory/images/sub_cate5_lnb1.png" alt="공지사항">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/list.do?cate=food">
                          <img src="/farmStory/images/sub_cate5_lnb2.png" alt="오늘의식단">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/list.do?cate=cook">
                          <img src="/farmStory/images/sub_cate5_lnb3.png" alt="나도요리사">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/list.do?cate=qna1">
                          <img src="/farmStory/images/sub_cate5_lnb4_ov.png" alt="1:1고객문의">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/list.do?cate=qna2">
                          <img src="/farmStory/images/sub_cate5_lnb5.png" alt="자주묻는 질문">
                        </a>
                      </li>
                  </ul>
              </article>
            </aside>
        </section>

        <section class="right_section">
            <article>
                <div>
                  <div class="sub_nav_tit">
                    <img src="/farmStory/images/sub_nav_tit_cate5_tit4.png" alt="1:1고객문의">
                  </div>
                  <div>
                    <p class="intro">
                       <img src="/farmStory/images/sub_page_nav_ico.gif" alt="1:1고객문의">
                         HOME > 커뮤니티 > <span class="eco_txt">고객문의&nbsp </span>
                    </p>
                  </div>  
                </div>
                
                <div>
                  <nav>
                    <h1>글목록</h1>
                    <form action="/farmStory/article/search.do">
                    	<select name="searchType" style="padding: 6px;">
                    	<option value="title">제목</option>
                    	<option value="content">내용</option>
                    	<option value="writer">글쓴이</option>
                    	</select>
                        <input type="text" name="keyword" placeholder="제목 키워드, 글쓴이 검색" style="width: 200px;">
                        <input type="submit" value="검색" style="padding: 6px;">
                    </form>
                  </nav>
                </div>   
                             
                <table border="0" class="list_table">                    
                    <tr>
                        <th class="table_title table_name1">번호</th>
                        <th class="table_title table_name2">제목</th>
                        <th class="table_title table_name3">글쓴이</th>
                        <th class="table_title table_name4">날짜</th>
                        <th class="table_title table_name5">조회</th>
                    </tr>
                     <c:forEach var="article" items="${requestScope.articles}">                   
                    <tr>
                        <td>${pageStartNum}</td>
                        <td><a href="/farmStory/article/view.do?no=${article.no}">${article.title}[${article.comment}]</a></td>
                        <td>${article.nick}</td>
                        <td>${article.wdate}</td>
                        <td>${article.hit}</td>
                    </tr>
                    <c:set var="pageStartNum" value="${pageStartNum-1}"/>
                    </c:forEach>
                </table>
                <div class="page">
                	<c:if test="${pageGroupDTO.start>1}">
                    <a href="farmStory/article/list.do?pg=${pageGroupDTO.start -1}" class="prev">이전</a>
                    </c:if>
                    <c:forEach var="num" begin="${pageGroupDTO.start}" end="${pageGroupDTO.end }">
                    <a href="/farmStory/article/list.do?pg=${num}" class="num ${currentPage==num ? 'current' : '' }">${num}</a>
                    </c:forEach>
                    <c:if test="${pageGroupDTO.end<lastPageNum}">
                    <a href="/farmStory/article/list.do?pg=${pageGroupDTO.end + 1}" class="next">다음</a>
                    </c:if>
					<a href="/farmStory/article/write.do" class="btn btn_Write" style="background-color: #4b545e; border: 1px solid #3B3c3f; float: right; color: #f2f2f2;">글쓰기</a>
                </div>

            </article>
        </section>
    </main>
<%@ include file="../../layout/_footer.jsp" %>   