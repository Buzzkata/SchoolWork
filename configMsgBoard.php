

<?php
//configMsgBoard.php
	DEFINE('DBUSER', '');
	DEFINE('DBPW', '');
	DEFINE('DBHOST', '');
	DEFINE('DBNAME', ''); //this is database names pswrd user host
	
	if($dbc = mysql_connect(DBHOST,DBUSER,DBPW)){
		if(!mysql_select_db(DBNAME)){
			trigger_error("Could not select db" . mysql_error()){
				exit();
			}
		}
		
	}
	else{
		trigger_error("Couldnt connect to MySQL.");
		exit();
	}
	
	function escape_data($data){
		if(function_exists('mysql_real_escape_string')){
			global $dbc;
			$data = mysql_real_escape_string(trim($data),$dbc);
			$data = strip_tags($data);		
		}
		else{
			$data = mysql_escape_string(trim($data));
			$data= strip_tags($data);
		}
		
		return $data;
	}
	
?>