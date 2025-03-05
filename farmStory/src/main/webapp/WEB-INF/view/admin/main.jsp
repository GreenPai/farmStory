<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 메인페이지</title>
	<link rel="stylesheet" href="/farmStory/css/admin/layout/layout.css"/>
	<link rel="stylesheet" href="/farmStory/css/admin/main.css"/>
	<style>
		main {
            width: 980px;
            height: 658px;
            margin: 0px auto;
        }
	</style>
</head>
<%@ include file="../admin/layout/_header.jsp" %>
<main>
<%@ include file="../admin/layout/_aside.jsp" %>
<section class="right_section">
                <p class="title">관리자 메인</p> 
                
                <article>
                    
                    <p class="m-10">상품현황 <span><a href="/farmStory/admin/product/list.do">+더보기</a></span></p>
        
                    <table class="product">
                        <thead>
                            <tr>
                                <th>상품번호</th>
                                <th>상품명</th>
                                <th>구분</th>
                                <th>가격</th>
                                <th>재고</th>
                                <th>등록일</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="product" items="${products}">
	                            <tr>
	                                <td>${product.prodNo}</td>
	                                <td>${product.prodName}</td>
	                                <td>${product.cateName}</td>
	                                <td>${product.prodPrice}원</td>
	                                <td>${product.prodStock}</td>
	                                <td>${product.regDate}</td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </article>
                <article>
                    <p class="m-10">
                        주문현황<span><a href="/farmStory/admin/order/list.do">+더보기</a></span>
                    </p>
                    <table class="order">
                        <thead>
                            <tr>
                                <th>주문번호</th>
                                <th>상품명</th>
                                <th>판매가격</th>
                                <th>수량</th>
                                <th>배송비</th>
                                <th>합계</th>
                                <th>주문자</th>
                                <th>주문일</th>
                            </tr>
                        </thead>
                        <tbody>

                       		<c:forEach var="order" items="${orders}">
                                <tr>
									<td>${order.orderNo}</td>
	                        		<td>${order.prodName}</td>
	                        		<td>${order.itemPrice}</td>
		                            <td>${order.itemCount}</td>
		                            <td>${order.prodDeliveryFee}</td>
		                            <td>${order.orderTotalPrice}</td>
		                            <td>${order.orderSender}</td>
		                            <td>${order.orderDate}</td>
                                </tr>
                              </c:forEach>
     
                        </tbody>
                            
                    </table>
                </article>
                <article>                  
                    <p class="m-10">회원현황<span><a href="/farmStory/admin/user/list.do">+더보기</a></span></p>
                    <table class="client">
                        <thead>
                            <tr>
                                <th>회원아이디</th>
                                <th>이름</th>
                                <th>닉네임</th>
                                <th>휴대폰</th>
                                <th>이메일</th>
                                <th>등급</th>
                                <th>회원가입일</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.uid}</td>
                                <td>${user.name}</td>
                                <td>${user.nick}</td>
                                <td>${user.hp}</td>
                                <td>${user.email}</td>
                                <td>${user.userLevel}</td>
                                <td>${user.regDate}</td>
                            </tr>
                           </c:forEach>
                            
                        </tbody>
                    </table>
                </article>
    
            </section>
</main>
<%@ include file="../admin/layout/_footer.jsp" %>
</body>
</html>

