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
package com.erkankaplan.mystepper2.ui.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.erkankaplan.mystepper2.R
import com.erkankaplan.mystepper2.databinding.ActivityMainBinding

import com.erkankaplan.mystepper2.ui.models.ActivityItem
import com.erkankaplan.mystepper2.ui.presentation.samples.FadeAnimStepperActivity
import com.erkankaplan.mystepper2.ui.presentation.samples.FleetsStepperActivity
import com.erkankaplan.mystepper2.ui.presentation.samples.NumberedTabStepperActivity
import com.erkankaplan.mystepper2.ui.presentation.samples.ProgressStepperActivity
import com.erkankaplan.mystepper2.ui.presentation.samples.StepperNoUpNavActivity
import com.erkankaplan.mystepper2.ui.presentation.samples.TabStepperActivity
import com.erkankaplan.mystepper2.ui.presentation.samples.TabStepperWithOverflowActivity
import com.erkankaplan.mystepper2.ui.presentation.samples.TabStepperWithoutNavigationComponentsActivity

import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Main activity that lists the samples.
 */
@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

 private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main)

        setSupportActionBar(binding.toolbar)

        binding.recyclerActivities.layoutManager = LinearLayoutManager(this)
        binding.recyclerActivities.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerActivities.adapter = ActivityListAdapter().apply {
            submitList(
                listOf(
                    ActivityItem(
                        getString(R.string.title_no_up_nav_stepper),
                        StepperNoUpNavActivity::class.java
                    ),
                    ActivityItem(
                        getString(R.string.title_tab_stepper),
                        TabStepperActivity::class.java
                    ),
                    ActivityItem(
                        getString(R.string.title_tab_numbered_stepper),
                        NumberedTabStepperActivity::class.java
                    ),
                    ActivityItem(
                        getString(R.string.title_progress_stepper),
                        ProgressStepperActivity::class.java
                    ),
                    ActivityItem(
                        getString(R.string.title_fleets_stepper),
                        FleetsStepperActivity::class.java
                    ),
                    ActivityItem(
                        getString(R.string.title_fade_anim_stepper),
                        FadeAnimStepperActivity::class.java
                    ),
                    ActivityItem(
                        getString(R.string.title_without_navigation_components),
                        TabStepperWithoutNavigationComponentsActivity::class.java
                    ),
                    ActivityItem(
                        getString(R.string.title_with_overflow),
                        TabStepperWithOverflowActivity::class.java
                    )
                )
            )
        }
    }
}
