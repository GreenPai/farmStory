<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리 로그인</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="/farmStory/css/farm/basket.css"/>
</head>
<script>
document.addEventListener("DOMContentLoaded", function () {
    let deleteButton = document.getElementById("deleteSelected");
    let checkAll = document.getElementById("checkAll");
    let orderButton = document.getElementById("orderButton");


    if (!deleteButton) {
        console.error("버튼 요소를 찾을 수 없습니다.");
        return;
    }

    deleteButton.addEventListener("click", function () {
        let checkedBoxes = document.querySelectorAll("input[name='cartNo']:checked");

        if (checkedBoxes.length === 0) {
            alert("삭제할 항목을 선택하세요.");
            return;
        }

        // 체크된 cartNo 값을 배열로 수집
        let cartNos = Array.from(checkedBoxes).map(cb => cb.value);

        // URLSearchParams를 사용하여 안전하게 데이터 변환
        let params = new URLSearchParams();
        cartNos.forEach(no => params.append("cartNos", no));

        // AJAX 요청으로 서버에 삭제 요청 보내기
        fetch("/farmStory/basket/delete.do", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            body: params.toString()
        })
            .then(response => response.json()) // JSON 응답을 파싱
            .then(data => {
                if (data.status === "success") {
                    // 성공하면 화면에서도 삭제
                    alert("선택한 상품이 삭제되었습니다.");
                    // window.location.href = "http://localhost:8080/farmStory/basket/basket.do";
                    location.href = "./basket/basket.do";
                } else {
                    alert("삭제 실패! 다시 시도해주세요.");
                }
            })
            .catch(error => console.error("Error:", error));
    });
    
 	// '전체 선택' 체크박스를 클릭했을 때
    checkAll.addEventListener("change", function () {
        // checkAll 체크 상태에 따라 다른 체크박스의 상태 변경
        let checkboxes = document.querySelectorAll("input[name='cartNo']");
        checkboxes.forEach(checkbox => {
            checkbox.checked = checkAll.checked;
        });
    });
 	
    orderButton.addEventListener("click", function () {
    	window.location.href = "http://localhost:8080/farmStory/basket/order.do"; 
    });
 	
});

</script>

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
                    <p>장바구니 전체(${tot})</p>
                    <div class="basket_table">
                      <table>
                        <thead>
                          <th style="width: 76.19px;"><input type="checkbox" id="checkAll"></th>
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
	                        <c:if test="${empty carts}">
	                        
		                          <tr class="none_item">
		                            <td colspan="8">장바구니에 상품이 없습니다.</td>
		                          </tr>                          
	                        </c:if>
	                        <c:forEach var="cart" items="${carts}">
                        		<tr>
		                            <td><input type="checkbox" name="cartNo" value="${cart.cartNo}"></td>
		                            <td><img src="${pageContext.request.contextPath}/product_images/${cart.sname}" alt="상품 이미지"></td>
		                            <td class="table_gray_txt">${cart.cateName}</td>
		                            <td>${cart.prodName}</td>
		                            <td class="table_gray_txt">${cart.cartProdCount}</td>
		                            <td class="table_gray_txt">${cart.prodDiscount }%</td>
		                            <td class="table_gray_txt">${cart.prodPoint}P</td>
		                            <td class="table_gray_txt">${cart.prodPrice }</td>
		                            <td>${cart.prodDiscountPrice}<span class="table_gray_txt">원</span></td>
		                        </tr>
                        	</c:forEach>
                         
                        </tbody>
                      </table>
                    </div>
                </div>

                <div style="margin-top: 10px;" class="total">
                  <button style="float: left; width: 60px; height: 29px;" class="red_btn" type="button" id="deleteSelected">선택삭제</button>
                  <div style="margin: 0px;" class="total_table">
                    <table>
                      <tr>
                        <td colspan="2">전체합계</td>
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
                        <td>배송비</td>
                        <td>${prodDeliveryFee}원</td>
                      </tr>
                      <tr>
                        <td>포인트</td>
                        <td>${point}P</td>
                      </tr>
                      <tr>
                        <td>전체주문금액</td>
                        <td class="red_tt">${finalPrice}</td>
                      </tr>

                    </table>
                      <button style="margin-top: 10px;" class="total_red_btn" id="orderButton">주문하기</button>
                  </div>
                </div>

                
            </article>
        </section>
    </main>
<%@ include file="../layout/_footer.jsp" %>       