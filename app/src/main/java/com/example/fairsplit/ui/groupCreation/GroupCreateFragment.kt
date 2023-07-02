package com.example.fairsplit.ui.groupCreation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.fairsplit.R
import com.example.fairsplit.databinding.FragmentGroupCreateBinding
import kotlin.random.Random

class GroupCreateFragment : DialogFragment() {

    lateinit var binding : FragmentGroupCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.let {
            it.window?.requestFeature(Window.FEATURE_NO_TITLE)
            it.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.setCancelable(false)
            it.window?.setGravity(Gravity.CENTER)
        }
        binding = FragmentGroupCreateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpClickListener()
    }

    private fun setUpClickListener() {

        binding.btnCreateGroup.setOnClickListener {
            val groupCode:String = groupCode()
            Toast.makeText(context, groupCode, Toast.LENGTH_SHORT).show()
        }

        binding.cancelDialog.setOnClickListener {
            dismiss()
        }
    }

    private fun groupCode():String{
        val random = Random
        val codeLength = 9
        val char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
        val code = StringBuilder()
        repeat(codeLength){
            val randomIndex = random.nextInt(char.length)
            val randomChar = char[randomIndex]
            code.append(randomChar)
        }
        return code.toString()
    }
}