package com.example.laboratorio4;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Estudiante  implements Parcelable {
    public String CUI;
    public String Nombres;
    public String Apellidos;

    public Estudiante(String CUI, String nombres, String apellidos) {
        this.CUI = CUI;
        Nombres = nombres;
        Apellidos = apellidos;
    }

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(CUI);
        dest.writeString(Nombres);
        dest.writeString(Apellidos);
    }
    protected Estudiante(Parcel in) {
        CUI = in.readString();
        Nombres = in.readString();
        Apellidos = in.readString();
    }

    public static final Creator<Estudiante> CREATOR = new Creator<Estudiante>() {
        @Override
        public Estudiante createFromParcel(Parcel in) {
            return new Estudiante(in);
        }

        @Override
        public Estudiante[] newArray(int size) {
            return new Estudiante[size];
        }
    };
}
