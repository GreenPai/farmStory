<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 메인페이지</title>
	<link rel="stylesheet" href="/farmStory/css/admin/layout/layout.css"/>
	<link rel="stylesheet" href="/farmStory/css/admin/order_list.css"/>
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
            <section class="left_section">
                <aside>
                    <div>
                        <p>주요기능</p>
                    </div>
                    <div style="margin-top: 20px;">
                        <div>
                            <p>상품관리</p>
                            <a href="/farmStory/admin/product/list.do">L 상품목록</a><br>
                            <a href="/farmStory/admin/product/register.do">L 상품등록</a>
                        </div>
                        <div>
                            <p>주문관리</p>
                            <a href="/farmStory/admin/order/list.do">L 주문목록</a>
                        </div>
                        <div>
                            <p>회원관리</p>
                            <a href="/farmStory/admin/user/list.do">L 회원목록</a>
                        </div>
                    </div>
                </aside>
            </section>

            <section class="right_section">
                <p class="title">주문목록</p>
        
                <article>
                    <p class="m-10">주문목록</p>
                    <table class="orderlist">
                        <thead>
                            <tr>
                                <th><input type="checkbox"></th>
                                <th>주문번호</th>
                                <th>상품명</th>
                                <th>판매가격</th>
                                <th>수량</th>
                                <th>배송비</th>
                                <th>합계</th>
                                <th>주문자</th>
                                <th>주문일</th>
                                <th>확인</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="order" items="${orders}">
	                            <tr>
	                                <td><input type="checkbox"></td>
	                                <td>${order.orderNo}</td>
	                        		<td>${order.prodName}</td>
	                        		<td>${order.itemPrice}</td>
		                            <td>${order.itemCount}</td>
		                            <td>${order.prodDeliveryFee}</td>
		                            <td>${order.orderTotalPrice}</td>
		                            <td>${order.orderSender}</td>
		                            <td>${order.orderDate}</td>
		                            <td><a href="#">상세확인</a></td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                    <div class="page">
	                	<c:if test="${pageGroupDTO.start>1}">
	                    <a href="/farmStory/admin/order/list.do?pg=${pageGroupDTO.start -1}" class="prev">이전</a>
	                    </c:if>
	                    <c:forEach var="num" begin="${pageGroupDTO.start}" end="${pageGroupDTO.end }">
	                    <a href="/farmStory/admin/order/list.do?pg=${num}" class="num ${currentPage==num ? 'current' : '' }">[${num}] &nbsp;</a>
	                    </c:forEach>
	                    <c:if test="${pageGroupDTO.end<lastPageNum}">
	                    <a href="/farmStory/admin/order/list.do?pg=${pageGroupDTO.end + 1}" class="next">다음</a>
	                    </c:if>
               		</div>
                </article>
            </section>
    </main>
<%@ include file="../admin/layout/_footer.jsp" %>