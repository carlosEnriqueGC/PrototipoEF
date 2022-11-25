/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.controlador;

/**
 *
 * @author Byron
 */
public class clsMovimientos {
   
    private int movid;
    private String movfecha;
    private String movestado;
    private int prodcodigo;
    private String prodnombre;
    private int movcantidad;   
    private int lincodigo;
    private String linnombre;
    private int marcodigo;
    private String marnombre;
    private int conid;
    private String connombre;
    private int movtotal;

 


    public clsMovimientos() {
    }

    public clsMovimientos(int sid) {
   
         this.prodcodigo = sid;
    }
     
      public int getMovid() {
        return movid;
    }

    public void setMovid(int mid) {
        this.movid = mid;
    }
    
      public String getMovfecha() {
        return movfecha;
    }

    public void setMovfecha(String Mfecha) {
        this.movfecha = Mfecha;
    }
      public String getMovestado() {
        return movestado;
    }

    public void setMovestado(String mestado) {
        this.movestado = mestado;
    }
    public int getProdcodigo() {
        return prodcodigo;
    }
    public void setProdcodigo(int pnombre) {
        this.prodcodigo = pnombre;
    }
  public String getProdnombre() {
        return prodnombre;
    }
    public void setProdnombre(String pnombre) {
        this.prodnombre = pnombre;
    }
    
    
       public int getMovcantidad() {
        return movcantidad;
    }

    public void setMovcantidad(int mcantidad) {
        this.movcantidad = mcantidad;
    }
    
      public int getLincodigo() {
        return lincodigo;
    }
    public void setLincodigo(int lcodigo) {
        this.lincodigo = lcodigo;
    }
      public String getLinnombre() {
        return linnombre;
    }
    public void setLinnombre(String lnombre) {
        this.linnombre = lnombre;
    }
     public int getMarcodigo() {
        return marcodigo;
    }
    public void setMarcodigo(int mcodigo) {
        this.marcodigo = mcodigo;
    } 
      public String getMarnombre() {
        return marnombre;
    }
    public void setMarnombre(String mnombre) {
        this.marnombre = mnombre;
    }
      public int getConid() {
        return conid;
    }
    public void setConid(int cid) {
        this.conid = cid;
    }
      public String getConnombre() {
        return connombre;
    }
    public void setConnombre(String cnombre) {
        this.connombre = cnombre;
    }
     
       public int getmovtotal() {
        return movtotal;
    }
    public void setmovtotal(int total) {
        this.movtotal = total;
    }
    
    
    }
