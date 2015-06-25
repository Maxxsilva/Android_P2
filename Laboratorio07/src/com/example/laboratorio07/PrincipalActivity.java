package com.example.laboratorio07;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * 
 * @author Mauro Silva
 * 
 * Classe Principal Activity que contém as ações de salvar estado do valor Mínimo e Valor Máximo
 * e as Ações da operação Compra, Venda etc e seleção do tipo de moto.
 *
 */

public class PrincipalActivity extends Activity {
	
	SeekBar valorMinimo;
	SeekBar valorMaximo;
	int min;
	int max;
	
	TextView operacaoTipo;
	TextView motoTipo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		 valorMinimo = (SeekBar) findViewById(R.id.maximoSeek);
		 valorMinimo.setProgress(min); // restaurando o progresso anterior
		 valorMaximo =  (SeekBar) findViewById(R.id.minimoSeek);
		 valorMaximo.setProgress(max);  // restaurando o progresso anterior
		 operacaoTipo = (TextView) findViewById(R.id.operacaotipo);
		 motoTipo = (TextView) findViewById(R.id.mototipo);
		 
		 valorMinimo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				min = valorMinimo.getProgress();
				if (min > max) {
					 AlertDialog.Builder msg = new AlertDialog.Builder(null);   
					 msg.setTitle("Atenção")
					  .setMessage("Valor minimo não pode ser maior que o maximo!")
					  .setPositiveButton("ok", null);
					 msg.create();
				}
			}
		 });
		 
		
		 valorMaximo.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					max = valorMaximo.getProgress();
					if (max < min) {
						 AlertDialog.Builder msg = new AlertDialog.Builder(null);   
						 msg.setTitle("Atenção")
						  .setMessage("Valor máximo não pode ser menor que o minimo!")
						  .setPositiveButton("ok", null);
						 msg.create();
					}
				}
			 });
			
		operacaoTipo.setOnClickListener(new OnClickListener() {
			// Aqui fica uma classe anônima ouvinte
			@Override
			public void onClick(View v) {
				operacaoAction();
				
			}

			private void operacaoAction() {
				
				AlertDialog.Builder operacaoDialog = new AlertDialog.Builder(null);
				operacaoDialog.setTitle("Operação")
				.setSingleChoiceItems(new CharSequence[] {"Comprar", "Vender","Alugar"}, 0, 
						new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
							//  Aqui fica o código do que foi selecionado  
								
							}

		        });
				operacaoDialog.create();
			}
		});
		
		motoTipo.setOnClickListener(new OnClickListener() {
			// Aqui fica uma classe anônima ouvinte
			@Override
			public void onClick(View v) {
				motoAction();
				
			}

			private void motoAction() {
				
				AlertDialog.Builder motoDialog = new AlertDialog.Builder(null);
				motoDialog.setTitle("Operação")
				.setMultiChoiceItems(new CharSequence[] {"Street", "Trilha","Estrada"}, 
						new boolean[] {true, false, false}, 
						new DialogInterface.OnMultiChoiceClickListener() {
		            @Override
		            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
		                //  Aqui fica o código do que foi selecionado                
		            }

		        });
				motoDialog.create();
			}
		});
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putInt("min", min);
		outState.putInt("max", max);
	    super.onSaveInstanceState(outState);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
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
