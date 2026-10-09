package tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FileUploadPage;
import pages.TopicsPage;

public class FileUploadTest extends BaseTest {

	private FileUploadPage fileUploadPage;

	@BeforeMethod
	public void openFileUploadPage() {

		TopicsPage topicsPage = new TopicsPage(driver);

		topicsPage.clickFileUpload();

		fileUploadPage = new FileUploadPage(driver);
	}

	@Test(priority = 1)
	public void verifyFileSelection() {

		String filePath = new File("test-data/test.pdf").getAbsolutePath();

		fileUploadPage.selectFile(filePath);

		String selectedFile = fileUploadPage.getSelectedFilePath();

		System.out.println("Selected File Path: " + selectedFile);

		Assert.assertTrue(selectedFile.endsWith("test.pdf"));
	}

	@Test(priority = 2)
	public void verifyFileNameAndSize() {

		String filePath = new File("test-data/test.pdf").getAbsolutePath();

		fileUploadPage.selectFile(filePath);

		String fileName = fileUploadPage.getFileName();

		String fileSize = fileUploadPage.getFileSize();

		System.out.println("File Name: " + fileName);

		System.out.println("File Size: " + fileSize);

		Assert.assertEquals(fileName, "test.pdf");

		Assert.assertFalse(fileSize.isEmpty());
	}

	@Test(priority = 3)
	public void verifyUploadButtonAndSuccessMessage() {

		String filePath = new File("test-data/test.pdf").getAbsolutePath();

		fileUploadPage.selectFile(filePath);

		boolean uploadEnabled = fileUploadPage.isUploadButtonEnabled();

		System.out.println("Upload Button Enabled: " + uploadEnabled);

		Assert.assertTrue(uploadEnabled);

		fileUploadPage.clickUploadButton();

		String result = fileUploadPage.getUploadResult();

		System.out.println("Upload Result: " + result);

		Assert.assertEquals(result, "File uploaded successfully!");
	}

	@Test(priority = 4)
	public void verifyResetButton() {

		String filePath = new File("test-data/test.pdf").getAbsolutePath();

		fileUploadPage.selectFile(filePath);

		fileUploadPage.clickUploadButton();

		fileUploadPage.clickResetButton();

		boolean uploadDisabled = fileUploadPage.isUploadButtonDisabled();

		System.out.println("Upload Button Disabled After Reset: " + uploadDisabled);

		Assert.assertTrue(uploadDisabled);
	}

	@Test(priority = 5)
	public void verifyMultipleFileSelection() {

		String file1 = new File("test-data/test.pdf").getAbsolutePath();

		String file2 = new File("test-data/test2.pdf").getAbsolutePath();

		fileUploadPage.selectMultipleFiles(file1, file2);

		String count = fileUploadPage.getFileCount();

		System.out.println("Total Files Selected: " + count);

		Assert.assertEquals(count, "2");
	}

	@Test(priority = 6)
	public void verifyMultipleFileNames() {

		String file1 = new File("test-data/test.pdf").getAbsolutePath();

		String file2 = new File("test-data/test2.pdf").getAbsolutePath();

		fileUploadPage.selectMultipleFiles(file1, file2);

		String fileList = fileUploadPage.getFileListText();

		System.out.println("Selected Files:\n" + fileList);

		Assert.assertTrue(fileList.contains("test.pdf"));

		Assert.assertTrue(fileList.contains("test2.pdf"));
	}

	@Test(priority = 7)
	public void verifyRemoveFile() {

		String file1 = new File("test-data/test.pdf").getAbsolutePath();

		String file2 = new File("test-data/test2.pdf").getAbsolutePath();

		// Select two files
		fileUploadPage.selectMultipleFiles(file1, file2);

		// Check initial count
		String beforeRemove = fileUploadPage.getFileCount();

		System.out.println("Files Before Remove: " + beforeRemove);

		Assert.assertEquals(beforeRemove, "2");

		// Remove the first file
		fileUploadPage.clickFirstRemoveButton();

		// Check count after removing
		String afterRemove = fileUploadPage.getFileCount();

		System.out.println("Files After Remove: " + afterRemove);

		Assert.assertEquals(afterRemove, "1");
	}

	@Test(priority = 8)
	public void verifyClearAllFiles() {

		String file1 = new File("test-data/test.pdf").getAbsolutePath();

		String file2 = new File("test-data/test2.pdf").getAbsolutePath();

		// Select two files
		fileUploadPage.selectMultipleFiles(file1, file2);

		// Verify files are selected
		String beforeClear = fileUploadPage.getFileCount();

		System.out.println("Files Before Clear All: " + beforeClear);

		Assert.assertEquals(beforeClear, "2");

		// Click Clear All
		fileUploadPage.clickClearAll();

		// Verify all files are removed
		String afterClear = fileUploadPage.getFileCount();

		System.out.println("Files After Clear All: " + afterClear);

		Assert.assertEquals(afterClear, "0");
	}

	@Test(priority = 9)
	public void verifyDragUploadMultipleFiles() {

		String file1 = new File("test-data/test.pdf").getAbsolutePath();

		String file2 = new File("test-data/test2.pdf").getAbsolutePath();

		fileUploadPage.selectDragUploadFiles(file1, file2);

		String result = fileUploadPage.getDragUploadResult();

		System.out.println("Drag Upload Result: " + result);

		Assert.assertEquals(result, "Uploaded: 2 files");
	}

	@Test(priority = 10)
	public void verifyUploadedFileDetails() {

		String file1 = new File("test-data/test.pdf").getAbsolutePath();

		String file2 = new File("test-data/test2.pdf").getAbsolutePath();

		fileUploadPage.selectDragUploadFiles(file1, file2);

		String fileInfo = fileUploadPage.getUploadedFileInfo();

		System.out.println("Uploaded File Details:\n" + fileInfo);

		Assert.assertTrue(fileInfo.contains("test.pdf"));

		Assert.assertTrue(fileInfo.contains("test2.pdf"));

		Assert.assertTrue(fileInfo.contains("[application/pdf]"));
	}

	@Test(priority = 11)
	public void verifyDragUploadClear() {

		String file1 = new File("test-data/test.pdf").getAbsolutePath();

		String file2 = new File("test-data/test2.pdf").getAbsolutePath();

		fileUploadPage.selectDragUploadFiles(file1, file2);

		String beforeClear = fileUploadPage.getDragUploadResult();

		System.out.println("Before Clear: " + beforeClear);

		Assert.assertEquals(beforeClear, "Uploaded: 2 files");

		fileUploadPage.clickDragUploadClear();

		String afterClear = fileUploadPage.getDragUploadResult();

		System.out.println("After Clear: " + afterClear);

		Assert.assertEquals(afterClear, "Uploaded: 0 files");
	}
}