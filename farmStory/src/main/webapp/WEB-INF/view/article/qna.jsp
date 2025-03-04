<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글목록</title>
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
                        <a href="/farmStory/article/list.do">
                            <img src="/farmStory/images/sub_cate5_lnb1.png" alt="공지사항">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/write.do">
                          <img src="/farmStory/images/sub_cate5_lnb2.png" alt="오늘의식단">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/view.do">
                          <img src="/farmStory/images/sub_cate5_lnb3.png" alt="나도요리사">
                        </a>
                      </li>
                      <li>
                        <a href="/fartmStory/article/modify.do">
                          <img src="/farmStory/images/sub_cate5_lnb4.png" alt="1:1고객문의">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/qna.do">
                          <img src="/farmStory/images/sub_cate5_lnb5_ov.png" alt="자주묻는 질문">
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
                    <img src="/farmStory/images/sub_nav_tit_cate5_tit5.png" alt="자주묻는질문">
                  </div>
                  <div>
                    <p class="intro">
                       <img src="/farmStory/images/sub_page_nav_ico.gif" alt="자주묻는질문문">
                         HOME > 커뮤니티 > <span class="eco_txt">자주묻는질문&nbsp </span>
                    </p>
                  </div>  
                </div>
                
                <div>
                  <nav>
                    <h1>글목록</h1>
                    <form action="#">
                        <input type="text" name="search" placeholder="제목 키워드, 글쓴이 검색">
                        <input type="submit" value="검색">
                    </form>
                  </nav>
                </div>                
                <table border="0" class="table_notion">                    
                    <tr>
                        <th class="table_title table_name1">번호</th>
                        <th class="table_title table_name2">제목</th>
                        <th class="table_title table_name3">글쓴이</th>
                        <th class="table_title table_name4">날짜</th>
                        <th class="table_title table_name5">조회</th>
                    </tr>                    
                    <tr>
                        <td>1</td>
                        <td><a href="#">반품은 어떻게 해야하나요?</a></td>
                        <td>관리자</td>
                        <td>20-05-12</td>
                        <td>12</td>
                    </tr>
                </table>

                <div class="page">
                    <a href="#" class="prev">이전</a>
                    <a href="#" class="num current">1</a>
                    <a href="#" class="num">2</a>
                    <a href="#" class="num">3</a>
                    <a href="#" class="next">다음</a>

                    <a href="./write.html" class="btn btn_Write" style="background-color: #4b545e; border: 1px solid #3B3c3f; float: right; color: #f2f2f2;">글쓰기</a>
                </div>
            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>   