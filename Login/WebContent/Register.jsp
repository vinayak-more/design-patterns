<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<form action="Register" method="post" name="myForm" onsubmit="return validateForm()">
Name:&nbsp;<input type="text" name="firstname" /><span id="errorname"></span><br/>
username:&nbsp;<input type="text" name="username" /><span id="errorusername"></span><br/>
email:&nbsp;<input type="email" name="email" /><span id="erroremail"></span><br/>
password:&nbsp;<input type="password" name="password" /><span id="errorpassword"></span><br/>
re-enter password:&nbsp;<input type="password" name="repassword"/><span id="errorrepassword"></span><br/>
date of birth:&nbsp;<input type="date" name="dob" min="5" max="100"><span id="errorage"></span><br/>
gender: &nbsp; <input type="radio" name="gender" value="Male"/>Male &nbsp; 
<input type="radio" name="gender" value="Female"/>Female<br/>  
&nbsp;&nbsp;<input type="submit" value="submit"/> 
</form>

<script type="text/javascript">
function validateForm() {
	var regex_name = /^[a-zA-Z ]+$/;
    var name = document.forms["myForm"]["firstname"].value;
    if (!regex_name.test(name)) 
	    {
	        //alert("Aplabates only");
	        document.getElementById('errorname').innerHTML="<span style=\"color:red\">Aplabates only</span>";
	        document.forms["myForm"]["firstname"].value="";
	        return false;
	    }
    document.getElementById('errorname').innerHTML="<span style=\"color:red\"></span>";
   var regex_username=/^[a-zA-Z0-9]+$/;
    var username=document.forms["myForm"]["username"].value;
    if(!regex_username.test(username))
    	{
    		//alert("username only coantains characters and numbers");
    		document.getElementById('errorusername').innerHTML="<span style=\"color:red\">username only contains characters and numbers</span>";
    		return false;
    	}
    document.getElementById('errorusername').innerHTML="<span style=\"color:red\"></span>";
	
    var regex_password=/^[ ]+$/;
    var password=document.forms["myForm"]["password"].value;
    if(regex_password.test(password))
		{
			//alert("password cannot contain blank space");
			document.getElementById('errorpassword').innerHTML="<span style=\"color:red\">password cannot contain blank space</span>";
			document.forms["myForm"]["password"].value="";
    		return false;
		}
    document.getElementById('errorpassword').innerHTML="<span style=\"color:red\"><span>";
	
    if(password.length<6)
    	{
	    	//alert("password must be greater than 6 characters");
	    	document.getElementById('errorpassword').innerHTML="<span style=\"color:red\">password must be greater than 6 characters</span>";
    		
			return false;
    	}
    document.getElementById('errorpassword').innerHTML="<span style=\"color:red\"></span>";
	
    var repassword=document.forms["myForm"]["repassword"].value;
    if(password!=repassword)
    	{
	    	//alert("password did not match");
	    	document.getElementById('errorrepassword').innerHTML="<span style=\"color:red\">password did not match</span>";
	    	document.forms["myForm"]["repassword"].value="";
	    	document.forms["myForm"]["password"].value="";
			return false;
    	}
    document.getElementById('errorrepassword').innerHTML="<span style=\"color:red\"></span>";
	
    
}
</script>
</body>
</html>