<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글보기</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/farm/community.css"/>
</head>
<%@ include file="../layout/_header_bg.jsp" %>
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
                            <a href="#">
                                <img src="/farmStory/images/sub_cate5_lnb1.png" alt="공지사항">
                            </a>
                          </li>
                          <li>
                            <a href="#">
                              <img src="/farmStory/images/sub_cate5_lnb2.png" alt="오늘의식단">
                            </a>
                          </li>
                          <li>
                            <a href="#">
                              <img src="/farmStory/images/sub_cate5_lnb3_ov.png" alt="나도요리사">
                            </a>
                          </li>
                          <li>
                            <a href="#">
                              <img src="/farmStory/images/sub_cate5_lnb4.png" alt="1:1고객문의">
                            </a>
                          </li>
                          <li>
                            <a href="#">
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
                        <img src="/farmStory/images/sub_nav_tit_cate5_tit3.png" alt="나도 요리사">
                      </div>
                      <div>
                        <p class="intro">
                           <img src="/farmStory/images/sub_page_nav_ico.gif" alt="공지사항">
                             HOME > 커뮤니티 > <span class="eco_txt">나도요리사&nbsp </span>
                        </p>
                      </div>  
                    </div>

                    <div>
                        <nav>
                            <h1>
                                글보기
                            </h1>
                        </nav>
                    </div>
                   
                    <table border="0">
                        <tbody>
                            <tr>
                                <th>제목</th>
                                <td>
                                    <input type="text" name="title" value="${articleDTO.title}" readonly>
                                </td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td>
                                     <input type="text" name="writer" value="${articleDTO.writer}(${articleDTO.nick})" readonly/>
                                </td>
                            </tr>
                            <tr>
                                <th>파일</th>
                                <td>
                                	
                                    <a href="#" >1</a>
                                    &nbsp;
                                    <span>7</span>
                                    회 다운로드 <br>
                                    <a href="#">교육 운영 관리자료.hwp</a>
                                    &nbsp;
                                    <span>7</span>
                                    회 다운로드 
                                </td>
                            </tr>
                            <tr>
                                <th>내용</th>
                                <td>
                                    <textarea name="content" readonly >${articleDTO.content}</textarea>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
                    <a href="/farmStory/article/delete.do?no=${articleDTO.no}" class="btn btnRemove" >삭제</a>
                     <a href="#" class="btn btnModify">수정</a>
                     <a href="/farmStory/article/list.do" class="btn btnList">목록</a>
                    </div>
                    <!--댓글목록-->
                    <section class="commentList">
                        <h3 class="title">댓글목록</h3>
                        <article>
                            <span class="nick">길동이</span>
                            <span class="date">2024-05-20</span>
                            <p class="content">댓글 샘플 입니다.</p>
                            <div>
                                <a href="#" class="remove">삭제</a>
                                <a href="#" class="modify">수정</a>
                            </div>
                        </article>
                        <p class="empty">등록된 댓글이 없습니다.</p>
                    </section>

                    <!--댓글쓰기-->
                    <section class="commentForm">
                    	<div style="width:728px; border-bottom: 1px dotted #111; margin-top:15px; margin-left:17px;">
	                        <h3 class="title">댓글쓰기</h3>
	                        <form action="#">
	                            <textarea name="content"></textarea>
	                            <div class="btn_div">
	                                <a href="#" class="btn btnCancel">취소</a>
	                                <input type="submit" value="작성완료" class="btn btnComplete">
	                            </div>
	                        </form>
                    	</div>
                    </section>
    
                    
                </article>
            </section>
        </main>
<%@ include file="../layout/_footer.jsp" %>   
