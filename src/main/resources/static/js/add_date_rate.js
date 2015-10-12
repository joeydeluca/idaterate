(function() {
	
	$('#DatingSiteOptions').change(function(e) {
		var value = $(this).find('option:selected').val();
		if(value == 'other') {
			$('#DatingSiteDiv').show();
		} else {
			$('#DatingSiteDiv').hide();
		}
	});
	
	$('#AddDateRateForm').submit(function(e) {
		if($('#DatingSiteOptions').find('option:selected').val() != 'other') {
			$('#DatingSite').val($(this).find('option:selected').val());
		}
	});
})();