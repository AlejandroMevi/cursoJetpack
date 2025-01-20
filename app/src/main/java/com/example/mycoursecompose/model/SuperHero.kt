package com.example.mycoursecompose.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var superheroName: String,
    var realName: String,
    var pusblisher: String,
    @DrawableRes var photo: Int
)
