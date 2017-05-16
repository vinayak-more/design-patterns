<html>
<body>
<h2>Hello World!</h2>
    <div class="container">
      <div class="col-md-6">
          <form class="form-signin" role="form" action="validateform.php" method="POST">
                <div id="status">
                </div>
            <h2 class="form-signin-heading">Please sign in</h2>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" value="mycodde@test.com" class="form-control" placeholder="Email address" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" value="rashid" class="form-control" placeholder="Password" required>
            <div id="recaptcha1"></div>
            <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="verify()">Sign in</button>
          </form>
      </div>
      <div class="col-md-6">
          <form class="form-signin" role="form" action="validateform.php" method="POST">
                <div id="status">
                </div>
            <h2 class="form-signin-heading">Sign Up Form</h2>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" value="mycodde@test.com" class="form-control" placeholder="Email address" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" value="rashid" class="form-control" placeholder="Password" required>
        <div id="recaptcha2"></div>
            <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="verify2()">Sign in</button>
          </form>
      </div>
    </div> <!-- /container -->
</body>
<script src="https://www.google.com/recaptcha/api.js?onload=myCallBack&render=explicit" async defer></script>
    <script>
      var recaptcha1;
      var recaptcha2;
      var myCallBack = function() {
        //Render the recaptcha1 on the element with ID "recaptcha1"
        recaptcha1 = grecaptcha.render('recaptcha1', {
          'sitekey' : '6LenoCEUAAAAAEdWQwzTw9-_MPHzyP2N9zOwES3S', //Replace this with your Site key
          'theme' : 'light'
        });
        
        //Render the recaptcha2 on the element with ID "recaptcha2"
        recaptcha2 = grecaptcha.render('recaptcha2', {
          'sitekey' : '6LenoCEUAAAAAEdWQwzTw9-_MPHzyP2N9zOwES3S', //Replace this with your Site key
          'theme' : 'dark'
        });
      };
      function verify2(){
    	  var captcha_response = grecaptcha.getResponse(1);
    	    if(captcha_response.length == 0)
    	    {  
    	    	alert("invalid captcha");return false;
    	    }
      };
      function verify(){
    	  var captcha_response = grecaptcha.getResponse(0);
    	    if(captcha_response.length == 0)
    	    {  
    	    	alert("invalid captcha");return false;
    	    }
      };
    </script>
</html>
