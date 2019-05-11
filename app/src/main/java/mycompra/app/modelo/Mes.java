package mycompra.app.modelo;

public class Mes {

    public static final String TABLE = "Mes";

    public static final String KEY_ID = "id";
    public static final String KEY_Nombre = "nombre";
    public static final String KEY_Anyo = "anyo";
    public static final String KEY_Presupuesto = "presupuesto";

    private int id;
    private String nombre;
    private int anyo;
    private double presupuesto;

    public Mes(){
    }

    public Mes(int id, String nombre, int anyo, double presupuesto){
        this.id = id;
        this.nombre = nombre;
        this.anyo = anyo;
        this.presupuesto = presupuesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
}
