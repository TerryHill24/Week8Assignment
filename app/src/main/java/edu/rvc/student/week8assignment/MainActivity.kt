package edu.rvc.student.week8assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //bind objects
        val btnGo = findViewById<Button>(R.id.btnPage2)
        val txtName = findViewById<EditText>(R.id.txtName)
        val txtAddress = findViewById<EditText>(R.id.txtAddress)
        val txtCity = findViewById<EditText>(R.id.txtCity)
        val txtState = findViewById<EditText>(R.id.txtState)
        val txtZip = findViewById<EditText>(R.id.txtZip)
        val txtEMail = findViewById<EditText>(R.id.txtEMail)

        btnGo.setOnClickListener(View.OnClickListener {
            //Intent is used to send data between activities
            val intent = Intent(this, Main2Activity::class.java)
            //putExtra sets value to name SendStuff (Could be called whatever you want
            intent.putExtra("SendShip","\n" + txtName.text.toString() + "\n" + txtAddress.text.toString()
                    + "\n" + txtCity.text.toString() + ", " + txtState.text.toString()  + "  " + txtZip.text.toString())
            intent.putExtra("SendEmail",txtEMail.text.toString())

            //Go to second activity
            startActivity(intent)

        })

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
