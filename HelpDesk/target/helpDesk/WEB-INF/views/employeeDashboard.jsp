<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>DashBoard</title>
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
    
    #approve{
    	background-color: #008B8B;
        color: white;
    }
    #reject{
    	background-color: #008B8B;
        color: white;
    }

</style>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/redmond/jquery-ui.min.css
">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.14.0/css/ui.jqgrid.min.css
">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js
"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.14.0/jquery.jqgrid.min.js"></script>
<%-- <spring:url value="/resources/js/jqGridTable.js" var="jqueryJs" /> --%>
<%-- <script src="${jqueryJs}"></script> --%>

<script type="text/javascript">jQuery(document).ready(function() {
    $("#list").jqGrid({
        url : "ticketDataForEmployeeGrid",
        datatype : "json",
        mtype : 'POST',
        colNames : [ 'Ticket ID','Ticket Reference No', 'Ticket Category', 'Ticket Sub-Category', 'Subject','Description', 'Status', 'Comments' ],
        colModel : [ {
            name : 'ticketID',
            index : 'ticketID',
            width : 100
        },
        	{
                name : 'ticketReferenceNo',
                index : 'ticketReferenceNo',
                width : 100
        }, {
                name : 'ticketCategory',
                index : 'ticketCategory',
                width : 150,
                editable : true
        }, {
                name : 'ticketSubCategory',
                index : 'ticketSubCategory',
                width : 150,
                editable : true
        }, {
            name : 'subject',
            index : 'subject',
            width : 100
        }, {
                name : 'description',
                index : 'description',
                width : 100,
                editable : true
        }, {
                name : 'status',
                index : 'status',
                width : 100,
                editable : true
        }, {
            name : 'comments',
            index : 'comments',
            width : 100,
            editable : true
    } ],
    multiselect: true,
        pager : '#pager',
        rowNum : 10,
        rowList : [ 10, 20, 30 ],
        sortname : 'invid',
        sortorder : 'desc',
        viewrecords : true,
        gridview : true,
        caption : 'Data Report',
        jsonReader : {
                repeatitems : false,
        },
        editurl : "ticketDataForEmployeeGrid"
});
jQuery("#list").jqGrid('navGrid', '#pager', {
        edit : true,
        add : true,
        del : true,
        search : true
});
$("#list1").jqGrid({
   url : "ticketApproveList", //////change it
   datatype : "json",
   mtype : 'POST',
    colNames : [ 'Ticket ID','Ticket Reference No', 'Ticket Category', 'Ticket Sub-Category','Subject', 'Description', 'Status', 'Comments' ],
    colModel : [ {
        name : 'ticketID',
        index : 'ticketID',
        width : 100
    },
    	{
            name : 'ticketReferenceNo',
            index : 'ticketReferenceNo',
            width : 100
    }, {
            name : 'ticketCategory',
            index : 'ticketCategory',
            width : 150,
            editable : true
    }, {
            name : 'ticketSubCategory',
            index : 'ticketSubCategory',
            width : 150,
            editable : true
    }, {
        name : 'subject',
        index : 'subject',
        width : 100
    }, {
            name : 'description',
            index : 'description',
            width : 100,
            editable : true
    }, {
            name : 'status',
            index : 'status',
            width : 100,
            editable : true
    }, {
        name : 'comments',
        index : 'comments',
        width : 100,
        editable : true
} ],
    pager : '#pager1',
    rowNum : 10,
    rowList : [ 10, 20, 30 ],
    sortname : 'invid',
    sortorder : 'desc',
    viewrecords : true,
    gridview : true,
    caption : 'Data Report',
    jsonReader : {
            repeatitems : false,
    },
    editurl : "ticketApproveList"
});

jQuery("#list1").jqGrid('navGrid', '#pager1', {
    edit : true,
    add : true,
    del : true,
    search : true
});

jQuery("#approve").click( function(){
	
	var selRowArr = jQuery("#list").getGridParam('selarrrow');
	var comments = prompt("Please enter the comments");
	
	 for(var i=0;i<selRowArr.length;i++){
		
		 var celValue = $('#list').jqGrid('getCell', selRowArr[i], 'ticketID');
		 var xhttp = new XMLHttpRequest();
		 xhttp.onreadystatechange = function(){
			 if (this.readyState == 4 && this.status == 200) {
				 var myObj = JSON.parse(this.responseText);
				 
				 function chg(){
					 //for (var i=0; i<myObj.length; i++){
						 
						 return myObj;
					 //}
				 }
				 
				 $("#list1").jqGrid('addRowData',i+1,chg());
				 /* $("#list").delRowData(selRowArr[i]); */ 
				 jQuery("#list").trigger("reloadGrid");
				 jQuery("#list1").trigger("reloadGrid");
			 }
			 
		 };
		 
		 xhttp.open("POST", "ticketApprove?val="+celValue+"&comments="+comments,true);
		 xhttp.send();
	 
	 }
	 jQuery("#list1").trigger("reloadGrid");
	 
});
$("#list2").jqGrid({
	   url : "ticketRejectList", //////change it
	   datatype : "json",
	   mtype : 'POST',
	    colNames : [ 'Ticket ID','Ticket Reference No', 'Ticket Category', 'Ticket Sub-Category','Subject', 'Description', 'Status', 'Comments' ],
	    colModel : [ {
	        name : 'ticketID',
	        index : 'ticketID',
	        width : 100
	    },
	    	{
	            name : 'ticketReferenceNo',
	            index : 'ticketReferenceNo',
	            width : 100
	    }, {
	            name : 'ticketCategory',
	            index : 'ticketCategory',
	            width : 150,
	            editable : true
	    }, {
	            name : 'ticketSubCategory',
	            index : 'ticketSubCategory',
	            width : 150,
	            editable : true
	    }, {
	        name : 'subject',
	        index : 'subject',
	        width : 100
	    }, {
	            name : 'description',
	            index : 'description',
	            width : 100,
	            editable : true
	    }, {
	            name : 'status',
	            index : 'status',
	            width : 100,
	            editable : true
	    }, {
	        name : 'comments',
	        index : 'comments',
	        width : 100,
	        editable : true
	} ],
	    pager : '#pager2',
	    rowNum : 10,
	    rowList : [ 10, 20, 30 ],
	    sortname : 'invid',
	    sortorder : 'desc',
	    viewrecords : true,
	    gridview : true,
	    caption : 'Data Report',
	    jsonReader : {
	            repeatitems : false,
	    },
	    editurl : "ticketRejectList"
	});
	
jQuery("#reject").click( function(){
	
	var selRowArr = jQuery("#list").getGridParam('selarrrow');
	var comments = prompt("Please enter the comments");
	
	 for(var i=0;i<selRowArr.length;i++){
		
		 var celValue = $('#list').jqGrid('getCell', selRowArr[i], 'ticketID');
		 var xhttp = new XMLHttpRequest();
		 xhttp.onreadystatechange = function(){
			 if (this.readyState == 4 && this.status == 200) {
				 var myObj = JSON.parse(this.responseText);
				 
				 function chg(){
					 //for (var i=0; i<myObj.length; i++){
						 
						 return myObj;
					 //}
				 }
				 
				 $("#list2").jqGrid('addRowData',i+1,chg());
				 /* $("#list").delRowData(selRowArr[i]); */ 
				 jQuery("#list").trigger("reloadGrid");
				 jQuery("#list2").trigger("reloadGrid");
			 }
			 
		 };
		 
		 xhttp.open("POST", "ticketReject?val="+celValue+"&comments="+comments,true);
		 xhttp.send();
		 
		 
	 }
	 jQuery("#list2").trigger("reloadGrid");
});

});
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

	<div> <h4 class= "well">Pending list</h4></div>
	<div>
        <table id="list">
                <tr>
                        <td />
                </tr>
        </table>
        <div id="pager"></div>
        <br /><button type="button" class="btn btn-info" id="approve">Approve</button><button type="button" class="btn btn-info" id="reject">Reject</button><br />
     </div>
     
    <div> <h4 class= "well">Approved list</h4></div>
    <div>
        <table id="list1">
                <tr>
                        <td />
                </tr>
        </table>
        <div id="pager1"></div>
     </div>
     
     <div> <h4 class= "well">Rejected list</h4></div>
    <div>
        <table id="list2">
                <tr>
                        <td />
                </tr>
        </table>
        <div id="pager2"></div>
     </div>
    
    <div class="footer">
        <p ><center>Copyright@Yeshwanth Konakanchi</center></p> 
    </div>
</body>
</html>