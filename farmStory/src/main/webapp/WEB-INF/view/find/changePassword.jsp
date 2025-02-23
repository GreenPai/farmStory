<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>비밀번호 변경</title>
    <link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
    <div id="wrapper">
        <header>
            <h3>
                <a href="/index.html" class="title">Board Project</a>
            </h3>
        </header>
        <main id="find">
            <section class="changePassword">
                <form action="#">
                    <h2 class="tit">비밀번호 변경</h2>
                    <table border="0">
                        <tr>
                            <td>아이디</td>
                            <td>honggildong</td>
                        </tr>
                        <tr>
                            <td>새 비밀번호</td>
                            <td>
                                <input type="email" name="pass1" placeholder="새 비밀번호 입력"/>
                            </td>
                        </tr>
                        <tr>
                            <td>새 비밀번호 확인</td>
                            <td>
                                <input type="email" name="pass1" placeholder="새 비밀번호 입력"/>
                            </td>
                        </tr>
                    </table>                                        
                </form>
                
                <p>
                    비밀번호를 변경해 주세요.<br>
                    영문, 숫자, 특수문자를 사용하여 8자 이상 입력해 주세요.                    
                </p>

                <div>
                    <a href="../user/login.html" class="btn btnCancel">취소</a>
                    <a href="../user/login.html" class="btn btnNext">다음</a>
                </div>
            </section>
        </main>
        <footer>
            <p>
                <span class="copyright">Copyrightⓒ 김철학(개발에반하다.)</span>
                <span class="version">v1.0.1</span>
            </p>
        </footer>
    </div>    
</body>
</html>