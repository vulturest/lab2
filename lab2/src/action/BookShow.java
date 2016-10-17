package action;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import po.book;
import po.author;

import com.opensymphony.xwork2.ActionSupport;

public class BookShow extends ActionSupport {

	private String authorname;
	private List<book> booklist = new ArrayList<book>();
	private List<author> authorlist = new ArrayList<author>();

	public String execute() {
		String ret = ERROR;
		Connection conn = null;
		try {
			String URL = " w.rdc.sae.sina.com.cn:3307/app_book941016";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "lxjzjz50wo", "1zlhyhk1hx4m022z3425lml4klzwy0zmxmx0hy11");
			String sql = "select * from Book";
			String sql1 = null;
			ResultSet rs, rs1 = null;
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps1 = null;

			rs = ps.executeQuery();
			while (rs.next()) {
				book tmp = new book();
				tmp.setISBN(rs.getString(1));
				tmp.setTitle(rs.getString(2));
				tmp.setAuthorID(rs.getString(3));
				tmp.setPublisher(rs.getString(4));
				tmp.setPublishDate(rs.getString(5));
				tmp.setPrice(rs.getString(6));
				booklist.add(tmp);
				sql1 = "select * from Author where AuthorID ='"
						+ tmp.getAuthorID() + "'";
				ps1 = conn.prepareStatement(sql1);
				rs1 = ps1.executeQuery();
				while (rs1.next()) {
					author tmp1 = new author();
					tmp1.setAuthorID(rs1.getString(1));
					tmp1.setName(rs1.getString(2));
					tmp1.setAge(rs1.getString(3));
					tmp1.setCountry(rs1.getString(4));
					authorlist.add(tmp1);
				}
				ret = SUCCESS;
			}
			booklist.toArray();
			authorlist.toArray();
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

	public List<book> getBooklist() {
		return booklist;
	}

	public void getBooklist(List<book> booklist) {
		this.booklist = booklist;
	}
	public List<author> getAuthorlist() {
		return authorlist;
	}

	public void getAuthorlist(List<author> authorlist) {
		this.authorlist = authorlist;
	}
}
