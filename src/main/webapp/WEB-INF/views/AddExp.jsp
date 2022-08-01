<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Expense</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
<body>
	<h2>Add New Expense</h2>

	<form>
		Title :<br> <Br> Date : <br> <bR>
		<button type="button" id="btnGo">Go</button>
		<br>
		<br> Category : <select id="category" name="category">
			<option>Select Category</option>
		</select>

	</form>
	<script>
	
		$(document).ready(function(){
			$("#btnGo").click(function(){
						let url = "http://localhost:9898/categories";	
						 	 
						$.get(url)
						.done(function(data){
							console.log(data);
							let category = $("#category");
							for(let i=0;i<data.length;i++){ 
								category.append("<option value="+data[i].categoryId+">"+data[i].categoryName+"</option>");
							}
							
						}).fail(function(){
							console.log("something went wrong"); 
						});

			})	
		})
		
		
	</script>
</body>
</html>