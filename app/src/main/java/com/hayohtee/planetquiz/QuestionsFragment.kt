package com.hayohtee.planetquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

const val QUESTION_KEY = "QUESTION_KEY"
const val QUESTION_NUM_KEY = "QUESTION_NUM_KEY"
const val ANSWER_KEY = "ANSWER_KEY"

class QuestionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttons = listOf<Button>(
            view.findViewById(R.id.question_1_btn),
            view.findViewById(R.id.question_2_btn),
            view.findViewById(R.id.question_3_btn)
        )

        buttons.forEach {
            it.setOnClickListener { question ->
                val bundle = Bundle()

                when (question.id) {
                    R.id.question_1_btn -> {
                        bundle.putString(QUESTION_KEY, getString(R.string.question_1))
                        bundle.putString(ANSWER_KEY, getString(R.string.jupiter))
                        bundle.putInt(QUESTION_NUM_KEY, 1)
                    }
                    R.id.question_2_btn -> {
                        bundle.putString(QUESTION_KEY, getString(R.string.question_2))
                        bundle.putString(ANSWER_KEY, getString(R.string.saturn))
                        bundle.putInt(QUESTION_NUM_KEY, 2)

                    }
                    R.id.question_3_btn -> {
                        bundle.putString(QUESTION_KEY, getString(R.string.question_3))
                        bundle.putString(ANSWER_KEY, getString(R.string.uranus))
                        bundle.putInt(QUESTION_NUM_KEY, 3)
                    }
                }

                findNavController().navigate(
                    R.id.action_questionsFragment_to_answersFragment,
                    bundle
                )
            }
        }
    }

}