package com.example.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.R
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)

        textName.setText(mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME))
    }

    override fun onClick(view: View) {
        val id = view.id

        if (id == R.id.buttonNewPhrase) {
            handleNewPhrase()
        } else if (id == R.id.imageAll) {
            handleFilter()
        }
    }

    private fun handleNewPhrase() {

    }

    private fun handleFilter() {
        
    }
}