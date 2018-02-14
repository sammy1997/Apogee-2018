package bitspilani.dvm.apogee2016.ui.informatives

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bitspilani.dvm.apogee2016.R
import bitspilani.dvm.apogee2016.databinding.NotificationsItemBinding
import bitspilani.dvm.apogee2016.di.SemiBold
import bitspilani.dvm.apogee2016.ui.base.BaseFragment
import bitspilani.dvm.apogee2016.ui.main.MainActivity
import java.util.*
import javax.inject.Inject

data class NotificationData(val title: String, val body: String, val timeRecieved: String, val date: Date)

class NotificationViewHolder(val binding: NotificationsItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(data: NotificationData, typeface: Typeface){
        binding.data = data
        binding.typeface = typeface
    }
}

class NotificationsAdapter(val typeface: Typeface) : RecyclerView.Adapter<NotificationViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(NotificationsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = TODO("GlobalData.notificationsData.size")

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        TODO("holder.bind(GlobalData.notificationsData[position], typeface)")
    }
}

class NotificationsFragment : BaseFragment(){

    @Inject
    @field:SemiBold
    lateinit var typeface: Typeface

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getFragmentComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        (getBaseActivity() as MainActivity).setHeading("Notifications")
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        try {
            TODO("GlobalData.notificationsData = GlobalData.tinyDb.getObject(\"notificationsData\", GlobalData.notificationsDataType)")
        }catch (e: NullPointerException){
            e.printStackTrace()
        }
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = NotificationsAdapter(typeface)
        return view
    }
}
