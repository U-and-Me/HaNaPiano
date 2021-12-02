package pack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecordFile {
	ArrayList<Integer> recordKey; // ���� Ű ����Ʈ
	ArrayList<Long> recordTime; // �����ð� ����Ʈ
	String id; // ���̵�(���� �̸�)
	
	public RecordFile(ArrayList<Integer> recordKey, ArrayList<Long> recordTime, String id) {
		this.recordKey = recordKey;
		this.recordTime = recordTime;
		this.id = id;
	}
	
	// ���������
	public void recordFile() {
		// ���� Ű ���ڿ��� ����
		String keys = "";
		for(int i=0; i<recordKey.size(); i++) {
			keys += recordKey.get(i).toString();
		}
		// �����ð� ���ڿ��� ����
		String times = "";
		for(int i=0; i<recordTime.size(); i++) {
			times += recordTime.get(i).toString() + " ";
		}
		// ���̵�� ���� �̸� ����
		 File file=new File("../HaNaPiano/src/record/" + id + ".txt");
	     if(!file.exists()) {
			try {
				file.createNewFile(); // ������ �������� ������ �� ���� �����
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     }
	     System.out.println("���� ���� �Ϸ�");
	     try {
	    	 // ���Ͽ� �Է�
			BufferedWriter bw=new BufferedWriter(new FileWriter(file));
			bw.write(keys);
			bw.newLine();
			bw.write(times);
			bw.newLine();
			bw.flush();
			bw.close();
			System.out.println("���� �ۼ� �Ϸ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
