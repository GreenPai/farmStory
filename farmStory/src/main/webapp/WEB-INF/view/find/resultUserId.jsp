<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기 결과</title>
    <link rel="stylesheet" href="../css/find/resultUserId.css"/>
</head>
<body>
    <div id="wrapper">
        <header>
            <div>
                <div class="top">
                    <p>
                        <a href="#">HOME |</a>
                        <a href="#">로그인 |</a>
                        <a href="#">회원가입 |</a>
                        <a href="#">나의정보 |</a>
                        <a href="#">로그아웃 |</a>
                        <a href="#">관리자 |</a>
                        <a href="#">고객센터</a>
                    </p>
                </div>
            </div>
            
            <div>
                <article>
                    <a href="#" class="logo">
                        <img src="/farmStory/images/logo.png" alt="팜스토리 로고">
                    </a>
                    <a href="#" class="freeShipping">
                        <img src="/farmStory/images/head_txt_img.png" alt="팜스토리 로고">
                    </a>
                </article>
            </div>

            <div>
                <ul>
                    <li>
                        <a href="#">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu1.png" alt="팜스토리소개">
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="/farmStory/images/head_menu_badge.png" alt="30%" class="head_badge">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu2.png" alt="장보기">
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu3.png" alt="농작물이야기">
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu4.png" alt="이벤트">
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu5.png" alt="커뮤니티">
                        </a>
                    </li>
                </ul>
            </div>
        </header>
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
        
        <footer>
            <div class="footer_container">
                <div class="footer_img">
                    <img src="/farmStory/images/footer_logo.png" alt="팜스토리 로고">
                </div>
                <div class="footer_p">
                    <p>
                        (주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제 2013-부산진구-123호 / 벤처기업확인 서울지방중소기업청 제 012345678-9-01234호<br>
                        등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동<br>
                        대표 : 홍길동 / 이메일 : honggildong@gmail.com / 전화 : 01) 234-5678 / 부산광역시 부산진구 부전동 123
                    </p>
                    <p>
                        copyrightⓒ 홍길동 All rights reserved.
                    </p>
                    <p>
                        farmstory ver1.0.1
                    </p>
                </div>
            </div>
        </footer>
</body>
</html>