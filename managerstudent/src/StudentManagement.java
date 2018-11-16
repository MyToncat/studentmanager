import  java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import  javax.swing.JTextField;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;

public class StudentManagement implements ActionListener {
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
        setAction();//启动监听
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
    private void setAction(){
        btnAdd.addActionListener(this);
        btnShowAll.addActionListener(this);
        btnSortAll.addActionListener(this);
        btnQuery.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
        String inputText=e.getActionCommand();
        if(inputText.equals("添加")){
            addStudent();
        }
        else if (inputText.equals("排序")){
            sortAll();
        }else if(inputText.equals("提交")){
            queryStudent();
        }
        else if(inputText.equals("显示")){
            displayAll();
        }else{
            showError("error");
        }

    }
    //-----------------------------------------
    //---功能实现------
    private void addStudent(){
        String name;
        int age;
        double grade;
        try{
            name=textName.getText();
            age=Integer.parseInt(textAge.getText());
            grade=Double.parseDouble(textGrade.getText());
        }catch (NumberFormatException e){
            showError("输入有错误！");
            return;
        }
        Student student=new Student(name,age,grade);
        StudentDAO sd=new StudentDAO();
        if(sd.insert(student)){
            showMsg("添加成功！");
           displayAll();
        }else{
            showError("添加错误！");
        }
    }

    private void displayAll(){
        StudentDAO sd=new StudentDAO();
        //从数据库中获取信息
        StudentClass xg=sd.getStudentClass();
        //格式化显示
        String content=DisplayUtils.display(xg.formatestudent());
        //显示内容
        areaShowAll.setText(content);

    }
    private void sortAll(){
        StudentDAO sd=new StudentDAO();
        //从数据库获取数据，
        StudentClass xg=sd.getStudentClass();
        //排序
        xg.sort();
        //格式化输出
        String content=DisplayUtils.display(xg.formatestudent());
        areaShowAll.setText(content);

    }

    private void queryStudent(){
        //创建对象，从文本输入框取出名字
        String name=textQuery.getText();
        StudentDAO sd=new StudentDAO();
        //
        Student student=sd.getByName(name);
        if(name!=null&&name.length()>0){
            String cotent=showStudent(student);
            areaQuery.setText(cotent);
        }else{
            showError("error!");
        }
    }
    private String showStudent(Student student){
        String result;
        if(student!=null){
            result="姓名"+student.getName()+"\t成绩"+student.getGrade();
        }
        else{
            result="学生不存在！";
        }
       return result;
    }
    private void showError(String errorMsg){
        String dialogTitle="学生成绩管理";
        JOptionPane.showMessageDialog(mainFrame,errorMsg,dialogTitle,JOptionPane.WARNING_MESSAGE);

    }
    private void showMsg(String msg){
        String dialogTitle="学生成绩管理";
        JOptionPane.showMessageDialog(mainFrame,msg,dialogTitle,JOptionPane.INFORMATION_MESSAGE);

    }
}
