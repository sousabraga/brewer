$(function () {
	
	var modalFastRegistration = $('#fast-registration');
	var saveButton = modalFastRegistration.find('.js-style-fast-registration-save-btn');
	var form = modalFastRegistration.find('form');
	var url = form.attr('action');
	var inputStyleName = $('#style-name');
	var containerErrorMessage = $('.js-message-style-fast-registration');
	
	form.on('submit', function(event) { 
		event.preventDefault() 
	});
	
	
	modalFastRegistration.on('shown.bs.modal', onmodalFastRegistrationShow);
	modalFastRegistration.on('hide.bs.modal', onmodalFastRegistrationHide);
	
	saveButton.on('click', onSaveButtonClick);
	
	function onmodalFastRegistrationShow() {
		inputStyleName.focus();
	}
	
	function onmodalFastRegistrationHide() {
		inputStyleName.val("");
		containerErrorMessage.addClass('hidden');
		form.find('.form-group').removeClass('has-error');
	}
	
	function onSaveButtonClick() {
		var styleName = inputStyleName.val().trim();
	
		$.ajax({
			url: url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ name : styleName }),
			error: onErrorSavingStyle,
			success: onStyleSaved
		});
	}
	
	function onErrorSavingStyle(object) {
		var errorMessage = object.responseText;
		
		containerErrorMessage.removeClass('hidden');
		containerErrorMessage.html('<span>' + errorMessage + '</span>');
		
		form.find('.form-group').addClass('has-error');
		
		inputStyleName.focus();
	}
	
	function onStyleSaved(style) {
		var styleSelect = $('#style');
		styleSelect.append('<option value=' + style.id + '>' + style.name + '</option>');
		styleSelect.val(style.id);
		
		modalFastRegistration.modal('hide');
	}
	
});