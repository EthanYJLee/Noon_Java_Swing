package com.noon.form.manager;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class ManagerForm1 extends JPanel {

    private JLabel lblNewLabel;
    private JComboBox comboBox;
    private JTextPane textPane;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    
//    -- Table Definition
	private final DefaultTableModel Outer_Table = new DefaultTableModel(); //********  중요 ********
	private JTable table_1;

    /**
     * Create the panel.
     */
    public ManagerForm1() {
    	addAncestorListener(new AncestorListener() {
    		public void ancestorAdded(AncestorEvent event) {
    			tableInit();
    		}
    		public void ancestorMoved(AncestorEvent event) {
    		}
    		public void ancestorRemoved(AncestorEvent event) {
    		}
    	});
        setLayout(null);
        setOpaque(false);
        add(getLblNewLabel());
        add(getComboBox());
        add(getTextPane());
        add(getBtnNewButton());
        add(getBtnNewButton_1());
        
        JScrollPane scrollPane_1 = new JScrollPane(); // 스크롤
        scrollPane_1.setBounds(33, 101, 698, 322);
        add(scrollPane_1);
        
        table_1 = new JTable();
        table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setModel(Outer_Table); // 이너테이블과 아우터테이블 연결 
        scrollPane_1.setViewportView(table_1); // 스크롤에 이너테이블 연결

    }

    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel("알바 급여 관리");
            lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
            lblNewLabel.setBounds(28, 46, 123, 16);
        }
        return lblNewLabel;
    }

    private JComboBox getComboBox() {
        if (comboBox == null) {
            comboBox = new JComboBox();
            comboBox.setModel(new DefaultComboBoxModel(new String[]{"이름", "전화번호"}));
            comboBox.setBounds(227, 41, 118, 27);
        }
        return comboBox;
    }

    private JTextPane getTextPane() {
        if (textPane == null) {
            textPane = new JTextPane();
            textPane.setBounds(350, 46, 252, 16);
        }
        return textPane;
    }

    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("검색");
            btnNewButton.setIcon(new ImageIcon("/Users/bagtaegwon/Downloads/Frame 6.png"));
            btnNewButton.setBounds(620, 38, 111, 24);
        }
        return btnNewButton;
    }
    
    // Init the table
	private void tableInit() {
		// 테이블의 컬럼 
		Outer_Table.addColumn("ID");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("주문처리 건수");
		Outer_Table.addColumn("인센티브 비율");
		Outer_Table.addColumn("이번달 급여");

		Outer_Table.setColumnCount(6);

		// table에 있는 데이터 지우기
		int a = Outer_Table.getRowCount();
		for (int i = 0; i < a; i++) {
			Outer_Table.removeRow(0); // 열이 하나씩 당겨지기 때문에
		}

		// 이너 테이블의 사이즈 
		table_1.setAutoResizeMode(table_1.AUTO_RESIZE_OFF);
		
		// ID column
		int vColIndex = 0;
		TableColumn col = table_1.getColumnModel().getColumn(vColIndex);
		int width = 80;
		col.setPreferredWidth(width);
		// 이름 column
		vColIndex = 1;
		col = table_1.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		// 전화번호 column
		vColIndex = 2;
		col = table_1.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);
		// 주문처리 건수 column
		vColIndex = 3;
		col = table_1.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		// 인센티브 비율 column
		vColIndex = 4;
		col = table_1.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		// 이번달 급여 column
		vColIndex = 5;
		col = table_1.getColumnModel().getColumn(vColIndex);
		width = 300;
		col.setPreferredWidth(width);
	}

    private JButton getBtnNewButton_1() {
        if (btnNewButton_1 == null) {
            btnNewButton_1 = new JButton("급여 입금하기");
            btnNewButton_1.setIcon(new ImageIcon("/Users/bagtaegwon/Downloads/Frame 7-2.png"));
            btnNewButton_1.setBounds(614, 440, 117, 29);
        }
        return btnNewButton_1;
    }


    @Override
    protected void paintChildren (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new Color(255,255,255,100));

        super.paintChildren(g);
    }
}
