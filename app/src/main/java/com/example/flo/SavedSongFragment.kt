package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flo.databinding.FragmentLockerSavedsongBinding
import java.util.ArrayList

class SavedSongFragment : Fragment() {

    lateinit var binding: FragmentLockerSavedsongBinding
    private var songDatas = ArrayList<Song>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLockerSavedsongBinding.inflate(inflater, container, false)

        songDatas.apply{
            add(Song("Butter", "방탄소년단 (BTS)", 0, 60, false, "music_butter", R.drawable.img_album_exp))
            add(Song("라일락", "아이유", 0, 60, false, "music_lilac", R.drawable.img_album_exp2))
            add(Song("Weekend", "태연 (Tae Yeon)", 0, 60, false, "music_weekend", R.drawable.img_album_exp6))
        }

        val savedSongRVAdapter = SavedSongRVAdapter(songDatas)
        binding.lockerSavedSongRecyclerView.adapter = savedSongRVAdapter
        binding.lockerSavedSongRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)



        return binding.root
    }
}