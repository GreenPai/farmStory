<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
                    
                    <p class="product_tap">
                    	<span class="black_txt"><a href="/farmStory/basket/list.do">전체(${total})</a></span> 
                    	<a href="/farmStory/basket/list.do?cateNo=1">| 과일 |</a> 
                    	<a href="/farmStory/basket/list.do?cateNo=2">야채 |</a> 
                    	<a href="/farmStory/basket/list.do?cateNo=3">곡류</a>  
                    </p>
                    
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
                        	<c:if test="${empty products}">
							    <tr>
							        <td colspan="6">등록된 상품이 없습니다.</td>
							    </tr>
							</c:if>
                        	<c:forEach var="product" items="${products}">
	                        	<tr>
	                        		<td>
	                        			<img src="${pageContext.request.contextPath}/product_images/${product.imagesName}" alt="상품 이미지">
	                        		</td>
	                        		<td>${product.cateName}</td>
	                        		<td><a href="/farmStory/basket/detail.do?prodNo=${product.prodNo}">${product.prodName}</a></td>
	                        		<td>${product.prodDiscount}%</td>
	                        		<td>${product.prodPoint}</td>
	                        		<td> <span style="font-weight: bold;" id="price">${product.prodDiscountPrice}원</span>  <span class="gray_txt_underline">${product.prodPrice}원</span> </td>
	                        	</tr>

                        	</c:forEach>
                        	
                        
                        </tbody>
                        
                    </table>
                </div>
                <div class="page">
                  <p>
                  	<c:if test="${pageGroupDTO.start>1}">
                    <a href="/farmStory/basket/list.do?pg=${pageGroupDTO.start -1}" class="prev">이전</a>
                    </c:if>
                    <c:forEach var="num" begin="${pageGroupDTO.start}" end="${pageGroupDTO.end }">
                    <a href="/farmStory/basket/list.do?pg=${num}" class="num ${currentPage==num ? 'current' : '' }">[${num}]</a>
                    </c:forEach>
                    <c:if test="${pageGroupDTO.end<lastPageNum}">
                    <a href="/farmStory/basket/list.do?pg=${pageGroupDTO.end + 1}" class="next">다음</a>
                    </c:if>
                  	
                  </p>
                </div>
            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>       