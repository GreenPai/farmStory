<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 로그인</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/event/event.css"/>
</head>

<%@ include file="../layout/_header_bg.jsp" %>
<main>
        <section class="left_section">
            <aside>
              <article>
                  <ul>
                      <li>
                          <img src="/farmStory/images/sub_aside_cate4_tit.png" alt="이벤트">
                      </li>
                  </ul>
              </article>
  
              <article>   
                  <ul>
                      <li>
                          <a href="#">
                              <img src="/farmStory/images/sub_cate4_lnb1_ov.png" alt="이벤트">
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
                    <img src="/farmStory/images/sub_nav_tit_cate4_tit1.png" alt="이벤트">
                  </div>
                  <div>
                    <p class="intro">
                       <img src="/farmStory/images/sub_page_nav_ico.gif" alt="이벤트">
                         HOME > 이벤트 > <span class="eco_txt">이벤트&nbsp </span>
                    </p>
                  </div>  
                </div>

                <!-- 이벤트 달력-->
                <div>
                  <div class="calendar_container">
                    <div class="calendar_header">
                        <div id="month"></div>
                        <div>
                          <button id="btntoday">today</button>
                          <button id="btnBack"><i class="fa fa-angle-left"></i></button>
                          <button id="btnNext"><i class="fa fa-angle-right"></i></button>
                        </div>
                    </div>
                    <div class="calendar_dates" id="calendarDates"></div>
                    <script src="/farmStory/js/event.js"></script>
                </div>                  
                
            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>       