package pack;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Join extends JFrame implements ActionListener{
	
	MySQLConnect mysql;  
	public JFrame frame;

	public Join(JFrame frame) {
		// ��� ���� Ŭ���� ����
		super("�ϳ��ǾƳ�");
		mysql = new MySQLConnect();
		this.frame = frame;
		setLayout(new FlowLayout());
		setSize(1600,900);//�������� ũ��
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mysql.connect();
		frame.setVisible(false);
		setVisible(true);
		JoinFrame();
	}
	
	public void JoinFrame() {
		ImageIcon image = new ImageIcon("../HanaPiano/src/image/join.png");
		JLabel jl = new JLabel(image);
		jl.setSize(1600, 900);
		this.add(jl);
		this.setLayout(null);
		this.setVisible(true);
		
		JTextField text_Id = new JTextField() {
			@Override public void setBorder(Border border) {
		    }
		};
		JTextField text_Pwd = new JTextField() {
			@Override public void setBorder(Border border) {
		    }
		};		JTextField text_PwdCheck = new JTextField() {
			@Override public void setBorder(Border border) {
		    }
		};
		JTextField text_Name = new JTextField() {
			@Override public void setBorder(Border border) {
		    }
		};
		
		JButton btnJoin = new JButton();
		
		// ���̵� �Է�
		text_Id.setBounds(600, 230, 548, 100);
		text_Id.setText("");
		text_Id.setOpaque(false);
		jl.add(text_Id);

		// ��й�ȣ �Է�
		text_Pwd.setBounds(600, 355, 548, 100);
		text_Pwd.setText("");
		text_Pwd.setOpaque(false);
		jl.add(text_Pwd);
		
		// ��ι�ȣ ���Է�
		text_PwdCheck.setBounds(600, 477, 548, 100);
		text_PwdCheck.setText("");
		text_PwdCheck.setOpaque(false);
		jl.add(text_PwdCheck);

		// �̸� �Է�
		text_Name.setBounds(600, 602, 548, 100);
		text_Name.setText("");
		text_Name.setOpaque(false);
		jl.add(text_Name);
		
		// ȸ������ ��ư
		btnJoin.setBounds(698, 730, 240, 90);
		btnJoin.setOpaque(false);
		btnJoin.setContentAreaFilled(false);
		btnJoin.setBorderPainted(false);
		btnJoin.setBorder(new RoundedBorder(100));
		btnJoin.setFocusable(false);
				
		btnJoin.getModel().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				ButtonModel model = (ButtonModel) e.getSource();
			    if (model.isRollover()) {
			      	btnJoin.setBorderPainted(true); // �׵θ� ���̰�
			    } else {
			        btnJoin.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
			    }
			}
		});		
		jl.add(btnJoin);
		
		btnJoin.addActionListener(new Login(frame));
	}
	
}