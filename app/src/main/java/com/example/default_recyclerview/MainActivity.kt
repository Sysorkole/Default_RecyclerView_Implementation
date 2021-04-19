package com.example.default_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val rvList: RecyclerView by lazy{
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = DefaultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etNome: EditText = findViewById(R.id.et_dado1)
        val etPhone: EditText = findViewById(R.id.et_dado2)
        val btAdd: Button = findViewById(R.id.btAdd)

        bindView()
        updateList()

        // Adiciona os elementos do campo à lista
        btAdd.setOnClickListener {
            if(etNome != null && etPhone != null)
                adapter.addItem(Default(etNome.text.toString(), etPhone.text.toString(), "img.png"))
        }
    }

    //Vincula o adapter do recycler view ao nosso adapter criado e escolhe o layout do RV
    private fun bindView(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    // Cria uma lista Mockada
    private fun updateList(){
        adapter.updateList(
            arrayListOf(Default(
                "Pessoa Um",
                "(00)0000-0001",
                "img1.png"
            ), Default(
                "Pessoa Dois",
                "(00)0000-0002",
                "img2.png"
            ), Default(
                "Pessoa Três",
                "(00)0000-0003",
                "img3.png"
            ))
        )
    }
}