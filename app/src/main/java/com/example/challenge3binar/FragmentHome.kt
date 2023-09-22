package com.example.challenge3binar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHome : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listMenu = arrayListOf(
            DataMenu(R.drawable.ayam_bakar, "Ayam Goreng", "Rp. 50.000", "Ayam Goreng khas gorengan dengan minyak bimoli.","Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345"),
            DataMenu(R.drawable.ayam_geprek, "Ayam Geprek", "Rp. 45.000", "Ayam Geprek khas geprekan dengan cabai merah.","Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345"),
            DataMenu(R.drawable.ayam_bakar_ori, "Ayam Bakar", "RP. 45.000", "Ayam Bakar khas bakaran dengan sambal bakar yang dicampur aduk.","Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345"),
            DataMenu(R.drawable.ayam_rica, "Ayam Rica-rica", "Rp. 55.000", "Ayam Rica-Rica khas sambal dengan kepedasan ekstra.","Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345")
        )

        val adapter = Adapaters(listMenu)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycleView)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adapter



        adapter.onItemClick = {
            val nBundle = Bundle()
            nBundle.putParcelable("DataMenu", it)
            view.findNavController().navigate(R.id.action_fragmentHome_to_fragmentDetail, nBundle)
        }

    }

}