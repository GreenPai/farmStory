<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자 메인페이지</title>
	<link rel="stylesheet" href="/farmStory/css/admin/layout/layout.css"/>
	<link rel="stylesheet" href="/farmStory/css/admin/user_list.css"/>
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
                <p class="title">회원목록</p>
        
                <article>
                    <p class="m-10">회원목록</p>
                    <table class="user_list">
                        <thead>
                            <tr>
                                <th><input type="checkbox"></th>
                                <th>아이디</th>
                                <th>이름</th>
                                <th>별명</th>
                                <th>이메일</th>
                                <th>휴대폰</th>
                                <th>등급</th>
                                <th>가입일</th>
                                <th>확인</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input type="checkbox"></td>
                                <td>a101</td>
                                <td>김유신</td>
                                <td>유신101</td>
                                <td>yusin101@naver.com</td>
                                <td>010-1234-1001</td>
                                <td>
                                    <select>
                                         <option value="level">1</option>
                                         <option value="level">2</option>
                                         <option value="level">3</option>
                                         <option value="level">4</option>
                                    </select>
                                </td>
                                <td>2023-01-01 13:06:14</td>
                                <td>[상세확인]</td>
                            </tr>
                        </tbody>
                        <tbody>
                            <tr>
                                <td><input type="checkbox"></td>
                                <td>a101</td>
                                <td>김유신</td>
                                <td>유신101</td>
                                <td>yusin101@naver.com</td>
                                <td>010-1234-1001</td>
                                <td>
                                    <select>
                                         <option value="level">1</option>
                                         <option value="level">2</option>
                                         <option value="level">3</option>
                                         <option value="level">4</option>
                                    </select>
                                </td>
                                <td>2023-01-01 13:06:14</td>
                                <td>[상세확인]</td>
                            </tr>
                        </tbody>
                        <tbody>
                            <tr>
                                <td><input type="checkbox"></td>
                                <td>a101</td>
                                <td>김유신</td>
                                <td>유신101</td>
                                <td>yusin101@naver.com</td>
                                <td>010-1234-1001</td>
                                <td>
                                    <select>
                                         <option value="level">1</option>
                                         <option value="level">2</option>
                                         <option value="level">3</option>
                                         <option value="level">4</option>
                                    </select>
                                </td>
                                <td>2023-01-01 13:06:14</td>
                                <td>[상세확인]</td>
                            </tr>
                        </tbody>
                        
                    </table>
                    <div class="page"  >
                        <p > < [1] [2] [3] [4] [5] ></p>
                    </div>
                </article>
            </section>
</main>
<%@ include file="../admin/layout/_footer.jsp" %>
</body>
</html>