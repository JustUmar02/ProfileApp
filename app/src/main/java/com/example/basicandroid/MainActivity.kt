package com.example.basicandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var etNama: EditText? = null
    var spGender: Spinner? = null
    var etEmail: EditText? = null
    var etTelp: EditText? = null
    var etAlamat: EditText? = null
    var btnSimpan: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNama = findViewById(R.id.et_nama)
        spGender = findViewById(R.id.sp_gender)
        etEmail = findViewById(R.id.et_email)
        etTelp = findViewById(R.id.et_notelp)
        etAlamat = findViewById(R.id.et_alamat)
        btnSimpan = findViewById(R.id.btn_save)

        btnSimpan?.setOnClickListener {
            validasiInput()
        }
        setDataGender()
    }

    private fun validasiInput() {
        val inputNama = etNama?.text.toString()
        val inputEmail = etEmail?.text.toString()
        val inputTelp = etTelp?.text.toString()
        val inputAlamat = etAlamat?.text.toString()
        val inputGender = spGender?.selectedItem.toString()

        when {
            inputNama.isEmpty() -> etNama?.error = "Nama tidak boleh kosong"
            inputEmail.isEmpty() -> etEmail?.error = "Email tidak boleh kosong"
            inputGender.equals("Pilih jenis kelamin") -> tampilkanToast("Jenis Kelamin tidak boleh kosong")
            inputTelp.isEmpty() -> etTelp?.error = "Nomor Telepon tidak boleh kosong"
            inputAlamat.isEmpty() -> etAlamat?.error = "Alamat tidak boleh kosong"
            else -> {
                tampilkanToast("Navigasi ke halaman profile")
                val intent = Intent(this, ProfileActivity::class.java)

                intent.putExtra("Nama", inputNama)
                intent.putExtra("Email", inputEmail)
                intent.putExtra("Gender", inputGender)
                intent.putExtra("Telp", inputTelp)
                intent.putExtra("Alamat", inputAlamat)

                startActivity(intent)
            }
        }
    }
    private fun tampilkanToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    }
    private fun setDataGender(){
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.gender_list, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spGender?.adapter = adapter
    }
}
