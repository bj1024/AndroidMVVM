package com.testdomain.androidmvvm.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.testdomain.androidmvvm.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

//    private lateinit var viewModel: MainViewModel

//    private val viewModel: MainViewModel as viewModels()


    // Get a reference to the ViewModel scoped to this Fragment
    val viewModel by viewModels<MainViewModel>()

    // Get a reference to the ViewModel scoped to its Activity
//    val viewModel by activityViewModels<MyViewModel>()




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var textView = view.findViewById<TextView>(R.id.main_message)
        var buttonCountUp = view.findViewById<Button>(R.id.main_countup)


        viewModel.count.observe(this, Observer { count ->
            textView.text = count.toString()
        })

        buttonCountUp.setOnClickListener {
            viewModel.countUp()
        }



    }

}