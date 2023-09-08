package obrador;

import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Obrador {

    public static void main(String[] args) {

        int dn = 0;
        String apellido = "";
        String nombre = "";
        int acceso = 0;
        int estado = 0;
        String descripcion = "";
        int stock = 0;
        int idEmpleado = 0;
        int idHerramienta = 0;
        LocalDate fechap = null;
        LocalDate fechad = null;
        int cantidadRet = 0;

        int opcion = 0;

        JOptionPane.showInputDialog("""
                                 INGRESO DE DATOS
                                 Para agregar un empleado digite((1)
                                 Para agregar una herramienta digite (2)
                                 Para agregar un movimiento digite (3)""");

        Connection con = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/obrador2023", "root", "");

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error de carga de Driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión");
        }

        if (opcion == 1) {

            dn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese DNI"));

            apellido = JOptionPane.showInputDialog("Ingrese Apellido");

            nombre = JOptionPane.showInputDialog("Ingrese Nombre");

            acceso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Acceso"));

            estado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Estado"));

            Empleado e_1 = new Empleado(dn, apellido, nombre, acceso, estado);
            e_1.agregarEmpleado(con);
        } else {

            JOptionPane.showMessageDialog(null, "Opcion inválida");
        }

        //try {
        //Class.forName("org.mariadb.jdbc.Driver");
        //Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/obrador2023", "root", "");
        //-----------incertamos tres empleados-------------------------

        /* String consulta = "INSERT INTO  empleado VALUES (null,30125475,'Juarez', 'Ezequiel', 9, true),(null, 14251478,'Juarez', 'Claudia', 3, true),(null, 23561256,'Martin', 'Ana', 9, true)";

            PreparedStatement st = con.prepareStatement(consulta);
            int cantidad = st.executeUpdate();
            System.out.println("cantidad agregada: " + cantidad);*/
        //-----------------incertamos dos herramientas-----------------
        /*String consulta =  "INSERT INTO herramienta VALUES (null, 'Pinza', 'Pinza de precion', 3, true),(null, 'Tenaza', 'Tenaza grande', 2, true)";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            int agregados = ps.executeUpdate();
            System.out.println("agregado: " + agregados);
            ps.close();*/
        // -----------mostramos las herramientas con stock superiores a 10-------------------------------

        /* String consulta = "SELECT * FROM herramienta WHERE stock > 10";
            
            PreparedStatement ps = con.prepareStatement(consulta);
            
            ResultSet respuesta = ps.executeQuery();
            
            while(respuesta.next()){
                
                System.out.println("Nombre: "+respuesta.getNString("nombre") + ", Descripcion: "+ respuesta.getNString("Descripcion")+", Stock: "+respuesta.getInt("Stock"));
                
            }*/
        // ---------------------eliminamos el primer empleado de la tabla cambiando su estado a 0 ( no usando DELETE)--------------           
        //String consulta = "UPDATE empleado SET estado = 0 WHERE idEmpleado = 1 " ;
        //PreparedStatement ps = con.prepareStatement(consulta);
        //int eliminado = ps.executeUpdate();
        // ps.close();
        //System.out.println("eliminados: " + eliminado);
        //} catch (ClassNotFoundException ex) {
        //JOptionPane.showMessageDialog(null, "Error de carga de Driver");
        //} catch (SQLException ex) {
        //JOptionPane.showMessageDialog(null, "Error de carga de Driver" + ex.getMessage());
        //}
    }

}
