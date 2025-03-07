<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/farmStory/js/daumPostcode.js"></script>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 로그인</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/farm/basket.css"/>
</head>
<script>
document.addEventListener('DOMContentLoaded', function(){
	
	let totPrice = `${finalPrice}`;
	
    document.getElementById("pointbtn").addEventListener("click", function(){
        
    	let usePoint = Number(document.getElementById("point1").value);
        let userPoint = Number(document.getElementById("userPoint").value);
        let txt = document.getElementById("pointmsg");
        let point2 = document.getElementById("point2");
        
        if(usePoint <= userPoint){
        	txt.innerText = "포인트를 성공적으로 사용했습니다.";
        	txt.style.color = "green";
        	point2.innerText = usePoint + "p";
        }else{
	        txt.innerText = "소유한 포인트가 부족합니다.";
	        txt.style.color = "red";
        	
        }
    });
});
</script>


<%@ include file="./layout/_header_bg_market.jsp" %>
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
                    <p style="display: inline-block;">장바구니 전체(10)</p>
                    <div class="basket_table">
                      <table>
                        <thead>
                          <th style="width: 80px;" >이미지</th>
                          <th style="width: 76.19px;">종류</th>
                          <th style="width: 224.88px;">상품명</th>
                          <th style="width: 76.19px;">수량</th>
                          <th style="width: 76.19px;">할인</th>
                          <th style="width: 76.19px;">포인트</th>
                          <th style="width: 76.19px;">가격</th>
                          <th style="width: 76.19px;">소계</th>
                        </thead>
                        <tbody>
                          
                          <c:if test="${empty carts}">
		                          <tr class="none_item">
		                            <td colspan="8">장바구니에 상품이 없습니다.</td>
		                          </tr>                          
	                      </c:if>
	                      
	                      <c:forEach var="cart" items="${carts}">
                        		<tr>
		                            <td><img src="${pageContext.request.contextPath}/product_images/${cart.sname}" alt="상품 이미지"></td>
		                            <td class="table_gray_txt">${cart.cateName}</td>
		                            <td>${cart.prodName}</td>
		                            <td class="table_gray_txt">${cart.cartProdCount}</td>
		                            <td class="table_gray_txt">${cart.prodDiscount }%</td>
		                            <td class="table_gray_txt">${cart.prodPoint}P</td>
		                            <td class="table_gray_txt">${cart.prodPrice }원</td>
		                            <td><span style="font-weight:bold;">${cart.prodDiscountPrice}</span><span class="table_gray_txt">원</span></td>
		                        </tr>
                        	</c:forEach>
                         
                        </tbody>
                      </table>
                    </div>
                </div>

	                <div class="total" style="margin-top: 15px;" >
                <form action="/farmStory/basket/order.do" method="post">
                	  <input type="hidden" id="userPoint" value="${userPoint}">
                	  <input type="hidden" name="totalCnt" value="${totalCnt}">
                	  <input type="hidden" name="userPoint" value="${userPoint}">
                	  <input type="hidden" name="userPoint" value="${userPoint}">
                	  <input type="hidden" name="userPoint" value="${userPoint}">
                	  <input type="hidden" name="userPoint" value="${userPoint}">
	                  <div>
	                    <p style="margin-bottom: 10px;">주문번호 입력</p>
	                    <div style="float: left;">
	                   
	                        <table class="order">
	                          <tr>
	                            <td>주문자</td>
	                            <td><input class="input_1" type="text" name="name" required></td>
	                          </tr>
	                          <tr>
	                            <td>휴대폰</td>
	                            <td><input class="input_1" type="text" name="hp" placeholder="010-7777-7777" required></td>
	                          </tr>
	                          <tr>
	                            <td>포인트사용</td>
	                            <td><input class="input_1" type="text" id="point1" name="usePoint" placeholder="0">
	                              <button type="button" id="pointbtn" class="btn_use">사용하기</button>
	                              <p style="margin-top: 5px;" id="pointmsg">사용가능 ${userPoint}</p>
	                            </td>
	                          </tr>
	                          <tr>
	                            <td>받는분</td>
	                            <td><input class="input_1" type="text" name="receiver" required></td>
	                          </tr>
	                          <tr>
	                            <td>연락처</td>
	                            <td>
	                              <input class="input_1" type="text" name="receiverHp" required>
	                            </td>
	                          </tr>
	                          <tr>
	                            <td>배송주소</td>
	                            <td class="address_input">
			                        <input type="text" name="zip" id="zip" class="input_1" required readonly placeholder="우편번호"/><br>
			                        <button class="address_btn" type="button" onclick="daumPostcode()"><img src="/farmStory/images/chk_post.gif" alt="우편번호찾기"/></button>
			                        <input type="text" name="addr1" id="addr1" class="input_2" required readonly placeholder="주소 검색"/>
			                        <input type="text" name="addr2" id="addr2"class="input_2" required placeholder="상세주소 입력"/>
			                    </td>
	                          </tr>
	                          <tr>
	                            <td>결제방법</td>
	                            <td>
	                              <input type="radio" name="payment" id="payment_bank" value="계좌이체" checked>
	                              <label for="payment_bank">계좌이체</label>
	                              <input type="radio" name="payment" id="payment_credit" value="신용카드">
	                              <label for="payment_credit">신용카드</label>
	                              <input type="radio" name="payment" id="payment_check" value="체크카드">
	                              <label for="payment_check">체크카드</label>
	                              <input type="radio" name="payment" id="payment_phone" value="휴대폰">
	                              <label for="payment_phone">휴대폰</label>
	      
	                            </td>
	                          </tr>
	                          <tr>
	                            <td>기타</td>
	                            <td><textarea style="width: 322px; height: 62px;" name="other_info"></textarea></td>
	                          </tr>
	                        </table>
	                       
	                    </div>
	                  </div>
	                  <div style="margin: 0px;" class="total_table">
	                    <table>
	                      <tr>
	                        <td colspan="2">최종결제정보</td>
	                      </tr>
	                      <tr>
	                        <td>상품수</td>
	                        <td>${totalCnt}개</td>
	                      </tr>
	                      <tr>
	                        <td>상품금액</td>
	                        <td>${Price}원</td>
	                      </tr>
	                      <tr>
	                        <td>할인금액</td>
	                        <td>${discountPrice}원</td>
	                      </tr>
	                      <tr>
	                        <td>포인트사용</td>
	                        <td id="point2">0P</td>
	                      </tr>
	                      <tr>
	                        <td>배송비</td>
	                        <td>${prodDeliveryFee}원</td>
	                      </tr>
	                      <tr>
	                        <td>포인트적립</td>
	                        <td>${point}P</td>
	                      </tr>
	                      <tr>
	                        <td>전체주문금액</td>
	                        <td class="red_tt" id="totPrice">${finalPrice}원</td>
	                      </tr>
	
	                    </table>
	                      <button type="submit" style="margin-top: 10px;" class="total_red_btn">결제하기</button>
	                  </div>
				</form> 
	                </div>
                
            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>       