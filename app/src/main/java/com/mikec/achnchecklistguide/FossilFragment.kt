package com.mikec.achnchecklistguide

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Paint
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
import kotlinx.android.synthetic.main.fragment_fossils.*
import kotlinx.android.synthetic.main.fragment_fossils.view.*

class FossilFragment : Fragment() {

    lateinit var dbHandler: DBHandler

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dbHandler = context?.let { DBHandler(it) }!!
        val fossilView:View = inflater.inflate(R.layout.fragment_fossils, container,false)
        fossilView.rv_fossils.layoutManager = LinearLayoutManager(context)
        return fossilView
    }

    override fun onResume() {
        super.onResume()
        refreshList()
    }

    private fun refreshList(){
        rv_fossils.adapter = this.context?.let { FossilAdapter(it,dbHandler, dbHandler.getFossils()) }
    }

    class FossilAdapter(var context: Context, val dbHandler: DBHandler, val list:MutableList<Fossil>):
        RecyclerView.Adapter<FossilAdapter.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_child_fossil, parent,false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.fossilName.text = list[position].name
            holder.fossilSellPrice.text = list[position].sellPrice.toString()
            holder.fossilCheckBox.isChecked = list[position].donated == 1
            holder.fossilImg.setImageBitmap(BitmapFactory.decodeStream(context.assets.open("fossils/" + list[position].image)))


            if(list[position].donated == 1){
                holder.fossilName.paintFlags = holder.fossilName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                holder.fossilName.paintFlags = holder.fossilName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
            holder.fossilCheckBox.setOnClickListener(View.OnClickListener {
                if(holder.fossilCheckBox.isChecked){
                    dbHandler.updateFossil(list[position],1)
                    holder.fossilName.setPaintFlags(holder.fossilName.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                    list[position].donated = 1
                } else {
                    dbHandler.updateFossil(list[position],0)
                    holder.fossilName.setPaintFlags(holder.fossilName.getPaintFlags() and Paint.STRIKE_THRU_TEXT_FLAG.inv())
                    list[position].donated = 0
                }

            })
        }

        class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
            val fossilName : TextView = v.findViewById(R.id.tv_fossil_name)
            val fossilCheckBox : CheckBox = v.findViewById(R.id.fossilCheckBox)
            val fossilSellPrice : TextView = v.findViewById(R.id.tv_fossil_sellprice)
            val fossilImg: ImageView = v.findViewById(R.id.iv_fossil_img)
        }
    }
}