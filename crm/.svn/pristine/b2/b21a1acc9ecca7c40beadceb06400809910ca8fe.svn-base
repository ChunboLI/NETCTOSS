$(function(){
	
	$('#sb').click(f1);
	$('#ret').click(f2);
});
function f1(){
//	alert($('#sex:checked').val());
	$.ajax({
			'url':'/crm/custom/add.do',
			'type':'post',
			'data':{
				'name':$('#name').val(),
				'source':$('#s1 option').val(),
				'job':$('#job').val(),
				'type':$('#s2 option').val(),
				'gender':$('#sex:checked').val(),
				'email':$('#email').val(),
				'birthday':$('#birthday').val(),
				'mobliephone':$('#mobliephone').val(),
				'qq':$('#qq').val(),
				'address':$('#address').val(),
				'weibo':$('#weibo').val(),
				'phone':$('#phone').val(),
				'msn':$('#msn').val(),
				'company':$('#company').val(),
				'creator':$('#creator').val(),
				'modifier':$('#modifier').val(),
				'status':$('#s3 option').val(),
				'remarks':$('#remarks').val()
			},
			'dateType':'text',
			'success':function(data){
					alert(data);
					$("#crm-main").load('/crm/page/customer/customerList.jsp');
				
				
			}
			
			
			}
			
	);
	
}

function f2(){
	$("#crm-main").load('/crm/page/customer/customerList.jsp');
}








