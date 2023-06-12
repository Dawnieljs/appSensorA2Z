package dev.br.daniel.ifsc.sensora2z.model;

import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class SensorA2Z {

    //atributos do sensor
        private String marca;
        private boolean importado;
        private boolean aferido;
        private int modelo;
        private boolean classe;


    //métodos
    public String getMarca() { return marca;}
    public boolean getImportado() { return importado;}
    public boolean getAferido() { return aferido;}
    public int getModelo() { return modelo;}
    public boolean getClasse() { return classe;}

        //construtor
        public SensorA2Z (JSONObject jo) {
            try {
                this.marca = jo.getString("marca");
                this.classe = jo.getBoolean("classe");
                this.modelo = jo.getInt("modelo");
                this.aferido = jo.getBoolean("aferido");
                this.importado = jo.getBoolean("importado");
            }catch(JSONException je){
                je.printStackTrace();
            }
        }

    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public SensorA2Z () {
        this.setMarca("");
        this.setSerie("");
        this.setImportado(0);
        this.setAferido(0);
        this.setModelo(0);
        this.setClasse(0);
    }

    private void setClasse(int i) {
    }

    private void setModelo(int i) {
    }

    private void setAferido(int i) {
    }

    private void setImportado(int i) {
    }

    private void setSerie(String s) {
    }

    public void setMarca(String s) {
    }

    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("marca", this.marca);
            json.put("classe", this.classe);
            json.put("modelo", this.modelo);
            json.put("aferido", this.aferido);
            json.put("importado", this.importado);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }
}