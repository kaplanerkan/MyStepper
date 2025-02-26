/*
 * Copyright 2020 Ayomide Falobi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.erkankaplan.mystepper2.ui.presentation.steps

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.erkankaplan.mystepper2.databinding.Step1Binding
import kotlinx.coroutines.ExperimentalCoroutinesApi


/**
 * Fragment for holding and controlling views for the first step.
 */
@ExperimentalCoroutinesApi
class Step1Fragment : Fragment() {

    //private lateinit var viewBinding: ColorChangeFragmentBinding
    private lateinit var viewBinding: Step1Binding

    private val viewModel: StepperViewModel by lazy { ViewModelProvider(requireActivity())[StepperViewModel::class.java] }

//    private val onSeekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
//        override fun onProgressChanged(
//            seekBar: SeekBar?, progress: Int, fromUser: Boolean
//        ) {
//            viewBinding.run {
//                viewModel.updateStepper(
//                    viewModel.stepperSettings.value.copy(
//                        textColor = Color.rgb(
//                            seekRed.progress, seekGreen.progress, seekBlue.progress
//                        )
//                    )
//                )
//            }
//        }
//
//        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
//
//        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
//    }

    /**
     * Setup view.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewBinding = Step1Binding.inflate(inflater, container, false).apply {
            setupUI()
            editTextName.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    // Hide the keyboard
                    val inputMethodManager = context?.getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
                    inputMethodManager?.hideSoftInputFromWindow(view?.windowToken, 0)
                    v.clearFocus()
                    return@OnEditorActionListener true
                }
                false
            })
        }
        return viewBinding.root
    }

    private fun setupUI() {




    }
}
