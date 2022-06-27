import java.sql.*;

public class Query02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.jdbc.Driver");



        Connection con=DriverManager.
                getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC","root","1234");



        Statement st=con.createStatement();

        // Soru Ogrenciler tablosundan erkek öğrencilerin bilgilerini getiriniz.

      //

       // ResultSet veri= st.executeQuery("Select * from ogrenciler where cinsiyet='E';");
        ResultSet veri= st.executeQuery("Select * from ogrenciler where cinsiyet='k'and sinif=9;");

        while (veri.next()){
            /*System.out.println(veri.getInt("okul_no")+" "+veri.getString("ogrenci_ismi")+
                    " "+
                    veri.getString("sinif")+" "+veri.getString("cinsiyet"));

             */

            System.out.printf("%-6d %-15.15s %-8s  %-8s\n", veri.getInt("okul_no"),
                    veri.getString("ogrenci_ismi"), veri.getString("sinif"),
                    veri.getString("cinsiyet"));

        }

        //kapatma

        con.close();
        st.close();
        veri.close();



    }
}
