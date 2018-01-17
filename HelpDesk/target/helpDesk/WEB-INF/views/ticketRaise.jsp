<%@ page language ="java" contentType ="text/html; charset = ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head>
   <title>Raise Ticket</title>
   <title>Help Desk</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <style>
    
 .footer {
   
   bottom:0;
   width:100%;
   height:60px;   /* Height of the footer */
   background:#808080;
}
    center{
        color: white;
        
    }
    .head{
    	font-family: serif;
    	font-style: italic;
    }
    
    .navbar{
        background-color: #008B8B;
        
    }
    .navbar-brand{
        color: white;
    }
    .dropdown-toggle{
        color: white;
    }
    .home{
        color: white;
    }
    
  	    .signOut{
        color: white;
    }
 
    .TM{
        color: white;
    }
    .help{
        color: white;
    }
	#submitButton{
        background-color: #008B8B;
        color: white;
    }

</style>
   <script type="text/javascript">
   function chg()
   {
	   var val = document.getElementById('ticketCategory').value;
	   var xhttp = new XMLHttpRequest();
	   xhttp.onreadystatechange=function()
	   {
		   if (this.readyState == 4 && this.status == 200) {
			    document.getElementById('ticketSubCategory').innerHTML = xhttp.responseText;
			}
	   };
	   xhttp.open("POST", "ticketSubCategory?valAjax="+val, true);
	   xhttp.send();
   }
   </script>

   
</head>
<body>
<header>

<h2 class="head">Ektha Solutions</h2>
</header>
  
<nav class="navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="helpDesk">Help Desk</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a class= "home" href="home">Home</a></li>
      <li><a class= "TM" href="dashBoard">Ticket Management</a></li>
      <li><a class= "help" href="#">Contact Us</a></li> 
    </ul>
        <ul class="nav navbar-nav navbar-right">
        <li><a class ="signOut" href="signOut" ><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
    </ul>
  </div>  
</nav>

<div class="container">

<h3 class="well">Raise Ticket</h3>

	<form class="form-horizontal" method="POST" action="submitTicket">
	
	<div class="form-group">
	
      <label class="control-label col-sm-2" for="ticketCategory">Ticket Category:</label>
      <div class="col-sm-4">
       <select id="ticketCategory" name="ticketCategory" onchange="chg()">
               <option>Select</option>
			${ticketCategoryDropDown}
            </select>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="ticketSubCategory">Ticket SubCategory:</label>
      <div class="col-sm-4">
       <select id="ticketSubCategory" name="ticketSubCategory">

            </select>
      </div>
    </div>
	
	<div class="form-group">
      <label class="control-label col-sm-2" for="subject">Subject:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" placeholder="subject" name="subject" id="subject" required>
      </div>
    </div>
    
     <div class="form-group">
      <div class="col-sm-offset-2 col-sm-4">
      <label class="control-label col-sm-2" for="description">Description:</label>
      <textarea class="form-control" rows="5" name="description" id="description"></textarea>
    </div>
    </div>
    
        <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-4">
        <button type="submit" class="btn btn-default" id="submitButton">Submit</button>
      </div>
    </div>
	
	
	</form>

</div>

<div class="footer">
        <p ><center>Copyright@Yeshwanth Konakanchi</center></p> 
    </div>


<%-- <h3 class="well">Raise Ticket</h3>

<form method="POST" action="submitTicket">
   <table>
   
   	<tr>
         <td>Ticket Category</td>
         <td>
            <select id="ticketCategory" name="ticketCategory" onchange="chg()">
               <option>Select</option>
			${ticketCategoryDropDown}
            </select>     	
         </td>
      </tr>
      <tr>
         <td>Ticket SubCategory</td>
         <td>
            <select id="ticketSubCategory" name="ticketSubCategory">
              
            </select>     	
         </td>
      </tr> 
       <tr>
         <td>Subject</td>
         <td><input type="text" name="subject" id="subject"></td>
      </tr>    
      <tr>
         <td>Description</td>
         <td><textarea name="description" rows="10" cols="30"></textarea></td>
      </tr> 
      
       	  
      <tr>
         <td colspan="2">
            <input type="submit" value="Submit"/>
         </td>
      </tr>
   </table>  
</form> --%>
</body>
</html>