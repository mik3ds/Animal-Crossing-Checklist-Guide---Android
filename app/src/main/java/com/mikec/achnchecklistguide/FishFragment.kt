package com.mikec.achnchecklistguide

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_fish.*
import kotlinx.android.synthetic.main.fragment_fish.view.*

class FishFragment : Fragment() {

    lateinit var dbHandler: DBHandler

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dbHandler = context?.let { DBHandler(it) }!!
        val fishView:View = inflater.inflate(R.layout.fragment_fish, container,false)
        fishView.rv_fish.layoutManager = LinearLayoutManager(context)
        return fishView
    }

    override fun onResume() {
        super.onResume()
        refreshList()
    }

    private fun refreshList(){
        rv_fish.adapter = this.context?.let {
            FishAdapter(
                it,
                dbHandler,
                dbHandler.getFish()
            )
        }
    }

    class FishAdapter(var context: Context, val dbHandler: DBHandler, val list:MutableList<Fish>):
        RecyclerView.Adapter<FishAdapter.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_child_fish, parent,false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.fishName.text = list[position].name
            holder.fishSellPrice.text = list[position].price.toString()
            holder.fishCheckBox.isChecked = list[position].donated == 1
            holder.fishImg.setImageBitmap(BitmapFactory.decodeStream(context.assets.open("fish/" + list[position].image)))
            holder.fishTime.text = list[position].time
            holder.fishShadow.text = "  |  " + list[position].shadow
            holder.fishLocation.text = list[position].location

            if(list[position].donated == 1){
                holder.fishName.paintFlags = holder.fishName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                holder.fishName.paintFlags = holder.fishName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
            holder.fishCheckBox.setOnClickListener(View.OnClickListener {
                if(holder.fishCheckBox.isChecked){
                    dbHandler.updateFish(list[position],1)
                    holder.fishName.setPaintFlags(holder.fishName.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                    list[position].donated = 1
                } else {
                    dbHandler.updateFish(list[position],0)
                    holder.fishName.setPaintFlags(holder.fishName.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
                    list[position].donated = 0
                }

            })

            if(list[position].hemisphere == 0){
                if(list[position].SJan == 0){
                    holder.fishJan.paintFlags = holder.fishJan.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                } else {
                    holder.fishJan.paintFlags = holder.fishJan.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                }
                if(list[position].SFeb == 0){
                    holder.fishFeb.paintFlags = holder.fishFeb.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SMar == 0){
                    holder.fishMar.paintFlags = holder.fishMar.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SApr == 0){
                    holder.fishApr.paintFlags = holder.fishApr.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SMay == 0){
                    holder.fishMay.paintFlags = holder.fishMay.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SJun == 0){
                    holder.fishJun.paintFlags = holder.fishJun.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SJul == 0){
                    holder.fishJul.paintFlags = holder.fishJul.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SAug == 0){
                    holder.fishAug.paintFlags = holder.fishAug.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SSep == 0){
                    holder.fishSep.paintFlags = holder.fishSep.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SOct == 0){
                    holder.fishOct.paintFlags = holder.fishOct.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SNov == 0){
                    holder.fishNov.paintFlags = holder.fishNov.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SDec == 0){
                    holder.fishDec.paintFlags = holder.fishDec.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
            } else {
                if(list[position].NJan == 0){
                    holder.fishJan.paintFlags = holder.fishJan.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NFeb == 0){
                    holder.fishFeb.paintFlags = holder.fishFeb.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NMar == 0){
                    holder.fishMar.paintFlags = holder.fishMar.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NApr == 0){
                    holder.fishApr.paintFlags = holder.fishApr.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NMay == 0){
                    holder.fishMay.paintFlags = holder.fishMay.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NJun == 0){
                    holder.fishJun.paintFlags = holder.fishJun.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NJul == 0){
                    holder.fishJul.paintFlags = holder.fishJul.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NAug == 0){
                    holder.fishAug.paintFlags = holder.fishAug.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NSep == 0){
                    holder.fishSep.paintFlags = holder.fishSep.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NOct == 0){
                    holder.fishOct.paintFlags = holder.fishOct.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NNov == 0){
                    holder.fishNov.paintFlags = holder.fishNov.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NDec == 0){
                    holder.fishDec.paintFlags = holder.fishDec.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }

            }

        }

        class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
            val fishName : TextView = v.findViewById(R.id.tv_fish_name)
            val fishCheckBox : CheckBox = v.findViewById(R.id.fishCheckBox)
            val fishSellPrice : TextView = v.findViewById(R.id.tv_fish_sellprice)
            val fishImg : ImageView = v.findViewById(R.id.iv_fish_img)
            val fishTime : TextView = v.findViewById(R.id.tv_fish_time)
            val fishShadow : TextView = v.findViewById(R.id.tv_fish_shadow)
            val fishLocation : TextView = v.findViewById(R.id.tv_fish_location)
            val fishJan: TextView = v.findViewById(R.id.tv_fish_jan)
            val fishFeb: TextView = v.findViewById(R.id.tv_fish_feb)
            val fishMar: TextView = v.findViewById(R.id.tv_fish_mar)
            val fishApr: TextView = v.findViewById(R.id.tv_fish_apr)
            val fishMay: TextView = v.findViewById(R.id.tv_fish_may)
            val fishJun: TextView = v.findViewById(R.id.tv_fish_jun)
            val fishJul: TextView = v.findViewById(R.id.tv_fish_jul)
            val fishAug: TextView = v.findViewById(R.id.tv_fish_aug)
            val fishSep: TextView = v.findViewById(R.id.tv_fish_sep)
            val fishOct: TextView = v.findViewById(R.id.tv_fish_oct)
            val fishNov: TextView = v.findViewById(R.id.tv_fish_nov)
            val fishDec: TextView = v.findViewById(R.id.tv_fish_dec)


        }
    }
}