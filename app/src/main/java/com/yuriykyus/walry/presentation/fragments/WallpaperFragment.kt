package com.yuriykyus.walry.presentation.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.yuriykyus.walry.app.App
import com.yuriykyus.walry.app.observeViewState
import com.yuriykyus.walry.databinding.FragmentPhotoListBinding
import com.yuriykyus.walry.presentation.MainActivity
import com.yuriykyus.walry.presentation.adapters.PhotoAdapter
import com.yuriykyus.walry.presentation.PhotoViewModel
import com.yuriykyus.walry.presentation.PhotoViewModelFactory
import com.yuriykyus.walry.presentation.events.LoadPhotosEvent
import javax.inject.Inject

private const val ARG_PARAM = "param"

class WallpaperFragment : BaseFragment() {

    private val binding by lazy {
        FragmentPhotoListBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var photoViewModelFactory: PhotoViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, photoViewModelFactory)[PhotoViewModel::class.java]
    }

    private lateinit var adapter: PhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ((requireActivity() as MainActivity).applicationContext as App).appComponent.inject(this)

        initAdapter()
        observeViewModel()

        val fragmentType = getSerializable()

        viewModel.send(LoadPhotosEvent(fragmentType))
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

    private fun getSerializable(): FragmentTypes? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable(ARG_PARAM, FragmentTypes::class.java)
        } else {
            arguments?.getSerializable(ARG_PARAM) as? FragmentTypes
        }
    }

    companion object {
        fun <E : Enum<E>> newInstance(arg: E) =
            WallpaperFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM, arg)
                }
            }
    }

}
