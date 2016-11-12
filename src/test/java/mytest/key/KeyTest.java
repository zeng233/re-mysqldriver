package mytest.key;

import java.sql.ResultSet;
import java.sql.Statement;

import mytest.BaseTest;

import org.junit.Test;

/**
 * http://www.cnblogs.com/xpchild/p/3825309.html MySQL内部实现auto
 * @author zenghua233
 *
 */
public class KeyTest extends BaseTest {

	@Test
	public void testKey() throws Exception {
		String sql = "INSERT INTO statement_test (strdata1) values ('jdbc-key1'),('hello')";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stmt.getGeneratedKeys();
		while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
	}
}
