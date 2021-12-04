package pack;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LoginAction extends JFrame implements ActionListener {
	
	public JFrame frame;
	String id, pw;
	Toast toast = null;
	public Thread th= null;
	int recordCnt;
	public MusicList mu = new MusicList();
	int recordIndex;

	public Container c = getContentPane();
	
	public int check_music = 1;
	public LabelList la = new LabelList();
	
	public JLabel imageLabel = new JLabel();
	public int NameInd = 0;
	
	JLabel title = new JLabel(); // �� �̸�
	String[][] music = {
			{"��������", "��������_1.png", "��������_2.png", "��������_3.png"},
			{"��������", "��������_1.png", "��������_2.png", "��������_3.png", "��������_4.png", "��������_5.png"},
			{"�����̼�", "�����̼�_1.png", "�����̼�_2.png", "�����̼�_3.png", "�����̼�_4.png"},
			{"�������  �� ��", "�������_1.png", "�������_2.png"}				
	};
	String path = "../HaNaPiano/src/music/";
	int musicName = 0, musicNum = 1;
	
	public LoginAction(JFrame frame) {
		// ��� ���� Ŭ���� ����
		super("�ϳ��ǾƳ�");
		
		this.frame = frame;
		setLayout(new FlowLayout());
		setSize(1600,900);//�������� ũ��
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.id = Login.text_Id.getText();
		this.pw = Login.text_Pwd.getText();
		System.out.println("���̵� : " + this.id+", ��й�ȣ : " + this.pw);
		int code = processLogin();
		toast.showtoast();
		if(code == 2) {
			frame.setVisible(false);
			setVisible(true);
			Start_Screen();
		}
	}

	public void Start_Screen() {
		la.j1.setSize(1600, 188);
		this.add(la.j1);
		this.setLayout(null);
		this.setVisible(true);
		
		la.j2.setSize(1600, 712);
		la.j2.setBounds(0, 189, 1600, 712);
		this.add(la.j2);
		this.setLayout(null);
		this.setVisible(true);
		
		imageLabel.setSize(1600, 219);
		imageLabel.setBounds(0, 189, 1600, 185);
		this.add(imageLabel);
		imageLabel.setLayout(new FlowLayout());
		this.setVisible(true);
		
		
		JButton btnMusic = new JButton();
		JButton btnUp = new JButton();
		JButton btnDawn = new JButton();
		JButton btnRecoding = new JButton();
		JButton btnStop = new JButton();
		JButton btnPause = new JButton();
		JButton btnPlay = new JButton();
		JButton btnUser = new JButton();
		
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

		btnMusic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(check_music == 1) { // �Ǻ�����
					ImageIcon menu = new ImageIcon("../HaNaPiano/src/image/music_log_menu.png");
					la.j1.setIcon(menu);
					showMusic(la.j1, la.j2);				
				}else {
					la.j1.setIcon(la.menu);
					la.j2.setIcon(la.piano_1);
					la.j2.setBounds(0, 189, 1600, 712);
					check_music = 1;
					title.setVisible(false);
					musicName = 0;
					musicNum = 1;
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
		
		// ����� ��ư
		btnUser.setBounds(1480, 57, 80, 90);
		btnUser.setOpaque(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorderPainted(false);
		btnUser.setFocusable(false);
		btnUser.setBorder(new LineBorder(new Color(255, 231, 110)));
		
		btnUser.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnUser.setBorder(new LineBorder(new Color(112, 112, 112)));
	            	btnUser.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	btnUser.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		
		btnUser.addActionListener(new MusicList(id));
		recordIndex = mu.getList();
		
		la.j1.add(btnUser);
		
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
				recordCnt = Main.mysql.getRecordCnt(id);
				Main.mysql.setRecordCnt(id, recordCnt+1);
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KeyListener.recording = false;
				RecordFile recordfile = new RecordFile(KeyListener.recordKey, KeyListener.recordTime, id);
				recordfile.recordFile();
				
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
	public int processLogin() {
		int loginCode = Main.mysql.login(this.id, this.pw);
		
		String s = "";
		if(loginCode == 1) {
			s = "���̵� �������� �ʽ��ϴ�.";
			toast = new Toast(s, 800, 700);
		}
		else if(loginCode == 2) {
			s = "�α��ο� �����Ͽ����ϴ�.";
			toast = new Toast(s, 800, 700);
		}
		else if(loginCode == 0){
			s = "��й�ȣ�� ��ġ���� �ʽ��ϴ�."; 
			toast = new Toast(s, 800, 700);
		}
		return loginCode;
		
	}
	public void showMusic(JLabel j1, JLabel j2) {
		ImageIcon musicImg = new ImageIcon(path+music[musicName][musicNum]);
		imageLabel.setIcon(musicImg);		
		
		JButton back = new JButton();
		back.setBounds(640, 141, 49, 39);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setFocusable(false);
		back.setBorder(new RoundedBorder(24));
		
		back.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	back.setBorder(new RoundedBorder(24));
	            	back.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	back.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		
		JButton next = new JButton();
		next.setBounds(911, 141, 49, 39);
		next.setOpaque(false);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		next.setFocusable(false);
		next.setBorder(new RoundedBorder(24));
		
		next.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	next.setBorder(new RoundedBorder(24));
	            	next.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	next.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		
		JButton select = new JButton();
		select.setBounds(745, 139, 110, 40);
		select.setOpaque(false);
		select.setContentAreaFilled(false);
		select.setBorderPainted(false);
		select.setFocusable(false);
		select.setBorder(new RoundedBorder(24));
		
		select.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	select.setBorder(new RoundedBorder(24));
	            	select.setBorderPainted(true); // �׵θ� ���̰�
	            } else {
	            	select.setBorderPainted(false); // �׵θ� �Ⱥ��̰�
	            }
	        }
	    });
		
		
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				musicNum++;
				if(musicNum < music[musicName].length) {
					ImageIcon musicImg = new ImageIcon(path+music[musicName][musicNum]);
					imageLabel.setIcon(musicImg);
				}
				
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				musicNum--;
				if(musicNum > 0) {
					ImageIcon musicImg = new ImageIcon(path+music[musicName][musicNum]);
					imageLabel.setIcon(musicImg);
				}
			}
		});
		
		select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				musicName++;
				musicNum = 1;
				if(musicName < music.length) {
					ImageIcon musicImg = new ImageIcon(path+music[musicName][musicNum]);
					imageLabel.setIcon(musicImg);
					title.setText(music[musicName][0]);
				}else{
					musicName = 0;
					musicNum = 1;
					ImageIcon musicImg = new ImageIcon(path+music[musicName][musicNum]);
					imageLabel.setIcon(musicImg);
					title.setText(music[musicName][0]);
				}
			}
		});
		
		add(imageLabel);
		j1.add(back);
		j1.add(next);	
		j1.add(select);
		
		title.setText(music[musicName][0]);
		title.setBounds(180, 35, 300, 100);
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

class LabelList{
	ImageIcon menu = new ImageIcon("../HaNaPiano/src/image/login_menu.png");
	JLabel j1 = new JLabel(menu);
	
	ImageIcon piano_1 = new ImageIcon("../HaNaPiano/src/image/piano_1.png");
	JLabel j2 = new JLabel(piano_1);
		
}

