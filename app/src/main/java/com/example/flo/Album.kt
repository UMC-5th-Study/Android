package com.example.flo

import java.util.*

data class Album(
    var title: String? = "",
    var singer: String? = "",
    var coverImg: Int? = null,
    var songs: ArrayList<Song>? = null //수록곡정보 - 강의에서는 활용X
)
