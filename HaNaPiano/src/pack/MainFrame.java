package pack;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
	
	private ImageIcon icon = new ImageIcon(Main.class.getResource("../image/start.png"));
	private Image background = icon.getImage();
	Graphics g;
	public MainFrame() {
		homeframe();
	}
	public void homeframe() {
		setTitle("�ϳ��ǾƳ�");//Ÿ��Ʋ
		setSize(1600,900);//�������� ũ��
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		setLayout(null);//���̾ƿ��� ������� ���������ϰ� ����.
		setVisible(true);//â�� ���̰�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
		changeImage("../image/login_start.png");
	}
	public void paint(Graphics g) {//�׸��� �Լ�
		g.drawImage(background, 0, 0, null);//background�� �׷���
	}

	public void changeImage(String path) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		icon = new ImageIcon(Main.class.getResource(path));
		background = icon.getImage();
		System.out.println("�̹��� ����");
		repaint();
	}
}
