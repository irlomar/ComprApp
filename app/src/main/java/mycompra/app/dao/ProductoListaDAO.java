package mycompra.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

import mycompra.app.dbhelper.DBHelper;
import mycompra.app.modelo.ProductoLista;

public class ProductoListaDAO {

    private static DBHelper dbHelper;

    public ProductoListaDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(ProductoLista productoLista) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ProductoLista.KEY_ID_Producto, productoLista.getIdProducto());
        values.put(ProductoLista.KEY_ID_Lista, productoLista.getIdLista());

        long idProductoLista = db.insert(ProductoLista.TABLE, null, values);
        db.close();
        return (int) idProductoLista;
    }

    public void delete(int idProductoLista) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(ProductoLista.TABLE, ProductoLista.KEY_ID_Producto + "= ?", new String[]{String.valueOf(idProductoLista)});
        db.close();
    }

    public void update(ProductoLista productoLista) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ProductoLista.KEY_ID_Producto, productoLista.getIdProducto());
        values.put(ProductoLista.KEY_ID_Lista, productoLista.getIdLista());

        db.update(ProductoLista.TABLE, values, ProductoLista.KEY_ID_Producto + "= ?", new String[]{String.valueOf(productoLista.getIdProducto())});
        db.close();
    }

    public ProductoLista getProductoListaById(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                ProductoLista.KEY_ID_Producto + "," +
                ProductoLista.KEY_ID_Lista +
                " FROM " + ProductoLista.TABLE
                + " WHERE " +
                ProductoLista.KEY_ID_Producto + "=?";

        ProductoLista productoLista = new ProductoLista();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(id) } );

        if (cursor.moveToFirst()) {
            do {
                productoLista.setIdProducto(cursor.getInt(cursor.getColumnIndex(ProductoLista.KEY_ID_Producto)));
                productoLista.setIdLista(cursor.getInt(cursor.getColumnIndex(ProductoLista.KEY_ID_Lista)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return productoLista;
    }

    public ArrayList<ProductoLista> getProductoListaList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                ProductoLista.KEY_ID_Producto + "," +
                ProductoLista.KEY_ID_Lista +
                " FROM " + ProductoLista.TABLE;

        ArrayList<ProductoLista> productoListaList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ProductoLista productoLista = new ProductoLista();
                productoLista.setIdProducto(cursor.getInt(cursor.getColumnIndex(ProductoLista.KEY_ID_Producto)));
                productoLista.setIdLista(cursor.getInt(cursor.getColumnIndex(ProductoLista.KEY_ID_Lista)));
                productoListaList.add(productoLista);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return productoListaList;
    }
}
