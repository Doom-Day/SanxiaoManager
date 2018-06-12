$(document).ready(function(){
	  $(".sign_bt").click(function(){
	    if($(".upwdsignup")!=$(".upwdsignup_confirm")){
	    	alert("二次密码不一致");
	    	return true;
	    }
	    else{
	    	return true;
	    }
	  });
});