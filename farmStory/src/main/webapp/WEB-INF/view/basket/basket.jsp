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
                    <p>장바구니 전체(10)</p>
                    <div class="basket_table">
                      <table>
                        <thead>
                          <th style="width: 76.19px;"><input type="checkbox"></th>
                          <th style="width: 76.19px;">이미지</th>
                          <th style="width: 76.19px;" >종류</th>
                          <th style="width: 148.69px;">상품명</th>
                          <th style="width: 76.19px;" >수량</th>
                          <th style="width: 76.19px;" >할인</th>
                          <th style="width: 76.19px;" >포인트</th>
                          <th style="width: 76.19px;" >가격</th>
                          <th style="width: 76.19px;" >소개</th>
                        </thead>
                        <tbody>
                          <tr class="none_item">
                            <td colspan="8">장바구니에 상품이 없습니다.</td>
                          </tr>
                          <tr>
                            <td><input type="checkbox"></td>
                            <td><img src="/farmStory/images/market_item1.jpg" alt="사과"></td>
                            <td class="table_gray_txt">과일</td>
                            <td>사과 500g</td>
                            <td class="table_gray_txt">1</td>
                            <td class="table_gray_txt">10%</td>
                            <td class="table_gray_txt">40P</td>
                            <td class="table_gray_txt">4,000</td>
                            <td>3,600<span class="table_gray_txt">원</span></td>
                          </tr>
                          <tr>
                            <td><input type="checkbox"></td>
                            <td><img src="/farmStory/images/market_item1.jpg" alt="사과"></td>
                            <td class="table_gray_txt">과일</td>
                            <td>사과 500g</td>
                            <td class="table_gray_txt">1</td>
                            <td class="table_gray_txt">10%</td>
                            <td class="table_gray_txt">40P</td>
                            <td class="table_gray_txt">4,000</td>
                            <td>3,600<span class="table_gray_txt">원</span></td>
                          </tr>
                          <tr>
                            <td><input type="checkbox"></td>
                            <td><img src="/farmStory/images/market_item1.jpg" alt="사과"></td>
                            <td class="table_gray_txt">과일</td>
                            <td>사과 500g</td>
                            <td class="table_gray_txt">1</td>
                            <td class="table_gray_txt">10%</td>
                            <td class="table_gray_txt">40P</td>
                            <td class="table_gray_txt">4,000</td>
                            <td>3,600<span class="table_gray_txt">원</span></td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                </div>

                <div style="margin-top: 10px;" class="total">
                  <button style="float: left; width: 60px; height: 29px;" class="red_btn" type="button">선택삭제</button>
                  <div style="margin: 0px;" class="total_table">
                    <table>
                      <tr>
                        <td colspan="2">전체합계</td>
                      </tr>
                      <tr>
                        <td>상품수</td>
                        <td>1</td>
                      </tr>
                      <tr>
                        <td>상품금액</td>
                        <td>27,000</td>
                      </tr>
                      <tr>
                        <td>할인금액</td>
                        <td>5,0000원</td>
                      </tr>
                      <tr>
                        <td>배송비</td>
                        <td>5,0000원</td>
                      </tr>
                      <tr>
                        <td>포인트</td>
                        <td>4,000</td>
                      </tr>
                      <tr>
                        <td>전체주문금액</td>
                        <td class="red_tt">22,000</td>
                      </tr>

                    </table>
                      <button style="margin-top: 10px;" class="total_red_btn">주문하기</button>
                  </div>
                </div>

                
            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>       