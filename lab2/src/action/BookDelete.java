package action;

import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;

public class BookDelete extends ActionSupport {
	private String bkID = new String();

	public String execute() {
		String ret = ERROR;
		Connection conn = null;
		try {
			String URL = " w.rdc.sae.sina.com.cn:3307/app_book941016";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "lxjzjz50wo", "1zlhyhk1hx4m022z3425lml4klzwy0zmxmx0hy11");
			
			String sql = "delete from Book  where ISBN = '" + bkID + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			int rs = ps.executeUpdate();
			ret = SUCCESS;
		} catch (Exception e) {
			ret = ERROR;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}

	public String getBkID() {
		return bkID;
	}

	public void setBkID(String bkID) {
		this.bkID = bkID;
	}
}
