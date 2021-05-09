package com.example.demo.Utilities;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Util {

	public static boolean validateGpxFile(MultipartFile gpxFile) {
		if(gpxFile != null && !gpxFile.isEmpty()) {
			List<String> contentTypes = Arrays.asList("application/gpx", "application/gpx+xml");
			String fileContentType = gpxFile.getContentType();
			if (contentTypes.contains(fileContentType)) {
				return true;
			}
		}
		return false;
	}
	
	public static File convertMultipartFile(MultipartFile file) throws IOException {
		File convFile = new File(System.currentTimeMillis() + file.getOriginalFilename());
		if (convFile.createNewFile()) {
			try (FileOutputStream fos = new FileOutputStream(convFile)) {
				fos.write(file.getBytes());
			}
		}
		return convFile;
	}

	public static Date dateFromString(String date, String format) {
		if(StringUtils.isEmpty(date)) {
			return null;
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			return formatter.parse(date);
		} catch (ParseException ex) {
			return null;
		}
	}
}
