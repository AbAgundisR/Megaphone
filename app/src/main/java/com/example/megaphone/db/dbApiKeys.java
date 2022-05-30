package com.example.megaphone.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;


import java.util.ArrayList;

public class dbApiKeys extends dbHelper {

    Context context;

    public dbApiKeys(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarApi(String tipo, String key) {

        long id = 0;

        try {
            dbHelper dbHelper = new dbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", tipo);
            values.put("telefono", key);

            id = db.insert(TABLE_KEYS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

//    public ArrayList<Contactos> mostrarContactos() {
//
//        dbHelper dbHelper = new dbHelper(context);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        ArrayList<Contactos> listaContactos = new ArrayList<>();
//        Contactos contacto;
//        Cursor cursorContactos;
//
//        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_KEYS + " ORDER BY tipo ASC", null);
//
//        if (cursorContactos.moveToFirst()) {
//            do {
//                contacto = new Contactos();
//                contacto.setId(cursorContactos.getInt(0));
//                contacto.setNombre(cursorContactos.getString(1));
//                contacto.setTelefono(cursorContactos.getString(2));
//                contacto.setCorreo_electornico(cursorContactos.getString(3));
//                listaContactos.add(contacto);
//            } while (cursorContactos.moveToNext());
//        }
//
//        cursorContactos.close();
//
//        return listaContactos;
//    }
//
//    public Contactos verContacto(int id) {
//
//        dbHelper dbHelper = new dbHelper(context);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        Contactos contacto = null;
//        Cursor cursorContactos;
//
//        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_KEYS + " WHERE id = " + id + " LIMIT 1", null);
//
//        if (cursorContactos.moveToFirst()) {
//            contacto = new Contactos();
//            contacto.setId(cursorContactos.getInt(0));
//            contacto.setNombre(cursorContactos.getString(1));
//            contacto.setTelefono(cursorContactos.getString(2));
//            contacto.setCorreo_electornico(cursorContactos.getString(3));
//        }
//
//        cursorContactos.close();
//
//        return contacto;
//    }
//
//    public boolean editarContacto(int id, String nombre, String telefono, String correo_electronico) {
//
//        boolean correcto = false;
//
//        dbHelper dbHelper = new dbHelper(context);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        try {
//            db.execSQL("UPDATE " + TABLE_KEYS + " SET nombre = '" + nombre + "', telefono = '" + telefono + "', correo_electronico = '" + correo_electronico + "' WHERE id='" + id + "' ");
//            correcto = true;
//        } catch (Exception ex) {
//            ex.toString();
//            correcto = false;
//        } finally {
//            db.close();
//        }
//
//        return correcto;
//    }
//
//    public boolean eliminarContacto(int id) {
//
//        boolean correcto = false;
//
//        dbHelper dbHelper = new dbHelper(context);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        try {
//            db.execSQL("DELETE FROM " + TABLE_KEYS + " WHERE id = '" + id + "'");
//            correcto = true;
//        } catch (Exception ex) {
//            ex.toString();
//            correcto = false;
//        } finally {
//            db.close();
//        }
//
//        return correcto;
//    }
}
