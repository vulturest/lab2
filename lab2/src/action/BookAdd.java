package action;

import java.sql.*;

import po.book;
import po.author;

import com.opensymphony.xwork2.ActionSupport;
public class BookAdd extends ActionSupport {
	private String newISBN, newTitle, newAuthorID, newPublisher,
			newPublishDate, newPrice;
	private String newName, newAge, newCountry = new String();

	public String execute() {
		String ret = ERROR;
		Connection conn = null;
		try {
			String URL = " w.rdc.sae.sina.com.cn:3307/app_book941016";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "lxjzjz50wo", "1zlhyhk1hx4m022z3425lml4klzwy0zmxmx0hy11");	
			String sql0 = "select * from Author where AuthorID = '" + newAuthorID + "'";
			String sql = "insert into Author values( '" + newAuthorID + "','"
					+ newName + "','" + newAge + "','" + newCountry + "')";
			String sql1 = "insert into Book values('" + newISBN + "','"
					+ newTitle + "','" + newAuthorID + "','" + newPublisher
					+ "','" + newPublishDate + "','" + newPrice + "')";
			
			PreparedStatement ps0 = conn.prepareStatement(sql0);
			PreparedStatement ps1 = null;
			ResultSet rs0 = ps0.executeQuery();
			int rs1;
			if (!rs0.next()) {
				ps1 = conn.prepareStatement(sql);
				rs1 = ps1.executeUpdate();
			}
			PreparedStatement ps2 = conn.prepareStatement(sql1);
			int rs2 = ps2.executeUpdate();
			ret = SUCCESS;
			//ok
		} catch (Exception e) {
			e.printStackTrace();
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

	public String getNewAge() {
		return newAge;
	}

	public void setNewAge(String newAge) {
		this.newAge = newAge;
	}

	public String getNewAuthorID() {
		return newAuthorID;
	}

	public void setNewAuthorID(String newAuthorID) {
		this.newAuthorID = newAuthorID;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewCountry() {
		return newCountry;
	}

	public void setNewCountry(String newCountry) {
		this.newCountry = newCountry;
	}

	public String getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(String newPrice) {
		this.newPrice = newPrice;
	}

	public String getNewISBN() {
		return newISBN;
	}

	public void setNewISBN(String newISBN) {
		this.newISBN = newISBN;
	}

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewPublisher() {
		return newPublisher;
	}

	public void setNewPublisher(String newPublisher) {
		this.newPublisher = newPublisher;
	}

	public String getNewPublishDate() {
		return newPublishDate;
	}

	public void setNewPublishDate(String newPublishDate) {
		this.newPublishDate = newPublishDate;
	}
}
