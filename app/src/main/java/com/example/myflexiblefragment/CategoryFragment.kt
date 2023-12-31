package com.example.myflexiblefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class CategoryFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_detail_category){
            val detaiCategoryFragment = DetailCategoryFragment()

            val bundle = Bundle()
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
            val description = "Kategori ini akan berisi produk-produk lifestyle"

            detaiCategoryFragment.arguments = bundle
            detaiCategoryFragment.description = description

            val fragmentManager = parentFragmentManager
//            fragmentManager.beginTransaction().apply {
//                replace(R.id.frame_container, detaiCategoryFragment, DetailCategoryFragment::class.java.simpleName)
//                addToBackStack(null)
//                commit()
//            }
            fragmentManager.commit {
                addToBackStack(null)
                replace(R.id.frame_container, detaiCategoryFragment, DetailCategoryFragment::class.java.simpleName)
            }
        }
    }
}