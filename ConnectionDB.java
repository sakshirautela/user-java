import java.sql.*;


public class ConnectionDB {
    public static void main(String[] args) {
        String database="trans_histroy";
        String port="3307";
        String host="localhost";
        String username="root";
        String pass="hello";
        String link="jdbc:mysql://"+host+":"+port+"/"+database;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn=DriverManager.getConnection(link,username,pass);
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery("select * from table trans");
            while(rs.next()){
                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getInt(3));
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
