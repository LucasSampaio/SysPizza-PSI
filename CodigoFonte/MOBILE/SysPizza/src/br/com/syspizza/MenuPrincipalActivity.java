package br.com.syspizza;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MenuPrincipalActivity extends ActionBarActivity {

	// TELA DE LOGIN
	EditText etLogin, etSenha;
	Button btEntrar;
	
	// TELA MENU PRINCIPAL
	Button btEfetuarPedido, btSolicitarReserva, btPerguntaSugestao, btSair;
	
	// TELA  EFETUAR PEDIDO
	Button btPizzaEfetuarPedido, btBebidaEfetuarPedido, btDoceEfetuarPedido, btSanduicheEfetuarPedido;
	
	TextView tvPizzaPedida, tvBebidaPedida, tvDocePedido, tvSanduichePedido;
	Button btAlterarItem, btFinalizarPedido;
	
	// SPINNERS
		String[] pizzas = { "Mussarela","4 Queijos", "Postuguesa"};
		ArrayAdapter<String> aPizzas; // OBJETO QUE VAI CONVERTER AS OPÇÕES PARA APARECEREM NO SPINNER
		Spinner spEscolherPizza;// Declarando variavel do tipo Spinner
		Button btAdicionarPedidoPizza;
		
		String[] bebidas = { "Coca-cola","Coca-cola 0", "Baré"};
		ArrayAdapter<String> abebidas; // OBJETO QUE VAI CONVERTER AS OPÇÕES PARA APARECEREM NO SPINNER
		Spinner spEscolherBebida;// Declarando variavel do tipo Spinner
		Button btAdicionarPedidoBebida;
		
		String[] doces = { "Cupcake","Musse", "Chocolate"};
		ArrayAdapter<String> adoces; // OBJETO QUE VAI CONVERTER AS OPÇÕES PARA APARECEREM NO SPINNER
		Spinner spEscolherDoce;// Declarando variavel do tipo Spinner
		Button btAdicionarPedidoDoce;
		
		String[] sanduiches= { "X-Salada","X-Tudo", "Especial da casa"};
		ArrayAdapter<String> asanduiches; // OBJETO QUE VAI CONVERTER AS OPÇÕES PARA APARECEREM NO SPINNER
		Spinner spEscolherSanduiche;// Declarando variavel do tipo Spinner
		Button btAdicionarPedidoSanduiche;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_escolher_pizza);
		chamaTelaDeLogin();
	}


// CHAMA TELA DE LOGIN
public void chamaTelaDeLogin(){
		setContentView(R.layout.activity_login);
		
		inicializaObjetos();
		btEntrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
					
					if( etLogin.getText().toString().equalsIgnoreCase("guilherme") && etSenha.getText().toString().equalsIgnoreCase("123")){
						chamaMenuPrincipal();
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

public void chamaMenuPrincipal(){
	setContentView(R.layout.activity_menu_principal);
	
	inicializaObjetos();
	
	btEfetuarPedido.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			chamaTelaEfetuarPedido();
		}
	});
	
	btSolicitarReserva.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			chamaReservarMesa();
		}
	});
}

public void chamaTelaEfetuarPedido(){
	setContentView(R.layout.activity_efetuar_pedidos);
	
	inicializaObjetos();
		// BOTÃO PIZZA
	btPizzaEfetuarPedido.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			chamaTelaEscolherPizza();
		}
	});
		// BOTÃO BEBIDA
	btBebidaEfetuarPedido.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			chamaTelaEscolherBebida();
		}
	});
		// BOTÃO DOCE
	btDoceEfetuarPedido.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			chamaTelaEscolherDoce();
		}
	});
		// BOTÃO SANDUICHE
	btSanduicheEfetuarPedido.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			chamaTelaEscolherSanduiche();
		}
	});
	
		// BOTÃO ALTERAR ITEM
	btAlterarItem.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// FAZ A AÇÃO DE ALTERAR O ITEM
		}
	});
		// BOTÃO FINALIZAR COMPRA
	btFinalizarPedido.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// FAZ A AÇÃO DE FINALIZAR O PEDIDO
		}
	});
	
}

public void chamaTelaEscolherPizza(){
	setContentView(R.layout.activity_escolher_pizza);
	//mensagemExibir("asd", "asd");
	inicializaObjetos();
	
	// modelo do spinner
	aPizzas = new ArrayAdapter<String>(this,
	android.R.layout.simple_spinner_item, pizzas);
	// capturando o spinner do xml pela id
	spEscolherPizza.setAdapter(aPizzas);
	 
	// Evento de click do botao mostrar
	btAdicionarPedidoPizza.setOnClickListener(new View.OnClickListener() {
	 
	@Override
	public void onClick(View v) {
	 
		// aqui eu recupero as posições selecionadas
		switch (spEscolherPizza.getSelectedItemPosition()) {
		 
			case 0: mensagemExibir("Aviso", "Pizza escolhida: MUSSARELA");
					chamaTelaEfetuarPedido();
					setTextView(1, pizzas[0]);
					break;
			 
			case 1: mensagemExibir("Aviso", "Pizza escolhida: 4 QUEIJOS");
					chamaTelaEfetuarPedido();
					setTextView(1, pizzas[1]);
					break;
			 
			case 2: mensagemExibir("Aviso", "Pizza escolhida: PORTUGUESA");
					chamaTelaEfetuarPedido();
					setTextView(1, pizzas[2]);
					break;
		}
	 
	}
	});
}

public void chamaTelaEscolherBebida(){
	setContentView(R.layout.activity_escolher_bebida);
	
	inicializaObjetos();
	
	// modelo do spinner
	abebidas = new ArrayAdapter<String>(this,
	android.R.layout.simple_spinner_item, bebidas);
	// capturando o spinner do xml pela id
	spEscolherBebida.setAdapter(abebidas);
	 
	// Evento de click do botao mostrar
	btAdicionarPedidoBebida.setOnClickListener(new View.OnClickListener() {
	 
	@Override
	public void onClick(View v) {
	 
		// aqui eu recupero as posições selecionadas
		switch (spEscolherBebida.getSelectedItemPosition()) {
		 
			case 0: mensagemExibir("Aviso", "Bebida escolhida: Coca-cola");
					chamaTelaEfetuarPedido();
					setTextView(2, bebidas[0]);
					break;
			 
			case 1: mensagemExibir("Aviso", "Bebida escolhida: Coca-cola 0");
					chamaTelaEfetuarPedido();
					setTextView(2, bebidas[1]);
					break;
			 
			case 2: mensagemExibir("Aviso", "Bebida escolhida: Baré");
					chamaTelaEfetuarPedido();
					setTextView(2, bebidas[2]);
					break;
		}
	 
	}
	});
}

public void chamaTelaEscolherDoce(){
	setContentView(R.layout.activity_escolher_doce);
	
	inicializaObjetos();
	
	// modelo do spinner
	adoces = new ArrayAdapter<String>(this,
	android.R.layout.simple_spinner_item, doces);
	// capturando o spinner do xml pela id
	spEscolherDoce.setAdapter(adoces);
	 
	// Evento de click do botao mostrar
	btAdicionarPedidoDoce.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (spEscolherDoce.getSelectedItemPosition()) {
			 
			case 0: mensagemExibir("Aviso", "Doce escolhido: Cupcake");
					chamaTelaEfetuarPedido();
					setTextView(3, doces[0]);
					break;
			 
			case 1: mensagemExibir("Aviso", "Doce escolhido: Musse");
					chamaTelaEfetuarPedido();
					setTextView(3, doces[1]);
					break;
			 
			case 2: mensagemExibir("Aviso", "Doce escolhido: Chocolate");
					chamaTelaEfetuarPedido();
					setTextView(3, doces[2]);
					break;
			}
		}
	});
}

public void chamaTelaEscolherSanduiche(){
	setContentView(R.layout.activity_escolher_sanduiche);
	
	inicializaObjetos();
	
	// modelo do spinner
	asanduiches = new ArrayAdapter<String>(this,
	android.R.layout.simple_spinner_item, sanduiches);
	// capturando o spinner do xml pela id
	spEscolherSanduiche.setAdapter(asanduiches);
	 
	// Evento de click do botao mostrar
	btAdicionarPedidoSanduiche.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (spEscolherSanduiche.getSelectedItemPosition()) {
			 
			case 0: mensagemExibir("Aviso", "Sanduiche escolhido: X-Salada");
					chamaTelaEfetuarPedido();
					setTextView(4, sanduiches[0]);
					break;
			 
			case 1: mensagemExibir("Aviso", "Sanduiche escolhido: X-Tudo");
					chamaTelaEfetuarPedido();
					setTextView(4, sanduiches[1]);
					break;
			 
			case 2: mensagemExibir("Aviso", "Sanduiche escolhido: Especial da casa");
					chamaTelaEfetuarPedido();
					setTextView(4, sanduiches[2]);
					break;
			}
		}
	});
}

public void chamaReservarMesa(){
	setContentView(R.layout.activity_reservar_mesa);
}

public void inicializaObjetos(){
	// TELA DE LOGIN
	etLogin = (EditText) findViewById(R.id.etLogin);
	etSenha = (EditText) findViewById(R.id.etSenha);
	btEntrar = (Button) findViewById(R.id.btEntrar);
	
	// MENU PRINCIPAL
	btSolicitarReserva = (Button) findViewById(R.id.btSolicitarReserva);
	btEfetuarPedido = (Button) findViewById(R.id.btEfetuarPedido);
	
	// EFETUAR PEDIDO
	//BOTÕES PARA EFETUAR PEDIDO
	btPizzaEfetuarPedido = (Button)findViewById(R.id.btPizzaEfetuarPedido);
	btBebidaEfetuarPedido = (Button)findViewById(R.id.btBebidaEfetuarPedido);
	btDoceEfetuarPedido = (Button)findViewById(R.id.btDoceEfetuarPedido);
	btSanduicheEfetuarPedido = (Button)findViewById(R.id.btSanduicheEfetuarPedido);
		//TEXTVIEW DOS PEDIDOS
	tvPizzaPedida = (TextView) findViewById(R.id.tvPizzaPedida);
	tvBebidaPedida = (TextView) findViewById(R.id.tvBebidaPedida);
	tvDocePedido = (TextView) findViewById(R.id.tvDocePedido);
	tvSanduichePedido = (TextView) findViewById(R.id.tvSanduichePedido);
		//BOTÕES ALTERAR E FINALIZAR
	btAlterarItem = (Button)findViewById(R.id.btAlterarItem);
	btFinalizarPedido = (Button)findViewById(R.id.btFinalizarPedido);
	
	// ESCOLHER PIZZA
	spEscolherPizza = (Spinner) findViewById(R.id.spEscolherPizza);
	btAdicionarPedidoPizza = (Button) findViewById(R.id.btAdicionarPedidoPizza);
	
	// ESCOLHER BEBIDA
	spEscolherBebida = (Spinner) findViewById(R.id.spEscolherBebida);
	btAdicionarPedidoBebida = (Button) findViewById(R.id.btAdicionarPedidoBebida);
	
	// ESCOLHER DOCE
	spEscolherDoce = (Spinner) findViewById(R.id.spEscolherDoce);
	btAdicionarPedidoDoce = (Button) findViewById(R.id.btAdicionarPedidoDoce);
	
	// ESCOLHER SANDUICHE
	spEscolherSanduiche = (Spinner) findViewById(R.id.spEscolherSanduiche);
	btAdicionarPedidoSanduiche = (Button) findViewById(R.id.btAdicionarPedidoSanduiche);
}

public void setTextView(int textView,String texto){
	inicializaObjetos();
	
	switch (textView) {
	case 1: tvPizzaPedida.setText(texto); 
			break;
	case 2: tvBebidaPedida.setText(texto);
			break;
	case 3: tvDocePedido.setText(texto);
			break;
	case 4: tvSanduichePedido.setText(texto);
			break;
	}
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

