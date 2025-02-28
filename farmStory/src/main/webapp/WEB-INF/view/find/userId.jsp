<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>아이디 찾기</title>
    <link rel="stylesheet" href="../css/find/userId.css"/>
</head>
<body>
    <div id="wrapper">
        <header>
            <div>
                <div class="top">
                    <p>
                        <a href="/farmStory">HOME |</a>
			            <a href="/farmStory/user/login.do">로그인 |</a>
			            <a href="/farmStory/user/terms.do">회원가입 |</a>
			            <a href="#">나의정보 |</a>
			            <a href="/farmStory/user/logout.do">로그아웃 |</a>
			            <a href="/farmStory/admin/main.do">관리자 |</a>
			            <a href="#">고객센터 </a>
                    </p>
                </div>
            </div>
            
            <div>
                <article>
                    <a href="/farmStory" class="logo">
                        <img src="/farmStory/images/logo.png" alt="팜스토리 로고">
                    </a>
                    <a href="#" class="freeShipping">
                        <img src="/farmStory/images/head_txt_img.png" alt="팜스토리 헤더 텍스트">
                    </a>
                </article>
            </div>

            <div>
                <ul>
                    <li>
                        <a href="/farmStory/intro.do">
                            <img src="/farmStory/images/head_menu_line.png" alt="라인">
                            <img src="/farmStory/images/head_menu1.png" alt="팜스토리소개">
                        </a>
                    </li>
                    <li>
                        <a href="/farmStory/basket/list.do">
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
                        <a href="/farmStory/event.do">
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
            <section class="id_find">             
                <form action="/farmStory/find/userId.do" method="POST">
                    <h2>아이디 찾기</h2>
                    <table>
                        <tbody>
                            <tr>
                                <td>이름</td>
                                <td><input type="text" name="name" placeholder="이름 입력"></td>
                            </tr>
                            <tr>
                                <td>이메일</td>
                                <td>
                                    <div>
                                        <input type="email" name="email" placeholder="이메일 입력"/>
                                        <button>인증번호 받기</button>
                                    </div>
                                    <div>
                                        <input type="text" name="auth_code" placeholder="인증번호 입력">
                                        <button>확인</button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                <p>회원가입시 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.<br>
                    인증번호를 입력 후 확인 버튼을 누르세요.
                </p>
                <div>
                    <a href="#">취소</a>
                    <a href="/farmStory/find/resultUserId.do">다음</a>
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