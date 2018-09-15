<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Controller.CreateTST"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
	
<script type="text/javascript" 
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.autocomplete.js"></script>


<style>
body {
	background-color: #fff;
}

h4 {
	font-size: 36px;
	color: #000080;
	font-weight: bold;
	text-align: center;
	margin: 30px 5px 15px 5px;
}

.setText {
	width: 500px;
	font-size: 14px;
	color: #000;
	padding: 10px;
	margin: 10px 5px 10px 5px;
	border: 1px solid #000;
}

.orangebtn {
	background: -webkit-gradient(linear, left top, left bottom, from(#faa51a),
		to(#f47a20));
	background: -moz-linear-gradient(top, #faa51a, #f47a20);
	color: #fef4e9;
	padding: 10px 25px;
	margin: 10px;
	font-size: 16px;
	background-color: #000;
}

.divCenter {
	position: fixed;
	top: 40%;
	left: 50%;
	transform: translate(-50%, -50%);
}

</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Search Engine</title>
</head>
<body >
<%
	CreateTST.createTrie();
%>

	<center>
		<div class="divCenter">
			<h4>Web Search Engine</h4>
			<form action="<%=request.getContextPath()%>/mainController" method="post" name="addname">

				<input type="text" name="sname" id="sname" placeholder="Search..." class="setText">
				<i class="fa fa-search" style="margin-left: -30px;display: inline-block;"></i>
				<input type="hidden" name="flag" value="tname"> <br /> 
				<input type="radio" name="command" value="0" checked="checked" />Word Occurrences
				<input type="radio" name="command" value="1" />Page Rank
				<input type="radio" name="command" value="2" />Spell Check<br /> 
				<input type="submit" value="Search" class="orangebtn">

			</form>
		</div>
	</center>
	
	<script type="text/javascript">
	
	
$("#sname").autocomplete("getdata.jsp",{
	extraParams:{
		filter:gettextboxvalue()
	}
});

function gettextboxvalue(){
	var check = document.getElementById("sname").value;
	return check;
}
</script>
</body>
</html>