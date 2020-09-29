package com.example.mygithubbrowser.ui.browse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mygithubbrowser.R

/**
 * A simple [Fragment] subclass.
 */
class BrowseFragment : Fragment() {

    private val params by navArgs<BrowseFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.browse_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val webView = view.findViewById<WebView>(R.id.webView)
        webView.loadUrl(params.url)
    }

    companion object {
    }
}