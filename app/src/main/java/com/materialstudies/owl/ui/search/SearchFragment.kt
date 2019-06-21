/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.materialstudies.owl.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.postDelayed
import androidx.fragment.app.Fragment
import com.materialstudies.owl.databinding.FragmentSearchBinding
import com.materialstudies.owl.model.topics
import com.materialstudies.owl.util.SpringAddItemAnimator

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater, container, false).apply {
            searchResults.apply {
                itemAnimator = SpringAddItemAnimator()
                adapter = SearchAdapter().apply {
                    // Add animations not running without this delay
                    // TODO(nickbutcher) work out why
                    postDelayed(100L) {
                        submitList(topics)
                    }
                }
            }
        }
        return binding.root
    }
}
