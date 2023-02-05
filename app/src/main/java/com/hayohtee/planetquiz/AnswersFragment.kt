package com.hayohtee.planetquiz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class AnswersFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answers, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val question = requireArguments().getString(QUESTION_KEY)
        val questionNum = requireArguments().getInt(QUESTION_NUM_KEY)
        val answer = requireArguments().getString(ANSWER_KEY)
        val answerTextView = view.findViewById<TextView>(R.id.answer_text)
        view.findViewById<TextView>(R.id.question_title).text = question

        val buttons = listOf<Button>(
            view.findViewById(R.id.mercury_btn),
            view.findViewById(R.id.venus_btn),
            view.findViewById(R.id.earth_btn),
            view.findViewById(R.id.mars_btn),
            view.findViewById(R.id.jupiter_btn),
            view.findViewById(R.id.saturn_btn),
            view.findViewById(R.id.uranus_btn),
            view.findViewById(R.id.neptune_btn),
        )



        buttons.forEach {
            it.setOnClickListener { _ ->
                val text = when (questionNum) {
                    1 -> getString(R.string.question_1_answer)
                    2 -> getString(R.string.question_2_answer)
                    3 -> getString(R.string.question_3_answer)
                    else -> "Unknown"
                }

                if (it.text == answer) {
                    answerTextView.text = "CORRECT! $text"
                } else {
                    answerTextView.text = "WRONG! $text"
                }
            }
        }
    }
}