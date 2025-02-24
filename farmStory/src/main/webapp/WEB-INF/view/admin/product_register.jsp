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
</head>
<%@ include file="../admin/layout/_header.jsp" %>
<main>
<%@ include file="../admin/layout/_aside.jsp" %>
  <section class="right_section">
                <p class="title">상품등록</p>
                <article>
                    <form action="#">
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
                                        <select>
                                             <option value="option">종류</option>
                                             <option value="option">과일</option>
                                             <option value="option">곡류</option>
                                             <option value="option">야채</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>가격</td>
                                    <td>
                                        <input type="text" name="name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>포인트</td>
                                    <td>
                                        <input type="text" name="name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>할인</td>
                                    <td>
                                        <select>
                                            <option value="discount">5%</option>
                                            <option value="discount">10%</option>
                                            <option value="discount">15%</option>
                                            <option value="discount">20%</option>
                                       </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <style>
                                        td input[type="radio"] {
                                          margin-right: 5px; /* 라디오 버튼과 텍스트 사이 간격 */
                                        }
                                        
                                        td label {
                                          margin-right: 15px; /* 각 옵션 사이의 간격 */
                                        }
                                      </style>
                                      
                                      <td>
                                        <input type="radio" id="price1" name="price"><label for="price1">2000원</label>
                                        <input type="radio" id="price2" name="price"><label for="price2">3000원</label>
                                        <input type="radio" id="price3" name="price"><label for="price3">5000원</label>
                                        <input type="radio" id="price4" name="price"><label for="price4">무료</label>
                                      </td> 
                                </tr>
                                <tr>
                                    <td>재고</td>
                                    <td>
                                        <input type="text" name="name">
                                    </td>
                                </tr>
                                <tr>
                                    <td>상품이미지</td>
                                    <td>
                                        <div class="file-input-container">
                                            <p>상품목록 이미지 (약 120 x 120)</p>
                                            <label for="file1">
                                                <div style="width: 100px; height: 20px; background-color: gray;
                                                display: flex; align-items: center; justify-content: center;">Choose File</div>
                                            </label>
                                            <input type="file" name="file1" id="file1" style="display: none;">
                                            
                                            
                                            
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
                                            <input type="text" name="name" style="width: 157px; height: 32px;">
                                        </td>
                                </tr>
                               
                            </tbody>

                        </table>
                    </form>
                        <div class="button-container">
                        <a href="#" class="button">취소</a>
                        <a href="#" class="button">상품등록</a>
                      </div>
                </article>
                
            </section>
</main>
<%@ include file="../admin/layout/_footer.jsp" %>
</body>
</html>