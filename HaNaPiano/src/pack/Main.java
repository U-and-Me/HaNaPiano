package pack;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Main {
	// ImageIcon icon = new ImageIcon(Main.class.getResource("../image/start.png"));
	// static Graphics background = icon.getImage();

	public static void main(String[] args) throws Exception {
		
		// setTitle("�ϳ��ǾƳ�");//Ÿ��Ʋ
		JFrame frame = new JFrame("�ϳ��ǾƳ�");
		frame.setSize(1600,900);//�������� ũ��
		frame.setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		frame.setLocationRelativeTo(null);//â�� ��� ������
		// frame.setLayout(null);//���̾ƿ��� ������� ���������ϰ� ����.
		//â�� ���̰�	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
		ImageIcon ii = new ImageIcon("F:\\HaNaPiano\\HaNaPiano\\HaNaPiano\\src\\image\\start.png");
		// TODO Auto-generated method stub
		JLabel jl = new JLabel(ii);
		jl.setSize(1600, 900);
		frame.add(jl);
		frame.setLayout(null);
		frame.setVisible(true);
		
		//MainFrame mainFrame = new MainFrame();
		// mainFrame.changeImage("../image/login_start.png");
		// JPanel pn = new JPanel();
		// pn.setLayout(null);
		// mainFrame.layoutButton(pn);
		// mainFrame.setContentPane(pn);
		// frame.paint(background);
		Thread.sleep(2000);
		ImageIcon iii = new ImageIcon("F:\\HaNaPiano\\HaNaPiano\\HaNaPiano\\src\\image\\login_start.png");
		jl.setIcon(iii);
		JButton btnLogin = new JButton();
		JButton btnStart = new JButton();
		btnLogin.setBounds(529, 185, 542, 207);
		btnStart.setBounds(529, 478, 542, 207);
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(true);
		btnLogin.setBorder(new LineBorder(Color.BLUE));
		btnStart.setOpaque(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setBorderPainted(true);
		btnStart.setBorder(new LineBorder(Color.BLUE));
		jl.add(btnLogin);
		jl.add(btnStart);
		
	}
	
	
}
