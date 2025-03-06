<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 로그인</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/event/event.css"/>
</head>

<script>
	const result = ${result};

	if(result == 102){
		alert('관리자 권한이 없습니다.');
	}
</script>

<%@ include file="./layout/_header_bg_intro.jsp" %>
<main>
        <section class="left_section">
            <aside>
              <article>
                  <ul>
                      <li>
                          <img src="/farmStory/images/sub_aside_cate1_tit.png" alt="팜스토리소개" id="">
                      </li>
                  </ul>
              </article>
  
              <article>   
                  <ul>
                      <li>
                          <a href="/farmStory/intro.do">
                              <img src="/farmStory/images/sub_cate1_lnb1_ov.png" alt="인사말">
                          </a>
                      </li>
                      <li>
                          <a href="/farmStory/location.do">
                              <img src="/farmStory/images/sub_cate1_lnb2.png" alt="찾아오시는길">
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
                    <img src="/farmStory/images/sub_nav_tit_cate1_tit1.png" alt="인사말">
                  </div>
                  <div>
                    <p class="intro">
                       <img src="/farmStory/images/sub_page_nav_ico.gif" alt="인사말">
                         HOME > 팜스토리소개 > <span class="eco_txt">인사말&nbsp </span>
                    </p>
                  </div>  
                </div>
                
                
                <div class="content">
                  <div style="margin-top: 40px;">
                      <img src="/farmStory/images/sub_page1_article_txt.png" class="sub_page1_article_txt" alt="건강한 먹거리를 위해 노력합니다.">
                      <br><br>
                      <p>항상 저희 팜스토리를 성원해 주시고 관심을 가져주시는 모든 분들께 감사의 인사를 드리며<br>
                        가정에 건강과 행복이 가득하시길 기원합니다.</p>
                      <br>
    
                      <p>
                        팜스토리는 신선하고 안전한 먹거리로 건강한 삶 만들기에 기여합니다.<br>
                        보다 좋은 농산품을 공급하기 위해 화학비료를 쓰지 않는 건강한 흙에서 유기농업으로 정성을 다해 지은 농사를 통해 믿고 먹을 수 있는 먹거리 제<br>
                        공에 앞장서겠습니다.
                      </p>
                      <br>
    
                      <p class="eco_txt">친환경 농장</p>
                      <p>팜스토리는 경기도 이천에 위치한 10만평 규모의 유기농 제배단지입니다.</p>
                      <br><br>
    
                      <p class="eco_txt">친환경 캠페인</p>
                      <p>팜스토리는 2차 포장재 사용을 줄임으로써 친환경적인 포장과, 친환경적인 소비문화 정착을 위해 노력합니다.</p>
                    </div>
                  </div>
            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>       