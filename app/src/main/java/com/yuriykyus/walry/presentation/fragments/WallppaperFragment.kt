package com.yuriykyus.walry.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.yuriykyus.walry.core.observeViewState
import com.yuriykyus.walry.databinding.FragmentPhotoListBinding
import com.yuriykyus.walry.domain.models.PhotoData
import com.yuriykyus.walry.presentation.adapters.PhotoAdapter
import com.yuriykyus.walry.presentation.PhotoViewModel
import com.yuriykyus.walry.presentation.PhotoViewModelFactory
import com.yuriykyus.walry.presentation.events.LoadCityEvent
import com.yuriykyus.walry.presentation.events.LoadPhotoEvent

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class WallppaperFragment : BaseFragment() {

    private lateinit var adapter: PhotoAdapter

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            PhotoViewModelFactory(requireActivity())
        )[PhotoViewModel::class.java]
    }

    private val binding by lazy {
        FragmentPhotoListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeViewModel()

        viewModel.send(LoadCityEvent)
        viewModel.send(
            LoadPhotoEvent(
                photoData = PhotoData(
                    requireArguments().getString(ARG_PARAM1).toString(),
                    requireArguments().getString(ARG_PARAM2).toString()
                )
            )
        )
    }

    private fun observeViewModel() {
        viewModel.listCitiesLiveData.observeViewState(viewLifecycleOwner) {
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
        fun newInstance(requestTag: String, requestText: String) =
            WallppaperFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, requestTag)
                    putString(ARG_PARAM2, requestText)
                }
            }
    }

}