<?php
//header.php
	ob_start();
	session_start();
	
	require_once('configMsgBoard.php');
	//requireonce recapcha lib if were using capcha to validate
	
?>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Message Board Forum </title>
<style>
	body {
		background-color: #FFF; 
	}
	
	#header {
		background-color: #006;
		color: #FFF;
		padding: 20px;
	}
	
	#footer {
		background-color: #006;
		color: #FFF;
		padding: 20px;
	}
	
	#main {
		padding: 15px;
		background-color: #FAF0E6;
		color: #FFF;
		margin-right: 220px;
		margin-top: 5px;
	}
	
	#login {
		padding: 10px;
		padding-bottom: 15px;
		border: none;
		background-color: #E0FFFF;
		width: 200px;
		text-align: left;
		float: right;
		margin-left: 10px;
		margin-right: 5px;
		margin-top: 5px;
	}
	
</style>
</head>
