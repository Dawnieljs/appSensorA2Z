package dev.br.daniel.ifsc.sensora2z.ui.cadsensora2z;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.DocumentsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import dev.br.daniel.ifsc.sensora2z.R;
import dev.br.daniel.ifsc.sensora2z.model.SensorA2Z;

/**
 * A fragment representing a list of Items.
 */
public class ConSensorA2ZFragment extends Fragment implements Response.ErrorListener, Response.Listener  {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    //atributo com lista de sensores
    private ArrayList<SensorA2Z> sensores;
//volley
    private RequestQueue requestQueue;
    private JsonArrayRequest jsonArrayReq;
    //passar a view como atributo da classe e não do método
    private View view;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ConSensorA2ZFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ConSensorA2ZFragment newInstance(int columnCount) {
        ConSensorA2ZFragment fragment = new ConSensorA2ZFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowCustomEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(false);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_con_sensor_a2z_list, container, false);


        //instanciando a fila de requests - caso o objeto seja o view
        this.requestQueue = Volley.newRequestQueue(view.getContext());
        //inicializando a fila de requests do SO
        this.requestQueue.start();

        //array parametro de envio para o serviço
        JSONArray jsonArray = new JSONArray();
        //objeto com informações de filtro da consulta
        SensorA2Z sensor = new SensorA2Z();
        //incluindo objeto no array de envio
        //jsonArray.put(sensor.toJsonObject());
        //requisição para o Rest Server
        jsonArrayReq = new JsonArrayRequest(Request.Method.GET,
                "http://10.0.2.2/consensora2z.php",
                jsonArray, this, this);
        //mando executar a requisção na fila do sistema
        requestQueue.add(jsonArrayReq);


        return view;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        //mostrar mensagem que veio do servidor
        Snackbar mensagem = Snackbar.make(view,
                "Ops! Houve um problema ao realizar a consulta: " +
                        error.toString(), Snackbar.LENGTH_LONG);
        mensagem.show();
    }

    @Override
    public void onResponse(Object response) {
        try {
            //array Json para receber a resposta do webservice
            JSONArray jsonArray = null;
            jsonArray = new JSONArray(response.toString());
//se a consulta não veio vazia passar para array list
            if (jsonArray != null) {
//objeto java
                SensorA2Z sensor = null;
//array list para receber a resposta
                this.sensores = new ArrayList<SensorA2Z>();
//preenchendo ArrayList com JSONArray recebido
                for (int i = 0, size = jsonArray.length();
                     i < size; i++) {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    sensor = new SensorA2Z(jo);
                    this.sensores.add(sensor);
                }
/*
O código abaixo já estava no método onCreateView().
Mas foi movido para cá, porque só pode ser
executado se o this.sensores for válido.
Ou seja, se NÃO retornar dados da consulta,
ele não deve ser executado;
*/
                if (view instanceof RecyclerView) {
                    Context context = view.getContext();
                    RecyclerView recyclerView =
                            (RecyclerView) view;
                    if (mColumnCount <= 1) {
                        recyclerView.setLayoutManager(
                                new LinearLayoutManager(context));
                    } else {
                        recyclerView.setLayoutManager(
                                new GridLayoutManager(context,
                                        mColumnCount));
                    }
                    recyclerView.setAdapter(
                            new ConSensorAZRecyclerViewAdapter(this.sensores));
                }
            } else {
                Snackbar mensagem = Snackbar.make(view,
                        "A consulta não retornou nenhum registro!",
                        Snackbar.LENGTH_LONG);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}