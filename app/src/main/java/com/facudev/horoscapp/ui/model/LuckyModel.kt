package com.facudev.horoscapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyModel (
    //Obligamos que la referencia seria de Drawable o de Res
    @DrawableRes val image: Int,
    @StringRes val text: Int
)

