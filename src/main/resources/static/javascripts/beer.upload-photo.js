this.Brewer = Brewer || {};

Brewer.UploadPhoto = (function() {
	
	function UploadPhoto() {    
        this.inputPhotoName = $('input[name=photo]');
        this.inputContentType = $('input[name=contentType]');
        
        this.source = $('#beer-photo').html();
        this.template = Handlebars.compile(this.source);
        
        this.uploadComponent = $('#upload-component');
        this.containerBeerPhoto = $('.js-container-beer-photo');
	}
	
	UploadPhoto.prototype.init = function() {
	    UIkit.upload('.js-upload', {
	        url: this.containerBeerPhoto.data('url-photo'),
	        type: 'json',
	        filelimit: 1,
	        multiple: false,
	        allow: '*.(jpg|jpeg|png)',        
	        complete: onComplete.bind(this),
	    });
	    
	    if (this.inputPhotoName.val()) {
	    	onComplete.call(this, {name: this.inputPhotoName.val(), contentType: this.inputContentType.val()});
	    }
	}
	
	function onComplete(XMLHttpRequest) {
    	var response = XMLHttpRequest.response? XMLHttpRequest.response : XMLHttpRequest;
    	var htmlBeerPhoto = this.template({photoName: response.name}); 
    	
        console.log('response', response);
        			            
        this.inputPhotoName.val(response.name);
        this.inputContentType.val(response.contentType);
        
        this.uploadComponent.addClass('hidden');
        this.containerBeerPhoto.append(htmlBeerPhoto);
        
        $('.js-remove-beer-photo').on('click', onClickRemovePhoto.bind(this));
	}
	
	function onClickRemovePhoto() {
		$('.js-beer-photo').remove();
    	
    	this.uploadComponent.removeClass('hidden'); 	
    	
    	this.inputPhotoName.val('');
    	this.inputContentType.val('');
	}
	
	return UploadPhoto;
})();

$(function() {
	var uploadPhoto = new Brewer.UploadPhoto();
	uploadPhoto.init();
});