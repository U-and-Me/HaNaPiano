package pack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		Start_Screen();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub4
		frame.setVisible(false);
		setVisible(true);
	}

	public void Start_Screen() {
		ImageIcon image = new ImageIcon("../HaNaPiano/src/image/play_start.png");
		JLabel jl = new JLabel(image);
		jl.setSize(1600, 900);
		this.add(jl);
		this.setLayout(null);
		this.setVisible(true);
		
		JButton btnMusic = new JButton();
		JButton btnUp = new JButton();
		JButton btnDawn = new JButton();
		JButton btnRecoding = new JButton();
		JButton btnStop = new JButton();
		JButton btnPause = new JButton();
		JButton btnPlay = new JButton();
		
		// �Ǻ�����
		btnMusic.setBounds(20, 40, 100, 110);
		btnMusic.setOpaque(false);
		btnMusic.setContentAreaFilled(false);
		btnMusic.setBorderPainted(true);
		btnMusic.setFocusable(false);
		
		btnMusic.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnMusic.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnMusic.setBorderPainted(false); // �׵θ� �Ⱥ��̰�   
	            }
	        }
	    });
		
		jl.add(btnMusic);
		
		// ��Ÿ�� �ø���
		btnUp.setBounds(635, 70, 50, 50);
		btnUp.setOpaque(false);
		btnUp.setContentAreaFilled(false);
		btnUp.setBorderPainted(true);
		btnUp.setFocusable(false);
		
		btnUp.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnUp.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnUp.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		
		jl.add(btnUp);
		
		// ��Ÿ�� ������
		btnDawn.setBounds(918, 70, 50, 50);
		btnDawn.setOpaque(false);
		btnDawn.setContentAreaFilled(false);
		btnDawn.setBorderPainted(true);
		btnDawn.setFocusable(false);

		btnDawn.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnDawn.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnDawn.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		jl.add(btnDawn);
		
		// �����ϱ�
		btnRecoding.setBounds(1103, 55, 70, 70);
		btnRecoding.setOpaque(false);
		btnRecoding.setContentAreaFilled(false);
		btnRecoding.setBorderPainted(true);
		btnRecoding.setFocusable(false);

		btnRecoding.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnRecoding.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnRecoding.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		jl.add(btnRecoding);
		
		// ���� ���߱�
		btnStop.setBounds(1185, 55, 70, 70);
		btnStop.setOpaque(false);
		btnStop.setContentAreaFilled(false);
		btnStop.setBorderPainted(true);
		btnStop.setFocusable(false);
		
		btnStop.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnStop.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnStop.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		jl.add(btnStop);
		
		// ���� ���
		btnPlay.setBounds(1263, 55, 70, 70);
		btnPlay.setOpaque(false);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorderPainted(true);
		btnPlay.setFocusable(false);
		
		btnPlay.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnPlay.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnPlay.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		jl.add(btnPlay);
		
		// ���� ����
		btnPause.setBounds(1345, 55, 70, 70);
		btnPause.setOpaque(false);
		btnPause.setContentAreaFilled(false);
		btnPause.setBorderPainted(true);
		btnPause.setFocusable(false);
		
		btnPause.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnPause.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnPause.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		jl.add(btnPause);
		
	}

}
