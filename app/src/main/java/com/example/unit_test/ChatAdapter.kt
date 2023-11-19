package com.example.unit_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val messages: List<ChatMessage>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.messageText)
        val timeText: TextView = itemView.findViewById(R.id.timeText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = when (viewType) {
            MessageType.QUESTION.ordinal -> layoutInflater.inflate(R.layout.item_pertanyaan, parent, false)
            MessageType.ANSWER.ordinal -> layoutInflater.inflate(R.layout.item_jawaban, parent, false)
            else -> throw IllegalArgumentException("Invalid view type")
        }
        return ChatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message = messages[position]
        holder.messageText.text = message.message
        holder.timeText.text = message.getFormattedTime()
    }

    override fun getItemCount(): Int = messages.size

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isQuestion) {
            MessageType.QUESTION.ordinal
        } else {
            MessageType.ANSWER.ordinal
        }
    }

    enum class MessageType {
        QUESTION,
        ANSWER
    }
}
