$(document).ready(function(){
	  $(".sign_bt").click(function(){
	    if($(".passwordsignup")!=$(".passwordsignup_confirm")){
	    	alert("二次密码不一致");
	    	return false;
	    }
	    else{
	    	return true;
	    }
	  });
});