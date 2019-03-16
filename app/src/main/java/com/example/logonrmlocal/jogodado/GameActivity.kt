package com.example.logonrmlocal.jogodado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        btJogar.setOnClickListener{
            realizarJogada()
        }
    }

    fun realizarJogada(){
        val jogador = gerarNumero()
        val adversario = gerarNumero()

        configuraImagemDoDado(jogador,ivJogador)
        configuraImagemDoDado(adversario,ivAndroid)

        verificaVencedor(jogador,adversario)

    }

    fun exibeMensagem(mensagem: String) {
        //Cria o gerador do AlertDialog
        val builder = AlertDialog.Builder(this)
        //define o titulo
        builder.setTitle("Dado")
        //define a mensagem
        builder.setMessage(mensagem)
        //define um botão como positivo
        builder.setPositiveButton("Jogar novamente", { arg0, arg1 ->

        })
        //define um botão como negativo.
        builder.setNegativeButton("Sair",{ arg0, arg1 ->
            finish()
        })
        //cria o AlertDialog
        val alerta = builder.create()
        //Exibe
        alerta.show()
    }
    fun verificaVencedor(numeroJogador:Int,numeroAdversario:Int){
        if(numeroJogador>numeroAdversario){
            exibeMensagem("Ganhou")
        }
        if(numeroJogador==numeroAdversario){
            exibeMensagem("Empatou")
        }
        if(numeroJogador<numeroAdversario){
            exibeMensagem("Perdeu")
        }
    }

    fun configuraImagemDoDado(numeroDado:Int,ImageView:ImageView){

        when(numeroDado){
            1->(setImagem(ImageView,R.drawable.dice))
            2->(setImagem(ImageView,R.drawable.dice2))
            3->(setImagem(ImageView,R.drawable.dice3))
            4->(setImagem(ImageView,R.drawable.dice4))
            5->(setImagem(ImageView,R.drawable.dice5))
            else->(setImagem(ImageView,R.drawable.dice6))

        }
    }

    private fun setImagem(imageView:ImageView,idImagem:Int){
        imageView.setImageDrawable(ContextCompat.getDrawable(this,idImagem))
    }

    fun gerarNumero():Int{
        return Random().nextInt(5)+1
    }
}
