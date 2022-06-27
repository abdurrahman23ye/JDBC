import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Driver yükle

        Class.forName("com.mysql.jdbc.Driver");

        //baglanti oluştur. Okul database i için

        Connection con=DriverManager.
                getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC","root","1234");

     // statement oluştur (SQL kodlarını yazabileceğimiz bir nesne)

        Statement st=con.createStatement();

      //Resultset

        ResultSet veri= st.executeQuery("Select * from ogrenciler;");

        while (veri.next()){

          //  System.out.println(veri.getInt(1)+veri.getString(2)+
            //        veri.getString(3)+veri.getString(4));

            System.out.println(veri.getInt("okul_no")+" "+veri.getString("ogrenci_ismi")+" "+
                    veri.getString("sinif")+" "+veri.getString("cinsiyet"));

            System.out.printf("%-6d %-15.15s %-8s\n", veri.getInt(1), veri.getString(2), veri.getString(3));

        }

        //kapatma

        con.close();
        st.close();
        veri.close();



    }
}
