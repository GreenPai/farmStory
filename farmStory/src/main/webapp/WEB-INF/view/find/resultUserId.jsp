<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기 결과</title>
    <link rel="stylesheet" href="/farmStory/css/layout_bg.css"/>
    <link rel="stylesheet" href="../css/find/resultUserId.css"/>
</head>
<%@ include file="../layout/_header.jsp" %>
        <main>
            <section>
                <form action="#" method="post">
                    <h2>아이디 찾기 결과</h2>
                    <table>
                        <tbody>
                            <tr>
                                <td>이름</td>
                                <td>${dto.name}</td>
                            </tr>
                            <tr>
                                <td>아이디</td>
                                <td>${dto.uid}</td>
                            </tr>
                            <tr>
                                <td>이메일</td>
                                <td>${dto.email}</td>
                            </tr>
                            <tr>
                                <td>가입일</td>
                                <td>${dto.regDate}</td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <p>고객님의 정보와 일치하는 아이디 입니다.</p>
                <div>
                    <a href="/farmStory/user/login.do">로그인</a>
                    <a href="./password.do">비밀번호 찾기</a>
                </div>
            </section>
        </main>
<%@ include file="../layout/_footer.jsp" %>    