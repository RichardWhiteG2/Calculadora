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
    private var primer_numero: Boolean= true
    private var segundo_numero: Boolean= false
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

        //Cuando se presiona un numero
        uno.setOnClickListener{numeropresionado("1")}
        dos.setOnClickListener{numeropresionado("2")}
        tres.setOnClickListener{numeropresionado("3")}
        cuatro.setOnClickListener{numeropresionado("4")}
        cinco.setOnClickListener{numeropresionado("5")}
        seis.setOnClickListener{numeropresionado("6")}
        siete.setOnClickListener{numeropresionado("7")}
        ocho.setOnClickListener{numeropresionado("8")}
        nueve.setOnClickListener{numeropresionado("9")}
        cero.setOnClickListener{numeropresionado("0")}
        punto.setOnClickListener{numeropresionado(".")}


        //Operaciones presionadas

        mas.setOnClickListener {operacionpresionada("+") }
        menos.setOnClickListener {operacionpresionada("-")}
        div.setOnClickListener {operacionpresionada("/")}
        mul.setOnClickListener {operacionpresionada("*")}


        borrar.setOnClickListener {
            total.text=""
            cuenta = 0.0
            primer_numero=true
            //operacion=0
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
            cuenta = when(operacion){
                1 -> num1 +num2
                2 -> num1 - num2
                3 -> num1 * num2
                4 -> num1 /num2
                else -> num1
            }
            total.text = cuenta.toString()
            //primer_numero=true
            num1=cuenta
        }

    }
    //Funcion para agregar el número precionado en la vista
    private fun numeropresionado(digito: String){
        val total: TextView= findViewById(R.id.tvTotal)

        if(primer_numero){
            operacion=0
            total.text ="${total.text}$digito"
            num1=total.text.toString().toDouble()
        }else{
            if(segundo_numero){
                total.text=""
            }
            total.text ="${total.text}$digito"
            segundo_numero=false

            num2=total.text.toString().toDouble()


        }

        //total.text ="${total.text}$digito"

    }

    private fun operacionpresionada(operador:String){
        val total: TextView= findViewById(R.id.tvTotal)
        total.text=operador
        primer_numero=false
        segundo_numero=true
        if(operador=="+"){
            operacion=1
        }
        if(operador=="-"){
            operacion=2
        }
        if(operador=="*"){
            operacion=3
        }
        if(operador=="/"){
            operacion=4
        }

    }

}