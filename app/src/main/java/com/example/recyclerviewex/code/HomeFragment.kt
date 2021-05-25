package com.example.recyclerviewex.code

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewex.R
import com.example.recyclerviewex.code.features.HomeFragmentAdapter
import com.example.recyclerviewex.code.features.RestaurantViewModel
import com.example.recyclerviewex.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: RestaurantViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

//    private lateinit var searchBar: SearchBar

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()
        setHasOptionsMenu(true)

//        binding.shimmerViewContainer.startShimmer()

        loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val searchView = R.id.app_bar_search

        when(item.itemId) {
            searchView -> onSearch()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadData() {

        val restaurantAdapter = HomeFragmentAdapter()

        binding.apply {
            restaurantRecyclerView.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(context)
            }

            viewModel.restaurants.observe(viewLifecycleOwner) { restaraunts ->
                restaurantAdapter.submitList(restaraunts)
            }
        }
    }

    private fun onSearch() {
//        val searchBar = view.findViewById<SearchBar>()
    }
}