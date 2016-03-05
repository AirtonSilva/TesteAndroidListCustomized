package activity;

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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import asynctask.BuscarPessoaAsyncTask;

/* Editado por Airton aos 26/02/2016 */ 

public class MainActivity extends Activity implements TextWatcher{
	
	private static int TAMANHO_MINIMO_TEXTO = 4;

	private EditText nomeEditText;
	private ArrayAdapter<String> adapter;
	private List<String> nomes;
	ListView nomeslistview;
		
	protected void onCreate(Bundle savedInstanceState) {
		
		//Criação da Activity e configuração do Layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Recuperar EditText da View através do ID
        nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        
        //O editText atenderá a um Listner usando um TextWatcher para exibir uma listinha
        nomeEditText.addTextChangedListener(this);
        
        ListView nomesListView = (ListView) findViewById(R.id.nomesListView);
        nomes = new ArrayList<String> ();
        adapter = new ArrayAdapter<String> (this,
        		android.R.layout.simple_list_item_1, nomes);
        nomesListView.setAdapter(adapter);
		}
	
	  	
		public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

	        Log.i("EditTextListener","beforeTextChanged: " + charSequence);
	        
	    }
        	
        //Esse método será executado quando o texto for digitado
		public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
			
			Log.i("EditTextListner", "onTextChanged: " + charSequence);
			String nome = charSequence.toString();
			
			// Enviar para o Servidor. Criar o JSONObject e uma AsyncTask<JSONObject, Void, Response>
			
			try {
				
				if (nome.length() >= TAMANHO_MINIMO_TEXTO){ //possui mais de 4 caracteres
					
					JSONObject json = new JSONObject();
					json.put("fullname", nome);		// {'fullName' : 'valor'}
			
					BuscarPessoaAsyncTask buscaAsyncTask = new BuscarPessoaAsyncTask(this, nomeslistview);
					buscaAsyncTask.execute(json);
					
					// Adiconar ao ListView
					nomes.add(nome);
	                adapter.notifyDataSetChanged();
			
				}
				
			} catch (JSONException e) {
				
				Log.e("EditTextListener", e.getMessage());
				
			}
			
		}
					
		public void afterTextChanged(Editable editable) {

	        Log.i("EditTextListener","afterTextChanged: " + editable);
	    }
	
}

