
import java.sql.*;
import java.util.ArrayList;

public class SQLite {

    public static void readAllData() {
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM av";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println("ALL WORDS\n");
            while(rs.next()) {
                String firstName = rs.getString("id");
                String secondName = rs.getString("word");
                String email = rs.getString("html");
                String password = rs.getString("description");
                String pronounce = rs.getString("pronounce");



                System.out.println("fir: "+firstName);
                System.out.println("Second Name: "+secondName);
                System.out.println("Email: "+email);
                System.out.println("Password: "+password+"\n\n");

            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch(SQLException e) {
                System.out.println(e.toString());
            }
        }


    }
    public static String readSpecificRow(String Word) {
        // lets read specific row on the database
        Connection con = DbConnection.connect();
        String html = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "Select html from av where word = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1,Word);
            rs = ps.executeQuery();

            // we are reading one row, so no need to loop
            html = rs.getString("html");

        } catch(SQLException e) {
            System.out.println(e.toString());
        } finally {
            // close connections
            try{
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                // TODO: handle exception
                System.out.println(e.toString());
            }

        }
        return html;

    }
    public static void insert(String word, String description) {
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO av(word, description) VALUES(?,?) ";
            ps = con.prepareStatement(sql);
            ps.setString(1, word);
            ps.setString(2, description);

            ps.execute();
            System.out.println("Data has been inserted!");
        } catch(SQLException e) {
            System.out.println(e.toString());
            // always remember to close database connections
        } finally {
            try{
                ps.close();
                con.close();
            } catch(SQLException e) {
                System.out.println(e.toString());
            }

        }
    }

    public static ArrayList<String> showWordList(String word) {
        ArrayList<String> result = new ArrayList<>();
        String sql = "SELECT word, description FROM av WHERE word LIKE '" + word + "%'";
        try (Connection conn = DbConnection.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                result.add(rs.getString("word"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }



    public static void main(String[] args) throws SQLException {
        // insert("Benson", "Karue", "benson@test.com", "myPassword");
        //readAllData();
        //  insert("Zoro","Thợ săn tiền thưởng");
        showWordList("word");

    }

}

