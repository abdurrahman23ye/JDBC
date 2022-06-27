import java.sql.*;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.jdbc.Driver");



        Connection con=DriverManager.
                getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC","root","1234");



        Statement st=con.createStatement();



       //herşey
       // ResultSet veri= st.executeQuery("Select * from bolumler");

        //satış ve muhasebedeki isim ve maas, maas ters sıralı

        ResultSet veri= st.executeQuery("select personel_isim, maas from bolumler right join personel on bolumler.bolum_id=personel.bolum_id where bolum_isim in('satis','maas') order by maas desc;");

        while (veri.next()){


            System.out.printf("%-6s %-6s  \n", veri.getString("personel_isim"),
                    veri.getString("maas"));



        }

        //kapatma

        con.close();
        st.close();
        veri.close();



    }
}
