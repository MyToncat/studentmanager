import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class StudentClass {
    private List<Student> StudentList;
    private int size;
    public StudentClass(){
        size=0;
        StudentList=null;
    }
    public void createclass(List<Student>lst){
        StudentList=lst;
        size=lst.size();

    }

    public void createclass(){
        String name[]={"张三","李四","王五","赵六","孙七"};
        double grade[]={67,78.5,98,76,90.5};
        int age[]={17,18,19,20,21};

        size=name.length;

        StudentList=new ArrayList<>();
        Student temp;

        for(int i=0;i<size;i++){
            temp=new Student(name[i],age[i],grade[i]);
            StudentList.add(temp);
        }

    }

    public void sort(){
        Student temp;
        //
        for (int i=0;i<size;i++){
            for (int j=1;j<size-i;j++){
                if(StudentList.get(j-1).getGrade()>StudentList.get(j).getGrade()){
                    temp=StudentList.get(j-1);
                    StudentList.set(j-1,StudentList.get(j));
                    StudentList.set(j,temp);
                }
            }
        }

    }
    public List<Map<String,String>>formatestudent(){
        List fclass=new ArrayList<Map<String,String>>();
        Map<String,String> stu;
        for(Student s:StudentList){
            stu=new HashMap<String,String>();   //定义，hashmap实现了map；
            stu.put("姓名：",s.getName());
            stu.put("成绩：",new Double(s.getGrade()).toString());
            fclass.add(stu);

        }
        return  fclass;
    }
    public void savaToDB(){
        StudentDAO dao=new StudentDAO();
        for (Student s:StudentList){
            dao.insert(s);
        }
    }

}
