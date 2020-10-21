package kr.or.ddit.fileUpload;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.fileupload.FileUploadUtil;

public class FileUploadUtilTest {

	@Test
	public void test() {
		/*** Given ***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"contentType.png\"";
		
		/*** When ***/
		String fileName = FileUploadUtil.getFilename(contentDisposition);

		/*** Then ***/
		assertEquals("contentType.png", fileName);
	}

}
