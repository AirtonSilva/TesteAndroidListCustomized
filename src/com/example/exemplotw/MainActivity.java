package com.example.exemplotw;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

/* Criado por Airton em 22/02/2016 */ 

public class MainActivity extends Activity {
	
	EditText editText;

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editText = (EditText) findViewById(R.id.editText);
        
        //O editText atender� a um Listner usando um TextWatcher para exibir uma listinha
        editText.addTextChangedListener(new TextWatcher() {
			
        	public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				//Esse m�todo ser� executado ANTES de digitar o Texto
				
			}
        	
        	//Esse m�todo ser� executado quando o texto for digitado
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
				// Contexto; o que ser quer imprimir; e a dura��o  
				
			}
					
			public void afterTextChanged(Editable s) {
				//Ser� executado DEPOIS de digitar o texto
			}
		}	);

	}
	
}
