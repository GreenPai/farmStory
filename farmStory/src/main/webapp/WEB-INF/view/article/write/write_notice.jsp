<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
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
                            <img src="/farmStory/images/sub_cate5_lnb1_ov.png" alt="공지사항">
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
                          <img src="/farmStory/images/sub_cate5_lnb4.png" alt="1:1고객문의">
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
                        <img src="/farmStory/images/sub_nav_tit_cate5_tit1.png" alt="공지사항">
                      </div>
                      <div>
                        <p class="intro">
                           <img src="/farmStory/images/sub_page_nav_ico.gif" alt="공지사항">
                             HOME > 커뮤니티 > <span class="eco_txt">공지사항&nbsp </span>
                        </p>
                      </div>  
                    </div>

                    <div>
                        <nav>
                            <h1>
                                글쓰기
                            </h1>
                        </nav>
                    </div>
                    <form action="/farmStory/article/write.do" method="post" enctype="multipart/form-data">
                    	<input type="hidden" name="writer" value="${sessUser.uid}" readonly>
                        <table border="0" class="write_table">
                            <tbody>
                                <tr>
                                    <th>제목</th>
                                    <td>
                                        <input type="text" name="title" placeholder="제목을 입력하세요.">
                                    </td>
                                </tr>
                                <tr>
                                    <th>내용</th>
                                    <td>
                                        <textarea name="content"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <th>파일</th>
                                    <td>
                                        <p style="margin-bottom: 6px;">
                                            최대 2개 파일 첨부 가능, 각 파일당 최대 10MB까지 가능
                                        </p>
                                        <input type="file" name="file1">
                                        <input type="file" name="file2">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div>
                            <input type="submit" value="작성완료" class="btn btnComplete" style="position: relative; float: right; border: 1px solid #3b3c3f; background-color:#4b545e ; top: 10px; color: #ffffff;">
                            <a href="/farmStory/article/list.do" class="btn btnCancel" style="position: relative; float: right; top: 10px;">취소</a>
                          </div>
                    </form>
                      
                    
    
                    
    
                    
                </article>
            </section>
        </main>
<%@ include file="../../layout/_footer.jsp" %>    
</html>