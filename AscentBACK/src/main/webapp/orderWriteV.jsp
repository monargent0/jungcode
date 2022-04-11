<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Write</title>
<!-- jQuery -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
</head>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
  table {
        border-collapse: collapse;
        width: auto;
        height: auto;
      }
      
      table, th, td {
        padding: 5px;
       }
       th{
       border-top : 1px solid black;
       border-bottom: 1px solid black;
       }
       
      .list{
      	position: absolute;
      	top : 50%;
      	left : 50%;
      	transform : translate(-50%,-50%);
      }
</style>
<script>
	
	var width = 500; //팝업의 너비
	var height = 600; //팝업의 높이
    
function sample6_execDaumPostcode() {
	
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
	    
    }).open();
}
</script>
<body>
<div class="list">
	<h2>주문 하기</h2>
	<form method="get">
		<table>
			<tr>
				<td>
				<h3>주문 상품</h3>
				</td>
			<tr>
				<th hidden="">cartCode</th>
				<th hidden="">productCode</th>
				<th>이미지</th>
				<th>이름</th>
				<th>용량</th>
				<th>가격</th>
				<th>수량</th>
				<th>합계</th>
			</tr>
			<c:set var="orderSum" value="0" />
			<c:set var="orderAmount" value="0" />
			<c:forEach items="${cartList }" var="dto" varStatus="status">
			<tr>
				<td align="center" hidden="">
				<input type="text" value="${dto.cartCode }" name="cartCode" readonly="readonly" style="text-align:center; ">
				</td>
				<td align="center" hidden="">
				<input type="text" value="${dto.productCode }" name="productCode" readonly="readonly">
				</td>
				<td align="center">
				<input type="image" value="${dto.productImages }" name="productImages" readonly="readonly">
				</td>
				<td align="center">
				<input type="text" value="${dto.productName }" name="productName" readonly="readonly">
				</td>
				<td align="center">
				<input type="text" value="${dto.productSize }" name="productSize" readonly="readonly">
				</td>
				<td align="center">
				<input type="number" value="${dto.productPrice }" name="productPrice" readonly="readonly">
				</td>
				<td align="center">
				<input type="number" value="${dto.cartAmount }" name="cartAmount" readonly="readonly"> 개
				</td>
				<td align="center">
				<input type="number" value=${dto.cartSum } name="cartSum" readonly="readonly"> 원
			</tr>
			<c:set var= "total" value="${orderSum + dto.cartSum}"/>
			<c:set var= "total" value="${orderAmount + dto.cartAmount}"/>
			</c:forEach>
		</table><br>
		<table>
			<tr>
				<td>
				<h3>결제 정보</h3>
				</td>
			</tr>
			<tr>
				<td>
				주문 총량
				</td>
				<td>
				<input type="number" value="${orderAmount }" name="orderAmount" readonly="readonly"> 개
				</td>
			</tr>
			<tr>
				<td>
				주문 총액
				</td>
				<td>
				<input type="number" value="${orderSum }" name="orderSum" readonly="readonly"> 원
				</td>
			</tr>
			<tr>
			</tr>
		</table><br>
		<table>
			<tr>
				<td><h3>배송 정보</h3></td>
			</tr>
			<tr>
				<td align="right">받는 사람</td>
				<td><input type="text" name="orderReceiver" size="10"></td>
			</tr>
			<tr>	
				<td align="right">우편 번호</td>
				<td>
				<input type="text" name="orderPostcode" id="sample6_postcode" placeholder="우편번호" size="20">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
				</td>
			</tr>
			<tr>	
				<td align="right">주소</td>
				<td><input type="text" name="orderMainAddress" id="sample6_address" placeholder="주소" size="30"></td>
			</tr>
			<tr>	
				<td align="right">참고항목</td>
				<td><input type="text" name="orderDetailAddress" id="sample6_extraAddress" placeholder="참고항목" size="30"></td>
			</tr>
			<tr>	
				<td align="right">상세주소</td>
				<td><input type="text" name="orderExtraAddress" id="sample6_detailAddress" placeholder="상세주소"></td>
			</tr>
			<tr>
				<td colspan="2">
				</td>
			</tr>
		</table><br>
		<table>
			<tr>
				<td>
				일반 결제
				</td>
				<td>
				<input type="radio" name="카카오페이" value="kakaopay">
				<img alt="KakaoPay" src="img/payment_icon_yellow_small.png" height="10">
				</td>
			</tr>
		</table><br>
		<input type="button" value="결제하기" formaction="pay.do" onclick="requestPay()">
	</form>
</div>
</body>
<script type="text/javascript">
var IMP = window.IMP; // 생략 가능
IMP.init("imp26081497"); // 예: imp00000000

function requestPay() {
    // IMP.request_pay(param, callback) 결제창 호출
    IMP.request_pay({ // param
        pg: "kakaopay",
        pay_method: "kakaopay",
        merchant_uid: "ORD20180131-0000011",
        name: "노르웨이 회전 의자",
        amount: 1,
        buyer_email: "gildong@gmail.com",
        buyer_name: "홍길동",
        buyer_tel: "010-4242-4242",
        buyer_addr: "서울특별시 강남구 신사동",
        buyer_postcode: "01181"
    }, function (rsp) { // callback
        if (rsp.success) {
            // 결제 성공 시 로직,
            alert('결제 성공')
        } else {
            // 결제 실패 시 로직,
            alert('결제 취소')
        }
    });
  }
</script>
</html>