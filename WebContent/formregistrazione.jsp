<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registrati</title>
	
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script language="javascript">
			function passTest() {
			
				let psw = document.getElementsByName("psw")[0].value;
				let pswrepeat = document.getElementsByName("pswrepeat")[0].value;
	  			if(psw!=pswrepeat){
	  				alert("La password non corrisponde");
	  				return false;
	  			}
	  			return true;
			}
		</script>
		<style>
			body {
			  font-family: Arial, Helvetica, sans-serif;
			  background-image: url('https://assets.poetryfoundation.org/uploads/contentImages/_1092xAUTO_fit_top-center/library-header.jpg?1092');
			  height: 100%;
			  background-position: center;
  				background-repeat: no-repeat;
  				background-size: cover;
  				 height: 180vh;
 	 		 
 	 		  
			}
			
			* {
			  box-sizing: border-box;
			}
			
			form {left: 50%;
				right: 50%;
			    top: 50%;
			    margin-left: -25%;
			    margin-right: -25%;
			    position: absolute;
			    margin-top: -19%;
			    margin-bottom: 5%;
			    border: 3px solid #f1f1f1;}
			
			/* Add padding to containers */
			.container {
			  padding: 16px;
			  background-color: white;
			}
			
			/* Full-width input fields */
			button {
			  background-color: #4CAF50;
			  color: white;
			  padding: 14px 20px;
			  margin: 8px 0;
			  border: none;
			  cursor: pointer;
			  width: 100%;
			}
			input[type=text], input[type=password] {
			  width: 100%;
			  padding: 15px;
			  margin: 5px 0 22px 0;
			  display: inline-block;
			  border: none;
			  background: #f1f1f1;
			}
			
			input[type=text]:focus, input[type=password]:focus {
			  background-color: #ddd;
			  outline: none;
			}
			
			/* Overwrite default styles of hr */
			hr {
			  border: 1px solid #f1f1f1;
			  margin-bottom: 25px;
			}
			
			/* Set a style for the submit button */
			.registerbtn {
			  background-color: #4CAF50;
			  color: white;
			  padding: 16px 20px;
			  margin: 8px 0;
			  border: none;
			  cursor: pointer;
			  width: 100%;
			  opacity: 0.9;
			}
			
			.registerbtn:hover {
			  opacity: 1;
			}
			
			/* Add a blue text color to links */
			a {
			  color: dodgerblue;
			}
			
			/* Set a grey background color and center the text of the "sign in" section */
			.signin {
			  background-color: #f1f1f1;
			  text-align: center;
			}
		</style>
		</head>
	<body>
	
		<form method = "post" action="./ServletForm">
		  <div class="container">
		    <h1 align = "center" >Registrati</h1>
		    <% if(request.getAttribute("err") != null && request.getAttribute("err").equals(2)){
					%>
					<div> <p  style="color:#FF0000" > *Utente gi&agrave  presente</p> </div>
				<%}%>
		    <p align = "center"> Inserisci i tuoi dati nei seguenti campi</p>
		    <hr>
		
			<label for="nome"><b>Nome</b></label>
		    <input type="text" placeholder="Inserisci il tuo nome" name="nome" >
		    
		    <label for="cognome"><b>Cognome</b></label>
		    <input type="text" placeholder="Inserisci il tuo cognome" name="cognome" >
		    
		    <label for="indirizzo"><b>Indirizzo</b></label>	<br>
	    	<input type="text" placeholder="Inserisci il tuo indirizzo" name="indirizzo">
	    	
	    	<label for="citta"><b>Inserisci la tua citta</b></label>	<br>
	    	<input type="text" placeholder="Inserisci la tua citta" name="citta">
	    	
		    <label for="email"><b>Email</b></label>
		    <input type="text" placeholder="Inserisci Email" name="email" required >
		
		    <label for="psw"><b>Password</b></label>
		    <input type="password" placeholder="Inserisci Password" name="psw" required>
		
		    <label for="pswrepeat"><b>Ripeti password</b></label>
		    <input type="password" placeholder="Ripeti Password" name="pswrepeat" required>
		    <hr>
		    <p>Prima di creare il tuo account dai un'occhiata al <a href="#">Terms & Privacy</a>.</p>
		
		    <button type="submit" onClick="return passTest();">Registrati</button>
		  </div>
		  
		  <div class="container signin">
		    <p>Hai gi&agrave un account? <a href="./index.jsp">Accedi</a>.</p>
		  </div>
		</form>
	
	</body>
</html>