package mycompra.app.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

import mycompra.app.dbhelper.DBHelper;
import mycompra.app.modelo.Tag;

public class TagDAO {
    private static DBHelper dbHelper;

    public TagDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Tag tag) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Tag.KEY_Nombre, tag.getNombre());
        values.put(Tag.KEY_ID_Categoria, tag.getIdCategoria());

        long idTag = db.insert(Tag.TABLE, null, values);
        db.close();
        return (int) idTag;
    }

    public void delete(int idTag) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Tag.TABLE, Tag.KEY_ID + "= ?", new String[]{String.valueOf(idTag)});
        db.close();
    }

    public void update(Tag tag) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Tag.KEY_Nombre, tag.getNombre());
        values.put(Tag.KEY_ID_Categoria, tag.getIdCategoria());

        db.update(Tag.TABLE, values, Tag.KEY_ID + "= ?", new String[]{String.valueOf(tag.getId())});
        db.close();
    }

    public Tag getTagById(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Tag.KEY_ID + "," +
                Tag.KEY_Nombre + "," +
                Tag.KEY_ID_Categoria +
                " FROM " + Tag.TABLE
                + " WHERE " +
                Tag.KEY_ID + "=?";

        Tag tag = new Tag();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(id) } );

        if (cursor.moveToFirst()) {
            do {
                tag.setId(cursor.getInt(cursor.getColumnIndex(Tag.KEY_ID)));
                tag.setNombre(cursor.getString(cursor.getColumnIndex(Tag.KEY_Nombre)));
                tag.setIdCategoria(cursor.getInt(cursor.getColumnIndex(Tag.KEY_ID_Categoria)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tag;
    }

    public ArrayList<Tag> getTagList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Tag.KEY_ID + "," +
                Tag.KEY_Nombre + "," +
                Tag.KEY_ID_Categoria +
                " FROM " + Tag.TABLE;

        ArrayList<Tag> tagList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Tag tag = new Tag();
                tag.setId(cursor.getInt(cursor.getColumnIndex(Tag.KEY_ID)));
                tag.setNombre(cursor.getString(cursor.getColumnIndex(Tag.KEY_Nombre)));
                tag.setIdCategoria(cursor.getInt(cursor.getColumnIndex(Tag.KEY_ID_Categoria)));
                tagList.add(tag);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return tagList;
    }
}