package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class JoinAction implements ActionListener {

	Toast toast = null;
	String id, pw, pwcheck, name;
	String message;
	JFrame frame;
	
	public JoinAction(JFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.id = Join.text_Id.getText();
		this.pw = Join.text_Pwd.getText();
		this.pwcheck = Join.text_PwdCheck.getText();
		this.name = Join.text_Name.getText();
		int code = processJoin();
		toast = new Toast(this.message, 800, 700);
		toast.showtoast();
		if(code == 2) {
			Login login = new Login(frame);
			frame.setVisible(false);
			login.LoginFrame();
		}
		
	}
	public int processJoin() {
		if(!pw.equals(pwcheck)) {
			this.message = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
			return 0;
		}
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
