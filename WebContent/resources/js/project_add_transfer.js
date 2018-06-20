$(function(){
	  $("#add").click(function(){
		  re = new RegExp("<div>|</div>", "g");
		  var jsonT="[";
		  for(var i=1;i<6;i++){
			  if($.trim($("#mid_"+i).html())!="")
				  jsonT += "{'mid':"+$.trim($('#mid_'+i).html())+",'mname':'"+$.trim($('#mname_'+i).html())+"','mage':"+$.trim($('#mage_'+i).html())+",'msex':'"+$.trim($('#msex_'+i).html())+"','mps':'"+$.trim($('#mps_'+i).html())+"','mac':'"+$.trim($('#mac_'+i).html())+"'},"
		  }
		  jsonT= jsonT.substr(0, jsonT.length - 1);
		  jsonT += "]";
		  if($.trim($("#mid_1").html())=="")
			  jsonT = "[]";
		  $.ajax({
              type: 'POST',
              url: "http://localhost:8080/SanxiaoManager/addProject",
              data: {
            	  pname: $("#pnamesignup").val(),
            	  ptype: $("#ptype option:selected").val(),
            	  ptea: $("#pteasignup").val(),
            	  pttel: $("#pttelsignup").val(),
            	  pprofile: ($.trim($("#pprofilesignup").html())).replace(re, "<br>"),
            	  pplan: ($.trim($("#pplansignup").html())).replace(re, "<br>"),
            	  pfee: $("#pfeesignup").val(),
            	  pof: $("#pof option:selected").val(),
            	  members:jsonT
              },
              async: false,
              success: function(data){
            	  alert("申报成功");
              }
          });
	  });
});