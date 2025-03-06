<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
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
<script>
document.addEventListener("DOMContentLoaded", function () {
    let deleteButton = document.getElementById("deleteSelected");
    let checkAll = document.getElementById("checkAll");
    
    if (!deleteButton) {
        console.error("버튼 요소를 찾을 수 없습니다.");
        return;
    }

    deleteButton.addEventListener("click", function () {
        let checkedBoxes = document.querySelectorAll("input[name='prodCheck']:checked");

        if (checkedBoxes.length === 0) {
            alert("삭제할 항목을 선택하세요.");
            return;
        }

        // 체크된 cartNo 값을 배열로 수집
        let prodNos = Array.from(checkedBoxes).map(cb => cb.value);
        alert(prodNos);

        
        // URLSearchParams를 사용하여 안전하게 데이터 변환
        let params = new URLSearchParams();
        prodNos.forEach(no => params.append("prodNos", no));

        // AJAX 요청으로 서버에 삭제 요청 보내기
        fetch("/farmStory/admin/product/delete.do?cate=product", {
            method: "POST",
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
            body: params.toString()
        })
            .then(response => response.json()) // JSON 응답을 파싱
            .then(data => {
                if (data.status === "success") {
                    // 성공하면 화면에서도 삭제
                    alert("선택한 상품이 삭제되었습니다.");
                    window.location.href = "./list.do";
                } else {
                    alert("삭제 실패! 다시 시도해주세요.");
                }
            })
            .catch(error => console.error("Error:", error));
    
    });
    
 	// '전체 선택' 체크박스를 클릭했을 때
    checkAll.addEventListener("change", function () {
        // checkAll 체크 상태에 따라 다른 체크박스의 상태 변경
        let checkboxes = document.querySelectorAll("input[name='prodCheck']");
        checkboxes.forEach(checkbox => {
            checkbox.checked = checkAll.checked;
        });
    });
 	
});

</script>

<%@ include file="../admin/layout/_header.jsp" %>
<main>
<%@ include file="../admin/layout/_aside.jsp" %>
 <section class="right_section">
                <p class="title">상품목록</p> 
                
                <article>
        
                    <table class="product">
                        <thead>
                            <tr>
                                <th><input id="checkAll" type="checkbox"></th>
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
                        	<c:forEach var="product" items="${products}">
                        	 	<tr>
                        	 		<td><input type="checkbox" id="prodCheck" name="prodCheck" value="${product.prodNo}"></td>
                        	 		<td><img src="${pageContext.request.contextPath}/product_images/${product.imagesName}" alt="상품 이미지"></td>
                        	 		<td>${product.prodNo}</td>
                        	 		<td>${product.prodName}</td>
                        	 		<td>${product.cateName}</td>
                        	 		<td>${product.prodPrice}</td>
                        	 		<td>${product.prodStock}</td>
                        	 		<td>${product.regDate}</td>
                        	 	</tr>
                        	</c:forEach>
                   
                        </tbody>
                    </table>
                </article>
                <div class="button-container">
                    <div class="delete-button-container">
                        <span id="deleteSelected" style="cursor:pointer;" >선택삭제</span>
                    </div>
                    <div class="register-button-container">
                        <a href="/farmStory/admin/product/register.do">
                        <span>상품등록</span>
                    	</a>
                    </div>
                </div>
               
               <div class="page">
                	<c:if test="${pageGroupDTO.start>1}">
                    <a href="/farmStory/admin/product/list.do?pg=${pageGroupDTO.start -1}" class="prev">이전</a>
                    </c:if>
                    <c:forEach var="num" begin="${pageGroupDTO.start}" end="${pageGroupDTO.end }">
                    <a href="/farmStory/admin/product/list.do?pg=${num}" class="num ${currentPage==num ? 'current' : '' }">[${num}] &nbsp;</a>
                    </c:forEach>
                    <c:if test="${pageGroupDTO.end<lastPageNum}">
                    <a href="/farmStory/admin/product/list.do?pg=${pageGroupDTO.end + 1}" class="next">다음</a>
                    </c:if>
                </div>
                
            </section>
</main>
<%@ include file="../admin/layout/_footer.jsp" %>
</body>
</html>