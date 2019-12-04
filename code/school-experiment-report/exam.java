import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;



public class exam extends JFrame {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel panel;
    private JLabel fileName;
	private JScrollPane js;
	private JButton jbtnOpen;
	private JButton jbtnRun;
	private JTextArea jtaContent;
    private JTextField jtfFileName;
    private JLabel addResult;
    private GroupLayout layout;

    private JFileChooser jfcFile;

    
	public exam() {
		initComponents();
		jfcFile = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("text", "txt", "ini");
		jfcFile.setFileFilter(filter);
	}

	private void initComponents() {
        
		setBounds(100, 100, 100, 100);
        setTitle("fmw");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

		fileName = new JLabel();
		jtfFileName = new JTextField();
		jbtnOpen = new JButton();
		js = new JScrollPane();
		jtaContent = new JTextArea();
        jbtnRun = new JButton();
        addResult = new JLabel("sum:");

		fileName.setText("\u6587\u4ef6\uff1a");
		jtfFileName.setColumns(15);

		jbtnOpen.setText("\u6253\u5f00");
		jbtnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jbtnOpenActionPerformed(evt);
			}
		});

		jtaContent.setColumns(15);
		jtaContent.setRows(10);
		js.setViewportView(jtaContent);

		jbtnRun.setText("求和");
		jbtnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jbtnRunActionPerformed(evt);
			}
		});
		

        // layout
		panel = new JPanel();
		layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
        layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

        // horizontal
        GroupLayout.ParallelGroup hParalGroup1 = layout.createParallelGroup().addComponent(fileName).addComponent(addResult);
        GroupLayout.ParallelGroup hParalGroup2 = layout.createParallelGroup().addComponent(jbtnOpen).addComponent(jbtnRun);
        GroupLayout.SequentialGroup hSeqGroup = layout.createSequentialGroup().addGroup(hParalGroup1).addComponent(jtfFileName).addGroup(hParalGroup2);
        GroupLayout.ParallelGroup hParalGroup3 = layout.createParallelGroup().addGroup(hSeqGroup).addComponent(js);

        layout.setHorizontalGroup(hParalGroup3);

        // vertical
        GroupLayout.ParallelGroup vParalGroup1 = layout.createParallelGroup().addComponent(fileName).addComponent(jtfFileName).addComponent(jbtnOpen);
        GroupLayout.ParallelGroup vParalGroup2 = layout.createParallelGroup().addComponent(addResult).addComponent(jbtnRun);
        GroupLayout.SequentialGroup vParalGroup = layout.createSequentialGroup().addGroup(vParalGroup1).addComponent(js).addGroup(vParalGroup2);

        layout.setVerticalGroup(vParalGroup);
        
        setContentPane(panel);
		pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	private void jbtnRunActionPerformed(java.awt.event.ActionEvent evt) {
		try {	
			int res = 0;
			String strContent=jtaContent.getText();
			String nums[];
			nums = strContent.split("\n");
			for (String num : nums) {
				res += Integer.parseInt(num);
			}
			addResult.setText("sum: " + res);
		} catch(Exception ex){
			JOptionPane.showMessageDialog(null, "文件内容读取失败!"); 
		} 
	}

	private void jbtnOpenActionPerformed(ActionEvent evt) {
		try
		{
			if(jfcFile.showOpenDialog(this)!=JFileChooser.APPROVE_OPTION)
			{
				return;
			}
			String strFileName=jfcFile.getSelectedFile().getAbsolutePath();
			BufferedReader in = new BufferedReader(new FileReader(strFileName));
			String strLine = in.readLine(); 
			String strContent="";
			boolean IsFirst=true;
			while(strLine != null ) {
				if(!IsFirst)
				{
					strContent+="\n";
				}
				strContent+=strLine;
				IsFirst=false;
				strLine = in.readLine();
			}
	        in.close();
	        jtfFileName.setText(strFileName);
	        jtaContent.setText(strContent);
	        
		}catch(Exception ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		} 
	}
    
	public static void main(String[] args) {
		new exam();
	}
}