package com.example.unit_test

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var editTextMessage: EditText
    private lateinit var buttonSend: Button
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        editTextMessage = findViewById(R.id.messageEditText)
        buttonSend = findViewById(R.id.sendButton)

        val messages = mutableListOf(
            ChatMessage("Apakah ini contoh pertanyaan?", true),
            ChatMessage("Ya, ini contoh jawaban.", false)
            // Tambahkan pesan lain sesuai kebutuhan
        )

        chatAdapter = ChatAdapter(messages)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = chatAdapter

        buttonSend.setOnClickListener {
            val messageText = editTextMessage.text.toString()
            if (messageText.isNotEmpty()) {
                val newQuestion = ChatMessage(messageText, true)
                messages.add(newQuestion)
                chatAdapter.notifyItemInserted(messages.size - 1)
                recyclerView.scrollToPosition(messages.size - 1)

                // Simulasi jawaban otomatis setelah beberapa detik
                Handler().postDelayed({
                    val answerText = "Ini adalah jawaban untuk pertanyaan: $messageText"
                    val newAnswer = ChatMessage(answerText, false)
                    messages.add(newAnswer)
                    chatAdapter.notifyItemInserted(messages.size - 1)
                    recyclerView.scrollToPosition(messages.size - 1)
                }, 1000) // Menunggu 1 detik sebelum mengirim jawaban
                editTextMessage.text.clear()
            }
        }
    }
}
