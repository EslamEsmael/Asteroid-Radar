package com.eslam.asteroidradar.presentation.detailsFragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.eslam.asteroidradar.R
import com.eslam.asteroidradar.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private val binding: FragmentDetailsBinding by lazy {
        FragmentDetailsBinding.inflate(layoutInflater)
    }

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.lifecycleOwner = this
        binding.asteroid = args.asteroid

        binding.helpIconImageView.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(context)
            alertDialogBuilder.setMessage(requireContext().getString(R.string.dialog_message))
            alertDialogBuilder.setCancelable(true)
            alertDialogBuilder.setPositiveButton(requireContext().getString(R.string.accept)) { dialog, _ ->
                dialog.dismiss()
            }
            alertDialogBuilder.show()
        }

        return binding.root
    }

}