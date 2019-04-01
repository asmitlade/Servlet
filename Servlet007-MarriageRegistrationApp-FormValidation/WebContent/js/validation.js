function validForm(form){
	let name = check.name.value;
	let age = check.age.value;
	document.getElementById("errName").innerHTML="";
	document.getElementById("errAge").innerHTML="";
	if(name==""){
		document.getElementById("errName").innerHTML="Please Enter Your Name";
		return false;
	}
	else if(age==""){
		document.getElementById("errAge").innerHTML="Please Enter Your Age";
		return false;
	}
	else if(age<=0 || age>=125){
		document.getElementById("errAge").innerHTML="Please Enter Age between 0 to 124";
		return false;
	}
	else if(isNaN(age)){
		document.getElementById("errAge").innerHTML="Please Enter Age as numeric value";
		return false;
	}
	else{
		return true;
	}
}