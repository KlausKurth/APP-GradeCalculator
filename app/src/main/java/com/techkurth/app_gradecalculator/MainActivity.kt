package com.techkurth.app_gradecalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.techkurth.app_gradecalculator.databinding.ActivityMainBinding

// Declaração da classe MainActivity, que herda de AppCompatActivity
class MainActivity : AppCompatActivity() {

    // Declaração de uma propriedade `binding`, que será inicializada depois
    private lateinit var binding: ActivityMainBinding

    // Função chamada quando a Activity é criada, onde ocorre a inicialização da interface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o `binding` usando o metodo `inflate` da classe gerada pelo ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)


        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura um ouvinte de clique para o botão 'btCalculate'.
        binding.btCalculate.setOnClickListener {
            Log.d("click", "Button has clicked!")

            val score1 = binding.editScore1.text.toString()
            val score2 = binding.editScore2.text.toString()
            val score3 = binding.editScore3.text.toString()
            val score4 = binding.editScore4.text.toString()
            val absence = binding.editAbsence.text.toString()

            if (score1.isEmpty() || score2.isEmpty() || score3.isEmpty() || score4.isEmpty() || absence.isEmpty()) {
                binding.txtResult.setText("Please fill out all fields.")
                binding.txtResult.setTextColor(getColor(R.color.red))

            } else {
                calculateGradeAverage(score1.toInt(), score2.toInt(), score3.toInt(), score4.toInt(), absence.toInt())
            }

        }

    }

    //para que a função possa ser chamada de fora ela deve ser criada fora do metodo onCreate
    fun calculateGradeAverage(score1: Int, score2: Int, score3: Int, score4: Int, absence: Int) {

        val average = (score1 + score2 + score3 + score4) / 4

        if (average >= 7 && absence <= 20) {
            binding.txtResult.setText("Student has successfully passed the subject. \n Grade Average: $average ")
            binding.txtResult.setTextColor(getColor(R.color.green))
        } else if (absence >= 20) {
            binding.txtResult.setText("Student failed due to excessive absences. \nAbsences: $absence")
            binding.txtResult.setTextColor(getColor(R.color.red))
        } else if (average < 7) {
            binding.txtResult.setText("Student failed due to low grade average. \nAverage: $average")
            binding.txtResult.setTextColor(getColor(R.color.red))
        }
    }
}