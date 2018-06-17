$(function(){
	  $("#revise").click(function(){
		  $.ajax({
              type: 'POST',
              url: "http://localhost:8080/SanxiaoManager/reviseProject",
              data: {
            	  pid: $("#pidsignup").val(),
            	  pname: $("#pnamesignup").val(),
            	  ptype: $("#ptype option:selected").val(),
            	  ptea: $("#pteasignup").val(),
            	  pttel: $("#pttelsignup").val(),
            	  pprofile: $.trim($("#pprofilesignup").html()),
            	  pplan: $.trim($("#pplansignup").html()),
            	  pfee: $("#pfeesignup").val(),
            	  pof: $("#pof option:selected").val(),
            	  mid_new: $.trim($("#mid_new").html()),
            	  mname_new: $.trim($("#mname_new").html()),
            	  mage_new: $.trim($("#mage_new").html()),
            	  msex_new: $.trim($("#msex_new").html()),
            	  mps_new: $.trim($("#mps_new").html()),
            	  mac_new: $.trim($("#mac_new").html())
              },
              async: false,
              success: function(data){
            	  alert("修改成功");
              }
          });
	  });
});