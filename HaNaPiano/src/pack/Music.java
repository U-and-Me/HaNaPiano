package pack;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Music extends JFrame implements ActionListener{
	
	public JFrame frame;

	public Music(JFrame frame) {
		// ��� ���� Ŭ���� ����
		super("�ϳ��ǾƳ�");
		this.frame = frame;
		//setLayout(new FlowLayout());
		setSize(1600,900);//�������� ũ��
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*frame.setVisible(false);
		setVisible(true);*/
		MusicFrame();
	}
	
	public void MusicFrame() {
		ImageIcon image = new ImageIcon("../HaNaPiano/src/image/action_music.png");
		JLabel jl = new JLabel(image);
		jl.setSize(1600, 900);
		this.add(jl);
		this.setLayout(null);
		this.setVisible(true);
	}
	
}
