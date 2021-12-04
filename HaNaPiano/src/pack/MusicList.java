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

	public JFrame frame = new JFrame("�ϳ��ǾƳ�");
	public int recordCnt;
	public DefaultListModel model = new DefaultListModel();
	public JList MList = new JList(model);
	public int index;
	String id;
	
	public MusicList() {}
	
	public MusicList(String id) {
		frame.setSize(300, 900);//�������� ũ��
		frame.setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		//frame.setLocationRelativeTo(null);//â�� ��� ������
		frame.setLocation(1500, 65);
		frame.setLayout(new FlowLayout());//���̾ƿ��� ������� ���������ϰ� ����.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
		this.id = id;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		this.recordCnt = Main.mysql.getRecordCnt(id);
		
		Button showBtn = new Button("�� ����");
		showBtn.setBounds(120, 800, 50, 50);
		
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

		frame.add(showBtn);
		
		MList.setFixedCellWidth(300);
		MList.setFixedCellHeight(50);
		
		for(int i = 1; i <= recordCnt; i++) {
			model.addElement(i+"��° ���� ���");
		}
		MList.setModel(model);
		
		frame.add(MList);
		frame.setVisible(true);

	}
	
	public int getList() {
		index = MList.getSelectedIndex();
		System.out.println(index);
		LoginAction.recordfile.playRecord(index);
		return index;
	}
	
	
}