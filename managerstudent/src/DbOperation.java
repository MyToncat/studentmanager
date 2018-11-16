import java.util.List;
import java.util.ArrayList;
import  java.sql.Connection;
import  java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;

public class DbOperation {
    public DbOperation(){

    }
    public Connection getConnection()throws ClassNotFoundException,SQLException{
        String sDBDriver="com.mysql.jdbc.Driver";
        String conStr="jdbc:mysql://localhost:3306/my?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
        String username="root";
        String password="131569";
        Class.forName(sDBDriver);
        Connection conn=DriverManager.getConnection(conStr,username,password);
        return conn;
    }
    public List<Student>getAll(Connection conn,String sql){
        List<Student>result=new ArrayList<Student>();
        Student temp;
        String name;
        int age;
        double grade;
        try{
            //返回数据
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                name=rs.getString("name");
                age=rs.getInt("age");
                grade=rs.getDouble("grade");
                temp=new Student(name,age,grade);
                result.add(temp);
            }

        }catch(SQLException e){
            System.out.println(e);
        }

        return  result;
    }

    public void update(Connection conn,String sql)throws SQLException{
        Statement st=conn.createStatement();
        st.executeUpdate(sql);
        st.close();
    }
    public void close(Connection conn)throws SQLException{
        conn.close();
    }
}
