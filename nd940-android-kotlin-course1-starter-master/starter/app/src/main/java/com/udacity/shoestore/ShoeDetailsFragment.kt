package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailsBinding
    private val shoeViewModel : ShoeViewModel by activityViewModels()

    private val newShoe = Shoe()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)

        binding.shoe = newShoe

        binding.cancelBtn.setOnClickListener { view : View ->
            view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }

        binding.saveBtn.setOnClickListener { view : View ->
            //add the shoe to the view model
            shoeViewModel.addShoe(newShoe)
            view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
        }

        return binding.root
    }

}