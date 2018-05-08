$(function(){
	$('#numbers_group input[type=checkbox]').change(function () {
		var countchecked = $("#numbers_group input[type=checkbox]:checked").length;

		if(countchecked >= 6) {
			$('#numbers_group input[type=checkbox]').not(':checked').prop('disabled',true);
		}else{
			$('#numbers_group input[type=checkbox]').not(':checked').prop('disabled',false);
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