package com.example.myappandrei

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myappandrei.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*QUE ES BINDING???*/
    lateinit var binding: ActivityMainBinding
    var contador:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Para utilizar todos los gadgets que pusimos antes en el cel
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Manejo de evento click
        binding.btnclickar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                //USAREMOS EL EVENTO CLICK
                var mensaje="Hola mundo. Gracias Andrew "+(contador++)
                binding.lblmensaje.setText(mensaje)
                val myToast=Toast.makeText(applicationContext,mensaje,Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.LEFT,200,200)
                myToast.show()
            }
        })

        binding.suma.setOnClickListener{solve("sumar")}
        binding.restar.setOnClickListener{solve("restar")}
        binding.multiplicar.setOnClickListener{solve("multiplicar")}
        binding.dividir.setOnClickListener{solve("dividir")}
        /*
        //Get de ambos números
        val n1=binding.numero1.text.toString().toInt()
        val n2=binding.numero2.text.toString().toInt()
        */


        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

    }

    private fun solve(operacion:String){



        var n1_str=binding.number1.text.toString()
        var n2_str=binding.number2.text.toString()

        if(n1_str.isEmpty() || n2_str.isEmpty()){
            binding.resultado.setText("Coloca 2 números")
            return
        }

        var n1=n1_str.toInt()
        var n2=n2_str.toInt()

        lateinit var resultado:Number
        when(operacion){
            "sumar"-> resultado=n1+n2
            "restar"-> resultado=n1-n2
            "multiplicar"-> resultado=n1*n2
            "dividir"->resultado=n1/n2
        }

        binding.resultado.setText(resultado.toString())
    }



}