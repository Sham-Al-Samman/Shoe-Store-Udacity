package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeListFragment : Fragment() {

    private lateinit var binding : FragmentShoeListBinding
    private val shoeViewModel : ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.floatingActionButton.setOnClickListener { view : View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        setHasOptionsMenu(true)

        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer{ list ->
            updateList(list) })

        return binding.root
    }

    private fun updateList(list : MutableList<Shoe>){
        for(item : Shoe in list){
            val newItem = TextView(context)
            newItem.text = item.getDetailsString() + "\n"
            newItem.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            binding.listLayout.addView(newItem)
        }
    }

    //extension function to get the formatted details of a shoe:
    private fun Shoe.getDetailsString() : String{
        return "Name: $name, Company: $company,\nSize: $size\nDescription: $description"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) ||
                super.onOptionsItemSelected(item)
    }

}