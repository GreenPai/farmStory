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
                    
                    <p><span class="black_txt">전체(10)</span> | 과일 | 야채 | 곡류</p>
                    
                    <table>
                        <thead>
                            <th>이미지</th>
                            <th>종류</th>
                            <th>상품명</th>
                            <th>할인</th>
                            <th>포인트</th>
                            <th>판매가격</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td><img src="/farmStory/images/market_item1.jpg" alt="사과"></td>
                                <td>과일</td>
                                <td><a href="/farmStory/basket/detail.do">사과 500g</a></td>
                                <td>10%</td>
                                <td>400P</td>
                                <td>
                                  <p>
                                    <span class="tr_b">3,600원</span>
                                    <span class="tr_g">4,000원</span>
                                  </p>
                                </td>
                            </tr>
                            <tr>
                                <td><img src="/farmStory/images/market_item2.jpg" alt="전남 완주 배 5kg"></td>
                                <td>과일</td>
                                <td>전남 완주 배 5kg</td>
                                <td>10%</td>
                                <td>400P</td>
                                <td>
                                  <p>
                                    <span class="tr_b">3,600원</span>
                                    <span class="tr_g">4,000원</span>
                                  </p>
                                </td>
                            </tr>
                            <tr>
                                <td><img src="/farmStory/images/market_item3.jpg" alt="방울 토마토"></td>
                                <td>과일</td>
                                <td>방울토마토</td>
                                <td>10%</td>
                                <td>400P</td>
                                <td>
                                  <p>
                                    <span class="tr_b">3,600원</span>
                                    <span class="tr_g">4,000원</span>
                                  </p>
                                </td>
                            </tr>
                            <tr>
                                <td><img src="/farmStory/images/market_item4.jpg" alt="무농약 현미"></td>
                                <td>곡류</td>
                                <td>우농약 현미</td>
                                <td>10%</td>
                                <td>400P</td>
                                <td>
                                  <p>
                                    <span class="tr_b">3,600원</span>
                                    <span class="tr_g">4,000원</span>
                                  </p>
                                </td>
                            </tr>
                            <tr>
                                <td><img src="/farmStory/images/market_item5.jpg" alt="팜스토리 하루 샐러드"></td>
                                <td>야채</td>
                                <td>팜스토리 하루야채 샐러드</td>
                                <td>10%</td>
                                <td>400P</td>
                                <td>
                                  <p>
                                    <span class="tr_b">3,600원</span>
                                    <span class="tr_g">4,000원</span>
                                  </p>
                                </td>
                            </tr>
                        </tbody>
                        
                    </table>
                </div>
                <div class="page">
                  <p>< [1] [2] [3] [4] [5] ></p>
                </div>
            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>       