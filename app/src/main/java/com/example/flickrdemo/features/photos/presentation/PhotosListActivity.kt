package com.example.flickrdemo.features.photos.presentation

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.example.flickrdemo.R
import com.example.flickrdemo.databinding.ActivityPhotosListBinding
import com.example.flickrdemo.utilities.PaginationScrollListener
import com.example.flickrdemo.utilities.getScreenOrientation
import com.example.flickrdemo.utilities.showToast
import kotlinx.android.synthetic.main.activity_photos_list.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class PhotosListActivity : AppCompatActivity(), KoinComponent {

    private val viewModel by inject<PhotosListViewModel>()
    private lateinit var binding: ActivityPhotosListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()

        setupRecyclerView()

        viewModel.errorMessage.observe(this,
            Observer { message -> showToast(message) })

        viewModel.getPhotosList(1)

        srl_photos_list.setOnRefreshListener {
            viewModel.handleSwipeToRefreshEvent()
            srl_photos_list.isRefreshing = false
        }
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_photos_list)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun setupRecyclerView() {
        if (getScreenOrientation(this) == ORIENTATION_PORTRAIT)
            rv_photos.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        else
            rv_photos.layoutManager = GridLayoutManager(this, 2, VERTICAL, false)

        rv_photos.addOnScrollListener(object :
            PaginationScrollListener(rv_photos.layoutManager as LinearLayoutManager) {
            override fun isLastPage(): Boolean {
                return viewModel.isLastPage
            }

            override fun loadMoreItems() {
                viewModel.progressBarLoading.value = true
                viewModel.getPhotosList(viewModel.currentPage)
            }

            override fun isLoading(): Boolean {
                viewModel.progressBarLoading.value?.let {
                    return it
                }
                return false
            }
        })
    }

}
