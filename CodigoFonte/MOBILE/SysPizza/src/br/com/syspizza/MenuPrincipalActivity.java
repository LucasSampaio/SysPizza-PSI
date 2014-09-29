package br.com.syspizza;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MenuPrincipalActivity extends ActionBarActivity {

	Button btEntrar;
	EditText etLogin, etSenha;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_efetuar_pedidos);
		chamaTelaDeLogin();
	}
	
	// CHAMA TELA DE LOGIN
	public void chamaTelaDeLogin(){
		setContentView(R.layout.activity_login);
		
		etLogin = (EditText) findViewById(R.id.etLogin);
		etSenha = (EditText) findViewById(R.id.etSenha);
		
		btEntrar = (Button) findViewById(R.id.btEntrar);
		btEntrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
					
					if( etLogin.getText().toString().equalsIgnoreCase("guilherme") && etSenha.getText().toString().equalsIgnoreCase("123")){
						setContentView(R.layout.activity_menu_principal);
					}
					else{
						mensagemExibir("Alerta !", "Erro de login e senha");
					}
				}
				catch(Exception erro){
					mensagemExibir("Alerta !", "O App encontro problemas na tela de autenticação");
				}
			}
		});
	}
	
public void mensagemExibir(String tituloAlerta, String mensagemAlerta){
		
		AlertDialog.Builder mensagem = new AlertDialog.Builder(MenuPrincipalActivity.this);
		
		mensagem.setTitle(tituloAlerta);
		mensagem.setMessage(mensagemAlerta);
		mensagem.setNeutralButton("Ok", null);
		mensagem.show();
	}
	
	//----------------------------------------------------------------------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_principal, menu);
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

