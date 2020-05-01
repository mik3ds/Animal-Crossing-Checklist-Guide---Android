package com.mikec.achnchecklistguide

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_bugs.*
import kotlinx.android.synthetic.main.fragment_bugs.view.*
import java.io.IOException

class BugFragment : Fragment() {
    lateinit var dbHandler: DBHandler

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dbHandler = context?.let { DBHandler(it) }!!
        val bugView:View = inflater.inflate(R.layout.fragment_bugs, container,false)
        bugView.rv_bugs.layoutManager = LinearLayoutManager(context)
        return bugView
    }

    override fun onResume() {
        super.onResume()
        refreshList()
    }

    private fun refreshList(){

        rv_bugs.adapter = this.context?.let {
            BugAdapter(
                it,
                dbHandler,
                dbHandler.getBug()
            )
        }
    }

    class BugAdapter(var context: Context, val dbHandler: DBHandler, val list:MutableList<Bug>):
        RecyclerView.Adapter<BugAdapter.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_child_bug, parent,false))
        }

        override fun getItemCount(): Int {
            return list.size
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bugName.text = list[position].name
            holder.bugSellPrice.text = list[position].price.toString()
            holder.bugCheckBox.isChecked = list[position].donated == 1
            holder.bugImg.setImageBitmap(BitmapFactory.decodeStream(context.assets.open("bugs/" + list[position].image)))
            holder.bugTime.text = list[position].time
            holder.bugLocation.text = list[position].location

            if(list[position].donated == 1){
                holder.bugName.paintFlags = holder.bugName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                holder.bugName.paintFlags = holder.bugName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }

            if(list[position].hemisphere == 0){
                if(list[position].SJan == 0){
                    holder.bugJan.paintFlags = holder.bugJan.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                } else {
                    holder.bugJan.paintFlags = holder.bugJan.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                }
                if(list[position].SFeb == 0){
                    holder.bugFeb.paintFlags = holder.bugFeb.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SMar == 0){
                    holder.bugMar.paintFlags = holder.bugMar.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SApr == 0){
                    holder.bugApr.paintFlags = holder.bugApr.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SMay == 0){
                    holder.bugMay.paintFlags = holder.bugMay.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SJun == 0){
                    holder.bugJun.paintFlags = holder.bugJun.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SJul == 0){
                    holder.bugJul.paintFlags = holder.bugJul.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SAug == 0){
                    holder.bugAug.paintFlags = holder.bugAug.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SSep == 0){
                    holder.bugSep.paintFlags = holder.bugSep.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SOct == 0){
                    holder.bugOct.paintFlags = holder.bugOct.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SNov == 0){
                    holder.bugNov.paintFlags = holder.bugNov.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].SDec == 0){
                    holder.bugDec.paintFlags = holder.bugDec.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
            } else {
                if(list[position].NJan == 0){
                    holder.bugJan.paintFlags = holder.bugJan.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NFeb == 0){
                    holder.bugFeb.paintFlags = holder.bugFeb.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NMar == 0){
                    holder.bugMar.paintFlags = holder.bugMar.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NApr == 0){
                    holder.bugApr.paintFlags = holder.bugApr.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NMay == 0){
                    holder.bugMay.paintFlags = holder.bugMay.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NJun == 0){
                    holder.bugJun.paintFlags = holder.bugJun.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NJul == 0){
                    holder.bugJul.paintFlags = holder.bugJul.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NAug == 0){
                    holder.bugAug.paintFlags = holder.bugAug.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NSep == 0){
                    holder.bugSep.paintFlags = holder.bugSep.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NOct == 0){
                    holder.bugOct.paintFlags = holder.bugOct.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NNov == 0){
                    holder.bugNov.paintFlags = holder.bugNov.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }
                if(list[position].NDec == 0){
                    holder.bugDec.paintFlags = holder.bugDec.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG                }

            }



            holder.bugCheckBox.setOnClickListener(View.OnClickListener {
                if(holder.bugCheckBox.isChecked){
                    dbHandler.updateBug(list[position],1)
                    holder.bugName.setPaintFlags(holder.bugName.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                    list[position].donated = 1
                } else {
                    dbHandler.updateBug(list[position],0)
                    holder.bugName.setPaintFlags(holder.bugName.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
                    list[position].donated = 0
                }

            })
        }

        class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
            val bugName : TextView = v.findViewById(R.id.tv_bug_name)
            val bugCheckBox : CheckBox = v.findViewById(R.id.bugCheckBox)
            val bugSellPrice : TextView = v.findViewById(R.id.tv_bug_sellprice)
            val bugImg : ImageView = v.findViewById(R.id.iv_bug_img)
            val bugTime : TextView = v.findViewById(R.id.tv_bug_time)
            val bugLocation : TextView = v.findViewById(R.id.tv_bug_location)
            val bugJan: TextView = v.findViewById(R.id.tv_bug_jan)
            val bugFeb: TextView = v.findViewById(R.id.tv_bug_feb)
            val bugMar: TextView = v.findViewById(R.id.tv_bug_mar)
            val bugApr: TextView = v.findViewById(R.id.tv_bug_apr)
            val bugMay: TextView = v.findViewById(R.id.tv_bug_may)
            val bugJun: TextView = v.findViewById(R.id.tv_bug_jun)
            val bugJul: TextView = v.findViewById(R.id.tv_bug_jul)
            val bugAug: TextView = v.findViewById(R.id.tv_bug_aug)
            val bugSep: TextView = v.findViewById(R.id.tv_bug_sep)
            val bugOct: TextView = v.findViewById(R.id.tv_bug_oct)
            val bugNov: TextView = v.findViewById(R.id.tv_bug_nov)
            val bugDec: TextView = v.findViewById(R.id.tv_bug_dec)
        }
    }
}