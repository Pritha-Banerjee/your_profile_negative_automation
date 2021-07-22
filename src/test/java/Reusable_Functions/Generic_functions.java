package Reusable_Functions;

import java.io.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Generic_functions {
	public static AndroidDriver<AndroidElement> driver;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell,f;
	public static XSSFRow row;
	public static String CellData,path;
	public static int iter; 
	public static int col;
	public static WebElement mob;
	static File file = new File("configuration/serenity.properties");
	static Properties prop = new Properties();
	public static MobileElement element;
	public static WebDriverWait wait;
	static WebElement ele;
	static String ere;
	static List<WebElement> drp_list;
	/* Launch the application and provide desired capabilities of connected device.Also give the URL of the Appium server*/
	public static void app_launch() throws FileNotFoundException ,IOException {
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		prop.load(fileInput);
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName",getDeviceName());
		cap.setCapability("udid", getUDID());
		cap.setCapability("platformName", getPlatformName());
		cap.setCapability("platformVersion", getPlatformVersion());
		cap.setCapability("appPackage", getAppPackage());
		cap.setCapability("appActivity", getAppActivity());
		URL url = new URL(getURL());
		driver= new AndroidDriver<AndroidElement>(url,cap);
	}
	/* Function will fetch the device name from the config.properties file*/
	public static String getDeviceName() {
		String deviceName= prop.getProperty("deviceName");
		if(deviceName!=null) return deviceName ;
		else throw new RuntimeException ("deviceName is not specified in the Config.properties");
	}
	/* Function will fetch the device UDID from the config.properties file*/
	public static String getUDID() {
		String udid= prop.getProperty("udid");
		if(udid!=null) return udid ;
		else throw new RuntimeException ("udid is not specified in the Config.properties");
	}
	/* Function will fetch the platform from the config.properties file*/
	public static String getPlatformName() {
		String platformName= prop.getProperty("platformName");
		if(platformName!=null) return platformName ;
		else throw new RuntimeException ("platformName is not specified in the Config.properties");
	}
	/* Function will fetch the platform version from the config.properties file*/
	public static String getPlatformVersion() {
		String platformVersion= prop.getProperty("platformVersion");
		if(platformVersion!=null) return platformVersion ;
		else throw new RuntimeException ("platformVersion is not specified in the Config.properties");
	}
	/* Function will fetch the app package from the config.properties file*/
	public static String getAppPackage() {
		String appPackage= prop.getProperty("appPackage");
		if(appPackage!=null) return appPackage ;
		else throw new RuntimeException ("appPackage is not specified in the Config.properties");
	}
	/* Function will fetch the app activity from the config.properties file*/
	public static String getAppActivity() {
		String appActivity= prop.getProperty("appActivity");
		if(appActivity!=null) return appActivity ;
		else throw new RuntimeException ("appActivity is not specified in the Config.properties");
	}
	/* Function will fetch the URLof the Appium server from the config.properties file*/
	public static String getURL() {
		String URL= prop.getProperty("URL");
		if(URL!=null) return URL ;
		else throw new RuntimeException ("URL is not specified in the Config.properties");
	}
	/* Refresh function to refresh the current page opened  */
	public static void page_refresh() {
		driver.navigate().refresh();
	}
	/* To wait the page till the time passed to this function */
	public static void page_wait(int time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	/* Reading Excel file path  from config.properties   */
	public static String getFilepath() {
		String filepath= prop.getProperty("Filepath");
		if(filepath!=null) return filepath ;
		else throw new RuntimeException ("Filepath is not specified in the Config.properties");
	}
	/*To get directory path of screenshots folder*/
	public static String getDir() {
		String dirpath= prop.getProperty("Dirpath");
		if(dirpath!=null) return dirpath ;
		else throw new RuntimeException ("user Dir is not specified in the Config.properties");
	}
	/*  Taking Screenshot of failed test cases  */
	public static  void takeScreenShot(String fileName) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(getDir()+fileName+".png"));
	}
	/* Reading Doctor's report file path  from config.properties   */
	public static String getcsv() {
		path= prop.getProperty("Test_csv");
		if(path!=null) return path ;
		else throw new RuntimeException (" csv path is not specified in the Config.properties");
	}
	public static String td_reader(String fieldname,int index) throws IOException {	
		Reader reader = Files.newBufferedReader(Paths.get(getcsv()));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser) {
			String name = csvRecord.get(0);
			String val = csvRecord.get(1);
			if(name.equalsIgnoreCase(fieldname))
			{
				String[] values = val.split(",");
				return values[index];
			}
		}
		return null;		
	}
	public static String td_reader(String fieldname) throws IOException {	
		Reader reader = Files.newBufferedReader(Paths.get(getcsv()));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser) {
			String name = csvRecord.get(0);
			String val = csvRecord.get(1);
			if(name.equalsIgnoreCase(fieldname))
			{
				return val;
			}
		}
		return null;		
	}
	public static String OR_reader(String fieldname) throws IOException {	
		Reader reader = Files.newBufferedReader(Paths.get(getFilepath()),Charset.forName("ISO-8859-1"));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser) {
			String name = csvRecord.get(0);
			String val = csvRecord.get(2);
			if(name.equalsIgnoreCase(fieldname))
			{
				return val;
			}
		}
		return null;		
	}
	/*To get test data iteration value from config.properties file*/
	public static int Dataiter() {            
		iter=Integer.parseInt(prop.getProperty("Data_iteration"));
		return iter;		
	}
	/* Click operation for a particular fieldname that is passing to this function through finding locator value of fieldname using OR_reader function*/
	public static void click(String fieldname) throws IOException {
		driver.findElement(By.xpath(OR_reader(fieldname))).click();
	}
	/* To go back to the previous page */
	public static void page_back(){
		driver.navigate().back();
	}
	/*close the application*/
	public static void  close() {
		driver.closeApp();
	}
	/*Function to clear the value in a particular field*/
	public static void field_clear(String fieldname) throws IOException {
		mob = driver.findElement(By.xpath(OR_reader(fieldname)));
		mob.clear();
	}
	/*Function to scroll down until the given the element */
	public static void scrolldown(String elementchoose) {
		element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true))" +
						".scrollIntoView(new UiSelector().text(\""+elementchoose+"\"))"));
		element.click(); 
	}
	/*Function to wait until the particular element is displayed */
	public static void waitelement(String fieldname) throws IOException {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR_reader(fieldname))));
	}
	/*Function to scroll down-up and click the given the element */
	public static void scrollAndClick(String visibleText) {
		String uiSelector = "new UiSelector().textMatches(\"" + visibleText
				+ "\")";
		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
				+ uiSelector + ");";
		driver.findElementByAndroidUIAutomator(command).click();
	}
	/* To select value passed as text from a dropdown menu if the element is input*/
	public static void drop_down(String drp_click,String text) throws IOException {
		//		drp_list = driver.findElements(By.xpath(drp_click));
		//		int size= drp_list.size();	
		//		for( int i=0; i<size;i++){
		//			ele = drp_list.get(i);
		//			ere= ele.getText();
		//			if(ere.equalsIgnoreCase(text)) {
		//				ele.click();
		//			}
		//
		//		}
		String searchText = text;
		WebElement dropdown = driver.findElement(By.xpath(drp_click));
		List<WebElement> options = dropdown.findElements(By.tagName("li"));
		for (WebElement option : options)
		{
			if (option.getText().equals(searchText))
			{
				option.click(); // click the desired option
				break;
			}
		}
	}
	
	/*Stale object element click*/
	public static void stale_click(String fieldname) {
		try {
			final WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.refreshed(
					ExpectedConditions.elementToBeClickable(By.xpath(OR_reader(fieldname)))));
			driver.findElement(By.xpath(OR_reader(fieldname))).click();
		}catch(Exception e) {}
	}
	/*Swipe left to right*/
	public static void swipe_right_to_left(int elementX, int elementY,int total_swipe) {
		Dimension dimension = driver.manage().window().getSize();
		int deviceHeight = dimension.getHeight();
		int deviceWidth = dimension.getWidth();
		int startX=deviceWidth - elementX;
		int startY=elementY;
		int endX=elementX;
		int endY=elementY;
		TouchAction touchAction = new TouchAction(driver);
		for(int i=1;i<=total_swipe;i++) {
			touchAction.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
		}
		
		
		
	}
}