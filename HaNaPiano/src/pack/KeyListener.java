package pack;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class KeyListener extends KeyAdapter {
	
	// ����� ���� arrayList
	public static ArrayList<ArrayList<File>> sounds = new ArrayList<ArrayList<File>>();
	// Ű �迭
	Character[] keys_code = {'a', 'w', 's', 'e', 'd', 'f', 't', 'g', 'y', 'h', 'u', 'j', 'k', 'o', 'l', 'p', ';'};
	// Ű �迭�� arrayList ����
	ArrayList<Character> keys = new ArrayList<>(Arrays.asList(keys_code));
	// ����� ���� �̸�
	String[] sounds_path = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E"};
	// ����� ���� ���
	String path = "../HaNaPiano/src/sound/";
	// ���� - ���� Ű arrayList
	public static ArrayList<Integer> recordKey = new ArrayList<>();
	// ���� - ���� ���� �ð� arrayList
	public static ArrayList<Long> recordTime = new ArrayList<>();
	public static ArrayList<Integer> recordOctave = new ArrayList<>();
	
	public static boolean recording = false; // ���� �� ����
	public static boolean playing = false; // ��� �� ����
	public static long keySecond = 0; // ���� Ű�� ���� �ð�
	public static long currentSecond = 0; // ���� Ű�� ���� �ð�
	
	public static int octNum = 4;
	
	public KeyListener() {
		for(int i=0; i<3; i++) {
			sounds.add(new ArrayList<File>());
			for(int j=0; j<sounds_path.length; j++) {
				if(j < 12) sounds.get(i).add(new File(path + sounds_path[j] + Integer.toString(i+3) + ".wav"));
				else if(j >= 12 && octNum != 3)sounds.get(i).add(new File(path + sounds_path[j] + Integer.toString(i+4) + ".wav"));
				// System.out.println(path + sounds_path[i] + Integer.toString(octNum) + ".mp3");
				// ����� ���� �����ϱ�
			}
		}
		sounds.get(2).add(new File(path + sounds_path[12] + Integer.toString(6) + ".wav"));
	}
	
	
	// Ű�� ������ �� �ǾƳ� �� ����ϱ�
	public void keyPressed(KeyEvent e) {
		Container contentPane = (Container)e.getSource();
		char c = e.getKeyChar();
		if((keys.contains(c) && octNum != 5) || (keys.indexOf(c) > -1 && keys.indexOf(c) < 13)) { // ���� Ű�� ����Ʈ�� ������
			int i = keys.indexOf(c); // ���� Ű�� �ε���
			AudioInputStream stream;
			try {
				stream = AudioSystem.getAudioInputStream(sounds.get(octNum-3).get(i)); // ���� Ű�� �ش��ϴ� ����� ���� stream ����
				Clip clip = AudioSystem.getClip();
	            clip.open(stream);
	            clip.start();
	            if(this.recording) { // ���� �� ������ true��
					recordKey.add(i); // ���� Ű ����Ʈ add
					recordOctave.add(octNum);
					currentSecond = System.currentTimeMillis() - keySecond; // ���� Ű�� ���� �ð����� ���� Ű�� ���� �ð� ����
					recordTime.add(currentSecond); // ���� �ð� ����Ʈ add
					keySecond = System.currentTimeMillis(); // ���� Ű�� ���� �ð��� ���� Ű�� ���� �ð� �ֱ�
				}
			}
			catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); 
			}
            
		}
		
	}
	
	// ���� ���
	public static void recordPlay() {
		playing = true; // ���� �� ���� true
		AudioInputStream stream;
		try {
			for(int i=0; i<recordKey.size(); i++) {
				if(!playing) return; // ���� �� ������ false�� break
				Thread.sleep(recordTime.get(i)); // �����ð� ����Ʈ�� i��° �游ŭ �����ϱ�
				stream = AudioSystem.getAudioInputStream(sounds.get(recordOctave.get(i)-3).get(recordKey.get(i))); // ���� Ű ����Ʈ�� �ش��ϴ� ����� ����
				Clip clip = AudioSystem.getClip();
	            clip.open(stream);
	            clip.start();
	            
			}
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
		}
		
	}
	public static void recordPlay(String[] recordKey, String[] recordTime, String[] recordOctave) { // int, long
		AudioInputStream stream;
		try {
			for(int i=0; i<recordKey.length; i++) {
				// if(!playing) return; // ���� �� ������ false�� break
				Thread.sleep(Long.parseLong(recordTime[i])); // �����ð� ����Ʈ�� i��° �游ŭ �����ϱ�
				stream = AudioSystem.getAudioInputStream(sounds.get(Integer.parseInt(recordOctave[i])-3).get(Integer.parseInt(recordKey[i]))); // ���� Ű ����Ʈ�� �ش��ϴ� ����� ����
				Clip clip = AudioSystem.getClip();
	            clip.open(stream);
	            clip.start();
	            
			}
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace(); 
		}
	}
}
