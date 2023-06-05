package dev.br.daniel.ifsc.sensora2z.ui.cadsensora2z;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import dev.br.daniel.ifsc.sensora2z.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadSensorA2Z#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadSensorA2Z extends Fragment implements View.OnClickListener, Response.ErrorListener,
        Response.Listener {

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;
        private String setNomeMarca;
        private String setNumserie;

        private EditText etMarca;
        private EditText etSerie;
        private EditText btSalvar;
        private View root;


    public CadSensorA2Z() {
    }
        // Required empty public constructor


        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment cad_sensor_a2z.
         */
        // TODO: Rename and change types and number of parameters
        public static CadSensorA2Z newInstance (String param1, String param2){
        CadSensorA2Z fragment = new CadSensorA2Z();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

        @Override
        public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState){
        // Inflate the layout for this fragment
        this.root = inflater.inflate(R.layout.fragment_cad_sensor_a2z, container, false);
        //
        this.etMarca = (EditText) root.findViewById(R.id.etMarca);
        this.etSerie = (EditText) root.findViewById(R.id.etSerie);
        this.btSalvar = (Button) root.findViewById(R.id.btSalvar);
        //
        this.btSalvar.setOnClickListener(this);
        return root;
    }

        @Override
        public void onClick (View view){
        switch (view.getId()) {
            //verificando se e o botao salvar
            case R.id.btSalvar:
                ;
                CadSensorA2Z cadastro = new CadSensorA2Z();
                cadastro.setNomeMarca = (this.etMarca.getText().toString());
                cadastro.setNumserie = (this.etSerie.getText().toString());
                Context context = view.getContext();
                CharSequence text = "salvo com sucesso!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText
                        (context, text, duration);
                toast.show();
                break;

        }
    }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(Object response) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar()
                .setDisplayShowCustomEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(false);
    }

    }
}