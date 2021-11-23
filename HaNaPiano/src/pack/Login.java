package pack;

import java.awt.Color;
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
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Login extends JFrame implements ActionListener {
	
	MySQLConnect mysql;  
	public JFrame frame;

	public Login(JFrame frame) {
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
		LoginFrame();
	}
	
	public void LoginFrame() {
		ImageIcon image = new ImageIcon("../HaNaPiano/src/image/login.png");
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
		};
		JButton btnLogin = new JButton();
		JButton btnJoin = new JButton();
		
		// ���̵� �Է�
		text_Id.setBounds(550, 310, 548, 100);
		text_Id.setText("");
		text_Id.setOpaque(false);
		jl.add(text_Id);
		
		// ��й�ȣ �Է�
		text_Pwd.setBounds(550, 450, 548, 100);
		text_Pwd.setText("");
		text_Pwd.setOpaque(false);
		jl.add(text_Pwd);
		
		// �α����ϱ�
		btnLogin.setBounds(842, 595, 270, 100);
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(new RoundedBorder(100));
		btnLogin.setFocusable(false);
		
		btnLogin.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnLogin.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnLogin.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });		
		jl.add(btnLogin);
		
		// ȸ������ �ϱ�
		btnJoin.setBounds(511, 595, 270, 100);
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
				
		btnLogin.addActionListener(new LoginAction(frame));
				
	}

}
