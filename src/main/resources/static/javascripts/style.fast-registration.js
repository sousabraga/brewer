var Brewer = Brewer || {};

Brewer.StyleFastRegistration = (function() {
	
	function StyleFastRegistration() {
		this.modalFastRegistration = $('#fast-registration');
		this.saveButton = this.modalFastRegistration.find('.js-style-fast-registration-save-btn');
		this.form = this.modalFastRegistration.find('form');
		this.url = this.form.attr('action');
		this.inputStyleName = $('#style-name');
		this.containerErrorMessage = $('.js-message-style-fast-registration');
	} 
	
	StyleFastRegistration.prototype.init = function() {
		this.form.on('submit', function(event) { 
			event.preventDefault() 
		});		
		
		this.modalFastRegistration.on('shown.bs.modal', onmodalFastRegistrationShow.bind(this));
		this.modalFastRegistration.on('hide.bs.modal', onmodalFastRegistrationHide.bind(this));
		
		this.saveButton.on('click', onSaveButtonClick.bind(this));
	}
	
	function onmodalFastRegistrationShow() {
		this.inputStyleName.focus();
	}
	
	function onmodalFastRegistrationHide() {
		this.inputStyleName.val("");
		this.containerErrorMessage.addClass('hidden');
		this.form.find('.form-group').removeClass('has-error');
	}
	
	function onSaveButtonClick() {
		var styleName = this.inputStyleName.val().trim();
	
		$.ajax({
			url: this.url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ name : styleName }),
			error: onErrorSavingStyle.bind(this),
			success: onStyleSaved.bind(this)
		});
	}
	
	function onErrorSavingStyle(object) {
		var errorMessage = object.responseText;
		
		this.containerErrorMessage.removeClass('hidden');
		this.containerErrorMessage.html('<span>' + errorMessage + '</span>');
		
		this.form.find('.form-group').addClass('has-error');
		
		this.inputStyleName.focus();
	}
	
	function onStyleSaved(style) {
		var styleSelect = $('#style');
		styleSelect.append('<option value=' + style.id + '>' + style.name + '</option>');
		styleSelect.val(style.id);
		
		this.modalFastRegistration.modal('hide');
	}
	
	return StyleFastRegistration;
	
})();

$(function() {
	var styleFastRegistration = new Brewer.StyleFastRegistration();
	styleFastRegistration.init();
});