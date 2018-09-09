package com.algaworks.brewer.storage.local;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.brewer.storage.PhotoStorage;

public class PhotoStorageLocal implements PhotoStorage {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhotoStorageLocal.class);
	
	private Path localPath;
	
	private Path temporaryPath;
	
	public PhotoStorageLocal() {
		this(FileSystems.getDefault().getPath(System.getenv("HOME"), ".brewerphotos"));
	}
	
	public PhotoStorageLocal(Path path) {
		this.localPath = path;
		createFolders();
	}

	@Override
	public String saveTemporarily(MultipartFile[] files) {
		String newFileName = null;
		
		if (files != null && files.length > 0) {
			MultipartFile file = files[0];
			newFileName = renameFile(file.getOriginalFilename());
			
			try {
				file.transferTo(new File(
									temporaryPath.toAbsolutePath().toString() 
									+ FileSystems.getDefault().getSeparator() 
									+ newFileName)
								);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Error saving photo to temporary folder", e);
			}
			
			return newFileName;
		}
		
		return newFileName;
	}
	
	private void createFolders() {
		try {
			Files.createDirectories(localPath);
			
			temporaryPath = FileSystems.getDefault().getPath(localPath.toString(), "temp");
			Files.createDirectories(temporaryPath);
			
			LOGGER.info("Folders created successfully");
			LOGGER.info("Folder default: " + localPath.toAbsolutePath());
			LOGGER.info("Folder temporary: " + temporaryPath.toAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error while creating folders for photos", e);
		}
	}
	
	private String renameFile(String fileName) {
		LOGGER.info("File name: " + fileName);
		String newFileName = UUID.randomUUID().toString() + "_" + fileName;
		LOGGER.info("File renamed to: " + newFileName);
		
		return newFileName;
	}
	
}
