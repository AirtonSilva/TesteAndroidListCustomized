package br.edu.ifpb.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.exemplotw.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import br.edu.ifpb.adapter.PessoasCustomAdapter;
import br.edu.ifpb.asynctask.BuscaAsyncTask;
import br.edu.ifpb.entidade.Pessoa;
import br.edu.ifpb.interfaceCallBack.BuscarPessoaCallBack;

public class MainActivity extends Activity implements TextWatcher, BuscarPessoaCallBack{
	
	final int TAMANHO_MINIMO = 4;

	ArrayAdapter<String> arrayAdapter;
	ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	PessoasCustomAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditText nomeEditText = (EditText) findViewById(R.id.nomeEditText);
		nomeEditText.addTextChangedListener(this);
				
		ListView nomesListView = (ListView) findViewById(R.id.nomesListView);		
		adapter = new PessoasCustomAdapter(this, pessoas);
        nomesListView.setAdapter(adapter);
	}

	@Override
	public void afterTextChanged(Editable s) {
		Log.i("afterTextChanged", s.toString());
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		Log.i("beforeTextChanged", s.toString());
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		
		Log.i("onTextChanged", s.toString());
		
		JSONObject json = new JSONObject();
		
		if(s.length() >= TAMANHO_MINIMO){
			try {	
				json.put("fullName", s.toString());
			} catch (JSONException e) {
				Log.e("Main Activity", e.getMessage());
			}
			
			BuscaAsyncTask buscaAsyncTask = new BuscaAsyncTask(this);
			buscaAsyncTask.execute(json);
		}else{
			pessoas.clear();
			arrayAdapter.notifyDataSetChanged();
		}
		
	}

	@Override
	public void backBuscarNome(List<Pessoa> names) {		

        this.pessoas.clear();
        this.pessoas.addAll(pessoas);
        adapter.notifyDataSetChanged();
		
	}
}
