(function() {
	$('#hashtags').tagEditor({
		delimiter: ', ', /* space and comma */
		placeholder: '#'
    });

	$('#DatingSiteOptions').change(function(e) {
		var value = $(this).find('option:selected').val();
		if(value == 'other') {
			$('#DatingSiteDiv').show();
		} else {
			$('#DatingSiteDiv').hide();
		}
	});
})();