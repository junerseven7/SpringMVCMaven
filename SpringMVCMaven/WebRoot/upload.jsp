<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/upload/file.do"	method="post" enctype="multipart/form-data">
		文件<input type="file" name="aaa"><input type="submit"	value="上传">
	</form>
	
	<form action="<%=request.getContextPath()%>/upload/fileImprove.do"	method="post" enctype="multipart/form-data">
		文件2<input type="file" name="bbb"><input type="submit"	value="上传">
	</form>
</body>
</html>