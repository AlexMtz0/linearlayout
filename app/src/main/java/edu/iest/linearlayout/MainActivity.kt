package edu.iest.linearlayout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var bnSuma : Button? = null
    private var bnResta : Button? = null
    private var bnDivision : Button? = null
    private var bnMultiplicacion : Button? = null
    private var etNumeroPrimero : EditText? = null
    private var etNumeroSegundo : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarVistas()
        asignarEventos()
    }

    private fun inicializarVistas(){
        bnSuma = findViewById(R.id.bnSuma)
        bnResta = findViewById(R.id.bnResta)
        bnDivision = findViewById(R.id.bnDivision)
        bnMultiplicacion = findViewById(R.id.bnMultipliacion)
        etNumeroPrimero = findViewById(R.id.etNumeroPrimero)
        etNumeroSegundo = findViewById(R.id.etNumeroSegundo)
    }

    private fun asignarEventos(){
        bnSuma?.setOnClickListener(this)
        bnResta?.setOnClickListener(this)
        bnDivision?.setOnClickListener(this)
        bnMultiplicacion?.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        val num1 = etNumeroPrimero?.text.toString().toFloat()
        val num2 = etNumeroSegundo?.text.toString().toFloat()
        if (num1 == null)
            return
        if (num2 == null)
            return
        val artimetica = artimetica()
        when (p0?.id) {
            R.id.bnSuma -> {
                val suma = artimetica.suma(num1,num2)
                Toast.makeText(this, "La suma es $suma", Toast.LENGTH_LONG).show()

            }

            R.id.bnResta -> {
                val resta = artimetica.resta(num1,num2)
                Snackbar.make(p0, "La resta es $resta", Snackbar.LENGTH_LONG).show()
            }

            R.id.bnDivision ->{
                val div = artimetica.division(num1,num2)
                Snackbar.make(p0, "La division es $div", Snackbar.LENGTH_LONG).show()
            }

            R.id.bnMultipliacion ->{
                val mul = artimetica.multiplicacion(num1,num2)
                Snackbar.make(p0, "La multiplicacion es $mul", Snackbar.LENGTH_LONG).show()
            }

        }
    }
}