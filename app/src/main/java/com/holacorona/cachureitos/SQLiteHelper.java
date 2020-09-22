package com.holacorona.cachureitos;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String NOMBRE_DB = "basededatos";
    public static final int VERSION_DB = 2;

    public static final String INGRESO_DATOS = "create table crearcuenta (rut text primary key, nombre text, " +
            "apellidos text, correo text, telefono integer, region text, ciudad text, contrasena text, confirmacion text)";

    public static final String ARTICULOS = "create table ingreso (id_articulo integer primary key autoincrement, titulo text, categoría text, descripcion text)";

    public SQLiteHelper(@Nullable Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }
    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(INGRESO_DATOS);
        db.execSQL(ARTICULOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists crearcuenta");
        db.execSQL(INGRESO_DATOS);
        db.execSQL("drop table if exists ingreso");
        db.execSQL(ARTICULOS);
    }
    public Cursor Consulta (String rut_usu, String contraa) throws SQLiteException {
        Cursor mCursor = null;
        mCursor=this.getReadableDatabase().query("crearcuenta", new String[]{"rut","nombre", "apellidos", "correo", "telefono", "region", "ciudad", "contrasena", "confirmacion"}, "rut like '"+rut_usu+"' and contrasena like '"+contraa+"'", null, null, null, null);
        return  mCursor;
    }

    public Cursor consu (String noombre) throws SQLException{
        Cursor eCursor = null;
        eCursor = this.getReadableDatabase().query("crearcuenta", new String[]{"rut", "nombre", "apellidos","correo", "telefono","region" , "ciudad", "contrasena", "confirmacion"}, "nombre like '"+noombre+"'", null, null, null, null);
        return eCursor;
    }

    public void EliminarCuenta (String rut) throws SQLiteException{
        SQLiteDatabase db = getWritableDatabase();
        if (db!=null){
            db.execSQL("Delete from crearcuenta where rut='"+rut+"'");
            db.close();
        }
    }

}
