package pack;
import java.sql.*;

public class MySQLConnect {
	Connection conn = null;
	public MySQLConnect() {
		// ������
	}
	// ���� �޼ҵ�
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // �� ������ ��
			System.out.println("����̺� ������ �ߵ�");
		} catch(ClassNotFoundException ee) {
			System.out.println("DB ���� ����̺갡 ����");
		}
		
		String url = "jdbc:mysql://127.0.0.1:3306/hanapiano_db";
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
	
	// �α���
	int login(String id, String pw) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			String sql = "select * from user where id = ?"; // ���̵� ���� ���� üũ
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
				sql = "select * from user where id = ? and pw = ?"; // ��й�ȣ Ȯ��
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
	
	// �ݱ�
	void closing() {
		try {
			// rs.close();
			conn.close();
		} catch(SQLException ee) {
			System.out.println("���� ���� ����"+ee.toString());
		}
	}
	
	// ȸ������
	int join(String id, String pw, String name) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			String sql = "select * from user where id = ?"; // ���̵� �ߺ� üũ
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
				sql = "insert into user (id, pw, name) values(?, ?, ?)"; // insert
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
	
	
	// ����� ���� ���� ��������
	public int getRecordCnt(String id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "select record from user where id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	// ����� ���� ���� update
	public void setRecordCnt(String id, int cnt) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "update user set record = ? where id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cnt);
			stmt.setString(2, id);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
