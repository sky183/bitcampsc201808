package member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Dao {
	Connection conn;
	/*
	 * String url = "jdbc:oracle:thin:@localhost:1522:orcl"; String user = "SCOTT";
	 * String password = "tiger";
	 */
	String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
	String sql;
	PreparedStatement pstmt;
	ResultSet rs;
	private static Dao instance;

	public static Dao getInstance() {
		if (instance == null) {
			instance = new Dao();
		}
		return instance;
	}

//	Dao 객체 생성 및 연결

	private Dao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당클래스를 찾을 수 없습니다." + cnfe.getMessage());
		}
	}

	public MemberInfo selSql() {
		MemberInfo mem = new MemberInfo();
		try {
			conn = DriverManager.getConnection(jdbcDriver);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				int i = 1;
				mem.setIdx(rs.getInt(i));
				mem.setUserId(rs.getString(++i));
				mem.setPassword(rs.getString(++i));
				mem.setUserName(rs.getString(++i));
				mem.setUserPhoto(rs.getString(++i));
				mem.setRegDate(rs.getDate(++i));

				break;
			}
			pstmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {

		}

		return mem;

	}

	public List<MemberInfo> selectAll() {
		List<MemberInfo> members = new ArrayList<MemberInfo>();
		sql = "select * from member";
		try {
			conn = DriverManager.getConnection(jdbcDriver);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql); // SQL문을 실행한다.
			while (rs.next()) {
				MemberInfo member = new MemberInfo();
				member.setIdx(rs.getInt(1));
				member.setUserId(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setUserName(rs.getString(4));
				member.setUserPhoto(rs.getString(5));
				member.setRegDate(rs.getDate(6));
				members.add(member);
			}
			pstmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;
	}

	public MemberInfo select(MemberInfo mem) {
		sql = "select * from member where userid='" + mem.getUserId() + "'";
		return selSql();
	}

	public int update(MemberInfo mem) {
		try {
			conn = DriverManager.getConnection(jdbcDriver);
			conn.setAutoCommit(true);

			sql = "update member set userid=?, password=?, username=?, userphoto=?";
			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setString(i, mem.getUserId());
			pstmt.setString(++i, mem.getPassword());
			pstmt.setString(++i, mem.getUserName());
			pstmt.setString(++i, mem.getUserPhoto());
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	public int insert(MemberInfo mem) {
		try {
			conn = DriverManager.getConnection(jdbcDriver);
			sql = "insert into member values (seq.nextval,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			int i = 1;

			pstmt.setString(i, mem.getUserId());
			pstmt.setString(++i, mem.getPassword());
			pstmt.setString(++i, mem.getUserName());
			pstmt.setString(++i, mem.getUserPhoto());

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
}
