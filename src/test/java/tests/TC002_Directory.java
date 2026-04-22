package tests;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.DirectoryPage;

public class TC002_Directory extends BaseClass {
	@Test
	public void search_data() {
		
		DirectoryPage dp=new DirectoryPage(driver);
		dp.Driectory_click();
		dp.Directory_list();
		dp.Search_but();
	}
}
