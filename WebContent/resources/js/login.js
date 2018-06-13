$(function(){
	  $(".sign_bt").click(function(){
	    if($("#upwdsignup").val()!=$("#upwdsignup_confirm").val()){
	    	alert("二次密码不一致");
	    	return false;
	    }
	    else{
	    	return true;
	    }
	  });
});