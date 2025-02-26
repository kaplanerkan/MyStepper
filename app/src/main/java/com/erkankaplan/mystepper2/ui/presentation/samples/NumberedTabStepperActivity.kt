package com.erkankaplan.mystepper2.ui.presentation.samples

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.ui.setupActionBarWithNavController
import com.aceinteract.android.stepper.StepperNavListener
import com.aceinteract.android.stepper.StepperNavigationView
import com.erkankaplan.mystepper2.R
import com.erkankaplan.mystepper2.databinding.TabNumberedStepperActivityBinding
import com.erkankaplan.mystepper2.ui.models.StepperSettings
import com.erkankaplan.mystepper2.ui.presentation.main.MainActivity
import com.erkankaplan.mystepper2.ui.presentation.steps.StepperViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ng.softcom.android.utils.ui.findNavControllerFromFragmentContainer
import ng.softcom.android.utils.ui.showToast

/**
 * Activity showing an sample usage of a numbered tab stepper.
 */
@ExperimentalCoroutinesApi
class NumberedTabStepperActivity : AppCompatActivity(), StepperNavListener {

    private val viewModel: StepperViewModel by lazy { ViewModelProvider(this)[StepperViewModel::class.java] }

    private lateinit var binding: TabNumberedStepperActivityBinding

    /**
     * Setup stepper and activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TabNumberedStepperActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.tab_numbered_stepper_activity)

        binding.stepper.initializeStepper()

        setSupportActionBar(binding.toolbar)

        // Setup Action bar for title and up navigation.
        setupActionBarWithNavController(findNavControllerFromFragmentContainer(R.id.frame_stepper))

        binding.buttonNext.setOnClickListener {
            binding.stepper.goToNextStep()
            Log.e("TAG", "onCreate: " + binding.stepper.currentStep)

        }

        binding.buttonPrevious.setOnClickListener {
            binding.stepper.goToPreviousStep()
        }



        collectStateFlow()
    }

    private fun StepperNavigationView.initializeStepper() {
        viewModel.updateStepper(
            StepperSettings(
                widgetColor, textColor, textSize, iconSize
            )
        )

        menu.add(0, R.id.step_4_dest, 0, "New Step")


        stepperNavListener = this@NumberedTabStepperActivity
        setupWithNavController(findNavControllerFromFragmentContainer(R.id.frame_stepper))
    }

    private fun collectStateFlow() {
        viewModel.stepperSettings.onEach {
            binding.stepper.widgetColor = it.iconColor
            binding.stepper.textColor = it.textColor
            binding.stepper.textSize = it.textSize
            binding.stepper.iconSize = it.iconSize
        }.launchIn(lifecycleScope)
    }

    override fun onStepChanged(step: Int) {
        showToast("Step changed to: $step")

        binding.buttonPrevious.isVisible = step != 0

        if (step == 4) {
            binding.buttonNext.setImageResource(R.drawable.ic_check)
        } else {
            binding.buttonNext.setImageResource(R.drawable.ic_right)
        }

        if (binding.stepper.currentStep == 3) {
            binding.buttonNext.visibility = View.GONE
        }else {
            binding.buttonNext.visibility = View.VISIBLE
        }
    }

    override fun onCompleted() {
        showToast("Stepper completed")
    }

    /**
     * Use navigation controller to navigate up.
     */
    override fun onSupportNavigateUp(): Boolean =
        findNavControllerFromFragmentContainer(R.id.frame_stepper).navigateUp()

    /**
     * Navigate up when the back button is pressed.
     */
    override fun onBackPressed() {
        if (binding.stepper.currentStep == 0) {
            super.onBackPressed()
        } else {
            findNavControllerFromFragmentContainer(R.id.frame_stepper).navigateUp()
        }
    }
}
