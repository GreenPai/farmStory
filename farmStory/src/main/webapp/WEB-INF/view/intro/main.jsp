<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>글보기</title>
    <link rel="stylesheet" href="/farmStory/css/layout.css"/>
    <link rel="stylesheet" href="/farmStory/css/temp.css"/>
</head>
<%@ include file="../layout/_header.jsp" %>

      <main>
          <div>
              <div class="main_slide_container">
                  <img src="/farmStory/images/main_slide_img1.jpg" alt="메인이미지">
                  <img src="/farmStory/images/main_slide_img_tit.png" alt="텍스트">
                  <div class="event">
                      <div>
                          <img src="/farmStory/images/main_banner_txt.png" alt="">
                          <img src="/farmStory/images/main_banner_tit.png" alt="">
                          <img src="/farmStory/images/main_banner_img.png" alt="">
                      </div>
                  </div>
              </div>
              <img src="/farmStory/images/main_market_tit.png" alt="장보기" class="tits">
              <section>
              	<c:forEach var="product" items="${products}">
		            <article>
	                      <a href="/farmStory/basket/detail.do?prodNo=${product.prodNo}">
	                          <img src="${pageContext.request.contextPath}/product_images/${product.imagesName}" alt="상품 이미지">
	                      </a>
	                      <p>${product.cateName}</p>
	                      <p>${product.prodName}<br>500g</p>
	                      <p><del>${product.prodPrice}</del> <span class="discount10">${product.prodDiscount}%↓</span></p>
	                      <h3>${product.prodDiscountPrice}원</h3>
	                  </article>
                 </c:forEach>
              </section>
              <div class="main_banner_sub_container">
                  <a href="/farmStory/article/list.do?cate=food">
                      <img src="/farmStory/images/main_banner_sub1_tit.png" alt="">
                  </a>
                  <a href="/farmStory/article/list.do?cate=cook">
                      <img src="/farmStory/images/main_banner_sub2_tit.png" alt="">
                  </a>
              </div>
              <div class="main_latest_container">
                  <div>
                      <div>
                          <a href="/farmStory/article/list.do?cate=grow">
                              <img src="/farmStory/images/main_latest1_tit.png" alt="텃밭가꾸기 텍스트" class="main_latest_tit">
                          </a>
                      </div>
                      <img src="/farmStory/images/main_latest1_img.jpg" alt="텃밭가꾸기 이미지">
                      <table>
                          <tr>
                          	  <c:forEach var="grow" items="${grows}">
	                              <td>
	                                  <a href="/farmStory/article/view.do?no=${grow.no}&cate=grow">${grow.title}</a>
	                                  <p>${grow.wdate}</p>
	                              </td>					            
			                  </c:forEach>
                          </tr>
                      </table>
                  </div>
                  <div>
                      <div>
                          <a href="/farmStory/article/list.do?cate=school">
                              <img src="/farmStory/images/main_latest2_tit.png" alt="귀농학교 텍스트" class="main_latest_tit">
                          </a>
                      </div>
                      <img src="/farmStory/images/main_latest2_img.jpg" alt="귀농학교 이미지">
                      <table>
                          <tr>
                              <c:forEach var="school" items="${schools}">
	                              <td>
	                                  <a href="/farmStory/article/view.do?no=${school.no}&cate=school">${school.title}</a>
	                                  <p>${school.wdate}</p>
	                              </td>					            
			                  </c:forEach>
                          </tr>
                      </table>
                  </div>
                  <div>
                      <div>
                          <a href="/farmStory/article/list.do?cate=story">
                              <img src="/farmStory/images/main_latest3_tit.png" alt="농작물이야기 텍스트" class="main_latest_tit">
                          </a>
                      </div>
                      <img src="/farmStory/images/main_latest3_img.jpg" alt="농작물이야기 이미지">
                      <table>
                          <tr>
                              <c:forEach var="story" items="${storys}">
	                              <td>
	                                  <a href="/farmStory/article/view.do?no=${story.no}&cate=story">${story.title}</a>
	                                  <p>${story.wdate}</p>
	                              </td>					            
			                  </c:forEach>
                          </tr>
                      </table>
                  </div>
              </div>
              <div class="main_sub2_container">
                  <div>
                      <div>
                          <img src="/farmStory/images/main_sub2_cs_tit.png" alt="고객센터안내">
                      </div>
                      <div>
                          <img src="/farmStory/images/main_sub2_cs_img.png" alt="전화">
                          <img src="/farmStory/images/main_sub2_cs_txt.png" alt="전화">
                          <p>
                              평일: AM 09:00 ~ PM 06:00<br>
                              점심: PM 12:00 ~ PM 01:00<br>
                              토, 일요일, 공휴일 휴무
                          </p>
                      </div>
                      <div>
                          <a href="/farmStory/article/list.do?cate=qna1">
                              <img src="/farmStory/images/main_sub2_cs_bt1.png" alt="1:1 고객문의">
                          </a>
                          <a href="/farmStory/article/list.do?cate=qna2">
                              <img src="/farmStory/images/main_sub2_cs_bt2.png" alt="자주묻는 질문">
                          </a>
                          <a href="/farmStory/article/list.do?cate=qna1">
                              <img src="/farmStory/images/main_sub2_cs_bt3.png" alt="배송 조회">
                          </a>
                      </div>
                  </div>
                  <div>
                      <div>
                          <img src="/farmStory/images/main_sub2_account_tit.png" alt="고객센터안내">
                      </div>
                      <p>
                          기업은행 123-456789-01-01-012<br>
                          국민은행 01-1234-56789<br>
                          우리은행 123-456789-01-01-012<br>
                          하나은행 123-456789-01-01<br>
                          예 금 주 (주)팜스토리
                      </p>
                  </div>
                  <div>
                      <div>
                          <img src="/farmStory/images/main_sub2_notice_tit.png" alt="공지사항">
                      </div>
                      <table>
                          <tr>
                              <c:forEach var="notice" items="${notices}">
	                              <td>
	                                  <a href="/farmStory/article/view.do?no=${notice.no}&cate=notice">${notice.title}</a>
	                                  <p>${notice.wdate}</p>
	                              </td>					            
			                  </c:forEach>
                          </tr>
                      </table>
                  </div>
              </div>
          </div>
      </main>

<%@ include file="../layout/_footer.jsp" %>


