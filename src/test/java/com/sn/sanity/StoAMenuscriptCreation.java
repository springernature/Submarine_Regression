package com.sn.sanity;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.eclipse.osgi.framework.util.FilePath;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sn.config.BaseConfig;
import com.sn.pageobjects.StoA_MS_SubmissionPage;
import com.sn.utils.CommonUtils;

public class StoAMenuscriptCreation extends BaseConfig {

	private static final Logger LOGGER = LogManager.getLogger(StoAMenuscriptCreation.class);

	private StoA_MS_SubmissionPage stoA_MS_SubmissionPage;

	String filePath = System.getProperty("user.dir") + "/TestData";

	String fileName = "/TestData.xlsx";

	String sheetName = "Sheet1";

	static int count = 0;

	@Test(dataProvider = "create_ms_data")
	public void createMS(Object stoA_userName, Object stoA_password, Object stoa_create_ms_file_path,
			Object stoa_create_ms_title, Object stoa_create_ms_abstract, Object stoa_create_ms_cover_letter_file_path,
			Object stoa_create_ms_author_first_name, Object stoa_create_ms_author_last_name,
			Object stoa_create_ms_author_email, Object stoa_create_ms_author_affiliation,
			Object stoa_create_ms_author_funding, Object stoa_create_ms_author_contribution) throws Exception {

		String stoA_userName_str = (String) stoA_userName;
		String stoA_password_str = (String) stoA_password;
		String stoa_create_ms_file_path_str = (String) stoa_create_ms_file_path;
		String stoa_create_ms_title_str = (String) stoa_create_ms_title;
		String stoa_create_ms_abstract_str = (String) stoa_create_ms_abstract;
		String stoa_create_ms_cover_letter_file_path_str = (String) stoa_create_ms_cover_letter_file_path;
		String stoa_create_ms_author_first_name_str = (String) stoa_create_ms_author_first_name;
		String stoa_create_ms_author_last_name_str = (String) stoa_create_ms_author_last_name;
		String stoa_create_ms_author_email_str = (String) stoa_create_ms_author_email;
		String stoa_create_ms_author_affiliation_str = (String) stoa_create_ms_author_affiliation;
		String stoa_create_ms_author_funding_str = (String) stoa_create_ms_author_funding;
		String stoa_create_ms_author_contribution_str = (String) stoa_create_ms_author_contribution;

		count++;

		stoA_MS_SubmissionPage = new StoA_MS_SubmissionPage(this);
		stoA_MS_SubmissionPage.loginToStoa(stoA_userName_str, stoA_password_str, stoa_create_ms_file_path_str,
				stoa_create_ms_title_str, stoa_create_ms_abstract_str, stoa_create_ms_cover_letter_file_path_str,
				stoa_create_ms_author_first_name_str, stoa_create_ms_author_last_name_str,
				stoa_create_ms_author_email_str, stoa_create_ms_author_affiliation_str,
				stoa_create_ms_author_funding_str, stoa_create_ms_author_contribution_str);

		CommonUtils.writeData(filePath, fileName, sheetName, count, 12, stoA_MS_SubmissionPage.getMSID());

		
	}

	@DataProvider()
	public Object[][] create_ms_data() throws IOException {

		return CommonUtils.readExcel(filePath, fileName, sheetName);
	}

//	@BeforeSuite
	public void clearAllMSIDs() throws IOException {
		 
		 System.out.println("Before Suite started.");

		CommonUtils.clearAllCellValues(filePath, fileName, sheetName);
	}

}
