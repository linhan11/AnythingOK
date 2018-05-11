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
		$('#numbers_group input[type=checkbox]').not(':checked').parent().css({'transform':'rotate(0deg)', 'font-weight':'normal'});
		$('#numbers_group input[type=checkbox]:checked').parent().css({'transform':'rotate(12deg)', 'font-weight':'bold'});
	});
});

$(function(){
	$(document).ready(function() {
		$("[id^=fuwa]").each(function() {
			$(this).jqFloat({
				width: 25,
				height: 35,
				speed: 2500
			});
		});
	});
});