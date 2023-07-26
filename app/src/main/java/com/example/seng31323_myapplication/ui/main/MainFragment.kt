package com.example.seng31323_myapplication.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.seng31323_myapplication.R
import androidx.lifecycle.Observer


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

    }

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view = inflater.inflate(R.layout.fragment_main, container, false)

        val number1= view?.findViewById<EditText>(R.id.textBox1)
        val number2=view?.findViewById<EditText>(R.id.textBox2)

        var message = view.findViewById<TextView>(R.id.message)

        // message.text=viewModel.result.value.toString()
        viewModel.result.observe(viewLifecycleOwner, Observer {
            message.text=it.toString()
        })

        val addButton = view.findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            if (number1!=null && number2!=null){
                if (number1.text.isNotBlank() && number2.text.isNotBlank()) {
                    viewModel.add(number1.text.toString().toDouble(), number2.text.toString().toDouble())
                } else {
                    message.text = "Fill both inputs"
                }
            }
        }

        var subsButton = view.findViewById<Button>(R.id.subsButton)
        subsButton.setOnClickListener {
            if (number1!=null && number2!=null){
                if (number1.text.isNotBlank() && number2.text.isNotBlank()) {
                    viewModel.subs(number1.text.toString().toDouble(), number2.text.toString().toDouble())
                } else {
                    message.text = "Fill both inputs"
                }
            }
        }
        var prodButton = view.findViewById<Button>(R.id.prodButton)
        prodButton.setOnClickListener {
            if (number1!=null && number2!=null) {
                if (number1.text.isNotBlank() && number2.text.isNotBlank()) {
                    viewModel.prod(
                        number1.text.toString().toDouble(),
                        number2.text.toString().toDouble()
                    )
                } else {
                    message.text = "Fill both inputs"
                }
            }
        }
        var divButton = view.findViewById<Button>(R.id.divButton)
        divButton.setOnClickListener {
            if (number1!=null && number2!=null){
                if (number1.text.isNotBlank() && number2.text.isNotBlank()) {
                    viewModel.div(number1.text.toString().toDouble(), number2.text.toString().toDouble())
                } else {
                    message.text = "Fill both inputs"
                }
            }
        }

        return view
    }

}