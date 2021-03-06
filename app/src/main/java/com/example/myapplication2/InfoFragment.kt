package com.example.myapplication2

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.cubecontro_fragment.*
import kotlinx.android.synthetic.main.userinfo_fragment.*
import kotlinx.android.synthetic.main.userinfo_fragment.relative

class InfoFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.userinfo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let {
            Info(
                res = resources,
                rel = relative,
                context = it
            )
        }

        backBtn.setOnClickListener {
            val viberator = activity?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            viberator.vibrate(40)
            change(fragment = cube)
        }
    }

    @SuppressLint("ResourceType")
    fun change(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentLayout, fragment)
        transaction?.commitAllowingStateLoss()
        Runtime.getRuntime().gc()
        Runtime.getRuntime().freeMemory()
    }
}