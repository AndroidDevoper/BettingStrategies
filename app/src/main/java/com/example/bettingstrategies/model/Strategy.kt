package com.example.bettingstrategies.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Strategy(val title_res: Int,
                    val info_res: Int,
                    val img_res: Int,
                    var isFavorite: Boolean) : Parcelable, Serializable
