package pack;
import java.sql.*;

public class MySQLConnect {
	Connection conn = null;
	public MySQLConnect() {
		// ������
	}
	public void connect() {
		try {
			// Class.forName("org.git.mm.mysql.Driver");// 1. jdbc ����̺� ����
			Class.forName("com.mysql.cj.jdbc.Driver"); // �� ������ ��
			System.out.println("����̺� ������ �ߵ�");
		} catch(ClassNotFoundException ee) {
			System.out.println("DB ���� ����̺갡 ����");
		}
		
		String url = "jdbc:mysql: //127.0.0.1:3306/hanapiano_db";
		String id = "root";
		String pw = "mirim";
		
		try {
			conn = DriverManager.getConnection(url, id, pw);// 2. �����ͺ��̽� ����
		} catch(SQLException ee) {
			System.out.println("DB �������");
		}
		
		Statement stmt = null; // 3. ��ɾ� ó�� ��ü ����
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch(SQLException ee) {
			System.out.println("�۾� ó�� ��ü ���� ����");
		}
		
	}
	int login(String id, String pw) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			String sql = "select * from user where id = ?";
			stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			rs.last();
			int rowCount = rs.getRow();
			rs.beforeFirst();
			if(rowCount < 1) {
				stmt.close();
				return 1;
			}
			else {
				cnt = 0;
				sql = "select * from user where id = ? and pw = ?";
				stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
				stmt.setString(1, id);
				stmt.setString(2, pw);
				rs = stmt.executeQuery();
				rs.last();
				rowCount = rs.getRow();
				rs.beforeFirst();
				if(rowCount == 1) {
					stmt.close();
					return 2;
				}
				else {
					stmt.close();
					return 0;
				}
			}
		} catch(SQLException ee) {
			System.out.println("��ɾ� ���� ����"+ee.toString());
		}
		return 0;
	}
	
	
	void closing() {
		try {
			// rs.close();
			conn.close();
		} catch(SQLException ee) {
			System.out.println("���� ���� ����"+ee.toString());
		}
	}
	
	
	int join(String id, String pw, String name) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			String sql = "select * from user where id = ?";
			stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			rs.last();
			int rowCount = rs.getRow();
			rs.beforeFirst();
			while(rs.next()) {
				cnt++;
			}
			if(cnt > 0) {
				stmt.close();
				return 1;
			}
			else {
				cnt = 0;
				sql = "insert into user values(?, ?, ?)";
				stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
				stmt.setString(1, id);
				stmt.setString(2, pw);
				stmt.setString(3, name);
				stmt.executeUpdate();
				return 2;
			}
		} catch(SQLException ee) {
			System.out.println("��ɾ� ���� ����"+ee.toString());
		}
		return 0;
	}
}