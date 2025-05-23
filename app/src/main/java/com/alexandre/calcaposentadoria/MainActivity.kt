package com.alexandre.calcaposentadoria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alexandre.calcaposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var sexo:Char = 'a'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnmasc.setOnClickListener {
            binding.btnmasc.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            binding.btnfem.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
            sexo = 'm'
        }

        binding.btnfem.setOnClickListener {
            binding.btnmasc.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
            binding.btnfem.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
            sexo = 'f'
        }

        binding.btnmostrar.setOnClickListener {
            val idade:Int? = binding.inputidade.text.toString().toIntOrNull()
            val resultado:Int

            if (idade != null) {

                if (sexo != 'a') {

                    if (sexo == 'm') {
                        resultado = 65 - idade
                    } else {
                        resultado = 62 - idade
                    }

                    if (resultado > 0) {
                        binding.textidade.text = "Faltam ${resultado} anos para você se aposentar."
                    } else {
                        binding.textidade.text = "Você já pode se aposentar."
                    }

                } else {
                    binding.textidade.text = "Selecione um sexo."
                }

            } else {
                binding.textidade.text = "Insira uma idade."
            }
        }

    } // fim onCreate

} // fim MainActivity