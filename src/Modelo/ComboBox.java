
package Modelo;


public class ComboBox {
    private int idLinea;
    private String colorEstacion;

    public ComboBox() {
    }
    
    
    public ComboBox(int idLinea, String colorEstacion){
        this.idLinea = idLinea;
        this.colorEstacion = colorEstacion;
    }

    public int getIdLinea() {
        return idLinea;
    }

    public String getColorEstacion() {
        return colorEstacion;
    }

    
    
    @Override
    public String toString(){
        return colorEstacion;
    }
}
