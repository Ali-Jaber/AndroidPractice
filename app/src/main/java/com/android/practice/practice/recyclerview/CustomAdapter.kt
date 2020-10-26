import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.practice.practice.R
import de.hdodenhof.circleimageview.CircleImageView
abstract class CustomAdapter<T, VM : RecyclerView.ViewHolder> :
    RecyclerView.Adapter<VM>() {
    private val myList = ArrayList<T>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VM =
        createVm(parent, viewType)
    override fun onBindViewHolder(holder: VM, position: Int) {
        bindVm(holder, position, myList[position])
    }
    abstract fun createVm(parent: ViewGroup, viewType: Int): VM
    abstract fun bindVm(holder: VM, position: Int, item: T)
    fun addItem(position: Int, infoUser: T) {
        myList.add(position, infoUser)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, myList.size)
    }
    fun addItem(infoUser: T) {
        myList.add(infoUser)
        notifyDataSetChanged()
    }
    fun addAll(users: List<T>) {
        myList.addAll(users)
    }
    fun clear() {
        myList.clear()
    }
    fun removeItem(position: Int) {
        myList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, myList.size)
    }
    override fun getItemCount(): Int {
        return myList.size
    }
}
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val username = itemView.findViewById<TextView>(R.id.username)
    val userPhoto = itemView.findViewById<CircleImageView>(R.id.userPhoto)
    val timesAgo = itemView.findViewById<TextView>(R.id.timesAgo)
    val postPhoto = itemView.findViewById<ImageView>(R.id.image_post)
    val addPost = itemView.findViewById<ImageButton>(R.id.addPost)
    val removePost = itemView.findViewById<ImageButton>(R.id.removePost)
}