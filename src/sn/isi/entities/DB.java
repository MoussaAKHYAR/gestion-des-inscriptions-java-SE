package sn.isi.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {

    private Connection cnx;
    private ResultSet rs;
    private PreparedStatement pstm;
    private int ok;

    private void getConnection(){
        String url = "jdbc:mysql://localhost:3306/examenuser1";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url,user,password);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void initPrepar(String sql){
        try {
            getConnection();
            pstm = cnx.prepareStatement(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ResultSet executeSelect(){
        try {
            rs = pstm.executeQuery();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }

    public int executeMaj(){
        try {
            ok = pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return ok;
    }

    public void closeConnection(){
        try {
            if (cnx != null){
                cnx.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public PreparedStatement getPstm() {
        return pstm;
    }

    public void setPstm(PreparedStatement pstm) {
        this.pstm = pstm;
    }
}
