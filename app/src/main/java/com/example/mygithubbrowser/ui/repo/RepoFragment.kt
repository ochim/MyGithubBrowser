package com.example.mygithubbrowser.ui.repo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mygithubbrowser.R

class RepoFragment : Fragment() {

    companion object {
        fun newInstance() = RepoFragment()
    }

    private lateinit var viewModel: RepoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}