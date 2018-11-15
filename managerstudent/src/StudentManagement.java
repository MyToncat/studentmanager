import  java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import  javax.swing.JTextField;

public class StudentManagement {
    private final long serivalVersionUID=1L;

    private JFrame mainFrame;
    private JPanel top;
    private JLabel labelTop;
    private JLabel labelName;
    private JTextField textName;
    private JLabel labelAge;
    private JTextField textAge;
    private JLabel labelGrade;
    private JTextField textGrade;
    private JButton btnAdd;

    private JPanel middle;
    private JLabel labelMiddle;
    private JButton btnShowAll;
    private JButton btnSortAll;
    private JTextArea areaShowAll;
    private JPanel bottom;
    private JLabel labelBottom;
    private JLabel labelQuery;
    private JTextField textQuery;
    private JButton btnQuery;
    private JTextArea areaQuery;
    public StudentManagement(String title){
        mainFrame=new JFrame(title);
    }
    public void run(){
        mainFrame.setBounds(100,100,500,250);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addInput();
        addShowAll();
        addQuery();
        mainFrame.validate();
    }
    private void addInput(){
        top=new JPanel();
        labelTop=new JLabel("录入|");
        labelName=new JLabel("姓名");
        labelAge=new JLabel("年龄");
        labelGrade=new JLabel("成绩");
        textName=new JTextField(10);
        textAge=new JTextField(6);
        textGrade=new JTextField(6);
        btnAdd=new JButton("添加");

         top.add(labelTop);
         top.add(labelName);
         top.add(textName);
         top.add(labelAge);
         top.add(textAge);
         top.add(labelGrade);
         top.add(textGrade);
         top.add(btnAdd);
         mainFrame.add(top,BorderLayout.NORTH);

    }
    private void addShowAll(){
        middle=new JPanel();
        labelMiddle=new JLabel("查看所有| ");
        btnShowAll=new JButton("显示");
        btnSortAll=new JButton("排序");
        areaShowAll=new JTextArea(7,25);

        middle.add(labelMiddle);
        middle.add(btnShowAll);
        middle.add(btnSortAll);
        middle.add(areaShowAll);

        mainFrame.add(middle,BorderLayout.CENTER);
    }
    private void addQuery(){
        bottom =new JPanel();
        labelBottom=new JLabel("查询|");
        labelQuery=new JLabel("姓名:|");
        textQuery=new JTextField(9);
        btnQuery=new JButton("提交");
        areaQuery=new JTextArea(1,20);

        bottom.add(labelBottom);
        bottom.add(labelQuery);
        bottom.add(textQuery);
        bottom.add(btnQuery);
        bottom.add(areaQuery);
        mainFrame.add(bottom,BorderLayout.SOUTH);

    }

}
