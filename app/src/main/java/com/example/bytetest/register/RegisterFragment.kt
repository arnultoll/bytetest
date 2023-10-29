package com.example.bytetest.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bytetest.R
import com.example.bytetest.dataBase.RegisterRepository
import com.example.bytetest.databinding.RegisterHomeFragmentBinding
import com.example.bytetest.domain.model.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val registerViewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: RegisterHomeFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.register_home_fragment, container, false
        )

        val application = requireNotNull(this.activity).application



        binding.submitButton.setOnClickListener {
            val firstName = binding.firstNameTextField.text.toString()
            val secondName = binding.secondNameTextField.text.toString()
            val lastName = binding.firstLastNameEditText.text.toString()
            val secondLastName = binding.secondLastNameEditText.text.toString()
            val userName = binding.userNameEditText.text.toString()
            val passwrd = binding.passwordEditText.text.toString()

            registerViewModel.saveRegister(
                User(firstName, secondName, lastName, secondLastName, userName, passwrd)
            )

        }
        return binding.root
    }
}





