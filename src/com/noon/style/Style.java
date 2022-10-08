package com.noon.style;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Style {

	// Fields
	
	
	
	// Constructor
	public Style() {
		// TODO Auto-generated constructor stub
	}

	
	
	// Method
	// change image scale >>"파일경로" input<<
	public ImageIcon imageSize(String imagePath) {
		ImageIcon icon = new ImageIcon(imagePath); // 파일경로 입력
		Image img = icon.getImage(); // 이미지아이콘을 이미지로 변환
		Image changeImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // 사이즈 조정
		ImageIcon changeIcon = new ImageIcon(changeImg); // 이미지에서 이미지아이콘으로 다시 변환
		return changeIcon;
	}
	
	
	
} // end
