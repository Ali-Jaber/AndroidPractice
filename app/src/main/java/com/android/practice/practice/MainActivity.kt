package com.android.practice.practice

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.android.practice.practice.Notifications.MyNotifications
import com.android.practice.practice.autocompletetext.CountryAutoCompleteText
import com.android.practice.practice.customview.CustomViewMain
import com.android.practice.practice.customview.MyCustomView
import com.android.practice.practice.dialog.CustomAlertDialog
import com.android.practice.practice.dialog.MyBottomSheet
import com.android.practice.practice.fragment.MainFragment
import com.android.practice.practice.fragment.dialog.MyDialogFragment
import com.android.practice.practice.fragment.fragmentinsidefragment.InsideFragment
import com.android.practice.practice.fragment.fragmenttofragment.FragmentToFragment
import com.android.practice.practice.fragment.toolbar.FragmentToolBar
import com.android.practice.practice.fragment.transferdata.MainTransferFragment
import com.android.practice.practice.listview.ListView
import com.android.practice.practice.pages.Pages2
import com.android.practice.practice.pages.PagesActivity
import com.android.practice.practice.recyclerview.UserRecyclerView
import com.android.practice.practice.sharedpreferences.SharedPreferencesOne
import com.android.practice.practice.sharedpreferences.SharedPreferencesPractice
import com.android.practice.practice.spinner.SpinnerMain
import com.android.practice.practice.viewpager.MyPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton("List View") {
            startActivity(Intent(this, ListView::class.java))
        }

        addButton("Recycler View") {
            startActivity(Intent(this, UserRecyclerView::class.java))
        }

        addButton("Collapsing Toolbar") {
            startActivity(Intent(this, CollapsingToolbar::class.java))
        }

        addButton("Drawer") {
            startActivity(Intent(this, Drawer::class.java))
        }

        addButton("Group Menu") {
            startActivity(Intent(this, GroupMenu::class.java))
        }

        addButton("Radio Button") {
            startActivity(Intent(this, RadioButton::class.java))
        }

        addButton("Spinner Main") {
            startActivity(Intent(this, SpinnerMain::class.java))
        }
//        btn7.setOnClickListener {
//            startActivity(Intent(this, SpinnerMain::class.java))
//        }
//        btn7.setOnClickListener {
//            startActivity(Intent(this, Spinner::class.java))
//        }

        addButton("Table Layout") {
            startActivity(Intent(this, TableLayout::class.java))
        }

        addButton("Scroll Vertical") {
            startActivity(Intent(this, ScrollVertical::class.java))
        }

        addButton("Scroll Horizontal") {
            startActivity(Intent(this, ScrollHorizontal::class.java))
        }

        addButton("Scroll Nested") {
            startActivity(Intent(this, ScrollNested::class.java))
        }

        addButton("Liner Layout") {
            startActivity(Intent(this, LinerLayout::class.java))
        }

        addButton("Relative Layout") {
            startActivity(Intent(this, RelativeLayout::class.java))
        }

        addButton("Coordinator Layout") {
            startActivity(Intent(this, CoordinatorLayout::class.java))
        }

        addButton("Country Auto Complete Text") {
            startActivity(Intent(this, CountryAutoCompleteText::class.java))
        }

        addButton("Custom Alert Dialog") {
            startActivity(Intent(this, CustomAlertDialog::class.java))
        }

        addButton("Notifications") {
            startActivity(Intent(this, MyNotifications::class.java))
        }

        addButton("Fragment") {
            startActivity(Intent(this, MainFragment::class.java))
        }

        addButton("Send from Activity to Fragment") {
            startActivity(Intent(this, MainTransferFragment::class.java))
        }

        addButton("Fragment To Fragment") {
            startActivity(Intent(this, FragmentToFragment::class.java))
        }

        addButton("fragment toolbar") {
            startActivity(Intent(this, FragmentToolBar::class.java))
        }

        addButton("Pager") {
            startActivity(Intent(this, MyPager::class.java))
        }


        addButton("Custom View") {
            startActivity(Intent(this, MyCustomView::class.java))
        }

        addButton("Dialog Fragment") {
            startActivity(Intent(this, MyDialogFragment::class.java))
        }


        addButton("Bottom Sheet") {
            startActivity(Intent(this, MyBottomSheet::class.java))
        }

        addButton("Fragment Inside Fragment") {
            startActivity(Intent(this, InsideFragment::class.java))
        }

        addButton("Pages") {
            startActivity(Intent(this, PagesActivity::class.java))
        }


        addButton("Pages 2") {
            startActivity(Intent(this, Pages2::class.java))
        }

        addButton("Custom View fro method") {
            startActivity(Intent(this, CustomViewMain::class.java))
        }

        addButton("Shared Preferences To Activity") {
            startActivity(Intent(this, SharedPreferencesOne::class.java))
        }

        addButton("Shared Preferences Practice") {
            startActivity(Intent(this, SharedPreferencesPractice::class.java))
        }

    }

    private fun addButton(btnName: String, onClick: View.OnClickListener) {
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        layoutParams.setMargins(0, 8, 0, 0)
        val btn = Button(this)
        btn.text = btnName
        btn.setOnClickListener(onClick)
        btn.gravity = Gravity.CENTER
        btn.layoutParams = layoutParams
        btn.setPadding(8, 8, 8, 8)
        mainLinear.addView(btn)
    }
}