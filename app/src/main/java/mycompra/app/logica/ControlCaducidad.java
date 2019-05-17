package com.example.comprapp.logica;

import com.example.comprapp.dao.CategoriaDAO;
import com.example.comprapp.modelo.Categoria;
import com.example.comprapp.modelo.Producto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControlCaducidad {

    public static int MAX_CAD_DIAS = 2;

    public ControlCaducidad() {}

    public boolean checkCaducidad(Producto prod)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy", Locale.US);

        try {
            Date caducidad = formatter.parse(prod.getCaducidad());

            if (caducidad.)

        }catch (ParseException e) {}
    }
}
