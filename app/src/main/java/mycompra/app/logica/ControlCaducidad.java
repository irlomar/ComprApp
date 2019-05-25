package mycompra.app.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import mycompra.app.modelo.Producto;

public class ControlCaducidad {

    public static int MAX_CAD_DIAS = 2;

    public ControlCaducidad() {}

    /*public boolean checkCaducidad(Producto prod)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        try {
            Date caducidad = formatter.parse(prod.getCaducidad());

            //if (caducidad.)

        }catch (ParseException e) {}
        return false;
    }*/
}
