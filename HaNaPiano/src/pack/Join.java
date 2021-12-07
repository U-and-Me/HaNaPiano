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

public class Join implements ActionListener{
	
	public JFrame frame;
	JFrame jframe;
	public static JTextField text_Id, text_Pwd, text_PwdCheck, text_Name;
	// ���̵�, ��й�ȣ, ��й�ȣ Ȯ��, �̸� �Է� JTextField

	public Join(JFrame frame) {
		System.out.println("Join.java ����");
		jframe = new JFrame("�ϳ��ǾƳ�"); // ��â �����
		this.frame = frame;
		jframe.setLayout(new FlowLayout());
		jframe.setSize(1600,900);//�������� ũ��
		jframe.setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		jframe.setLocationRelativeTo(null);//â�� ��� ������
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.setVisible(false); // ���� â ���ֱ�
		jframe.setVisible(true); // �� â ����
		JoinFrame();
	}
	
	public void JoinFrame() {
		ImageIcon image = new ImageIcon("../HanaPiano/src/image/join.png");
		JLabel jl = new JLabel(image);
		jl.setSize(1600, 900);
		jframe.add(jl);
		jframe.setLayout(null);
		jframe.setVisible(true);
		
		text_Id = new JTextField() {
			@Override public void setBorder(Border border) {
		    }
		};
		text_Pwd = new JTextField() {
			@Override public void setBorder(Border border) {
		    }
		};		text_PwdCheck = new JTextField() {
			@Override public void setBorder(Border border) {
		    }
		};
		text_Name = new JTextField() {
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
		btnJoin.setBounds(698, 731, 240, 91);
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
		jframe.add(jl);
		
		btnJoin.addActionListener(new JoinAction(jframe));
	}
	
}