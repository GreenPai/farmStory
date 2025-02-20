<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
<script>
	// 문서 로드 이후 실행	
	document.addEventListener('DOMContentLoaded', function(){
		
		const btnNext = document.getElementsByClassName('btnNext')[0];
		const check1 = document.getElementsByTagName('input')[0];
		const check2 = document.getElementsByTagName('input')[1];
		
		btnNext.onclick = function(e){			
			
			if(check1.checked && check2.checked){				
				return true;
			}else{
				alert('동의체크를 해야 합니다.');
				return false;
			}
		}
	});
</script>
<main id="user">
    <section class="terms">
        <h2 class="tit">사이트 이용약관</h2>
        <table border="1">                    
            <tr>
                <td>
                    <textarea name="terms">${dto.terms}</textarea>
                    <label><input type="checkbox" class="terms">&nbsp;동의합니다.</label>
                </td>
            </tr>
        </table>

        <h2 class="tit">개인정보 취급방침</h2>
        <table border="1">                    
            <tr>
                <td>
                    <textarea name="privacy">${dto.privacy}</textarea>
                    <label><input type="checkbox" class="privacy">&nbsp;동의합니다.</label>
                </td>
            </tr>
        </table>
        
        <div>
            <a href="/jboard/user/login.do" class="btn btnCancel">취소</a>
            <a href="/jboard/user/register.do" class="btn btnNext">다음</a>
        </div>

    </section>
</main>
<%@ include file="./_footer.jsp" %>