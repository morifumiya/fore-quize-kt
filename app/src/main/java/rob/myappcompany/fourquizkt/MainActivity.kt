package rob.myappcompany.fourquizkt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val quizTitle = arrayOf("問題a", "問題b", "問題c", "問題d")
    private val quizData = arrayOf(
        arrayOf("a0", "a1", "a2", "a3"),
        arrayOf("b0", "b1", "b2", "b3"),
        arrayOf("c0", "c1", "c2", "c3"),
        arrayOf("d0", "d1", "d2", "d3")
    )

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCount: TextView = findViewById(R.id.tvCount)
        val tvQuestion: TextView = findViewById(R.id.tvQuestion)
        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btnNext: Button = findViewById(R.id.btnNext)

        // 3) カウント数と、最初の問題表示
        tvCount.text = "あと4問"
        tvQuestion.text = quizTitle[0]

        val list = listOf(0, 1, 2, 3)
        val num = list.shuffled()

        // 3) ボタンにquizData を表示 + NEXT 無効化
        btn0.text = quizData[0][num[0]]
        btn1.text = quizData[0][num[1]]
        btn2.text = quizData[0][num[2]]
        btn3.text = quizData[0][num[3]]
        btnNext.isEnabled = false

        btn0.setOnClickListener {
            if (btn0.text == quizData[i][0]) {
//                tvQuestion.text = "正解"
                correctAns()
            } else {
                incorrectAns()
            }
        }

        btn1.setOnClickListener {
            if (btn1.text == quizData[i][0]) {
//                tvQuestion.text = "正解"
                correctAns()
            } else {
                incorrectAns()
            }
        }

        btn2.setOnClickListener {
            if (btn2.text == quizData[i][0]) {
//                tvQuestion.text = "正解"
                correctAns()
            } else {
                incorrectAns()
            }
        }

        btn3.setOnClickListener {
            if (btn3.text == quizData[i][0]) {
//                tvQuestion.text = "正解"
                correctAns()
            } else {
                incorrectAns()
            }
        }

        btnNext.setOnClickListener {
            i++
            val numNext = list.shuffled()
            tvCount.text = "あと" + (4 - i); "問"
            tvQuestion.text = quizTitle[i]
            btn0.text = quizData[i][numNext[0]]
            btn1.text = quizData[i][numNext[1]]
            btn2.text = quizData[i][numNext[2]]
            btn3.text = quizData[i][numNext[3]]

            btn0.isEnabled = true
            btn1.isEnabled = true
            btn2.isEnabled = true
            btn3.isEnabled = true
            btnNext.isEnabled = false

        }
    }

    private fun correctAns() {
        val tvQuestion: TextView = findViewById(R.id.tvQuestion)
        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btnNext: Button = findViewById(R.id.btnNext)
        if (i == 3) {
            // 全問正解でクリア画面
            val intent: Intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
            finish()

        } else {
            AlertDialog.Builder(this)
                .setTitle("正解")
                .setMessage(quizData[i][0])
                .setPositiveButton("OK", null)
                .show()

            btn0.isEnabled = false
            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btnNext.isEnabled = true
        }
    }

    private fun incorrectAns() {
        val tvQuestion: TextView = findViewById(R.id.tvQuestion)
        val btn0: Button = findViewById(R.id.btn0)
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btnNext: Button = findViewById(R.id.btnNext)

        tvQuestion.text = "不正解! GameOver"
        btn0.isEnabled = false
        btn1.isEnabled = false
        btn2.isEnabled = false
        btn3.isEnabled = false
        btnNext.isEnabled = false

    }
}
