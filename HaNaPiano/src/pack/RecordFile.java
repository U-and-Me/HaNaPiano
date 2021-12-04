package pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class RecordFile {
	ArrayList<Integer> recordKey; // ���� Ű ����Ʈ
	ArrayList<Long> recordTime; // �����ð� ����Ʈ
	static String id; // ���̵�(���� �̸�)
	
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
			keys += recordKey.get(i).toString() + " ";
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
			BufferedWriter bw=new BufferedWriter(new FileWriter(file, true));
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
	public static void playRecord(int index) {
		File file=new File("../HaNaPiano/src/record/" + id + ".txt");
		ArrayList<String> files = new ArrayList<String>();
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			Stream<String> stream = br.lines();
			stream.forEach(arr -> files.add(arr));
			//files = (String[]) stream.toArray();
			String[] recordKey = files.get(index*2).split(" ");
			String[] recordTime = files.get(index*2+1).split(" ");
			KeyListener.recordPlay(recordKey, recordTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
