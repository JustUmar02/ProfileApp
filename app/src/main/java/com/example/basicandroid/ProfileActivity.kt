package com.example.basicandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {

    var tvNama: TextView? = null
    var tvGender: TextView? = null
    var tvEmail: TextView? = null
    var tvTelp: TextView? = null
    var tvAlamat: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvNama = findViewById(R.id.tv_nama)
        tvGender = findViewById(R.id.tv_gender)
        tvEmail = findViewById(R.id.tv_email)
        tvTelp = findViewById(R.id.tv_telp)
        tvAlamat = findViewById(R.id.tv_alamat)

        ambilData()
    }
    private  fun ambilData(){
        tvNama?.text = intent.getStringExtra("Nama")
        tvGender?.text = intent.getStringExtra("Gender")
        tvEmail?.text = intent.getStringExtra("Email")
        tvTelp?.text = intent.getStringExtra("Telp")
        tvAlamat?.text = intent.getStringExtra("Alamat")
    }
}
