package mytest;

import java.sql.Connection;

import mytest.util.ConnectionUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {
	public static Connection conn;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		conn = ConnectionUtil.getCon();
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		conn.close();
	}
}
