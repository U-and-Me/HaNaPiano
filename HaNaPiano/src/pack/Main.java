
package pack;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main {
	// ImageIcon icon = new ImageIcon(Main.class.getResource("../image/start.png"));
	// static Graphics background = icon.getImage();

	public static void main(String[] args) throws Exception {
		
		// �� â ����
		JFrame frame = new JFrame("�ϳ��ǾƳ�");
		frame.setSize(1600,900);//�������� ũ��
		frame.setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		frame.setLocationRelativeTo(null);//â�� ��� ������
		frame.setLayout(null);//���̾ƿ��� ������� ���������ϰ� ����.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
		
		// ó�� ���÷��� ȭ�� ����
		ImageIcon ii = new ImageIcon("../HaNaPiano/src/image/start.png");
		JLabel jl = new JLabel(ii);
		jl.setSize(1600, 900);
		frame.add(jl);
		frame.setLayout(null);
		frame.setVisible(true);
		
		Thread.sleep(2000); // ���÷��� 2�� ���
		// 2�� �� ��ư ȭ�� ����
		ImageIcon iii = new ImageIcon("../HaNaPiano/src/image/login_start.png");
		jl.setIcon(iii);
		
		// �α���, �ٷ� ���� ��ư �����
		JButton btnLogin = new JButton();
		JButton btnStart = new JButton();
		
		
		// LineBorder roundedLineBorder = new LineBorder(Color.black, 195, true);
		
		// �α��� ��ư
		btnLogin.setBounds(529, 185, 542, 207); // ��ǥ, ����, ���� ����
		btnLogin.setOpaque(false); 
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(true); // �׵θ� ���� ����
		btnLogin.setBorder(new RoundedBorder(195));
		btnLogin.setFocusable(false);
		// ��Ŭ�� ������
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
		
		// �ٷ� ���� ��ư
		btnStart.setBounds(529, 478, 542, 207);
		btnStart.setOpaque(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setBorderPainted(true);
		btnStart.setBorder(new RoundedBorder(195));
		btnStart.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnStart.setBorderPainted(true);
	            } else {
	            	btnStart.setBorderPainted(false);
	            }
	        }
	    });
		jl.add(btnStart);
		
		btnLogin.addActionListener(new Login(frame));
		btnStart.addActionListener(new StartAction(frame));
		
	}
	
	
}
