import java.sql.*;

public class JDBCDemo {

   private static final String URL="jdbc:mysql://localhost:3306/demo1_db";   //  isme jo port diye hue hai wo by default
    private static final String USER="root";
    private static final String PASSWORD="MySQL@12345";

    public static void main(String[] args) {

        //try-with-resources for resources managment me automatically work-done hone ke baad closed ho jayega
        try(Connection  conn= DriverManager.getConnection(URL,USER,PASSWORD);){
            System.out.println("Connected the DataBase!");
            inserStudent(conn,"Ravi Singh", "ravi@gmail.com");
            updateStudents(conn,2,"Ravi Kumar", "ravik@gmail.com");
            selectStudents(conn);
            //deletedStudents(conn, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }






        //try catch me boilerplate code with some code then it will large shows huge amouunt of code
//        Connection conn=null;
//        try {
//            conn= DriverManager.getConnection(URL,USER,PASSWORD);
//            System.out.println("Connected to DataBase !");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                conn.close();
//                System.out.println("Connection Closed!");
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }

    }
    private static void inserStudent(Connection conn, String name, String email) throws SQLException {
        String sql="INSERT INTO Students(name, email) VALUES('"+name + "','"+email+"')";
        try(Statement stmt=conn.createStatement()){
            int rows=stmt.executeUpdate(sql);
            System.out.println("INSERTED: "+rows);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void selectStudents(Connection conn){
        String sql="SELECT * FROM students";
        try(Statement stmt=conn.createStatement()){
            ResultSet resultSet=stmt.executeQuery(sql);
            System.out.println("Student List: ");
            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                System.out.println(id+" : "+ name + " : "+email );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Ab update karna student table ko
//    private static void updateStudents(Connection conn,int id, String name, String email){
//        String sql = "UPDATE students SET name = '" + name + "', email = '" + email + "' WHERE id = " + id;
//        //UPDATE students SET name='Ravi Kumar' ,email='ravikumar@gmail.com'
//        //WHERE id=10;
//        try(Statement stmt=conn.createStatement()){
//            int rows=stmt.executeUpdate(sql);
//            System.out.println("UPDATED: "+rows);
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }


    //by using preparedStatements
    private static void updateStudents(Connection conn,int id, String name, String email){
        //String sql = "UPDATE students SET name = '" + name + "', email = '" + email + "' WHERE id = " + id;
        String sql = "UPDATE students SET name =?, email = ? WHERE id =? ";
        //UPDATE students SET name='Ravi Kumar' ,email='ravikumar@gmail.com'
        //WHERE id=10;
        try(PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setInt(3,id);
            int rows=pstmt.executeUpdate();
            System.out.println("UPDATED: "+rows);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static void deletedStudents(Connection conn,int id){
        String sql="DELETE FROM students WHERE id="+id;
        try(Statement stmt=conn.createStatement()){
            int rows=stmt.executeUpdate(sql);
            System.out.println("DELETED: "+rows);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }




}
