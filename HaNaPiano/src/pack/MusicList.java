package pack;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class MusicList implements ActionListener{

	public JFrame frame = new JFrame("하나피아노");
	public int recordCnt;
	public DefaultListModel model = new DefaultListModel();
	public JList MList = new JList(model);
	public int index;
	
	public MusicList() {}
	
	public MusicList(String id) {
		frame.setSize(300, 900);//프레임의 크기
		frame.setResizable(false);//창의 크기를 변경하지 못하게
		//frame.setLocationRelativeTo(null);//창이 가운데 나오게
		frame.setLocation(1500, 65);
		frame.setLayout(new FlowLayout());//레이아웃을 내맘대로 설정가능하게 해줌.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
	
		this.recordCnt = Main.mysql.getRecordCnt(id);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		
		Button showBtn = new Button("곡 선택");
		Button CancelBtn = new Button("취소");
		showBtn.setBounds(110, 800, 80, 80);
		showBtn.setFocusable(false);
		CancelBtn.setBounds(115, 800, 80, 80);
		
		showBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getList();
				model.removeAllElements();
				frame.remove(MList);
				frame.remove(showBtn);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
		CancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.remove(MList);
				frame.remove(showBtn);
				frame.setVisible(false);
				frame.dispose();
			}
		});

		frame.add(showBtn);
		frame.add(CancelBtn);
		
		MList.setFixedCellWidth(300);
		MList.setFixedCellHeight(50);
		
		for(int i = 1; i <= recordCnt; i++) {
			model.addElement("Element " + i);
		}
		MList.setModel(model);
		
		frame.add(MList);
		frame.setVisible(true);

	}
	
	public int getList() {
		index = MList.getSelectedIndex();
		System.out.println(index);
		
		return index;
	}
	
	
}
