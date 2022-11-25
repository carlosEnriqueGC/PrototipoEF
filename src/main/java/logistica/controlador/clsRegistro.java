/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.controlador;



/**
 *
 * @author carlos
 */

/*
    private int perid;
    private String pernombre;
    private String perestatus; 
*/
public class clsRegistro {
    int regid;
    int regnombre;
    String regfecha;

    public clsRegistro() {
    }

    public clsRegistro(int codigo) {
        this.regid= codigo;
    }

    public clsRegistro(int nombre, String fecha) {
        this.regnombre = nombre;
        this.regfecha = fecha;
    }

    public int getcodigo() {
        return regid;
    }

    public void setcodigo(int codigo) {
        this.regid = codigo;
    }

    public int getNombre() {
       return regnombre;
    }

    public void setNombre(int nombre) {
        this.regnombre = nombre;
    }

    public String getfecha() {
        return regfecha;
    }

    public void setfecha(String fecha) {
        this.regfecha = fecha;
    }

    @Override
    public String toString() {
        return "tbl_registro{" + "regid=" + regid + ", regnombre=" + regnombre + ", regfecha=" + regfecha + '}';
    }
    
}
