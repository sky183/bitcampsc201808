package member.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	Connection conn;
	String url = "jdbc:oracle:thin:@localhost:1522:orcl";
	String user = "SCOTT";
	String password = "tiger";
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
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException cnfe) {
				System.out.println("해당클래스를 찾을 수 없습니다." + cnfe.getMessage());
			} catch (SQLException se) {
				System.out.println(se.getMessage());
		}
	}
	
	

	public MemberInfo selSql() {
		MemberInfo mem = new MemberInfo();
		try {
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
			conn.close();
		} catch (Exception e) {
			
		} 
		
		return mem;
		
	}

	public MemberInfo selectAll() {
		sql = "select * from member";
		return selSql();
	}
	
	public MemberInfo select(MemberInfo mem) {
		sql = "select * from member where userid='" + mem.getUserId() + "'";
		return selSql();
	}

	public int update(MemberInfo mem) {
		try {
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
