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

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.erkankaplan.mystepper2.databinding.SizeChangeFragmentBinding
import com.erkankaplan.mystepper2.databinding.Step4Binding

import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Fragment for holding and controlling views for the third step.
 */
@ExperimentalCoroutinesApi
class Step4Fragment : Fragment() {

    private lateinit var viewBinding: Step4Binding

    private val viewModel: StepperViewModel by lazy { ViewModelProvider(requireActivity())[StepperViewModel::class.java] }

    /**
     * Setup view.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = Step4Binding.inflate(inflater, container, false)

//        viewBinding = Step4Binding.inflate(inflater, container, false).apply {
//            setupUI()
//        }
        return viewBinding.root
    }

    private fun setupUI() {

    }
}
