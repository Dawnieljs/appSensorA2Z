package dev.br.daniel.ifsc.sensora2z.model;

import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class SensorA2Z {

    //atributos do sensor
        private String cdmarca;
        private boolean flimportado;
        private boolean flaferido;
        private int cdmodelo;
        private boolean flclasse;


    //métodos
    public String getMarca() { return cdmarca;}
    public boolean getImportado() { return flimportado;}
    public boolean getAferido() { return flaferido;}
    public int getModelo() { return cdmodelo;}
    public boolean getClasse() { return flclasse;}

        //construtor
        public SensorA2Z (JSONObject jo) {
            try {
                this.cdmarca = jo.getString("marca");
                this.flclasse = jo.getBoolean("classe");
                this.cdmodelo = jo.getInt("modelo");
                this.flaferido = jo.getBoolean("aferido");
                this.flimportado = jo.getBoolean("importado");
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
            json.put("marca", this.cdmarca);
            json.put("classe", this.flclasse);
            json.put("modelo", this.cdmodelo);
            json.put("aferido", this.flaferido);
            json.put("importado", this.flimportado);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }
}