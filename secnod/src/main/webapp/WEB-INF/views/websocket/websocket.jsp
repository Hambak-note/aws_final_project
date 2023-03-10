<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>

	#chatarea {
		background-color: yellow;
		border:2px solid black;
	}
</style>

</head>
<body>
	
	별명: <input type=text id="nickname" value="${param.id}">
	<input type=button id="enterbtn" value="입장">
	<h1>채팅영역</h1>
	<div id="chatarea">채팅내용표시<br></div>
	전송할 메시지: <input type=text id=message> <input type = button id=sendbtn value="메시지전송">
	
	<script src="js/jquery-3.6.1.min.js"></script>
	<script>
	$(function() {
		
		var websocket;
		
		$("#enterbtn").on('click', function(){
			websocket = new WebSocket("ws://localhost:8085/ws");
			websocket.onopen = open;
			websocket.onclose = close;
			websocket.onmessage = message; //서버가 응답한 내용 수신
		});
		
		$("#sendbtn").on('click', function(){ //서버로 송신
			var nickname = $("#nickname").val();
			var sendmessage = $("#message").val();
			websocket.send(nickname + ":" +sendmessage);
		});
	});
	
	function open(){
		console.log("웹 소켓 연결 성공");
	}
	
	function close(){
		console.log("웹 소켓 해제 성공");
	}
	
	function message(evt){
		console.log("서버로부터 메시지 수신성공");
		$("#chatarea").append(evt.data+"<br>");
	}
		
	</script>

</body>
</html>