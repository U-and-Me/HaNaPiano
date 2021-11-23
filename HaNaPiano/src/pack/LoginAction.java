package pack;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
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

public class LoginAction extends JFrame implements ActionListener {
	MySQLConnect mysql = new MySQLConnect();
	public JFrame frame;
	String id, pw;
	Toast toast = null;
	public LoginAction(JFrame frame, String id, String pw) {
		// 디비 연결 클래스 생성
		super("하나피아노");
		mysql = new MySQLConnect();
		this.frame = frame;
		setLayout(new FlowLayout());
		setSize(1600,900);//프레임의 크기
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
		
		mysql.connect();
		this.id = id;
		this.pw = pw;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub'
		int code = processLogin();
		toast.showtoast();
		if(code == 2) {
			frame.setVisible(false);
			setVisible(true);
			Start_Screen();
		}
	}

	public void Start_Screen() {
		ImageIcon image = new ImageIcon("../HaNaPiano/src/image/login_action.png");
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
		jl.add(btnUser);
		
		Container c = getContentPane();
		c.setFocusable(true);
		c.requestFocus();
		
		KeyListener playPiano = new KeyListener();
		c.addKeyListener(playPiano);
		
	}
	public int processLogin() {
		int loginCode = mysql.login(this.id, this.pw);
		
		String s = "";
		if(loginCode == 1) {
			s = "아이디가 존재하지 않습니다.";
			toast = new Toast(s, 150, 400);
		}
		else if(loginCode == 2) {
			s = "로그인에 성공하였습니다.";
			toast = new Toast(s, 150, 400);
		}
		else if(loginCode == 0){
			s = "비밀번호가 일치하지 않습니다."; 
			toast = new Toast(s, 150, 400);
		}
		return loginCode;
		
	}
	
}
