package com.shopper.app.ui.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.fragment.findNavController
import com.shopper.app.R
import com.shopper.app.common.KEY_CATEGORY_ID
import com.shopper.app.common.KEY_CATEGORY_LABEL
import com.shopper.app.databinding.FragmentMapBinding
import com.shopper.app.databinding.ItemCategoryBinding
import com.shopper.app.model.Category
import com.shopper.app.ui.common.EventObserver
import com.shopper.app.ui.common.ViewModelFactory

class CategoryFragment:Fragment() {

    private val viewModel: CategoryViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryAdapter = CategoryAdapter(viewModel)
        binding.rvCategoryList.adapter = categoryAdapter
        viewModel.items.observe(viewLifecycleOwner){
            categoryAdapter.submitList(it)
        }

        viewModel.openCategoryEvent.observe(viewLifecycleOwner, EventObserver{
            openCategoryDetail(it.categoryId, it.label)
        })

    }

    private fun openCategoryDetail(categoryId: String, categoryLabel: String){
        findNavController().navigate(R.id.action_category_to_category_detail, bundleOf(
            KEY_CATEGORY_ID to categoryId,
            KEY_CATEGORY_LABEL to categoryLabel
        ))
    }

}