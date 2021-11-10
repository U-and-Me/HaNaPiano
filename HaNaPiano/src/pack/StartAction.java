package pack;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class StartAction extends JFrame implements ActionListener {
	public JFrame frame;

	public StartAction(JFrame frame) {
		super("�ϳ��ǾƳ�");
		this.frame = frame;
		setLayout(new FlowLayout());
		setSize(1600,900);//�������� ũ��
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub4
		frame.setVisible(false);
		setVisible(true);
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(new Color(255, 231, 110));
		g.fillRect(0, 0, 1600, 180);
		ImageIcon icon = new ImageIcon("../HaNaPiano/src/image/piano_background.png");
        Image img = icon.getImage();
		g.drawImage(img, 0, 180, 1600, 800, null);
	}
	

}
