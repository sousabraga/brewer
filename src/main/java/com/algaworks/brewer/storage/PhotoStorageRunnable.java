package com.algaworks.brewer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.brewer.dto.PhotoDTO;

public class PhotoStorageRunnable implements Runnable {
	
	private PhotoStorage photoStorage;
	
	private MultipartFile[] files;

	private DeferredResult<PhotoDTO> result;
	
	public PhotoStorageRunnable(PhotoStorage photoStorage, MultipartFile[] files, DeferredResult<PhotoDTO> result) {
		this.photoStorage = photoStorage;
		this.files = files;
		this.result = result;
	}
	
	@Override
	public void run() {
		String fileName = photoStorage.saveTemporarily(files);
		String contentType = files[0].getContentType();
		
		result.setResult(new PhotoDTO(fileName, contentType));
	}

}
