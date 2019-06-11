<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Menu</title>
		<style>
			body {
			  margin: 0;
			  background-image: url('./images/libroimmagine.jpg') ;
			  height: 40%;
			  background-position: center;
  				background-repeat: no-repeat;
  				background-size: cover;
  	
			}
			
		
			
			
			input[type=text] {
			  width: 100%;
			  padding: 12px 20px;
			  margin: 8px 0;
			  display: inline-block;
			  border: 1px solid #ccc;
			  box-sizing: border-box;
		
			}
			
			button {
			  background-color: #4CAF50;
			  color: white;
			  padding: 14px 20px;
			  margin: 8px 0;
			  border: none;
			  cursor: pointer;
			  width: 100%;
			}
				
			ul {
			  list-style-type: none;
			  margin: 0;
			  padding: 0;
			  width: 15%;
			  background-color: #f1f1f1;
			  position: fixed;
			  height: 30%;
			  overflow: auto;
			}
			
			li a {
			  display: block;
			  color: #000;
			  padding: 8px 16px;
			  text-decoration: none;
			}
			
			li a.active {
			  background-color: #4CAF50;
			  color: white;
			}
			
			li a:hover:not(.active) {
			  background-color: #555;
			  color: white;
			}
		</style>
	</head>
	<body>
		<ul>
		  <li><a class="active" href="C:\Users\Protom\git\TakeBookProject\WebContent/VIEW//menu.jsp">Home</a></li>
		  <li><a href="">Contact</a></li>
		  <li><a href="#about">About</a></li>
		  <li><a href="http://localhost:8080/TakeBook/index.html">Logout</a></li>
		</ul>
			<div style="margin-left:20%;margin-right:15%;padding:1px 16px;height:1000px; "  >
	  			<h1 align="center">Ciao <%= request.getSession().getAttribute("nome") %></h1>
	  			
	  			
	  			<form>
				  <input type="radio" name="ricerca" value="libro"> Ricerca per titolo<br>
				  <input type="radio" name="ricerca" value="autore"> Ricerca per autore<br>
				  <input type="text" placeHolder="Cerca" name="cerca" id ="R">
				  <button type="submit">Cerca</button>
	
				</form> 
			
		</div>
	</body>
</html>