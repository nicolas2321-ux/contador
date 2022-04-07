package com.orellana.clase4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var teamA_text: TextView
    private lateinit var teamA_count: TextView
    private lateinit var teamA_button: Button
    private lateinit var teamB_text: TextView
    private lateinit var teamB_count: TextView
    private lateinit var teamB_button: Button
    private var score_A = 0
    private var score_B = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initial()
        stepup()
        clickHandler()
         //si el elemento es nulo no lo va a ejecutar
        savedInstanceState?.let {
            bundle ->
            score_A= bundle.getInt(KEY_SCORE_TEAM_A, score_A)
            score_B= bundle.getInt(KEY_SCORE_TEAM_B, score_B)
        }

    }

    private fun initial (){
        teamA_text = findViewById(R.id.teamA_string)
        teamA_count = findViewById(R.id.teamA_count)
        teamA_button = findViewById(R.id.goal_A)
        teamB_text = findViewById(R.id.teamB_string)
        teamB_count = findViewById(R.id.teamB_count)
        teamB_button = findViewById(R.id.goal_teamB)

    }
    private fun stepup (){
        teamA_count.text = score_A.toString()
        teamB_count.text = score_B.toString()

    }
    private fun clickHandler (){
        teamA_button.setOnClickListener{
            score_A++
            teamA_count.text = score_A.toString()
        }
        teamB_button.setOnClickListener(){
            score_B++
            teamB_count.text = score_B.toString()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SCORE_TEAM_A,score_A)
        outState.putInt(KEY_SCORE_TEAM_B, score_B)
    }
    companion object {
        private const val KEY_SCORE_TEAM_A = "ScoreTeamA"
        private const val KEY_SCORE_TEAM_B = "ScoreTeanB"
    }
}