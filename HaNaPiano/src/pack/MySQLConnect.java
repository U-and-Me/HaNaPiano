package pack;
import java.sql.*;

public class MySQLConnect {
	public MySQLConnect() {
		
	}
	public void connect() {
		try {
			// Class.forName("org.git.mm.mysql.Driver");// 1. jdbc ����̺� ����
			Class.forName("com.mysql.cj.jdbc.Driver"); // �� ������ ��
			System.out.println("����̺� ������ �ߵ�");
		} catch(ClassNotFoundException ee) {
			System.out.println("DB ���� ����̺갡 ����");
		}
		
		Connection conn = null;
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
			stmt = conn.createStatement();
		} catch(SQLException ee) {
			System.out.println("�۾� ó�� ��ü ���� ����");
		}
		
		
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery("select * from user");// 4. �������
			while(rs.next()) {
				System.out.println(rs.getString("id"));
			}
		} catch(SQLException ee) {
			System.out.println("��ɾ� ���� ����"+ee.toString());
		}
		
		
		try {
			// rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException ee) {
			System.out.println("���� ���� ����"+ee.toString());
		}
	}
}

