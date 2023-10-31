package com.example.practice15

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun btnClick(view: View){
        val edtv1: EditText = findViewById(R.id.editTextText)
        val edtv2: EditText = findViewById(R.id.editTextNumber)
        val edtv3: EditText = findViewById(R.id.editTextNumber2)

        if (edtv1!!.text.toString() == "") {
            Toast.makeText(this, "Порода не может быть пустой", Toast.LENGTH_SHORT).show()
            edtv1.requestFocus()}
        else if (edtv2!!.text.toString() == ""){
            Toast.makeText(this, "Год не может быть пустым", Toast.LENGTH_SHORT).show()
            edtv2.requestFocus()}
        else if (edtv2.text.toString().toInt() < 1993 || edtv2.text.toString().toInt() > 2023){
            Toast.makeText(this, "Выберите год от 1993 до 2023", Toast.LENGTH_SHORT).show()
            edtv2.requestFocus()}
        else if (edtv3!!.text.toString() == ""){
            Toast.makeText(this, "Год не может быть пустым", Toast.LENGTH_SHORT).show()
            edtv3.requestFocus()}
        else if (edtv3.text.toString().toInt() < 1 || edtv3.text.toString().toInt() >12 || edtv3!!.text.toString() == "") {
            Toast.makeText(this, "Выберите месяц от 1 до 12", Toast.LENGTH_SHORT).show()
            edtv3.requestFocus()}

        else {
            val breed: String = edtv1.text.toString()
            val year: Int = edtv2.text.toString().toInt()
            val month: Int = edtv3.text.toString().toInt()

            val pet: Pet = Pet(breed, year, month)

            val intent: Intent = Intent(this@MainActivity, MainActivity2::class.java)

            intent.putExtra(pet.javaClass.simpleName, pet)

            startActivity(intent)

        }

    }

}