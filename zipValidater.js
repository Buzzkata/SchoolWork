<script>

	function checkForm(){  //in the html file we add the name theForm as form name
		if(document.forms["theForm"]["Address"].value == ""){
			alert("Error. You need to enter an adress.");
			
			return false;
		}
		if(document.forms["theForm"]["cityinput"].value == ""){
			alert("Error. You need to enter a city.");
			
			return false;
		}
		if(document.forms["theForm"]["countryinput"].value == "canada"){
			if(document.forms["theForm"]["zipinput"].value == ""){
				alert("Error. Need to enter a postal code.");
				return false;
			}
			else{
				var userIn = document.forms["theForm"]["zipinput"].value;
				if(userIn.length == 6){
					if(!(Number.isInteger(userIn.charAt(0)))){ //not integer.assuming no special characters entered
						if(Number.isInteger(userIn.charAt(1))){// number
							if(!(Number.isInteger(userIn.charAt(2)))){//letter
								if(Number.isInteger(userIn.charAt(3))){//number
									if(!(Number.isInteger(userIn.charAt(4)))){//letter
										if(Number.isInteger(userIn.charAt(5))){//number
											return true; //valid zip
										}
									}
								}
							}
						}
					}
				}
				return false;
			}
		}else if(document.getElementById('countryinput').value == "us"){
			//here we validate the us postal code
		}
	}
</script>