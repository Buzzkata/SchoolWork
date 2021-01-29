
<?php
	//msgBoardRegister.php
	include('header.php');
?>
<html>
<body>
	<div id="header"><h2>Message Board</h2></div>
	<div id="login">
	
		<p>
			<?php
				echo '<h4>Welcome';
			
				if(isset($_SESSION['first_name'])){
					echo ", {$_SESSION['first_name']}!";
				}
				
				echo '</h4>';
				
				if(isset($_SESSION['user_id']) AND (substr($_SERVER['PHP_SELF'], -10) != 'logout.php')){
					echo '<a href="logout.php">Logout</a><br /> <a href="change_password.php">Change Password </a><br />';
					
				}
				else{
					echo '<a href="register.php">Register</a><br /> <a href="login.php">Login to your account</a><br /> <a href="forgot_password.php">Forgot Password</a><br />';
				}
			?>
		</p>
		
	</div>
	
	<h1> Register </h1>
	
	<form action="mbregister.php" method="post">
		<fieldset>
			<p><b> First name: </b><input type="text" name="firstName" size="20" maxlength="20" value="<?php if(isset($_POST['firstName'])) echo $_POST['firstName']; ?>" /> </p>
			
			<p><b> Last name: </b><input type="text" name="lastName" size="25" maxlength="25" value="<?php if(isset($_POST['lastName'])) echo $_POST['lastName']; ?>" /> </p>
			
			<p><b> Email Adress: </b><input type="text" name="email" size="40" maxlength="40" value="<?php if(isset($_POST['email'])) echo $_POST['email']; ?>" /> </p>
			
			<p><b> Username: </b><input type="password" name="userID" size="20" maxlength="20" /><small>Must contain an upper case lower case letter, minimum length of 8 characters. </small></p>
			
			<p><b> Password: </b><input type="password" name="pass1" size="20" /><small>Must contain an upper case lower case letter, minimum length of 8 characters. </small></p>
			
			<p><b> Confirm Password:</b><input type="password" name="pass2" size="20" /></p>
			
		<?php
			$publickey="sdsa7f8sa";
			echo recapcha_get_html($publickey);//capcha validation
		?>
		
		</fieldset>
		
		<div align="center"><input type="submit" name="submit" value="Register" /></div>
		
		<input type="hidden" name="submitted" value="TRUE" />
	</form>
	
	</body>
	</html>