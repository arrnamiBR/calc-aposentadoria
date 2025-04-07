package com.alexandre.calcaposentadoria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alexandre.calcaposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var masc:Boolean = false
    private var fem:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnmasc.setOnClickListener {
            binding.btnmasc.setBackgroundColor(ContextCompat.getColor(this, R.color.hardblue))
            binding.btnfem.setBackgroundColor(ContextCompat.getColor(this, R.color.pink))
            masc = true
            fem = false
        }

        binding.btnfem.setOnClickListener {
            binding.btnmasc.setBackgroundColor(ContextCompat.getColor(this, R.color.blue))
            binding.btnfem.setBackgroundColor(ContextCompat.getColor(this, R.color.hardpink))
            masc = false
            fem = true
        }

        binding.btnmostrar.setOnClickListener {
            val idade:Int? = binding.inputidade.text.toString().toIntOrNull()
            if (idade != null) {
                if (masc) {
                    binding.textidade.text = "Faltam ${65 - idade} anos para você se aposentar."
                } else if (fem) {
                    binding.textidade.text = "Faltam ${62 - idade} anos para você se aposentar."
                } else {
                    binding.textidade.text = "Selecione um sexo."
                }
            } else {
                binding.textidade.text = "Insira uma idada."
            }
        }

    } // fim onCreate

} // fim MainActivity