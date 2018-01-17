<%@ page language ="java" contentType ="text/html; charset = ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
    
 .footer {
   position:absolute;
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
    
  
    .TM{
        color: white;
    }
    .help{
        color: white;
    }

    #loginButton{
         background-color: #008B8B;
        color: white;
       
    }
    
   
</style>
</head>
<body>

<header>

<h2 class="head">Ektha Solutions</h2>
</header>
  
<nav class="navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="homePage">Help Desk</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a class= "home" href="homePage">Home</a></li>
      <li><a class= "TM" href="dashBoard">Ticket Management</a></li>
      <li><a class= "help" href="Contact">Contact Us</a></li> 
    </ul>
  </div>  
</nav>

	<div class="container">
  <h2 class="well">Login</h2>
  ${error}
  <form class="form-horizontal" action="loginUser" method="POST">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-4">
        <input type="email" class="form-control" placeholder="Enter email" name="userName" id="email" >
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-4">          
        <input type="password" class="form-control" placeholder="Enter password" name="password" id="password">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-4">
        <button type="submit" class="btn btn-default" id="loginButton">login</button>
      </div>
    </div>
  </form>
</div>
  

    <div class="footer">
        <p ><center>Copyright@Yeshwanth Konakanchi</center></p> 
    </div>   


</body>
</html>
