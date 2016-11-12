package mytest.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil
{
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
	
	static {
		//获取源代码文件下面的一个资源
//		InputStream in = ConnectionUtil.class.getResourceAsStream("/src/test/resources/jdbc.properties");
		//获取classpath下的资源文件
		InputStream in = ClassLoader.getSystemResourceAsStream("jdbc.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			url = prop.getProperty("jdbc.jdbcUrl");
			user = prop.getProperty("jdbc.username");
			password = prop.getProperty("jdbc.password");
			driver = prop.getProperty("jdbc.driver");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ConnectionUtil() {}
	
	public static Connection getCon() throws Exception {
		//初始化Driver
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
}
