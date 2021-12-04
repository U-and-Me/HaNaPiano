package pack;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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
	
	public JFrame frame; // 이전 창. 없애는 용도
	String id, pw; // JTextField에서 가져올 아이디, 비밀번호 변수
	Toast toast = null; // 토스트 클래스 변수
	public Thread th= null; // 녹음 재생을 위한 스레드
	int recordCnt; // 사용자가 지금까지 녹음한 갯수
	public MusicList mu = new MusicList();
	int recordIndex;
	public static RecordFile recordfile = null;

	public Container c = getContentPane();
	
	public LoginAction(JFrame frame) {
		// 디비 연결 클래스 생성
		super("하나피아노");
		this.frame = frame;
	//	setLayout(new CardLayout());
		setSize(1600,900);//프레임의 크기
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.id = Login.text_Id.getText(); // 아이디 가져오기
		this.pw = Login.text_Pwd.getText(); // 비밀번호 가져오기
		System.out.println("아이디 : " + this.id+", 비밀번호 : " + this.pw);
		int code = processLogin(); // 로그인 후 실행 결과 코드 가져오기
		toast.showtoast(); // 토스트 띄우기
		// 로그인이 성공적으로 완료되면
		if(code == 2) {
			frame.setVisible(false); // 이전 창 없애기
			setVisible(true); // 현재 창 띄우기
			Start_Screen(); // 창 구성하는 메소드
		}
	}

	public void Start_Screen() {
		ImageIcon image = new ImageIcon("../HaNaPiano/src/image/login_action.png");
		JLabel jl = new JLabel(image);
		jl.setSize(1600, 900);
		this.add(jl);
		this.setLayout(null);
		this.setVisible(true);
		recordfile = new RecordFile(KeyListener.recordKey, KeyListener.recordTime, id); // 녹음 파일입출력 객체
		
		JButton btnMusic = new JButton();
		JButton btnUp = new JButton();
		JButton btnDawn = new JButton();
		JButton btnRecoding = new JButton();
		JButton btnStop = new JButton();
		JButton btnPause = new JButton();
		JButton btnPlay = new JButton();
		JButton btnUser = new JButton();
		
		// 악보보기
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
	            	btnMusic.setBorderPainted(true); // 테두리 보이게
	            } else {
	            	btnMusic.setBorderPainted(false); // 테두리 안보이게
	            }
	        }
	    });
		
		jl.add(btnMusic);
		
		// 옥타브 올리기
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
	            	btnUp.setBorderPainted(true); // 테두리 보이게
	            } else {
	            	btnUp.setBorderPainted(false); // 테두리 안보이게
	            }
	        }
	    });
		
		jl.add(btnUp);
		
		// 옥타브 내리기
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
	            	btnDawn.setBorderPainted(true); // 테두리 보이게
	            } else {
	            	btnDawn.setBorderPainted(false); // 테두리 안보이게
	            }
	        }
	    });
		jl.add(btnDawn);
		
		// 녹음하기
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
	            	btnRecoding.setBorderPainted(true); // 테두리 보이게
	            } else {
	            	btnRecoding.setBorderPainted(false); // 테두리 안보이게
	            }
	        }
	    });
		jl.add(btnRecoding);
		
		// 녹음 멈추기
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
	            	btnStop.setBorderPainted(true); // 테두리 보이게
	            } else {
	            	btnStop.setBorderPainted(false); // 테두리 안보이게
	            }
	        }
	    });
		jl.add(btnStop);
		
		// 음악 재생
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
	            	btnPlay.setBorderPainted(true); // 테두리 보이게
	            } else {
	            	btnPlay.setBorderPainted(false); // 테두리 안보이게
	            }
	        }
	    });
		jl.add(btnPlay);
		
		// 음악 정지
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
	            	btnPause.setBorderPainted(true); // 테두리 보이게
	            } else {
	            	btnPause.setBorderPainted(false); // 테두리 안보이게
	            }
	        }
	    });
		jl.add(btnPause);
		
		// 사용자 버튼
		btnUser.setBounds(1497, 50, 75, 75);
		btnUser.setOpaque(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorderPainted(true);
		btnUser.setFocusable(false);
		btnUser.setBorder(new LineBorder(new Color(255, 231, 110)));
		
		btnUser.getModel().addChangeListener(new ChangeListener() {
	        @Override
	        public void stateChanged(ChangeEvent e) {
	            ButtonModel model = (ButtonModel) e.getSource();
	            if (model.isRollover()) {
	            	btnUser.setBorder(new LineBorder(new Color(112, 112, 112)));
	            	btnUser.setBorderPainted(true); // 테두리 보이게
	            } else {
	            	btnUser.setBorderPainted(false); // 테두리 안보이게
	            }
	        }
	    });
		
		btnUser.addActionListener(new MusicList(id));
		// recordIndex = mu.getList();
		
		jl.add(btnUser);
		
		Container c = getContentPane();
		c.setFocusable(true);
		c.requestFocus();
		// 키 입력 받기
		
		KeyListener playPiano = new KeyListener(); // 키 리스너 객체 생성
		c.addKeyListener(playPiano);
		
		// 녹음 시작
		btnRecoding.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				KeyListener.recording = true; // 녹음 중 변수 true
				KeyListener.recordKey.clear(); // 녹음 키 리스트 비우기
				KeyListener.recordTime.clear(); // 녹음 시간 리스트 비우기
				KeyListener.keySecond = System.currentTimeMillis(); // 현재 시간 표시
				
			}
			
		});
		
		// 녹음 재생
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				th = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						KeyListener.recordPlay(); // 스레드로 녹음 재생
					}
				});
				th.start();
				
			}
		});
		
		// 녹음 중지
		btnStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KeyListener.recording = false; // 녹음 중 변수 false
				recordfile.recordFile(); // 파일입출력 실행
				recordCnt = Main.mysql.getRecordCnt(id); // 녹음 갯수 가져오기
				Main.mysql.setRecordCnt(id, recordCnt+1); // 녹음 갯수 + 1 데이터베이스에 넣기
				
			}
		});
		
		// 재생 정지
		btnPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KeyListener.playing = false; // 연주 중 변수 false
				
			}
		});
		
	}
	public int processLogin() {
		int loginCode = Main.mysql.login(this.id, this.pw); // MySQL 클래스 변수를 통해 로그인하고 결과 코드 가져오기
		String s = "";
		if(loginCode == 1) {
			s = "아이디가 존재하지 않습니다.";
			toast = new Toast(s, 800, 700);
		}
		else if(loginCode == 2) {
			s = "로그인에 성공하였습니다.";
			toast = new Toast(s, 800, 700);
		}
		else if(loginCode == 0){
			s = "비밀번호가 일치하지 않습니다."; 
			toast = new Toast(s, 800, 700);
		}
		// 로그인 결과에 따라 토스트 변수 생성
		return loginCode;
		
	}
	
}
