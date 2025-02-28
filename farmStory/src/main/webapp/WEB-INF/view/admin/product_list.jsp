<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 메인페이지</title>
	<link rel="stylesheet" href="/farmStory/css/admin/layout/layout.css"/>
	<link rel="stylesheet" href="/farmStory/css/admin/product_list.css"/>
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
                <p class="title">상품목록</p> 
                
                <article>
        
                    <table class="product">
                        <thead>
                            <tr>
                                <th><input type="checkbox"></th>
                                <th>사진</th>
                                <th>상품번호</th>
                                <th>상품명</th>
                                <th>구분</th>
                                <th>가격</th>
                                <th>재고</th>
                                <th>등록일</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input type="checkbox"></td>
                                <td><img src="/farmStory/images/market_item1.jpg" alt="사과"></td>
                                <td>1011</td>
                                <td>사과500g</td>
                                <td>과일</td>
                                <td>4000원</td>
                                <td>100</td>
                                <td>2023-01-01</td>
                            </tr>
                        
                        </tbody>
                    </table>
                </article>
                <div class="button-container">
                    <div class="delete-button-container">
                        <span>선택삭제</span>
                    </div>
                    <div class="register-button-container">
                        <a href="/farmStory/admin/product/register.do">
                        <span>상품등록</span>
                    	</a>
                    </div>
                </div>
               
                <div class="page"  >
                    <p > < [1] [2] [3] [4] [5] ></p>
                </div>
            </section>
</main>
<%@ include file="../admin/layout/_footer.jsp" %>
</body>
</html>