package mycompra.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;

import mycompra.app.dbhelper.DBHelper;
import mycompra.app.modelo.Categoria;

public class CategoriaDAO {

    private static DBHelper dbHelper;

    public CategoriaDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Categoria categoria) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Categoria.KEY_Nombre, categoria.getNombre());

        long idCategoria = db.insert(Categoria.TABLE, null, values);
        db.close();
        return (int) idCategoria;
    }

    public void delete(int idCategoria) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Categoria.TABLE, Categoria.KEY_ID + "= ?", new String[]{String.valueOf(idCategoria)});
        db.close();
    }

    public void update(Categoria categoria) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Categoria.KEY_Nombre, categoria.getNombre());

        db.update(Categoria.TABLE, values, Categoria.KEY_ID + "= ?", new String[]{String.valueOf(categoria.getId())});
        db.close();
    }

    public Categoria getCategoriaById(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Categoria.KEY_ID + "," +
                Categoria.KEY_Nombre +
                " FROM " + Categoria.TABLE
                + " WHERE " +
                Categoria.KEY_ID + "=?";

        Categoria categoria = new Categoria();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(id) } );

        if (cursor.moveToFirst()) {
            do {
                categoria.setId(cursor.getInt(cursor.getColumnIndex(Categoria.KEY_ID)));
                categoria.setNombre(cursor.getString(cursor.getColumnIndex(Categoria.KEY_Nombre)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return categoria;
    }

    public ArrayList<Categoria> getCategoriaList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Categoria.KEY_ID + "," +
                Categoria.KEY_Nombre +
                " FROM " + Categoria.TABLE;

        ArrayList<Categoria> categoriaList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Categoria categoria = new Categoria();
                categoria.setId(cursor.getInt(cursor.getColumnIndex(Categoria.KEY_ID)));
                categoria.setNombre(cursor.getString(cursor.getColumnIndex(Categoria.KEY_Nombre)));
                categoriaList.add(categoria);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return categoriaList;
    }
}
