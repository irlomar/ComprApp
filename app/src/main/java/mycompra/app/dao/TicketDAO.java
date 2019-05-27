package mycompra.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

import mycompra.app.dbhelper.DBHelper;
import mycompra.app.modelo.Ticket;

public class TicketDAO {

    private static DBHelper dbHelper;

    public TicketDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Ticket ticket) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Ticket.KEY_Precio, ticket.getPrecio());
        values.put(Ticket.KEY_Fecha, ticket.getFecha());
        values.put(Ticket.KEY_ID_Supermercado, ticket.getIdSupermercado());
        values.put(Ticket.KEY_ID_Mes, ticket.getIdMes());

        long idTicket = db.insert(Ticket.TABLE, null, values);
        db.close();
        return (int) idTicket;
    }

    public void delete(int idTicket) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Ticket.TABLE, Ticket.KEY_ID + "= ?", new String[]{String.valueOf(idTicket)});
        db.close();
    }

    public void update(Ticket ticket) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Ticket.KEY_Precio, ticket.getPrecio());
        values.put(Ticket.KEY_Fecha, ticket.getFecha());
        values.put(Ticket.KEY_ID_Supermercado, ticket.getIdSupermercado());
        values.put(Ticket.KEY_ID_Mes, ticket.getIdMes());

        db.update(Ticket.TABLE, values, Ticket.KEY_ID + "= ?", new String[]{String.valueOf(ticket.getId())});
        db.close();
    }

    public Ticket getTicketById(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Ticket.KEY_ID + "," +
                Ticket.KEY_Precio + "," +
                Ticket.KEY_Fecha + "," +
                Ticket.KEY_ID_Supermercado + "," +
                Ticket.KEY_ID_Mes +
                " FROM " + Ticket.TABLE
                + " WHERE " +
                Ticket.KEY_ID + "=?";

        Ticket ticket = new Ticket();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(id) } );

        if (cursor.moveToFirst()) {
            do {
                ticket.setId(cursor.getInt(cursor.getColumnIndex(Ticket.KEY_ID)));
                ticket.setPrecio(cursor.getDouble(cursor.getColumnIndex(Ticket.KEY_Precio)));
                ticket.setFecha(cursor.getString(cursor.getColumnIndex(Ticket.KEY_Fecha)));
                ticket.setIdSupermercado(cursor.getInt(cursor.getColumnIndex(Ticket.KEY_ID_Supermercado)));
                ticket.setIdMes(cursor.getInt(cursor.getColumnIndex(Ticket.KEY_ID_Mes)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ticket;
    }

    public ArrayList<Ticket> getTicketList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Ticket.KEY_ID + "," +
                Ticket.KEY_Precio + "," +
                Ticket.KEY_Fecha + "," +
                Ticket.KEY_ID_Supermercado + "," +
                Ticket.KEY_ID_Mes +
                " FROM " + Ticket.TABLE;

        ArrayList<Ticket> ticketList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Ticket ticket = new Ticket();
                ticket.setId(cursor.getInt(cursor.getColumnIndex(Ticket.KEY_ID)));
                ticket.setPrecio(cursor.getDouble(cursor.getColumnIndex(Ticket.KEY_Precio)));
                ticket.setFecha(cursor.getString(cursor.getColumnIndex(Ticket.KEY_Fecha)));
                ticket.setIdSupermercado(cursor.getInt(cursor.getColumnIndex(Ticket.KEY_ID_Supermercado)));
                ticket.setIdMes(cursor.getInt(cursor.getColumnIndex(Ticket.KEY_ID_Mes)));
                ticketList.add(ticket);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return ticketList;
    }

    public Ticket getLastTicket(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Ticket.KEY_ID + "," +
                Ticket.KEY_Precio + "," +
                Ticket.KEY_Fecha + "," +
                Ticket.KEY_ID_Supermercado + "," +
                Ticket.KEY_ID_Mes +
                " FROM " + Ticket.TABLE
                + " ORDER BY " + Ticket.KEY_ID + " DESC LIMIT 1";

        Ticket ticket = new Ticket();

        Cursor cursor = db.rawQuery(selectQuery, null );

        if (cursor.moveToFirst()) {
            do {
                ticket.setId(cursor.getInt(cursor.getColumnIndex(Ticket.KEY_ID)));
                ticket.setPrecio(cursor.getDouble(cursor.getColumnIndex(Ticket.KEY_Precio)));
                ticket.setFecha(cursor.getString(cursor.getColumnIndex(Ticket.KEY_Fecha)));
                ticket.setIdSupermercado(cursor.getInt(cursor.getColumnIndex(Ticket.KEY_ID_Supermercado)));
                ticket.setIdMes(cursor.getInt(cursor.getColumnIndex(Ticket.KEY_ID_Mes)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return ticket;
    }
}
