package pack;

import java.awt.Color;
import java.awt.Container;
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
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StartAction extends JFrame implements ActionListener {
	public JFrame frame;
	public int check_music = 1;

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
		Start_Screen();
	}

	public void Start_Screen() {
		ImageIcon menu = new ImageIcon("../HaNaPiano/src/image/start_menu.png");
		JLabel j1 = new JLabel(menu);
		j1.setSize(1600, 188);
		this.add(j1);
		this.setLayout(null);
		this.setVisible(true);
		
		ImageIcon piano_1 = new ImageIcon("../HaNaPiano/src/image/piano_1.png");
		ImageIcon piano_2 = new ImageIcon("../HaNaPiano/src/image/piano_2.png");
		JLabel j2 = new JLabel(piano_1);
		//j2.setSize(1600, 712);
		j2.setBounds(0, 189, 1600, 712);
		this.add(j2);
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
		btnMusic.setBorder(new LineBorder(new Color(255, 231, 110)));
		
		btnMusic.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnMusic.setBorder(new LineBorder(new Color(112, 112, 112)));
	            	btnMusic.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnMusic.setBorderPainted(false); // �׵θ� �Ⱥ��̰�   
	            	btnMusic.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		
		j1.add(btnMusic);
		//btnMusic.addActionListener(new Music(frame));
		btnMusic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(check_music == 1) {
					j2.setIcon(piano_2);
					j2.setBounds(0, 373, 1600, 493);
					check_music = 0;
				}else {
					j2.setIcon(piano_1);
					j2.setBounds(0, 189, 1600, 712);
					check_music = 1;
				}
			}
		});
		
		// ��Ÿ�� �ø���
		btnUp.setBounds(635, 70, 50, 50);
		btnUp.setOpaque(false);
		btnUp.setContentAreaFilled(false);
		btnUp.setBorderPainted(true);
		btnUp.setFocusable(false);
		btnUp.setBorder(new LineBorder(new Color(255, 231, 110)));
		
		btnUp.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnUp.setBorder(new LineBorder(new Color(112, 112, 112)));
	            	btnUp.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnUp.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		
		j1.add(btnUp);
		
		// ��Ÿ�� ������
		btnDawn.setBounds(918, 70, 50, 50);
		btnDawn.setOpaque(false);
		btnDawn.setContentAreaFilled(false);
		btnDawn.setBorderPainted(true);
		btnDawn.setFocusable(false);
		btnDawn.setBorder(new LineBorder(new Color(255, 231, 110)));

		btnDawn.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnDawn.setBorder(new LineBorder(new Color(112, 112, 112)));
	            	btnDawn.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnDawn.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		j1.add(btnDawn);
		
		// �����ϱ�
		btnRecoding.setBounds(1103, 55, 70, 70);
		btnRecoding.setOpaque(false);
		btnRecoding.setContentAreaFilled(false);
		btnRecoding.setBorderPainted(true);
		btnRecoding.setFocusable(false);
		btnRecoding.setBorder(new LineBorder(new Color(255, 231, 110)));

		btnRecoding.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnRecoding.setBorder(new LineBorder(new Color(112, 112, 112)));
	            	btnRecoding.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnRecoding.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		j1.add(btnRecoding);
		
		// ���� ���߱�
		btnStop.setBounds(1185, 55, 70, 70);
		btnStop.setOpaque(false);
		btnStop.setContentAreaFilled(false);
		btnStop.setBorderPainted(true);
		btnStop.setFocusable(false);
		btnStop.setBorder(new LineBorder(new Color(255, 231, 110)));
		
		btnStop.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnStop.setBorder(new LineBorder(new Color(112, 112, 112)));
	            	btnStop.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnStop.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		j1.add(btnStop);
		
		// ���� ���
		btnPlay.setBounds(1263, 55, 70, 70);
		btnPlay.setOpaque(false);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorderPainted(true);
		btnPlay.setFocusable(false);
		btnPlay.setBorder(new LineBorder(new Color(255, 231, 110)));
		
		btnPlay.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnPlay.setBorder(new LineBorder(new Color(112, 112, 112)));
	            	btnPlay.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnPlay.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		j1.add(btnPlay);
		
		// ���� ����
		btnPause.setBounds(1345, 55, 70, 70);
		btnPause.setOpaque(false);
		btnPause.setContentAreaFilled(false);
		btnPause.setBorderPainted(true);
		btnPause.setFocusable(false);
    	btnPause.setBorder(new LineBorder(new Color(255, 231, 110)));
		
		btnPause.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnPause.setBorder(new LineBorder(new Color(112, 112, 112)));
	            	btnPause.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnPause.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		j1.add(btnPause);
		Container c = getContentPane();
		c.setFocusable(true);
		c.requestFocus();
		
		KeyListener playPiano = new KeyListener();
		c.addKeyListener(playPiano);
		
	}

}
