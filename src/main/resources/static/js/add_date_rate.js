(function() {

	$( "#scoreDiv" ).slider({
		orientation: "horizontal",
		range: "min",
		max: 10,
		value: $('#score').val(),
		slide: function( event, ui ) {
			$( '#scoreLabel' ).html( ui.value );
			$( '#score' ).val( ui.value );
		}
	});

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