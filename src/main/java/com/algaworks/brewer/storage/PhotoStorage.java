package com.algaworks.brewer.storage;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoStorage {

	String saveTemporarily(MultipartFile[] files);
	
}
