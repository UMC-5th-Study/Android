package com.example.flo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flo.databinding.ItemAlbumBinding

class AlbumRVAdapter(private val albumList: ArrayList<Album>) : RecyclerView.Adapter<AlbumRVAdapter.ViewHolder>() {

    interface MyItemClickListner{
        fun onItemClick(album: Album)
    }

    //외부에서 전달받은 Listner 객체를 어댑터에서 사용할 수 있도록 해야한다
    private lateinit var mItemClickListner : MyItemClickListner
    fun setMyItemClickListner(itemClickListner : MyItemClickListner){
        mItemClickListner = itemClickListner
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AlbumRVAdapter.ViewHolder {
        //아이템 뷰 객체 생성 후, 재활용을 위해 ViewHolder에 전달
        val binding: ItemAlbumBinding = ItemAlbumBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumRVAdapter.ViewHolder, position: Int) {
        //ViewHolder에 데이터를 바인딩해줘야 할 때마다 호줄 = 스크롤 시 계속 호출
        //position = RecyclerView에서의 인덱스 아이디
        holder.bind(albumList[position])
        holder.itemView.setOnClickListener{
            mItemClickListner.onItemClick(albumList[position])
        }
    }

    override fun getItemCount(): Int = albumList.size
    //데이터셋의 크기 반환


    inner class ViewHolder(val binding: ItemAlbumBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(album: Album){
            binding.itemAlbumTitleTv.text = album.title
            binding.itemAlbumSingerTv.text = album.singer
            binding.itemAlbumCoverImgIv.setImageResource(album.coverImg!!)
        }
    }

}