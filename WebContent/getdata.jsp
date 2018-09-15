<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Controller.AutoComplete"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%


	String query = request.getParameter("filter");
	
	System.out.println(query);
	
	List<String> pagewords = AutoComplete.getData(query);

	Iterator<String> iterator = pagewords.iterator();
	while(iterator.hasNext()) {
		String words = (String)iterator.next();
		out.println(words);
	}
%>
</body>
</html>