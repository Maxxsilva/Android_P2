package com.example.laboratorio04;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 
 * @author Mauro Silva
 * 
 * Classe Activity Principal de acesso
 *
 */


public class AcessoActivity extends Activity {
	
	private Button botaoOk; // para criar uma instancia do botão que fará o acesso
	private Button botaoLimpar; //para criar uma instância do botão que irá limpar
	private EditText acesso; // para se referenciar ao campo acesso
	private EditText senha; //para se referenciar ao campo senha
	private TextView resultado; // para exibir o resultado do acesso

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acesso);
		
		acesso = (EditText) findViewById(R.id.acessoEditText);
		senha = (EditText) findViewById(R.id.senhaEditText);
		resultado = (TextView) findViewById(R.id.resultadoTextview);
		
		
		botaoOk = (Button) findViewById(R.id.acessoButton);
		botaoOk.setOnClickListener(new OnClickListener() {
			// Aqui fica uma classe anônima ouvinte
			@Override
			public void onClick(View v) {
				okButtonAction();
				
			}

			private void okButtonAction() {
				String acessoInserido = acesso.getText().toString();
				String senhaInserida = senha.getText().toString();
				
				if (acessoInserido.equals("admin") && senhaInserida.equals("12345")) {
					resultado.setText("Acesso ok");
				} else{
					resultado.setText("Acesso negado");
				}
			}
		});
		
		botaoLimpar = (Button) findViewById(R.id.limparButton);
		botaoLimpar.setOnClickListener(new OnClickListener() {
			// Aqui fica uma classe anônima ouvinte
			@Override
			public void onClick(View v) {
				limparButtonAction();
				
			}

			private void limparButtonAction() {
				acesso.setText(null);
				senha.setText(null);
				resultado.setText(null);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.acesso, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
