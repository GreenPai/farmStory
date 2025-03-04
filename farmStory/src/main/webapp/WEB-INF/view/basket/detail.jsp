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
	document.addEventListener('DOMContentLoaded', function(){
		
		total.innerText = Number(total.innerText).toLocaleString()+"원";
		price.innerText = Number(price.innerText).toLocaleString()+"원";
		fee.innerText = Number(fee.innerText).toLocaleString()+"원";
		
		let prodprice = `${product.prodDiscountPrice}`;
		
		let itemCountInput = document.querySelector('#itemCount');
		itemCountInput.addEventListener("input", function(){
			let itemCount = itemCountInput.value;
			console.log("현재 수량: " + itemCount);
			total.innerText = (prodprice*itemCount).toLocaleString()+"원";	
		})
		
		// 장바구니 버튼 클릭 시
		// uid, prodNo, cartProdCount
		document.getElementById("addBtn").addEventListener("click", async function() {
            
			alert("장바구니에 추가되었습니다.");

            const prodNo = formProduct.prodNo.value;
            const cartProdCount = formProduct.itemCount.value;
            
            const response = await fetch('/farmStory/basket/register.do?prodNo=' + prodNo + '&cartProdCount=' + cartProdCount);
		
            // 장바구니에 추가하는 코드 작성 가능
        });
		
		// 바로구매 버튼 클릭 시
		document.getElementById("buyBtn").addEventListener("click", function() {
            alert("구매 페이지로 이동합니다.");
            // 바로 구매하는 코드 작성 가능
            let url = "http://localhost:8080/farmStory/basket/basket.do";
			window.location.href = url;
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
                    <p class="black_bold_txt">기본정보</p>
                    <div class="info">
                      <div class="info_img">
                      	<img src="${pageContext.request.contextPath}/product_images/${imageName}" alt="상품 이미지">
                      </div>
                      <div class="info_form">
                        <form action="#" name="formProduct">
                          <input type="hidden" name="uid" >
                          <table>
                            <tr>
                              <td>상품명</td>
                              <td>${product.prodName}</td>
                            </tr>
                            <tr>
                              <td>상품코드</td>
                              <td><input type="hidden" name="prodNo" value="${product.prodNo}">${product.prodNo}</td>
                            </tr>
                            <tr>
                              <td>배송비</td>
                              <td><span id="fee">${product.prodDeliveryFee}</span><span class="gray_tt"> 3만원 이상 무료배송</span></td>
                            </tr>
                            <tr>
                              <td>판매가격</td>
                              <td id="price">${product.prodDiscountPrice}</td>
                            </tr>
                            <tr>
                              <td>구매수량</td>
                              <td><input type="number" name="itemCount" id="itemCount" style="width: 60px;" value="1"></td>
                            </tr>
                            <tr>
                              <td>합계</td>
                              <td class="red_tt" id="total">${product.prodDiscountPrice}</td>
                            </tr> 
                          </table>
                        </form>
                      </div>
                      <div class="buttons">
                        <button class="green_btn" type="button" id="addBtn">장바구니</button>
                        <button class="red_btn"   type="button" id="buyBtn">바로구매</button>
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