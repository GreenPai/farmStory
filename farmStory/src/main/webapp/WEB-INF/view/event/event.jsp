<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 로그인</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/event/event.css"/>
</head>

<style>
	.calendar_header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 10px 0;
    gap: 5px;  /* 요소 간 간격 추가 */
}

.calendar_header > div:nth-child(1) {
    font-size: 20px;
    font-weight: bold;
}

.calendar_header > div {
    display: flex;
    align-items: center;  /* 버튼 정렬 맞추기 */
    gap: 5px;  /* 버튼 사이 여백 추가 */
}

.calendar_header > div > button {
    min-width: 50px;
    height: 30px;
    border-radius: 10%;
    background-color: rgb(66, 57, 59);
    color: white;
    border: none;
    cursor: pointer;
    display: flex;
    align-items: center;
    justify-content: center;
}

.calendar_header > div > #btntoday {
    margin-right: 8px;
    min-width: 60px;
    font-size: 15px;
    background-color: gray;
    color: white;
}

/* 왼쪽/오른쪽 버튼 아이콘 스타일 */
.calendar_header > div > button i {
    font-size: 18px; /* 아이콘 크기 키우기 */
    color: white;
    display: inline-block; /* 혹시 안 보이면 강제 표시 */
}
	
</style>
<%@ include file="./layout/_header_bg_event.jsp" %>
  <!-- 메인 시작선-->
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
    <!-- 메인 끝선-->
<%@ include file="../layout/_footer.jsp" %>       