<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/farm/community.css"/>
</head>
<%@ include file="../layout/_header_bg_crop.jsp" %>
<main id="notice">
            <section class="left_section">
                <aside>
              <article>
                  <ul>
                      <li>
                          <img src="/farmStory/images/sub_aside_cate3_tit.png" alt="농작물이야기" >
                      </li>
                  </ul>
              </article>
  
              <article>   
                  <ul>
                      <li>
                          <a href="/farmStory/article/list.do?cate=story">
                              <img src="/farmStory/images/sub_cate3_lnb1.png" alt="농작물이야기">
                          </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/list.do?cate=grow">
                            <img src="/farmStory/images/sub_cate3_lnb2.png" alt="텃밭가꾸기">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/list.do?cate=school">
                            <img src="/farmStory/images/sub_cate3_lnb3_ov.png" alt="귀농학교">
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
                        <img src="/farmStory/images/sub_nav_tit_cate3_tit3.png" alt="귀농학교">
                      </div>
                      <div>
                        <p class="intro">
                           <img src="/farmStory/images/sub_page_nav_ico.gif" alt="귀농학교">
                             HOME > 커뮤니티 > <span class="eco_txt">귀농학교&nbsp </span>
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