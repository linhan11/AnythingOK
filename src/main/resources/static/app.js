$(function(){
	$('#numbers_group input[type=checkbox]').change(function () {
		var countchecked = $("#numbers_group input[type=checkbox]:checked").length;

		if(countchecked >= 6) {
			$('#numbers_group input[type=checkbox]').not(':checked').prop('disabled',true);
			$('#numbers_group input[type=checkbox]').not(':checked').parent().prop('disabled',true);
			$('#numbers_group input[type=checkbox]').not(':checked').parent().attr("disabled","disabled");
			$('#numbers_group input[type=checkbox]').not(':checked').parent().toggleClass("hvr", false);
		}else{
			$('#numbers_group input[type=checkbox]').not(':checked').prop('disabled',false);
			$('#numbers_group input[type=checkbox]').not(':checked').parent().prop('disabled',false);
			$('#numbers_group input[type=checkbox]').not(':checked').parent().removeAttr("disabled");
			$('#numbers_group input[type=checkbox]').not(':checked').parent().toggleClass("hvr", true);
		}
	});
});

$(function(){
	$(document).ready(function() {
		$("[id^=fuwa]").jqFloat({
			width: 25,
			height: 25,
			speed: 3000
		});
	});
});