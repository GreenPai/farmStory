<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 메인페이지</title>
	<link rel="stylesheet" href="/farmStory/css/admin/layout/layout.css"/>
	<link rel="stylesheet" href="/farmStory/css/admin/register.css"/>
	<link rel="stylesheet" href="/farmStory/css/admin/main.css"/>
	<style>
		main {
            width: 980px;
            height: 658px;
            margin: 0px auto;
        }
	</style>
      <script>
        // 가격 입력시 포인트 자동 계산
        function calculatePoints() {
		    const price = document.getElementsByName('price')[0].value;
		    if (price && !isNaN(price) && price > 0) {
		        const points = Math.floor(price * 0.01);
		        document.getElementsByName('point_display')[0].value = points; // 화면에 표시
		        document.getElementsByName('point')[0].value = points; // 실제 데이터 전송
		    } else {
		        document.getElementsByName('point_display')[0].value = '';
		        document.getElementsByName('point')[0].value = '';
		    }
		}
    </script>
</head>
<%@ include file="../admin/layout/_header.jsp" %>
<main>
<%@ include file="../admin/layout/_aside.jsp" %>
  <section class="right_section">
                <p class="title">상품등록</p>
                <article>
                    <form action="/farmStory/admin/product/register.do" method="post" enctype="multipart/form-data">
                        <table class="register">
                            <tbody>
                                <tr>
                                    <td >상품명</td>
                                    <td>
                                        <input type="text" name="name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>종류</td>
                                    <td>
                                        <select name="cateName">
                                             <option value="종류" disabled selected>종류</option>
                                             <option value="과일">과일</option>
                                             <option value="곡류">곡류</option>
                                             <option value="야채">야채</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>가격</td>
                                    <td>
                                        <input type="text" name="price" oninput="calculatePoints()">
                                    </td>
                                </tr>
                                <tr>
                                    <td>포인트</td>
                                    <td>
                                        <input type="text" name="point_display" disabled readonly placeholder="">
                                        <input type="hidden" name="point">
                                        포인트는 가격의 1%
                                    </td>
                                </tr>
                                <tr>
                                    <td>할인</td>
                                    <td>
                                        <select name="discount">
                                            <option value="5">5%</option>
                                            <option value="10">10%</option>
                                            <option value="15">15%</option>
                                            <option value="20">20%</option>
                                       </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>배송비</td>  
                                    <td>
                                        <input type="radio" id="price1" name="delivery" value="2000"><label for="price1">2000원</label>
                                        <input type="radio" id="price2" name="delivery" value="3000"><label for="price2">3000원</label>
                                        <input type="radio" id="price3" name="delivery" value="5000"><label for="price3">5000원</label>
                                        <input type="radio" id="price4" name="delivery" value="0"><label for="price4">무료</label>
                                    </td> 
                                </tr>
                                <tr>
                                    <td>재고</td>
                                    <td>
                                        <input type="text" name="stock">
                                    </td>
                                </tr>
                                <tr>
                                    <td>상품이미지</td>
                                    <td>
                                        <div class="file-input-container">
                                            <p>상품목록 이미지 (약 120 x 120)</p>
                                            <input type="file" name="file1" >
                                        	 
                                            <p>기본정보 이미지 (약 240 x 240)</p>
                                            <input type="file" name="file2">
                                        
                                            <p>상품설명 이미지 (약 750 x Auto)</p>
                                            <input type="file" name="file3">
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>기타</td>
                                        <td>
                                            <input type="text" name="other" style="width: 157px; height: 32px;">
                                        </td>
                                </tr>
                               
                            </tbody>

                        </table>
                        <div class="button-container">
	                        <a href="/farmStory/admin/product/list.do" class="button">취소</a>
	                        <input type="submit" value="상품등록" class="button">
	                    </div>
                    </form>
                </article>
                
            </section>
</main>
<%@ include file="../admin/layout/_footer.jsp" %>
</body>
</html>