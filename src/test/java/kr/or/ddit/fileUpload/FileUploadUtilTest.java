package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileupload.FileUploadUtil;

public class FileUploadUtilTest {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtilTest.class);
	@Test
	public void test() {
		/*** Given ***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"contentType.png\"";
		
		/*** When ***/
		String fileName = FileUploadUtil.getFilename(contentDisposition);

		/*** Then ***/
		assertEquals("contentType.png", fileName);
	}

	@Test
	public void UUIDTest() {
		/*** Given ***/
		
		/*** When ***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {}", uuid);

		/*** Then ***/
		
	}
	@Test
	public void getExtensionTest() {
		/*** Given ***/
		String extension = "sally.png";
		
		/*** When ***/
		FileUploadUtil util = new FileUploadUtil();
		String test = util.getExtension(extension);
		logger.debug("extension : {}", extension);

		/*** Then ***/
		assertEquals("png", test);
	}
}
