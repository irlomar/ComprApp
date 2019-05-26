package mycompra.app.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mycompra.app.modelo.Categoria;
import mycompra.app.modelo.Inventario;
import mycompra.app.modelo.Lista;
import mycompra.app.modelo.Mes;
import mycompra.app.modelo.Producto;
import mycompra.app.modelo.ProductoLista;
import mycompra.app.modelo.ProductoTicket;
import mycompra.app.modelo.Supermercado;
import mycompra.app.modelo.Ticket;


public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Comprapp.db";

    public DBHelper(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE_CATEGORIA = "CREATE TABLE " + Categoria.TABLE + "("
                + Categoria.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Categoria.KEY_Nombre + " TEXT ,"
                + Categoria.KEY_ID_Inventario + " INTEGER ,"
                + " FOREIGN KEY(" + Categoria.KEY_ID_Inventario + ") REFERENCES " + Inventario.TABLE + "(" + Inventario.KEY_ID + ") ON UPDATE CASCADE ON DELETE CASCADE)";
        sqLiteDatabase.execSQL(CREATE_TABLE_CATEGORIA);

        String CREATE_TABLE_INVENTARIO = "CREATE TABLE " + Inventario.TABLE + "("
                + Inventario.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Inventario.KEY_Nombre + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE_INVENTARIO);

        String CREATE_TABLE_LISTA = "CREATE TABLE " + Lista.TABLE + "("
                + Lista.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Lista.KEY_Nombre + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE_LISTA);

        String CREATE_TABLE_SUPERMERCADO = "CREATE TABLE " + Supermercado.TABLE + "("
                + Supermercado.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Supermercado.KEY_Nombre + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE_SUPERMERCADO);

        String CREATE_TABLE_MES = "CREATE TABLE " + Mes.TABLE + "("
                + Mes.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Mes.KEY_Nombre + " TEXT ,"
                + Mes.KEY_Anyo + " INTEGER ,"
                + Mes.KEY_Presupuesto + " REAL)";
        sqLiteDatabase.execSQL(CREATE_TABLE_MES);

        String CREATE_TABLE_TICKET = "CREATE TABLE " + Ticket.TABLE + "("
                + Ticket.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Ticket.KEY_Precio + " REAL ,"
                + Ticket.KEY_Fecha + " TEXT ,"
                + Ticket.KEY_ID_Mes + " INTEGER ,"
                + Ticket.KEY_ID_Supermercado + " INTEGER ,"
                + " FOREIGN KEY(" + Ticket.KEY_ID_Mes + ") REFERENCES " + Mes.TABLE + "(" + Mes.KEY_ID + ") ON UPDATE CASCADE ON DELETE CASCADE, "
                + " FOREIGN KEY(" + Ticket.KEY_ID_Supermercado + ") REFERENCES " + Supermercado.TABLE + "(" + Supermercado.KEY_ID + ") ON UPDATE CASCADE ON DELETE CASCADE)";
        sqLiteDatabase.execSQL(CREATE_TABLE_TICKET);

        String CREATE_TABLE_PRODUCTO = "CREATE TABLE " + Producto.TABLE + "("
                + Producto.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Producto.KEY_Nombre + " TEXT ,"
                + Producto.KEY_Precio + " REAL ,"
                + Producto.KEY_Caducidad + " TEXT ,"
                + Producto.KEY_Cantidad + " INTEGER ,"
                + Producto.KEY_ID_Categoria + " INTEGER ,"
                + Producto.KEY_ID_Inventario + " INTEGER ,"
                + " FOREIGN KEY(" + Producto.KEY_ID_Categoria + ") REFERENCES " + Categoria.TABLE + "(" + Categoria.KEY_ID + ") ON UPDATE CASCADE ON DELETE CASCADE, "
                + " FOREIGN KEY(" + Producto.KEY_ID_Inventario + ") REFERENCES " + Inventario.TABLE + "(" + Inventario.KEY_ID + ") ON UPDATE CASCADE ON DELETE CASCADE)";
        sqLiteDatabase.execSQL(CREATE_TABLE_PRODUCTO);

        String CREATE_TABLE_PRODUCTO_LISTA = "CREATE TABLE " + ProductoLista.TABLE + "("
                + ProductoLista.KEY_ID_Producto + " INTEGER ,"
                + ProductoLista.KEY_ID_Lista + " INTEGER ,"
                + " PRIMARY KEY (" + ProductoLista.KEY_ID_Producto + "," + ProductoLista.KEY_ID_Lista + "), "
                + " FOREIGN KEY (" + ProductoLista.KEY_ID_Producto + ") REFERENCES " + Producto.TABLE + "(" + Producto.KEY_ID + ") ON UPDATE CASCADE ON DELETE CASCADE, "
                + " FOREIGN KEY (" + ProductoLista.KEY_ID_Lista + ") REFERENCES " + Lista.TABLE + "(" + Lista.KEY_ID + ") ON UPDATE CASCADE ON DELETE CASCADE)";
        sqLiteDatabase.execSQL(CREATE_TABLE_PRODUCTO_LISTA);

        String CREATE_TABLE_PRODUCTO_TICKET = "CREATE TABLE " + ProductoTicket.TABLE + "("
                + ProductoTicket.KEY_ID_Producto + " INTEGER ,"
                + ProductoTicket.KEY_ID_Ticket + " INTEGER ,"
                + ProductoTicket.KEY_Cantidad + " INTEGER ,"
                + " PRIMARY KEY (" + ProductoTicket.KEY_ID_Producto + "," + ProductoTicket.KEY_ID_Ticket + "), "
                + " FOREIGN KEY (" + ProductoTicket.KEY_ID_Producto + ") REFERENCES " + Producto.TABLE + "(" + Producto.KEY_ID + ") ON UPDATE CASCADE ON DELETE CASCADE, "
                + " FOREIGN KEY (" + ProductoTicket.KEY_ID_Ticket + ") REFERENCES " + Ticket.TABLE + "(" + Ticket.KEY_ID + ") ON UPDATE CASCADE ON DELETE CASCADE)";
        sqLiteDatabase.execSQL(CREATE_TABLE_PRODUCTO_TICKET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Categoria.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Inventario.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Lista.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Mes.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Supermercado.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Ticket.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Producto.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProductoLista.TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProductoTicket.TABLE);

        onCreate(sqLiteDatabase);
    }
}
