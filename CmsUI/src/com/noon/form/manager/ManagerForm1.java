package com.noon.form.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.noon.dao.DaoStaff;
import com.noon.dto.DtoStaff;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerForm1 extends JPanel {

    private JLabel lblNewLabel;
    private JComboBox comboBox;
    private JButton btnNewButton;
    
//    -- Table Definition
	private final DefaultTableModel Outer_Table = new DefaultTableModel(); //********  중요 ********
	private JTable table_1;  // 이너테이블 
	private JTextField tfSelection;

    /**
     * Create the panel.
     */
    public ManagerForm1() {
    	addAncestorListener(new AncestorListener() {
    		public void ancestorAdded(AncestorEvent event) {
    			tableInit();
    			searchAction();
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
        add(getBtnNewButton());
        
        
        JPanel panel = new JPanel();
        panel.setBounds(28, 80, 728, 283);
        add(panel);
        panel.setLayout(null);
        
        // 스크롤
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 0, 728, 283);
        panel.add(scrollPane_1);
        
        table_1 = new JTable();
        table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table_1.setModel(Outer_Table); // 이너테이블과 아우터테이블 연결 
        scrollPane_1.setViewportView(table_1); // 스크롤에 이너테이블 연결
        
        tfSelection = new JTextField();
        tfSelection.setBounds(357, 28, 289, 35);
        add(tfSelection);
        tfSelection.setColumns(10);

    }

    private JLabel getLblNewLabel() {
        if (lblNewLabel == null) {
            lblNewLabel = new JLabel("알바별 처리 건수");
            lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
            lblNewLabel.setBounds(28, 28, 174, 34);
        }
        return lblNewLabel;
    }

    private JComboBox getComboBox() {
        if (comboBox == null) {
            comboBox = new JComboBox();
            comboBox.setModel(new DefaultComboBoxModel(new String[] {"이름", "ID"}));
            comboBox.setBounds(227, 28, 118, 34);
        }
        return comboBox;
    }

    private JButton getBtnNewButton() {
        if (btnNewButton == null) {
            btnNewButton = new JButton("검색");
            btnNewButton.setIcon(new ImageIcon(ManagerForm1.class.getResource("/com/noon/icon/검색버튼.png")));
            btnNewButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		conditionQuery();
            	}
            });
            btnNewButton.setBounds(658, 28, 98, 34);
        }
        return btnNewButton;
    }
    
    // Init the table
	private void tableInit() {
		// 테이블의 컬럼 
		Outer_Table.addColumn("ID");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("주문처리 건수");;

		Outer_Table.setColumnCount(4);

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
		int width = 182;
		col.setPreferredWidth(width);
		// 이름 column
		vColIndex = 1;
		col = table_1.getColumnModel().getColumn(vColIndex);
		width = 182;
		col.setPreferredWidth(width);
		// 전화번호 column
		vColIndex = 2;
		col = table_1.getColumnModel().getColumn(vColIndex);
		width = 182;
		col.setPreferredWidth(width);
		// 주문처리 건수 column
		vColIndex = 3;
		col = table_1.getColumnModel().getColumn(vColIndex);
		width = 182;
		col.setPreferredWidth(width);

	}
	
	private void searchAction() {
		DaoStaff dao = new DaoStaff();
		ArrayList<DtoStaff> dtoList = dao.searchAction();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getCount());
			String[] qTxt = { dtoList.get(index).getId(), dtoList.get(index).getName(),
					dtoList.get(index).getPhone() , temp };
			Outer_Table.addRow(qTxt);

		}
	}
	
	private void conditionQuery() {
		int i = comboBox.getSelectedIndex();
		String conditionQueryColumn = "";
		switch (i) {
		case 0:
			conditionQueryColumn = "name";
			break;
		case 1:
			conditionQueryColumn = "id";
			break;
		default:
			break;
		}
		tableInit();
		conditionQueryAction(conditionQueryColumn);
	}
	
	private void conditionQueryAction(String conditionQueryColumn) {

		DaoStaff dao = new DaoStaff(conditionQueryColumn, tfSelection.getText().trim());
		ArrayList<DtoStaff> dtoList = dao.conditionList();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getCount());
			String[] qTxt = { dtoList.get(index).getId(), dtoList.get(index).getName(),
					dtoList.get(index).getPhone() , temp };
			Outer_Table.addRow(qTxt);

		}
	}

    @Override
    protected void paintChildren (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new Color(255,255,255,100));

        super.paintChildren(g);
    }
}
