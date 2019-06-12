<!DOCTYPE html>
<html>
	<head>
	<!--IN META SONO CONTENUTE TUTTE LE INFORMAZIONI RIGUARDATI LA PAGINA-->
	<!-- viewport adatta la visibilita' della pagine al browser; con content width impostiamo la larghezza in base
	 alla larghezza device-width cioè dello schermo del dispositivo -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="Ascione Dalila, Ferrante Roberta, Mundo Consiglia, Siciliano Flavia">
		<title>Home Page</title>
		<!--CSS-->
		<style>
			body {font-family: Arial, Helvetica, sans-serif; 
				  background-image: url('http://localhost:8080/TakeBook/images/library-header.jpg');
				  height: 100vh;
	 	 		  background-size: cover;
	 	 		  background-position: center;
				  }
				
			
			form {	left: 60%;
					right: 60%;
				    top: 50%;
				    margin-left: -25%;
				    margin-right: -25%;
				    margin-bottom: 25px;
				    position: absolute;
				    margin-top: -19%;
				    border: 3px solid #f1f1f1;
				    background-color: white}
			
			input[type=email], input[type=password] {
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
			
			<!--AL PASSAGGIO DEL MOUSE-->
			button:hover {
			  opacity: 0.8;
			}
			
			.resetbtn {
			  width: auto;
			  padding: 10px 18px;
			  background-color: #f44336;
			}
			
			.imgcontainer {
			  text-align: center;
			  margin: 24px 0 12px 0;
			}
			
			img.avatar {
			  width: 40%;
			  border-radius: 50%;
			}
			
			.container {
			  padding: 16px;
			}
			
			span.bnv {
			  float: right;
			  padding-top: 16px;
			}
		</style>
	</head>
	
	<body>
		<h2 align="center" ><font color="white" face="Bodoni">TakeBook</font></h2>
		<form method ="post" action="http://localhost:8080/TakeBook/ServletIndex">
		  	<div class="imgcontainer">
		    	<img src="http://localhost:8080/TakeBook/images/avatar.png" alt="Avatar" class="avatar">
		  	</div>
		  	<div class="container">
		    	<label for="em"><b>Inserisci la tua email:</b></label>
		     	<input type="email" placeHolder="Email" name="email" id ="E">
		    	<label for="psw"><b>Inserisci la tua password:</b></label>
		    	<input type="password" placeHolder="Password" name="password" id="P" required> 
		    	<button type="submit" >Login</button>
		    	
		    	<% if(request.getAttribute("err") != null && request.getAttribute("err").equals(1)){%>
					<div style="color:red">  *Utente e password errati </div>
				<%}%>
		 	</div>
		 	<br>
			  Non sei ancora registrato? <a href="http://localhost:8080/TakeBook/VIEW/formregistrazione.jsp">Clicca qui!</a>
		  	<div class="container" style="background-color:#f1f1f1">
		    	<button type="reset" class="resetbtn">Reset</button>
		    	<span class="bnv">Unisciti a noi!</span>
		  	</div>
		</form>
	</body>
</html>