package obrador;

import javax.swing.JOptionPane;
import java.sql.*;


public class Empleado {

   
    private int dni;
    private String apellido;
    private String nombre;
    private int acceso;
    private int estado;

    public Empleado(int dni, String apellido, String nombre, int acceso, int estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.acceso = acceso;
        this.estado = estado;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAcceso() {
        return acceso;
    }

    public void setAcceso(int acceso) {
        this.acceso = acceso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    public void agregarEmpleado(Connection c){
        
  
        
        try {
           
            
            String consulta = "INSERT INTO empleado VALUES (null, '" + dni+ "', '"+apellido+"', '"+nombre+"', '"+acceso+"', '"+estado+"')";
            

            PreparedStatement ps = c.prepareStatement(consulta);
            
            int agregado = ps.executeUpdate();
            System.out.println("agregado : "+ agregado);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conección"+ ex.getMessage());
        }
    }

}
