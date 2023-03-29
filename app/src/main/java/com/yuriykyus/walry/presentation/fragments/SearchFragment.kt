package com.yuriykyus.walry.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.yuriykyus.walry.R
import com.yuriykyus.walry.app.App
import com.yuriykyus.walry.app.observeViewState
import com.yuriykyus.walry.databinding.FragmentSearchBinding
import com.yuriykyus.walry.domain.models.SearchData
import com.yuriykyus.walry.presentation.MainActivity
import com.yuriykyus.walry.presentation.PhotoViewModel
import com.yuriykyus.walry.presentation.PhotoViewModelFactory
import com.yuriykyus.walry.presentation.adapters.PhotoAdapter
import com.yuriykyus.walry.presentation.events.LoadPhotoSearchEvent
import javax.inject.Inject

class SearchFragment : BaseFragment() {

    private val binding by lazy {
        FragmentSearchBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var viewModelFactory: PhotoViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[PhotoViewModel::class.java]
    }

    private lateinit var adapter: PhotoAdapter

    private val searchParamMap by lazy {
        mapOf(
            resources.getString(R.string.search_everywhere) to 7,
            resources.getString(R.string.photos) to 1,
            resources.getString(R.string.screenshots) to 2,
            resources.getString(R.string.other) to 3,
            resources.getString(R.string.photos_and_screenshots) to 4,
            resources.getString(R.string.photos_and_other) to 6,
            resources.getString(R.string.screenshots_and_other) to 5
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ((requireActivity() as MainActivity).applicationContext as App).appComponent.inject(this)

        initAdapter()
        observeViewModel()

        binding.searchToolbar.apply {
            etSearch.setOnEditorActionListener { v, actionId, event ->
                when (actionId) {
                    EditorInfo.IME_ACTION_SEARCH -> {
                        val chipId = binding.chipGroup.checkedChipId
                        val chip: Chip = binding.chipGroup.findViewById(chipId)

                        if (!etSearch.text.isEmpty()) {
                            val contentType = searchParamMap[chip.text]
                            viewModel.send(LoadPhotoSearchEvent(FragmentTypes.SearchPhoto, SearchData(contentType = contentType!!, "", etSearch.text.toString())))
                        }

                        true
                    }
                    else -> false
                }
            }
        }

        binding.searchToolbar.btnBack.setOnClickListener {
            getNavigator().backFragment()
        }
    }

    private fun observeViewModel() {
        viewModel.listPhotosLiveData.observeViewState(viewLifecycleOwner) {
            onSuccess { data ->
                adapter.addPhotoUrlList(data)
                hideLoad()
            }

            onError { error, isShowError ->
                hideLoad()
            }

            onProgress {
                showLoad()
            }
        }
    }

    private fun initAdapter() {
        binding.apply {
            adapter = PhotoAdapter()
            rvPhoto.layoutManager = GridLayoutManager(context, 2)
            rvPhoto.adapter = adapter
            rvPhoto.setHasFixedSize(true)
        }
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}