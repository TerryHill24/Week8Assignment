package edu.rvc.student.week8assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txtShowEmail = findViewById<TextView>(R.id.txtShowEmail)
        val txtShowShip = findViewById<TextView>(R.id.txtShowShip)

        //loads intent string from MainActivity.kt

        var strShip: String = intent.getStringExtra("SendShip")
        var strEmail: String = intent.getStringExtra("SendEmail")
        txtShowEmail.text = "Thank You for your order. \nYour order confirmation number has been sent to:\n\n" + strEmail
        txtShowShip.text = "Your order will ship to: \n" + strShip




        //btnBack.setOnClickListener(View.OnClickListener {
            //this.finish()
        //})

        //Fire hidekeyboard when user taps outside any text object
//Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }

    }

    //function to hide keyboard goes right before the last right bracket of Class MainActivity
//should auto import android.content.Context
//should auto add import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}
