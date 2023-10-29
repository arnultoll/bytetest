package com.example.bytetest.login

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bytetest.R
import com.example.bytetest.dataBase.RegisterRepository
import com.example.bytetest.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login, container, false
        )

        val application = requireNotNull(this.activity).application



        binding.lifecycleOwner = this

        binding.submitButton.setOnClickListener {
            val user = binding.userNameTextField.text.toString()
            val password = binding.passwordTextField.text.toString()

            loginViewModel.getUser(user, password)
        }

        loginViewModel.user.observe(viewLifecycleOwner) { hasFinished ->
            if (hasFinished == true) {
                CoroutineScope(Dispatchers.Main).launch {
                    val dialogBuilder = AlertDialog.Builder(requireActivity())
                    dialogBuilder.setMessage("Inicio Exitoso")
                        // if the dialog is cancelable
                        .setCancelable(false)
                        .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, id ->
                            dialog.dismiss()

                        })

                    val alert = dialogBuilder.create()
                    alert.setTitle("Test")
                    alert.show()
                }
            } else {
                AlertDialog.BUTTON_NEGATIVE
            }
        }
        binding.registerButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }

        return binding.root
    }

}