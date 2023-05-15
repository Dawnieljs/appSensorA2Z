package dev.br.daniel.ifsc.sensora2z.model;

import org.json.JSONException;
import org.json.JSONObject;

public class SensorA2Z {

        //atributos do sensor
        private String marca;
        private String serie;
        private int importado;
        private int aferido;
        private int modelo;
        private int classe;
        private String observacoes;
        private int preco;

        //atributos do tecnico
        private String responsavel;

        //construtor
        public SensorA2Z (JSONObject jo) {
            try {
                this.marca = jo.getString("marca");
                this.serie = jo.getString("serie");
                this.importado = jo.getInt("importado");
                this.aferido = jo.getInt("aferido");
                this.modelo = jo.getInt("modelo");
                this.classe = jo.getInt("classe");
                this.observacoes = jo.getString("observacoes");
                this.preco = jo.getInt("preco");
                this.responsavel = jo.getString("responsavel");
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
        this.setObservacoes("");
        this.setPreco(0);
        this.setResponsavel("");
    }

    private void setResponsavel(String s) {
    }

    private void setPreco(int i) {
    }

    private void setObservacoes(String s) {
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

    private void setMarca(String s) {
    }

    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("marca", this.marca);
            json.put("serie", this.serie);
            json.put("importado", this.importado);
            json.put("aferido", this.aferido);
            json.put("modelo", this.modelo);
            json.put("classe", this.classe);
            json.put("observacoes", this.observacoes);
            json.put("preco", this.preco);
            json.put("responsavel", this.responsavel);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;

    }
}