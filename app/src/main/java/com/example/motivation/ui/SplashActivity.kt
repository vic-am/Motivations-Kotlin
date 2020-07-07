package com.example.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        supportActionBar?.hide()

        buttonSave.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSave) handleSave()
    }

    private fun handleSave() {
        val name = editName.text.toString()

        if (name != "") {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            loadActivity()
        } else Toast.makeText(
            this, "Por favor, preencha seu nome",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun loadActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}