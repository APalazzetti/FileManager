package com.example.filemanager;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gestore {
    public String leggiFile(String nomeFile, Context c) {
        StringBuilder sb =new StringBuilder();
        String righeLette="";
        try{
            BufferedReader fileDaLeggere = new BufferedReader(new InputStreamReader(
                c.openFileInput(nomeFile)));

            while ((righeLette=fileDaLeggere.readLine())!=null) {

                    sb.append(righeLette);

            }
    } catch (FileNotFoundException fileNotFoundException) {
            Log.e("gestore","File inesistente");
        } catch (IOException e) {
            Log.e("gestore","Errore IO");
        }

return  sb.toString();
    }
    public String scriviFile(String nomeFile,Context c ){
       String esito;
        FileOutputStream fileO;
        String testoDaScrivere="Questo è il testo del file creato!";
        try {
            fileO = c.openFileOutput(nomeFile,Context.MODE_PRIVATE);
            fileO.write(testoDaScrivere.getBytes());
            fileO.close();
            esito = " file scritto corretamente";
        } catch (FileNotFoundException e) {
            esito = "Attenzione non sono riuscito a creare il file";

        } catch (IOException e) {
            esito = "Errore in fase di scritturs del file";
        }

        return esito;

    }

}


