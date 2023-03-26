package com.example.myfood

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.PointerIcon
import androidx.annotation.DrawableRes
import com.google.android.material.chip.Chip
import kotlin.coroutines.coroutineContext

data class FilterItem(
  val id :Int,
  val text : String,
  @DrawableRes val icon: Int? = null,
  val iconSize : Float = 38.0f,
  @DrawableRes val closeIcon: Int? = null,


)


fun FilterItem.toChip(context:Context) : Chip{
  val chip = if (closeIcon == null){

    LayoutInflater.from(context).inflate(R.layout.tip_choice, null, false) as Chip

  }else{

    Chip(ContextThemeWrapper(context, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Choice))

  }

   if (closeIcon!= null)

     chip.setChipBackgroundColorResource(R.color.white)

     chip.setChipBackgroundColorResource(R.color.lt_gray)

  chip.chipStrokeWidth = 2f

  if(icon != null){

    chip.chipIconSize = iconSize
    chip.setChipIconResource(icon)
    chip.chipStartPadding = 20f

  }else {
    chip.chipIcon = null
  }

  closeIcon?.let {

    chip.setCloseIconResource(it)
    chip.isCloseIconVisible = true

  }

  chip.text = text

  return chip
}