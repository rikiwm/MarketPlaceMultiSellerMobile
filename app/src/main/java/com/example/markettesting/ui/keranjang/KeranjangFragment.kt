package com.example.markettesting.ui.keranjang

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.markettesting.R

class KeranjangFragment : Fragment() {

    private lateinit var KeranjangViewModel: KeranjangViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        KeranjangViewModel =
            ViewModelProvider(this).get(com.example.markettesting.ui.keranjang.KeranjangViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_keranjang, container, false)
        val textView: TextView = root.findViewById(R.id.text_keranjang)
        KeranjangViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}