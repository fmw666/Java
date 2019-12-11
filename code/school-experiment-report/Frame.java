

import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


class Menu extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel panel;
	private JLabel jlName;
	private JLabel jlSName;
	private JLabel jlId;
	private JLabel jlSId;
	private JScrollPane jsp;
	private JTable jt;
    private GroupLayout layout;
    private JFileChooser jfcFile;

    public Menu() {
		initComponents();
		jfcFile = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("text", "txt", "ini");
		jfcFile.setFileFilter(filter);
    }

	private void initComponents() {
		setBounds(200, 200, 100, 100);
        setTitle("fmw666 成绩");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

		jlName = new JLabel();
		jlSName = new JLabel();
		jlId = new JLabel();
		jlSId = new JLabel();

		// 表头（列名）
		Object[] columnNames = {"课程代码", "课程名称", "成绩"};
		// 表格所有行数据
        Object[][] rowData = {
			{"1701", "Java", 80},
			{"1702", "C++", 80},
			{"1703", "数据结构", 70},
			{"1704", "计算机组成原理", 70},
			{"1705", "操作系统", 70},
			{"1706", "计算机网络", 92}
		};

		jt = new JTable(rowData, columnNames);
		jsp = new JScrollPane(jt);

        // layout
		panel = new JPanel();
		layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
        layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

        // horizontal
        GroupLayout.ParallelGroup hParalGroup = layout.createParallelGroup().addComponent(jlName).addComponent(jlSName).addComponent(jlId).addComponent(jlSId);
        GroupLayout.SequentialGroup hSeqGroup = layout.createSequentialGroup().addGroup(hParalGroup).addComponent(jsp);

        layout.setHorizontalGroup(hSeqGroup);

        // vertical
        GroupLayout.ParallelGroup vParalGroup1 = layout.createParallelGroup().addComponent(jlName).addComponent(jlSName).addComponent(jlId).addComponent(jlSId);
        GroupLayout.SequentialGroup vParalGroup = layout.createSequentialGroup().addGroup(vParalGroup1).addComponent(jsp);

        layout.setVerticalGroup(vParalGroup);
        
        setContentPane(panel);
		pack();
        setLocationRelativeTo(null);
        setVisible(false);
	}
}

class SelectTable extends JFrame {

    private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel jlDB;
	private JComboBox jcbDB;
	private JLabel jlTable;
	private JComboBox jcbTable;
	private JButton jbtnConn;
    private GroupLayout layout;
	private Menu menu;

	public SelectTable() {
		menu = new Menu();
		initComponents();
		
	}

	private void initComponents() {
        
		setBounds(200, 200, 100, 100);
		setResizable(false);
        setTitle("连接数据库表");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jlDB = new JLabel("数据库名");
		jcbDB = new JComboBox();
		jlTable = new JLabel("表名");
		jcbTable = new JComboBox();
		jbtnConn = new JButton();
		
		jcbDB.addItem("fanmaowei");
		jcbTable.addItem("tb1Score");
		jbtnConn.setText("连接");
		jbtnConn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(null, "连接成功!");
				setVisible(false);
				menu.setVisible(true);
			}
		});

        // layout
		panel = new JPanel();
		layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
        layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

        // horizontal
        GroupLayout.ParallelGroup hParalGroup1 = layout.createParallelGroup().addComponent(jlDB).addComponent(jcbDB);
        GroupLayout.ParallelGroup hParalGroup2 = layout.createParallelGroup().addComponent(jlTable).addComponent(jcbTable);
		GroupLayout.SequentialGroup hSeqGroup = layout.createSequentialGroup().addGroup(hParalGroup1).addGroup(hParalGroup2).addComponent(jbtnConn);
		
		layout.setHorizontalGroup(hSeqGroup);

        // vertical
        GroupLayout.ParallelGroup vParalGroup1 = layout.createParallelGroup().addComponent(jlDB).addComponent(jlTable);
        GroupLayout.ParallelGroup vParalGroup2 = layout.createParallelGroup().addComponent(jcbDB).addComponent(jcbTable).addComponent(jbtnConn);
        GroupLayout.SequentialGroup vSeqGroup = layout.createSequentialGroup().addGroup(vParalGroup1).addGroup(vParalGroup2);

        layout.setVerticalGroup(vSeqGroup);
        
        setContentPane(panel);
		pack();
        setLocationRelativeTo(null);
        setVisible(false);
	}
	
}

class LoginDB extends JFrame {

    private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel jlTitle;
	private JLabel jlAccount;
	private JTextField jtfAccount;
	private JLabel jlPasswd;
	private JTextField jtfPasswd;
	private JButton jbtnLogin;
    private GroupLayout layout;
	private SelectTable st;

	public LoginDB() {
		st = new SelectTable();
		initComponents();
		
	}

	private void initComponents() {
        
		setBounds(200, 200, 100, 100);
		setResizable(false);
        setTitle("login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jlTitle = new JLabel("数据库 登录");
		jlAccount = new JLabel("账户：");
		jtfAccount = new JTextField();
		jlPasswd = new JLabel("密码：");
		jtfPasswd = new JPasswordField();
		jbtnLogin = new JButton();
		
		jlTitle.setFont(new java.awt.Font("Dialog", 1, 15));
		jtfAccount.setColumns(13);
		jtfAccount.setText("fmw");
		// jtfAccount.setEnabled(false);
		jtfAccount.setFocusable(false);
		jtfPasswd.setColumns(13);
		jtfPasswd.requestFocus(); 
		jbtnLogin.setText("登录");
		jbtnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (jtfAccount.getText().equals("fmw") && jtfPasswd.getText().equals("123123")) {
					setVisible(false);
					st.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "账户或者密码错误!\r\n（提示：密码 123123）");
					jtfPasswd.requestFocus(); 
				}
			}
		});

        // layout
		panel = new JPanel();
		layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
        layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

        // horizontal
        GroupLayout.ParallelGroup hParalGroup1 = layout.createParallelGroup().addComponent(jlAccount).addComponent(jlPasswd);
        GroupLayout.ParallelGroup hParalGroup2 = layout.createParallelGroup().addComponent(jtfAccount).addComponent(jtfPasswd);
		GroupLayout.SequentialGroup hSeqGroup = layout.createSequentialGroup().addGroup(hParalGroup1).addGroup(hParalGroup2);
		GroupLayout.ParallelGroup hParalGroup = layout.createParallelGroup().addComponent(jlTitle, GroupLayout.Alignment.CENTER).addGroup(hSeqGroup).addComponent(jbtnLogin, GroupLayout.Alignment.CENTER);

        layout.setHorizontalGroup(hParalGroup);

        // vertical
        GroupLayout.ParallelGroup vParalGroup1 = layout.createParallelGroup().addComponent(jlAccount).addComponent(jtfAccount);
        GroupLayout.ParallelGroup vParalGroup2 = layout.createParallelGroup().addComponent(jlPasswd).addComponent(jtfPasswd);
        GroupLayout.SequentialGroup vSeqGroup = layout.createSequentialGroup().addComponent(jlTitle).addGroup(vParalGroup1).addGroup(vParalGroup2).addComponent(jbtnLogin);

        layout.setVerticalGroup(vSeqGroup);
        
        setContentPane(panel);
		pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
}


/**/
public class Frame {
	public static void main(String[] args) {
		new LoginDB();
	}
}