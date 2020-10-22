package kr.or.ddit.fileupload;

import java.util.List;

import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
	public static void main(String[] args) {
		
		FileUploadUtil fileUpload = new FileUploadUtil();
		String part = fileUpload.getFilename("imgPart");
		logger.debug("part : {}", part);
		logger.debug(fileUpload.getFilename("img"));
		
	}
	
	// form-data; name="img"; filename="sally.png"
	// ==> sally.png
	
	// FileUploadUtilTest를 만들어 반환이 잘 되는지 확인
	public static String getFilename(String contentDisposition) {
		String[] attrs = contentDisposition.split("; ");
		for (String attr : attrs) {
			String[] attrArray = attr.split("=");
			if(attrArray[0].equals("filename")) {
				return attrArray[1].replace("\"", "");
			}
		}
	return "";
	}
	
	// 확장자 설정 filename : sally.png ==> png
	public static String getExtension(String filename) {
//		String[] attrs = filename.split("\\.");
//		String extension = attrs[1];
//		logger.debug("Extenstion : {}", extension);
//		return extension;
		if (filename == null || filename.indexOf(".") == -1) {
			return "";
		}else {
			return filename.split("\\.")[1];
		}
	}

}
