package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student_detail {
    private Connection conn = null;
    private String rno, batch, dep, address;
    public String name;

    public Student_detail(String name1, String rn, String b, String d, String add) {
        name = name1;
        rno = rn;
        batch = b;
        dep = d;
        address = add;
    }

    public Student_detail() {

    }

    private void connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/sample", "root", "");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public int add_detail() {
        try {
            connection();
            String querry = "VALUES(?,?,?,?,?) ";
            String query1 = "INSERT INTO student " + "(regid,name,batch,dep,address)" + querry;
            PreparedStatement mystmt = conn.prepareStatement(query1);
            mystmt.setString(1, rno);
            mystmt.setString(2, name);
            mystmt.setString(3, batch);
            mystmt.setString(4, dep);
            mystmt.setString(5, address);
            mystmt.execute();
            conn.close();
            return (1);
        } catch (Exception e) {
            return (0);
        }
    }

    public int check(String id) {
        try {
            connection();
            rno = id;
            PreparedStatement stmt = conn.prepareStatement("SELECT Name FROM Student WHERE regid=?");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                name = rs.getString("Name");
                return (1);
            } else
                return (0);
        } catch (Exception e) {
            return (0);
        }
    }

    public int update(String add) {
        try {
            connection();
            System.out.println(rno);
            PreparedStatement stmt = conn.prepareStatement("UPDATE Student SET `address`=? WHERE regid=?");
            stmt.setString(1, add);
            stmt.setString(2, rno);
            System.out.println(add);
            stmt.executeUpdate();
            return (1);
        } catch (Exception e) {
            return (0);
        }
    }

    public int deleted(String id) {
        try {
            connection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Student WHERE regid=?");
            stmt.setString(1, id);
            stmt.execute();
            return (1);
        } catch (Exception e) {
            return (0);
        }
    }
}
