<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                            <tr>
                                <td><input type="checkbox"></td>
                                <td>1011</td>
                                <td>사과500g</td>
                                <td>4,000원</td>
                                <td>2</td>
                                <td>3000원</td>
                                <td>11,000</td>
                                <td>김유신</td>
                                <td>2023-01-01 13:06:14</td>
                                <td>[상세확인]</td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="delete-button-container">
                        <span>선택삭제</span>
                    </div>

                    <div class="page">
                        <p>< [1] [2] [3] [4] [5] ></p>
                    </div>
                </article>
            </section>
    </main>
<%@ include file="../admin/layout/_footer.jsp" %>
