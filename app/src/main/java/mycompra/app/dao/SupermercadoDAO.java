package mycompra.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

import mycompra.app.dbhelper.DBHelper;
import mycompra.app.modelo.Supermercado;

public class SupermercadoDAO {

    private static DBHelper dbHelper;

    public SupermercadoDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Supermercado supermercado) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Supermercado.KEY_Nombre, supermercado.getNombre());

        long idSupermercado = db.insert(Supermercado.TABLE, null, values);
        db.close();
        return (int) idSupermercado;
    }

    public void delete(int idSupermercado) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Supermercado.TABLE, Supermercado.KEY_ID + "= ?", new String[]{String.valueOf(idSupermercado)});
        db.close();
    }

    public void update(Supermercado supermercado) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Supermercado.KEY_Nombre, supermercado.getNombre());

        db.update(Supermercado.TABLE, values, Supermercado.KEY_ID + "= ?", new String[]{String.valueOf(supermercado.getId())});
        db.close();
    }

    public Supermercado getSupermercadoById(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Supermercado.KEY_ID + "," +
                Supermercado.KEY_Nombre +
                " FROM " + Supermercado.TABLE
                + " WHERE " +
                Supermercado.KEY_ID + "=?";

        Supermercado supermercado = new Supermercado();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(id) } );

        if (cursor.moveToFirst()) {
            do {
                supermercado.setId(cursor.getInt(cursor.getColumnIndex(Supermercado.KEY_ID)));
                supermercado.setNombre(cursor.getString(cursor.getColumnIndex(Supermercado.KEY_Nombre)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return supermercado;
    }

    public ArrayList<Supermercado> getSupermercadoList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Supermercado.KEY_ID + "," +
                Supermercado.KEY_Nombre +
                " FROM " + Supermercado.TABLE;

        ArrayList<Supermercado> supermercadoList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Supermercado supermercado = new Supermercado();
                supermercado.setId(cursor.getInt(cursor.getColumnIndex(Supermercado.KEY_ID)));
                supermercado.setNombre(cursor.getString(cursor.getColumnIndex(Supermercado.KEY_Nombre)));
                supermercadoList.add(supermercado);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return supermercadoList;
    }
}
