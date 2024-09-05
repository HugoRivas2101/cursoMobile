package com.example.myktactil

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myktactil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mBitmap = Bitmap.createBitmap(500,500,Bitmap.Config.ARGB_8888)
        val mCanvas = Canvas(mBitmap)
        // color del imageView
        mCanvas.drawColor(Color.GRAY)
        binding.myImg.setImageBitmap(mBitmap)

        val mPaint = Paint()
        // color del objeto a dibujar
        mPaint.color = Color.BLACK
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 2F// el grosor del objeto a dibujar
        mPaint.isAntiAlias =true

        var alto = mCanvas.height.toFloat()
        var ancho = mCanvas.width.toFloat()
        //dibujar la linea horizontal X
        mCanvas.drawLine(0F,alto/2,ancho,alto/2,mPaint)
        //dibujar la linea vertical Y
        mCanvas.drawLine(ancho/2,0F,ancho/2,alto,mPaint)
        mPaint.color = Color.RED
        binding.myImg.setImageBitmap(mBitmap)

        val point1=Pair(100,100) //btn rojo
        val point2=Pair(450,300) //btn verde
        val point3=Pair(200,400) //btn azul


        /*
        binding.myImg.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View, e: MotionEvent): Boolean {
                var proporcionancho = binding.myImg.width
                var proporcionalto = binding.myImg.height

                var x = e.x*500/proporcionancho
                var y = e.y*500/proporcionancho

                var mensaje1:String = "("+x.toString()+","+y.toString()+")"
                binding.lblposicion.setText(mensaje1)
                var mensaje2:String = "("+(x-250).toString()+","+(y-250).toString()+")"
                binding.lblcoordenada.setText(mensaje2)
                mCanvas.drawCircle(x,y,2F,mPaint)
                binding.myImg.setImageBitmap(mBitmap)
                return true
            }
        })
        */
        binding.btnrojo.setOnClickListener(
            object :View.OnClickListener{
            override fun onClick(v: View?) {
                mPaint.color = Color.RED
                mCanvas.drawCircle(point1.first.toFloat(),point1.second.toFloat(),2F,mPaint)
                binding.myImg.setImageBitmap(mBitmap)
            }
        })

        binding.btnverde.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                mPaint.color = Color.GREEN
                mCanvas.drawCircle(point2.first.toFloat(),point2.second.toFloat(),2F,mPaint)
                binding.myImg.setImageBitmap(mBitmap)
            }
        })
        binding.btnazul.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                mPaint.color = Color.BLUE
                mCanvas.drawCircle(point3.first.toFloat(),point3.second.toFloat(),2F,mPaint)
                binding.myImg.setImageBitmap(mBitmap)
            }
        })

        binding.btncambiar.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v:View?){
                mPaint.color=Color.BLACK
                mPaint.style=Paint.Style.FILL

                for(j in 0..100){
                    val t=(j/100.0).toFloat()
                    val x=point1.first*(1-t)*(1-t)+point2.first*2*(t)*(1-t)+point3.first*t*t
                    val y=point1.second*(1-t)*(1-t)+point2.second*2*(t)*(1-t)+point3.second*t*t

                    mCanvas.drawCircle(x,y,3F,mPaint)
                }
                binding.myImg.setImageBitmap(mBitmap)

            }
        })

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }
}