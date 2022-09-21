package com.shopper.app.ui.categorydetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.shopper.app.R
import com.shopper.app.common.KEY_CATEGORY_LABEL
import com.shopper.app.common.KEY_PRODUCT_ID
import com.shopper.app.databinding.FragmentCategoryDetailBinding
import com.shopper.app.ui.common.ProductClickListener
import com.shopper.app.ui.common.ProductPromotionAdapter
import com.shopper.app.ui.common.SectionTitleAdapter
import com.shopper.app.ui.common.ViewModelFactory

class CategoryDetailFragment: Fragment(), ProductClickListener {

    private lateinit var binding: FragmentCategoryDetailBinding
    private val viewModel: CategoryDetailViewModel by viewModels {ViewModelFactory(requireContext())}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        setToolbar()
        setListAdapter()

    }

    override fun onProductClick(productId: String) {
        // TODO 화면 이동 구현
    }


    private fun setToolbar(){
        val categoryLabel = requireArguments().getString(KEY_CATEGORY_LABEL)
        binding.toolbarCategoryDetail.title = categoryLabel
    }

    private fun setListAdapter(){
        val titleAdapter = SectionTitleAdapter()
        val promotionAdapter = ProductPromotionAdapter(this)
        binding.rvCategoryDetail.adapter = ConcatAdapter(titleAdapter, promotionAdapter)
        viewModel.promotions.observe(viewLifecycleOwner){ promotions ->
            titleAdapter.submitList(listOf(promotions.title))
            promotionAdapter.submitList(promotions.items)
        }
    }
}