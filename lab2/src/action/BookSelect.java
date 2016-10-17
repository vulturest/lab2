package action;

import java.sql.*;

import po.book;
import po.author;

import com.opensymphony.xwork2.ActionSupport;

public class BookSelect extends ActionSupport {
	private book book = new book();
	private author author = new author();
	private String BookID;

	public String execute() {
		String ret = ERROR;
		Connection conn = null;
		try {
			String URL = " w.rdc.sae.sina.com.cn:3307/app_book941016";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "lxjzjz50wo", "1zlhyhk1hx4m022z3425lml4klzwy0zmxmx0hy11");
			
			ResultSet rs, rs1 = null;
			String sql = "select * from Book where ISBN ='" + BookID + "'";
			String sql11 = new String();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				book.setISBN(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthorID(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPublishDate(rs.getString(5));
				book.setPrice(rs.getString(6));
				sql11 = "select * from Author where AuthorID='"
						+ rs.getString("AuthorID") + "'";
			}
			PreparedStatement ps1 = conn.prepareStatement(sql11);
			rs1 = ps1.executeQuery();
			while (rs1.next()) {
				author.setAuthorID(rs1.getString(1));
				author.setName(rs1.getString(2));
				author.setAge(rs1.getString(3));
				author.setCountry(rs1.getString(4));
				ret = "success";
			}
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

	public book getBook() {
		return book;
	}

	public void setBook(book book) {
		this.book = book;
	}

	public author getAuthor() {
		return author;
	}

	public void setAuthor(author author) {
		this.author = author;
	}

	public String getBookID() {
		return BookID;
	}

	public void setBookID(String BookID) {
		this.BookID = BookID;
	}
}
