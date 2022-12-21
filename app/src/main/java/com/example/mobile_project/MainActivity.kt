package com.example.mobile_project
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var ansA : Button
    private lateinit var ansB : Button
    private lateinit var ansC : Button
    private lateinit var ansD : Button
    private lateinit var submitBtn : Button
    private lateinit var totalQuestionsTextView : TextView
    private lateinit var questionTextView : TextView

    var temp_QuestionAnswer = QuestionAnswer();
    val totalQuestion: Int = temp_QuestionAnswer.question().size;
    var indexQuestion: Int = 1;
    var currentQuestionIndex: Int = 0;
    var selectedAnswer:String = "";
    var score: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);
        loadNewQuestion();
    }

    private fun loadNewQuestion() {
        if(currentQuestionIndex == totalQuestion ) {
            finishquiz();
            return
            score = 0;
            currentQuestionIndex = 0
        }
        totalQuestionsTextView.setText("Total questions " + indexQuestion +" / " + totalQuestion)
        questionTextView.setText(temp_QuestionAnswer.question()[currentQuestionIndex]);
        ansA.setText(temp_QuestionAnswer.choices()[currentQuestionIndex][0]);
        ansB.setText(temp_QuestionAnswer.choices()[currentQuestionIndex][1]);
        ansC.setText(temp_QuestionAnswer.choices()[currentQuestionIndex][2]);
        ansD.setText(temp_QuestionAnswer.choices()[currentQuestionIndex][3]);
    }

    fun buttonClicked(view: View) {
        if (view.id == R.id.submit_btn) {
            bg_button();
            if(selectedAnswer.equals(temp_QuestionAnswer.correctAnswers()[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            indexQuestion++;
            loadNewQuestion();
        }
        else {
            bg_button();
            val temp_button = view as Button;
            val temp_text = temp_button.text.toString();
            selectedAnswer  = temp_text;
            temp_button.setBackgroundColor(Color.GREEN);
        }
    }

    private fun bg_button() {
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);
    }

    private fun finishquiz() {
        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle("Result")

        //set message for alert dialog
        builder.setMessage("Your score : ".plus(score.toString()) + " of ".plus(totalQuestion.toString()));
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        //performing negative action
        builder.setNegativeButton("Try again"){dialogInterface, which ->
            restartQuiz()
        }
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun restartQuiz() {
        score = 0
        currentQuestionIndex = 0
        indexQuestion = 1
        loadNewQuestion()
    }

}