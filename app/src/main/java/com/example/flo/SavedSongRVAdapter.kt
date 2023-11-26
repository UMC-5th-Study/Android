package com.example.flo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flo.databinding.ItemSongBinding

class SavedSongRVAdapter() : RecyclerView.Adapter<SavedSongRVAdapter.ViewHolder>(){

    private val songs = ArrayList<Song>()

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): SavedSongRVAdapter.ViewHolder {
        val binding : ItemSongBinding = ItemSongBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedSongRVAdapter.ViewHolder, position: Int) {
        holder.bind(songs[position])
    }

    override fun getItemCount(): Int = songs.size

    inner class ViewHolder(val binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(song: Song){
            binding.itemSongImgIv.setImageResource(song.coverImg!!)
            binding.itemSongTitleTv.text = song.title
            binding.itemSongSingerTv.text = song.singer
        }
    }
}