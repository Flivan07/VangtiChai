package com.example.vangtichai

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var amount: String = ""
    private val notes = intArrayOf(500, 100, 50, 20, 10, 5, 2, 1)
    private lateinit var tvAmount: TextView
    private lateinit var noteViews: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvAmount = findViewById(R.id.tvAmount)
        noteViews = listOf(
            R.id.tv500, R.id.tv100, R.id.tv50, R.id.tv20,
            R.id.tv10, R.id.tv5, R.id.tv2, R.id.tv1
        ).map { findViewById<TextView>(it) }

        // Digit buttons
        val digitIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )
        digitIds.forEachIndexed { digit, id ->
            findViewById<Button>(id).setOnClickListener { appendDigit(digit) }
        }
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            amount = ""
            updateUI()
        }

        // Restore state after rotation
        amount = savedInstanceState?.getString("amount") ?: ""
        updateUI()
    }

    private fun appendDigit(d: Int) {
        if (amount.length >= 9) return          // prevent Int overflow
        amount += d.toString()
        updateUI()
    }

    private fun updateUI() {
        tvAmount.text = getString(R.string.taka_amount, amount)
        var remaining = if (amount.isEmpty()) 0 else amount.toInt()
        for (i in notes.indices) {
            val count = remaining / notes[i]
            remaining %= notes[i]
            noteViews[i].text = getString(R.string.note_format, notes[i], count)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("amount", amount)
    }
}