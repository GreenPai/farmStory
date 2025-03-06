<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>팜스토리 로그인</title>
<link rel="stylesheet" href="/farmStory/css/layout_bg.css" />
</head>
<%@ include file="./layout/_header_bg_intro.jsp" %>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8655d93046b5ed7b57441e72274b9656"></script>
<main>
	<section class="left_section">
		<aside>
			<article>
				<ul>
					<li><img src="/farmStory/images/sub_aside_cate1_tit.png"
						alt="팜스토리소개" id=""></li>
				</ul>
			</article>

			<article>
				<ul>
					<li><a href="/farmStory/intro.do"> <img
							src="/farmStory/images/sub_cate1_lnb1.png" alt="인사말">
					</a></li>
					<li><a href="/farmStory/location.do"> <img
							src="/farmStory/images/sub_cate1_lnb2_ov.png" alt="찾아오시는길">
					</a></li>
				</ul>
			</article>
		</aside>
	</section>

	<section class="right_section">
		<article>
			<div>
				<div class="sub_nav_tit">
					<img src="/farmStory/images/sub_nav_tit_cate1_tit2.png"
						class="sub_nav_tit_cate1_tit2" alt="찾아오시는길">
				</div>
				<div>
					<p class="intro">
						<img src="/farmStory/images/sub_page_nav_ico.gif" alt="인사말">
						HOME > 팜스토리소개 > <span class="eco_txt">찾아오시는길&nbsp </span>
					</p>
				</div>
			</div>

		

			<div class="content">
				<div>
					<p class="eco_txt" style="margin-top: 40px;">팜스토리</p>
					<p>주소: 경기도 이천시 잘한다구 신난다동 123</p>
					<p>전화: 01-234-5678</p>
					<br>

					<p class="eco_txt">찾아오시는길</p>
						<div id="map" style="width:100%;height:400px;"></div>
						    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8655d93046b5ed7b57441e72274b9656"></script>
							<script>
							var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				            mapOption = { 
				                center: new kakao.maps.LatLng(35.159823, 129.060193), // 지도의 중심좌표
				                level: 3 // 지도의 확대 레벨
				            };

				        var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

				        // 마커가 표시될 위치입니다 
				        var markerPosition  = new kakao.maps.LatLng(35.159823, 129.060193); 

				        // 마커를 생성합니다
				        var marker = new kakao.maps.Marker({
				            position: markerPosition
				        });

				        // 마커가 지도 위에 표시되도록 설정합니다
				        marker.setMap(map);
							</script>
					</div>
				</div>
		</article>
	</section>
</main>
<%@ include file="../layout/_footer.jsp"%>