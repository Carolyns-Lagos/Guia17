package cl.accenture.programatufuturo.ejemplo;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hola desde maven");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/negocio","root","Caro61756550.");
            Statement s= conexion.createStatement();
            ResultSet rS= s.executeQuery("select * from clientes");
            while (rS.next()){
                //2Formas para tarer un dato int
                System.out.println(rS.getInt(1));
                //System.out.println(rS.getInt("ID_AUTOR"));

                //2 formas para traer un tipo String
                //System.out.println(rS.getString("ID_AUTOR"));
                //System.out.println(rS.getString(2));
            }
            Statement sentenciaInsert= conexion.createStatement();
            int resultadoInsert=sentenciaInsert.executeUpdate("INSERT INTO clientes (IdCliente, Nombre, Ciudad, Status, IdVendedor )"+"VALUES('3009', 'jose Perez', 'Talca', '100', '5001');");
            System.out.println("coso");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            //System.out.println("El driver requerido no esta cargando");
        }catch (SQLException e){
            e.printStackTrace();
        }


    }


}
