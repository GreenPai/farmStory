<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 로그인</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/farm/basket.css"/>
</head>

<%@ include file="../layout/_header_bg.jsp" %>
<main>
        <section class="left_section">
            <aside>
              <article>
                  <ul>
                      <li>
                          <img src="/farmStory/images/sub_aside_cate2_tit.png" alt="장보기" >
                      </li>
                  </ul>
              </article>
  
              <article>   
                  <ul>
                      <li>
                          <a href="/farmStory/basket/list.do">
                              <img src="/farmStory/images/sub_cate2_lnb1_ov.png" alt="장보기">
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
                    <img src="/farmStory/images/sub_nav_tit_cate2_tit1.png" class="sub_nav_tit_cate1_tit2" alt="찾아오시는길">
                  </div>
                  <div>
                    <p class="intro">
                       <img src="/farmStory/images/sub_page_nav_ico.gif" alt="인사말">
                         HOME > 장보기 > <span class="eco_txt">장보기&nbsp </span>
                    </p>
                  </div>  
                </div>
                
                
                <div class="content">
                    <p class="black_bold_txt">기본정보</p>
                    <div class="info">
                      <div class="info_img"> 
                      </div>
                      <div class="info_form">
                        <form action="#">
                          <table>
                            <tr>
                              <td>상품명</td>
                              <td>딸기 500g</td>
                            </tr>
                            <tr>
                              <td>상품코드</td>
                              <td>01</td>
                            </tr>
                            <tr>
                              <td>배송비</td>
                              <td>5,000원<span class="gray_tt"> 3만원 이상 무료배송</span></td>
                            </tr>
                            <tr>
                              <td>판매가격</td>
                              <td>4000원</td>
                            </tr>
                            <tr>
                              <td>구매수량</td>
                              <td><input type="text" style="width: 60px;" value="1"></td>
                            </tr>
                            <tr>
                              <td>합계</td>
                              <td class="red_tt">4,000원</td>
                            </tr>
                            
                          </table>
                        </form>
                      </div>
                      <div class="buttons">
                        <button class="green_btn" type="button">장바구니</button>
                        <button class="red_btn" type="button">바로구매</button>
                      </div>
                    </div>
                </div>

                <div class="detail">
                  <p class="black_title_txt">상품설명</p>
                  <img style="width: 750px; height:1387px;"   src="/farmStory/images/market_detail_sample.jpg" alt="샘플">
                  <p class="black_title_txt">배송정보</p>
                  <p>입금하신 이후 택배송장번호는 SMS(문자서비스)를 통해 고객님께 안내드립니다.</p>
                  <p class="black_title_txt">교환/반품</p>
                  <table>
                    <tbody>
                      <tr>
                        <td>교환 반품이 가능한 경우</td>
                        <td>
                          팜스토리 상품에 하자가 있거나 불량인 경우 <br>
                          채소, 과일, 양곡등의 식품은 만1일 이내 <br>
                          기타 상품은 수령일로부터 영업일 기준 일주일 이내<br>
                          받으신 상품이 표시사항과 다른 경우에는 받으신 날로부터 일주일 이내
                        </td>
                      </tr>
                      <tr>
                        <td>교환 반품이 불가능한 경우</td>
                        <td>
                          신선 식품의 경우 단순히 마음에 들지 않는 경우<br>
                          단순 변심으로 상품이 가치가 훼손돼서 판매가 어려운 경우
                        </td>
                        
                      </tr>
                    </tbody>
                  </table>
                </div>

                
            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>       