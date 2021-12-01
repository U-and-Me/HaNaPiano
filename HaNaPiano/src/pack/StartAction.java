package pack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.TextAction;

public class StartAction extends JFrame implements ActionListener {
	public JFrame frame;
	public Thread th= null;
	public int check_music = 1;
	public MusicListener mu;
	public JLabel Jl_mu = new JLabel();
	public Label la = new Label();
	
	JLabel title = new JLabel(); // �� �̸�
	String[][] music = {
			{"��������", "��������_1.png", "��������_2.png", "��������_3.png"}
						};
	String path = "../HaNaPiano/src/music/";
	int musicName = 0, musicNum = 1;

	public StartAction() {}
	
	public StartAction(int musicNum) {
		this.musicNum = musicNum;
		System.out.println(musicNum);
	}
	
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
		//ImageIcon menu = new ImageIcon("../HaNaPiano/src/image/start_menu.png");
		//JLabel j1 = new JLabel(menu);
		la.j1.setSize(1600, 188);
		this.add(la.j1);
		this.setLayout(null);
		this.setVisible(true);
		
		//ImageIcon piano_1 = new ImageIcon("../HaNaPiano/src/image/piano_1.png");
		//JLabel j2 = new JLabel(piano_1);
		la.j2.setSize(1600, 712);
		la.j2.setBounds(0, 189, 1600, 712);
		this.add(la.j2);
		this.setLayout(null);
		this.setVisible(true);
		
		la.j3.setSize(1600, 219);
		la.j3.setBounds(0, 189, 1600, 219);
		this.add(la.j3);
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
		
		la.j1.add(btnMusic);
		//btnMusic.addActionListener(new Music(frame));
		btnMusic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(check_music == 1) { // �Ǻ�����
					showMusic(la.j1, la.j2, la.j3);					
										
				}else {
					la.j2.setIcon(la.piano_1);
					la.j2.setBounds(0, 189, 1600, 712);
					check_music = 1;
					title.setVisible(false);
				}
			}
		});
		
		Container cc = getContentPane();
		cc.setFocusable(true);
		cc.requestFocus();
		mu = new MusicListener(musicName, musicNum);
		cc.addKeyListener(mu);
		
		
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
		
		la.j1.add(btnUp);
		
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
		la.j1.add(btnDawn);
		
		// �����ϱ�
		btnRecoding.setBounds(1105, 59, 68, 68);
		btnRecoding.setOpaque(false);
		btnRecoding.setContentAreaFilled(false);
		btnRecoding.setBorderPainted(false);
		btnRecoding.setFocusable(false);
		btnRecoding.setBorder(new RoundedBorder(50));

		btnRecoding.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	        		btnRecoding.setBorder(new RoundedBorder(50));
	            	btnRecoding.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnRecoding.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		la.j1.add(btnRecoding);
		
		// ���� ���߱�
		btnStop.setBounds(1185, 59, 68, 68);
		btnStop.setOpaque(false);
		btnStop.setContentAreaFilled(false);
		btnStop.setBorderPainted(false);
		btnStop.setFocusable(false);
		btnStop.setBorder(new RoundedBorder(50));

		
		btnStop.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnStop.setBorder(new RoundedBorder(50));
	            	btnStop.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnStop.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		la.j1.add(btnStop);
		
		// ���� ���
		btnPlay.setBounds(1265, 59, 68, 68);
		btnPlay.setOpaque(false);
		btnPlay.setContentAreaFilled(false);
		btnPlay.setBorderPainted(false);
		btnPlay.setFocusable(false);
		btnPlay.setBorder(new RoundedBorder(50));
		
		btnPlay.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnPlay.setBorder(new RoundedBorder(50));
	            	btnPlay.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnPlay.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		la.j1.add(btnPlay);
		
		// ���� ����
		btnPause.setBounds(1345, 59, 68, 68);
		btnPause.setOpaque(false);
		btnPause.setContentAreaFilled(false);
		btnPause.setBorderPainted(false);
		btnPause.setFocusable(false);
    	btnPause.setBorder(new RoundedBorder(50));
		
		btnPause.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnPause.setBorder(new RoundedBorder(50));
	            	btnPause.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnPause.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		la.j1.add(btnPause);
		
		Container c = getContentPane();
		c.setFocusable(true);
		c.requestFocus();
		
		KeyListener playPiano = new KeyListener();
		c.addKeyListener(playPiano);
		
		btnRecoding.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				KeyListener.recording = true;
				KeyListener.recordKey.clear();
				KeyListener.keySecond = System.currentTimeMillis();
			}
			
		});
		
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				th = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						KeyListener.recordPlay();
					}
				});
				th.start();
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KeyListener.recording = false;
			}
		});
		
		btnPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KeyListener.playing = false;
			}
		});
	}
	
	public void test(int musicNum) {
		this.musicNum = musicNum;
		//System.out.println("test " + musicNum);
		showMusic(la.j1, la.j2, la.j3);
	}
	public void showMusic(JLabel j1, JLabel j2, JLabel j3) {
		// �Ǻ� ����
		ImageIcon musicImg = new ImageIcon(path+music[musicName][musicNum]);
		//System.out.println("musicn  " + path+music[musicName][musicNum]);
		
		j3.setIcon(musicImg);
		j3.setSize(1600, 219);
		j3.setBounds(0, 189, 1600, 219);
		System.out.println(j3.getIcon());
		System.out.println(j3);
		add(j3);
		//j3.setBounds(0, 189, 1600, 219);
		
		
		
		title.setText(music[musicName][0]);
		title.setBounds(180, 35, 200, 100);
		title.setFont(new Font("SansSerif", Font.BOLD, 35));
		j1.add(title);
		j1.setLayout(null);
		title.setVisible(true);				
		
		ImageIcon piano_2 = new ImageIcon("../HaNaPiano/src/image/piano_2.png");
		// �ǾƳ� ����
		j2.setIcon(piano_2);
		j2.setBounds(0, 373, 1600, 493);
		check_music = 0;
		
	}
	
}

class Label{
	ImageIcon menu = new ImageIcon("../HaNaPiano/src/image/start_menu.png");
	JLabel j1 = new JLabel(menu);
	
	ImageIcon piano_1 = new ImageIcon("../HaNaPiano/src/image/piano_1.png");
	JLabel j2 = new JLabel(piano_1);
	
	ImageIcon musicImg = new ImageIcon("../HaNaPiano/src/music/��������_1");
	JLabel j3 = new JLabel(musicImg); 
	
}
