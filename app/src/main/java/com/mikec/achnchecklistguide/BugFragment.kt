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
        }
    }
}