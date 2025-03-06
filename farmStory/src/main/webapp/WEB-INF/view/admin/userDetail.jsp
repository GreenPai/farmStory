<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/farmStory/css/admin/userDetail.css"/>
    <title>회원 상세 정보</title>
    <script>
        // 닫기 버튼을 눌렀을 때 팝업을 닫는 함수
        function closePopup() {
            window.close();  // 팝업 창 닫기
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="header">회원 상세 정보</div>
        
        <dl class="user-detail">
            <dt>아이디 (UID):</dt>
            <dd>${dto.uid }</dd>
         
            <dt>이름:</dt>
            <dd>${dto.name}</dd>

            <dt>닉네임:</dt>
            <dd>${dto.nick}</dd>

            <dt>이메일:</dt>
            <dd>${dto.email}</dd>

            <dt>전화번호:</dt>
            <dd>${dto.hp}</dd>

            <dt>회원 등급:</dt>
            <dd>${dto.userLevel}</dd>

            <dt>가입일:</dt>
            <dd>${dto.regDate}</dd>

            <dt>보유 포인트:</dt>
            <dd>${dto.userPoint}</dd>

            <dt>작성한 게시글 수:</dt>
            <dd>${dto.postCount}</dd>

            <dt>주소:</dt>
            <dd>${dto.addr1}
            <br>${dto.addr2}</dd>
        </dl>

        <!-- 닫기 버튼에 closePopup() 함수 추가 -->
        <a href="#" class="close-btn" onclick="closePopup()">닫기</a>
    </div>
</body>
</html>
