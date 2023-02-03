<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="fileupload" method=post enctype="multipart/form-data" >
작성자:<input type=text name="name" ><br>
설명:<input type=text name="description" ><br>
업로드파일1:<input type=file name="file1" ><br>
업로드파일2:<input type=file name="file2" ><br>
<input type=submit value="파일전송">
    젠킨스에서 가져온 프로젝트가 맞는지 확인하기 위한 구문
</form>
</body>
</html>
