package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class JoinAction implements ActionListener {

	Toast toast = null; // �佺Ʈ ��ü
	String id, pw, pwcheck, name; // JTextField���� ������ ���̵�, ��й�ȣ, ��й�ȣ Ȯ��, �̸� ����
	String message; // �佺Ʈ���� ��� �޽���
	JFrame frame; // ���� â. ���ִ� �뵵
	
	public JoinAction(JFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// JTextField���� �� ��������
		this.id = Join.text_Id.getText();
		this.pw = Join.text_Pwd.getText();
		this.pwcheck = Join.text_PwdCheck.getText();
		this.name = Join.text_Name.getText();
		int code = processJoin(); // ȸ������ ���� ��, ���� ��� �ڵ� ����.
		toast = new Toast(this.message, 800, 700); // �޽��� �佺Ʈ ����
		toast.showtoast();
		// ȸ�������� ���������� �Ϸ�Ǹ� �α��� â���� ���ư���(�α��� â ����)
		if(code == 2) {
			Login login = new Login(frame);
			frame.setVisible(false); // ȸ������ â �ݱ�
			login.LoginFrame();
		}
		
	}
	public int processJoin() {
		if(!pw.equals(pwcheck)) {
			this.message = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
			return 0;
		}
		// MySQL Ŭ���� ������ ���� ȸ������ ����.
		int joinCode = Main.mysql.join(this.id, this.pw, this.name);
		if(joinCode == 1) {
			this.message = "�̹� �����ϴ� ���̵��Դϴ�. ";
		}
		else if(joinCode == 2) {
			this.message = "ȸ�������� �Ϸ�Ǿ����ϴ�.";
		}
		else {
			this.message = "ȸ�����Կ� �����Ͽ����ϴ�.";
		}
		return joinCode;
	}
	
}