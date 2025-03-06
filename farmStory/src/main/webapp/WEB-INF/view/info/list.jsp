<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 로그인</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/farm/basket.css"/>
</head>

<%@ include file="./layout/_header_bg_myinfo.jsp" %>
<main>
        <section class="left_section">
            <aside>
              <article>
                  <ul>
                      <li>
                          <img src="/farmStory/images/myinfo/myinfo_menu_tit.png" alt="나의정보" >
                      </li>
                  </ul>
              </article>
  
              <article>   
                  <ul>
                      <li>
                          <a href="/farmStory/myinfo/basket.do">
                              <img src="/farmStory/images/myinfo/myinfo_menu1.png" alt="장바구니">
                          </a>
                      </li>
                      <li>
                        <a href="/farmStory/myinfo/list.do">
                            <img src="/farmStory/images/myinfo/myinfo_menu2_ov.png" alt="주문내역">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/myinfo/info.do">
                            <img src="/farmStory/images/myinfo//myinfo_menu3.png" alt="정보수정">
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
                    <img src="/farmStory/images/myinfo/myinfo_nav_tit2.png" class="sub_nav_tit_cate1_tit2" alt="주문내역">
                  </div>
                  <div>
                    <p class="intro">
                       <img src="/farmStory/images/sub_page_nav_ico.gif" alt="인사말">
                         HOME > 나의정보 > <span class="eco_txt">주문내역&nbsp </span>
                    </p>
                  </div>  
                </div>
                
                
                <div class="content">
                    <div class="basket_table">
                      <table>
                        <thead>
                          <th style="width: 76.19px;">주문번호</th>
                          <th style="width: 76.19px;" >이미지</th>
                          <th style="width: 76.19px;">상품명</th>
                          <th style="width: 76.19px;" >판매가격</th>
                          <th style="width: 76.19px;" >수량</th>
                          <th style="width: 76.19px;" >합계</th>
                          <th style="width: 76.19px;" >주문자</th>
                          <th style="width: 140.19px;" >주문일</th>
                          <th style="width: 76.19px;" >확인</th>
                        </thead>
                        <tbody>
	                        <c:if test="${empty orders}">
	                        
		                          <tr class="none_item">
		                            <td colspan="9">상품 구매 내역이 없습니다.</td>
		                          </tr>                          
	                        </c:if>
	                        <c:forEach var="order" items="${orders}">
                        		<tr>
	                        		<td>${order.orderNo}</td>
	                        		<td><img src="${pageContext.request.contextPath}/product_images/${order.sname}" alt="상품 이미지"></td>
	                        		<td>${order.prodName}</td>
	                        		<td>${order.itemPrice}</td>
		                            <td>${order.itemCount}</td>
		                            <td>${order.orderTotalPrice}</td>
		                            <td>${order.orderSender}</td>
		                            <td>${order.orderDate}</td>
		                            <td><a href="/farmStory/basket/detail.do?prodNo=${order.prodNo}">상세확인</a></td>        		
                        		</tr>          		
                        	</c:forEach>
                         
                        </tbody>
                      </table>
                      <div class="page">
	                	<c:if test="${pageGroupDTO.start>1}">
	                    <a href="/farmStory/myinfo/list.do?pg=${pageGroupDTO.start -1}" class="prev">이전</a>
	                    </c:if>
	                    <c:forEach var="num" begin="${pageGroupDTO.start}" end="${pageGroupDTO.end }">
	                    <a href="/farmStory/myinfo/list.do?pg=${num}" class="num ${currentPage==num ? 'current' : '' }">${num}</a>
	                    </c:forEach>
	                    <c:if test="${pageGroupDTO.end<lastPageNum}">
	                    <a href="/farmStory/myinfo/list.do?pg=${pageGroupDTO.end + 1}" class="next">다음</a>
	                    </c:if>
                	  </div>
                    </div>
                </div>

                
            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>       