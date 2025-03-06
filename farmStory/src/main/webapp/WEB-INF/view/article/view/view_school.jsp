<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en"></html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
<link rel="stylesheet" href="/farmStory/css/layout_bg.css" />
<link rel="stylesheet" href="/farmStory/css/farm/community.css" />

<script>
document.addEventListener('DOMContentLoaded', function(){
	console.log('DOMContentLoaded...');
	
	const commentList = document.getElementsByClassName('commentList')[0];
	
	// 댓글 등록
	formComment.onsubmit = function(e){
		e.preventDefault();
		
		// 입력한 데이터 가져오기
		const parent = formComment.parent.value;
		const writer = formComment.writer.value;
		const content = formComment.content.value;
		
		// 폼 데이터 생성
		const formData = new FormData();
		formData.append('parent', parent);
		formData.append('writer', writer);
		formData.append('content', content);
		console.log(formData);
		
		// 서버 전송
		fetch('/farmStory/comment/write.do', {
			method: 'POST',
			body: formData
		})
		.then(response => response.json())
		.then(data => {
			console.log(data);
			
			// 동적 태그 생성
			if(data != null){
				
				alert('댓글이 등록 되었습니다.');
				
				//입력 필드 비우기
				const article = `<article>
			                        <span class='date'>\${data.wdate}</span>
			                        <span class='nick'>\${data.nick}</span>
			                        <p class='content'>\${data.content}</p>
			                        <div>
			                            <a href='#' class='remove'>삭제</a>
			                            <a href='#' class='modify'>수정</a>
			                        </div>
			                     </article>`;
			                     
				commentList.insertAdjacentHTML('beforeend', article);    					
			}else{
				alert('댓글 등록 실패 했습니다.');
			}
			
		})
		.catch(err => {
			console.log(err);
		});
	};
	
	});

</script>



</head>
<%@ include file="../layout/_header_bg_crop.jsp" %>
<main id="notice">
	<section class="left_section">
		<aside>
              <article>
                  <ul>
                      <li>
                          <img src="/farmStory/images/sub_aside_cate3_tit.png" alt="농작물이야기" >
                      </li>
                  </ul>
              </article>
  
              <article>   
                  <ul>
                      <li>
                          <a href="/farmStory/article/list.do?cate=story">
                              <img src="/farmStory/images/sub_cate3_lnb1.png" alt="농작물이야기">
                          </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/list.do?cate=grow">
                            <img src="/farmStory/images/sub_cate3_lnb2.png" alt="텃밭가꾸기">
                        </a>
                      </li>
                      <li>
                        <a href="/farmStory/article/list.do?cate=school">
                            <img src="/farmStory/images/sub_cate3_lnb3_ov.png" alt="귀농학교">
                        </a>
                      </li>

                  </ul>
              </article>
            </aside>
	</section>

	<section class="right_section">
		<article>
			<div>
				<div class="sub_nav_tit">
					<img src="/farmStory/images/sub_nav_tit_cate3_tit3.png"
						alt="귀농학교">
				</div>
				<div>
					<p class="intro">
						<img src="/farmStory/images/sub_page_nav_ico.gif" alt="귀농학교">
						HOME > 커뮤니티 > <span class="eco_txt">귀농학교&nbsp </span>
					</p>
				</div>
			</div>

			<div>
				<nav>
					<h1>글보기</h1>
				</nav>
			</div>

			<table border="0">
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"
							value="${articleDTO.title}" readonly></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" name="writer"
							value="${articleDTO.writer}(${articleDTO.nick})" readonly /></td>
					</tr>
					<c:if test="${articleDTO.file > 0 }">
						<tr>
							<th>파일</th>
							<td><c:forEach var="file" items="${articleDTO.files}">
									<a href="/farmStory/file/download.do?fno=${file.fno}">${file.oName}</a> &nbsp; <span>${file.download}</span> 회 다운로드 <br>
								</c:forEach></td>
						</tr>
					</c:if>
					<tr>
						<th>내용</th>
						<td><textarea name="content" readonly>${articleDTO.content}</textarea>
						</td>
					</tr>
				</tbody>
			</table>
			<div
				style="text-align: right; margin-top: 10px; margin-bottom: 10px;">
				<a href="/farmStory/article/delete.do?no=${articleDTO.no}"
					class="btn btnRemove">삭제</a> <a
					href="/farmStory/article/modify.do?no=${articleDTO.no}"
					class="btn btnModify">수정</a> <a href="/farmStory/article/list.do"
					class="btn btnList">목록</a>
			</div>
			<!--댓글목록-->
			<section class="commentList">
				<h3 class="title">댓글목록</h3>
				<c:forEach var="comment" items="${comments}">
					<article>
						<span class="date">${comment.wdate}</span> <span class="nick">${comment.nick}</span>
						<p class="content">${comment.content}</p>
						<div>
							<a
								href="/farmStory/comment/delete.do?cno=${comment.cno}&parent=${articleDTO.no}"
								class="remove">삭제</a> <a href="#" class="modify">수정</a>
						</div>
					</article>
				</c:forEach>

				<c:if test="${empty comments}">
					<p class="empty">등록된 댓글이 없습니다.</p>
				</c:if>
			</section>

			<!--댓글쓰기-->
			<section class="commentForm">
				<div
					style="width: 728px; border-bottom: 1px dotted #111; margin-top: 15px; margin-left: 17px;">
					<h3 class="title">댓글쓰기</h3>
					<form action="#" name="formComment">
						<input type="hidden" name="parent" value="${articleDTO.no}">
						<input type="hidden" name="writer" value="${sessUser.uid}">
						<textarea name="content"></textarea>
						<div class="btn_div">
							<a href="#" class="btn btnCancel">취소</a> <input type="submit"
								value="작성완료" class="btn btnComplete">
						</div>
					</form>
				</div>
			</section>


		</article>
	</section>
</main>
<%@ include file="../../layout/_footer.jsp" %>    