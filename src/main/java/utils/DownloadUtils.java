package utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadUtils {

	public static File getDownloadFolder() {

		File downloadFolder = new File("downloads");

		if (!downloadFolder.exists()) {
			downloadFolder.mkdirs();
		}

		return downloadFolder;
	}

	public static ChromeOptions getChromeOptions() {

		File downloadFolder = getDownloadFolder();

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> preferences = new HashMap<>();

		preferences.put("download.default_directory", downloadFolder.getAbsolutePath());

		preferences.put("download.prompt_for_download", false);

		preferences.put("download.directory_upgrade", true);

		options.setExperimentalOption("prefs", preferences);

		return options;
	}
}