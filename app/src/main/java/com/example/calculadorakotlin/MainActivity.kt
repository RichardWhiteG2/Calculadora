package com.example.calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var num1: Double =0.0
    private  var num2: Double=0.0
    private var operacion: Int =0
    private var cuenta: Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val total: TextView= findViewById(R.id.tvTotal)
        val uno: TextView = findViewById(R.id.numero_1)
        val dos: TextView = findViewById(R.id.numero_2)
        val tres: TextView = findViewById(R.id.numero_3)
        val cuatro: TextView = findViewById(R.id.numero_4)
        val cinco: TextView = findViewById(R.id.numero_5)
        val seis: TextView = findViewById(R.id.numero_6)
        val siete: TextView = findViewById(R.id.numero_7)
        val ocho: TextView = findViewById(R.id.numero_8)
        val nueve: TextView = findViewById(R.id.numero_9)
        val cero: TextView = findViewById(R.id.numero_0)
        val igual: TextView = findViewById(R.id.numero_igual)
        val punto: TextView = findViewById(R.id.numero_punto)
        val del: TextView = findViewById(R.id.signo_del)
        val borrar: TextView = findViewById(R.id.signo_c)
        val div: TextView = findViewById(R.id.signo_div)
        val mas: TextView = findViewById(R.id.signo_mas)
        val menos: TextView = findViewById(R.id.signo_menos)
        val mul: TextView = findViewById(R.id.signo_mul)
        total.text="0.0"
        //Cuando se presiona un numero
        uno.setOnClickListener{numeropresionado("1",true)}
        dos.setOnClickListener{numeropresionado("2",true)}
        tres.setOnClickListener{numeropresionado("3",true)}
        cuatro.setOnClickListener{numeropresionado("4",true)}
        cinco.setOnClickListener{numeropresionado("5",true)}
        seis.setOnClickListener{numeropresionado("6",true)}
        siete.setOnClickListener{numeropresionado("7",true)}
        ocho.setOnClickListener{numeropresionado("8",true)}
        nueve.setOnClickListener{numeropresionado("9",true)}
        cero.setOnClickListener{numeropresionado("0",true)}
        punto.setOnClickListener{numeropresionado(".",true)}


        //Operaciones presionadas

        mas.setOnClickListener {numeropresionado("+",false)}
        menos.setOnClickListener {numeropresionado("-",false)}
        div.setOnClickListener {numeropresionado("/",false)}
        mul.setOnClickListener {numeropresionado("*",false)}


        borrar.setOnClickListener {
            total.text=""
        }
        //opciones adicionales

        //Para borral el ultimo digito ingresado
        del.setOnClickListener {
            val string = total.text.toString()
            if(string.isNotBlank()){
                total.text=string.substring(0, string.length-1)
            }
        }

        igual.setOnClickListener {
            var resultado = when(operacion){
                Suma -> num1 +num2
                resta -> num1 - num2
                division -> num1 / num2
                multiplicacion -> num1 *num2
                else -> 0
            }
            total.text=resultado.toString()
        }

    }
    //Funcion para agregar el número precionado en la vista
    fun numeropresionado(digito: String, limpíar_datos:Boolean){
        val total: TextView= findViewById(R.id.tvTotal)

        total.text ="${total.text}$digito"

        if (operacion== no_operacion){
            num1 = total.text.toString().toDouble()
        }else{
            num2 = total.text.toString().toDouble()
        }
    }
    //Para saber que operacion se va a realizar i guardar el primer valor
    private fun operacionPresionada(operacion: Int){
        val total: TextView= findViewById(R.id.tvTotal)

        this.operacion = operacion

        num1 = total.text.toString().toDouble()
        total.text="0"
    }
}