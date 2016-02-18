$(document).ready(function() {
	
	var prefix = "/modules/student";
	
	var studentTableTemplate = [
	                  		'<table cellspacing="0px" bordercolor="#e3e3e3" border="1" frame="below" reles="all" style="table-layout: fixed; width: 100%; border-collapse: collapse; float:left;">',
	                  		'   <thead>',
	                  		'		<tr id="account_base" class="headtr"><th width="100">id</th><th width="100">name</th><th width="80">age</th><th width="80">gender</th></tr>',
	                  		'   </thead>',
	                  		'   <tbody>',
	                  		'	${list}.each(<tr>',
	                  		'    <td>${i.id}</td>',
	                  		'    <td>${i.name}</td>',
	                  		'    <td>${i.age}</td>',
	                  		'    <td>${i.gender}</td>',
	                  		'    <td><a href="#" class="editbtn" id="${i.id}">编辑</a> <a href="#" class="delbtn" id="${i.id}">删除</a></td></tr>)',
	                  		'   </tbody>',
	                  		'</table>'].join("");
	
	var init = function() {
		$("#queryButton").click(queryStudent);
	}
	
	var queryStudent = function() {
		var param = loadQueryParam();
		alert(param.id +","+ param.name +","+ param.age +","+ param.gender);
		$.postJSON(prefix+"/queryStudent.json", param, function(data){
			alert(data.length);
			$("#list").render(studentTableTemplate, {"list":data});
			$("#list tbody tr:odd").css("background-color","#B2E0FF");
//			$("#list a.editbtn").click(function(event){
//				var id = $(this).attr("id");
//				onEdit(id);
//			});
//			$("#list a.delbtn").click(function(event){
//				var id = $(this).attr("id");
//				onDelete(id);
//			});

			$("#result").show();
		});
	}
	
	var loadQueryParam = function() {
		var queryParam = {
				"id"    : $("#idInput").val(),
				"name"  : $("#nameInput").val(),
				"age"   : $("#ageInput").val(),
				"gender": $("#genderInput").val()
		};
		return queryParam;
	}
	

	init();

});
