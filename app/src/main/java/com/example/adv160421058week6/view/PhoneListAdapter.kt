package com.example.adv160421058week6.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160421058week6.databinding.PhoneListItemBinding
import com.example.adv160421058week6.model.Phone
import com.google.gson.JsonObject

class PhoneListAdapter(val phoneList: ArrayList<Phone>): RecyclerView.Adapter<PhoneListAdapter.PhoneViewHolder>() {
    class PhoneViewHolder(val binding: PhoneListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val binding = PhoneListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhoneViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        with (holder.binding) {
            txtID.text = phoneList[position].id.toString()
            txtBrand.text = phoneList[position].brand
            txtModel.text = phoneList[position].model
            val colors = phoneList[position].color
            txtColors.text = "Colors:\n"
            if (colors != null) {
                for (color in colors) {
                    txtColors.append("- ${color}\n")
                }
            }
            val specs = phoneList[position].specs
            txtSpecs.text = "Specs:\n"
            if (specs != null) {
                txtSpecs.append(
                    "Display: ${specs.display}" +
                            "\nProcessor: ${specs.processor}" +
                            "\nRAM: ${specs.RAM}" +
                            "\nStorage: ${specs.storage}" +
                            "\nCamera: ${specs.camera}"
                )
            }

        }
    }

    fun updatePhoneList(newPhoneList: List<Phone>) {
        phoneList.clear()
        phoneList.addAll(newPhoneList)
        notifyDataSetChanged()
    }
}